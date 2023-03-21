package by.dilo1992.telegrambotarso.service;


import by.dilo1992.telegrambotarso.config.BotConfig;
import by.dilo1992.telegrambotarso.entity.Ads;
import by.dilo1992.telegrambotarso.entity.User;
import by.dilo1992.telegrambotarso.repository.AdsRepository;
import by.dilo1992.telegrambotarso.repository.UserRepository;
import com.vdurmont.emoji.EmojiParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
//@Data
public class TelegramBot extends TelegramLongPollingBot {
    public static final String YES_BUTTON = "YES_BUTTON";
    public static final String NO_BUTTON = "NO_BUTTON";
    // что бот периодически сам проверяет не написали ли ему что-то

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdsRepository adsRepository;

    @Autowired
    private BotConfig config;

    //потом добавить более расширенное описание методов которые мы можем ввести
    static final String HELP_TEXT = "This bot is created to demonstrate data of manufacturing the concrete company\n\n";

    public TelegramBot(BotConfig config) {
        this.config = config;

        //создаем список команд для меню (добавляем список команд для бота в меню и краткое описание)
        //нельзя использовать верхний регистр в командах
        List<BotCommand> listOfCommands = new ArrayList<>(); //лист содержащий команды бота
        listOfCommands.add(new BotCommand("/start", "get a welcome message"));
        listOfCommands.add(new BotCommand("/mydata", "get your data stored"));
        listOfCommands.add(new BotCommand("/deletedata", "delete my data"));
        listOfCommands.add(new BotCommand("/help", "info how to use this bot"));
        listOfCommands.add(new BotCommand("/settings", "set your preferences"));
        listOfCommands.add(new BotCommand("/register", "register new users"));

        //передаем созданный выше список в бот
        try {
            this.execute(new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error("Error settings bot`s command list " + e.getMessage());
        }
    }

    @Override
    public String getBotUsername() { //предоставляем имя бота
        return config.getBotName();
    }

    @Override
    public String getBotToken() { //для предоставления нашего токена
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) { //что должен делать бот если ему кто-то пишет
        //проверка того, что у нас есть что проверять в сообщении (что не пусто, чтоб не получить исключение)
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            //чтоб бот знал кому и что отправлять, передаем сразу
            long chatId = update.getMessage().getChatId(); //id чата, в котором работает бот

            //код для того, чтоб делать рассылку (набирать команду /send
            // и дальше писать текст для рассылки) + проверка на владельца бота (сравниваем chatId)
            if (messageText.contains("/send") && config.getOwnerId() == (chatId)) {
                //находим текст после /send
                String textToSend = EmojiParser.parseToUnicode(messageText.substring(messageText.indexOf(" ")));
                List<User> users = userRepository.findAll();
                for (User user : users) {
                    sendMessage(user.getChatId(), textToSend);
                }
            } else {

                switch (messageText) {
                    case "/start": //начало общения с ботом начинается со слова /start
                        //регистрация пользователя и занесение данных о нем (сущность User) в таблицу (UserRepository)
                        try {
                            registerUser(update.getMessage());
                        } catch (TelegramApiException e) {
                            log.error("We catch TelegramApiException with message: {}", e.getMessage());
                        }

                        // update.getMessage().getChat().getFirstName() - имя пользователя, с которым ведется чат
                        startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                        break;

                    case "/help":
                        sendMessage(chatId, HELP_TEXT);
                        break;

                    case "/register":
                        register(chatId);
                        break;
                    //на все остальные запросы кроме /start будем отвечать
                    default:
                        sendMessage(chatId, "Sorry, command was not recognized");
                }
            }
        }

        //проверяем, если у нас в update нет сообщения никакого, то проверяем,
        // нет ли в нем данных о нажатии какой-то кнопки (сообщение точно
        // пустое, если мы входим в этот else if)
        else if (update.hasCallbackQuery()) {
            //теперь задаем, что если мы нажали какую-то кнопку,
            // то мы можем поменять текст в сообщении без отправки нового сообщения
            long messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();

            //проверяем, что мы получили, какую из кнопок нажали
            //получаем данные с кнопки которую нажали
            String callbackData = update.getCallbackQuery().getData();
            if (callbackData.equals(YES_BUTTON)) {
                String text = "You pressed YES button";

                executeEditMessageText((int) messageId, chatId, text);

            } else if (callbackData.equals(NO_BUTTON)) {
                String text = "You pressed NO button";

                //заменяем сообщение при нажатии на эту кнопку
                executeEditMessageText((int) messageId, chatId, text);
            }

        }
    }

    // метод для отправки замененного сообщения
    private void executeEditMessageText(int messageId, long chatId, String text) {
        //заменяем сообщение при нажатии на эту кнопку
        EditMessageText messageText = new EditMessageText();
        messageText.setChatId(chatId);
        messageText.setText(text);
        messageText.setMessageId(messageId);

        //отправка сообщений
        try {
            execute(messageText);
        } catch (TelegramApiException e) {
            log.info("Error occurred: " + e.getMessage());
        }
    }

    //метод для использования при команде /register. Здесь определяем
    // кнопки, прикрепленные к сообщению с вариантами ответов
    private void register(Long chatId) {

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Do you really want to register?");

        //cоздаем разметку для кнопок
        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();

        //создаем коллекцию рядов с кнопками
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();

        //создаем коллекцию кнопок в ряду
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        //создаем кнопку
        InlineKeyboardButton yesButton = new InlineKeyboardButton();
        //добавляем текст
        yesButton.setText("Yes");
        //определяем идентификатор для кнопки (чтоб бот понимал, какую кнопку нажал пользователь)
        yesButton.setCallbackData(YES_BUTTON);

        //создаем кнопку
        InlineKeyboardButton noButton = new InlineKeyboardButton();
        //добавляем текст
        noButton.setText("No");
        //определяем идентификатор для кнопки (чтоб бот понимал, какую кнопку нажал пользователь)
        noButton.setCallbackData(NO_BUTTON);

        //расставляем кнопки в ряду по порядку
        rowInLine.add(yesButton);
        rowInLine.add(noButton);

        //расставляем ряды по порядку
        rowsInLine.add(rowInLine);

        //заполняем разметку
        markupInLine.setKeyboard(rowsInLine);
        message.setReplyMarkup(markupInLine);

        executeSendMessage(message);
    }

    //метод для регистрации пользователя и занесения в таблицу данных о нем
    private void registerUser(Message message) throws TelegramApiException {
        //проверяем не зарегистрирован ли пользователь уже,
        // если да - то мы его не сохраняем, если нет - сохраняем в БД
        if (userRepository.findById(message.getChatId()).isEmpty()) {

            Long chatId = message.getChatId();
            Chat chat = message.getChat();

            User user = new User();
            user.setChatId(chatId);
            user.setFirstname(chat.getFirstName());
            user.setLastname(chat.getLastName());
            user.setUsername(chat.getUserName());
            user.setRegisteredAt(new Timestamp(System.currentTimeMillis()));

            userRepository.save(user);
            log.info("user saved: {}", user);
        }
    }

    //отправка стартового сообщения
    private void startCommandReceived(long chatId, String name) {
        String answer = EmojiParser.parseToUnicode("Hi, " + name + " , nice to meet you!" + " :blush:"); //ответ с эмоджи
        log.info("Replied to user: " + name);
        sendMessage(chatId, answer);
    }

    // метод для отправки сообщений
    private void sendMessage(long chatId, String textToSend) {
        SendMessage sendMessage = new SendMessage(); //sendMessage - исходящее сообщение
        sendMessage.setChatId(String.valueOf(chatId)); //особенность api telegram
        // (когда извлекаем chatId - то получаем long, а когда присваиваем - то String)
        sendMessage.setText(textToSend); //сект сообщения

        //отправка сообщений
        executeSendMessage(sendMessage);
    }

    private void executeSendMessage(SendMessage message) {
        //отправка сообщений
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.info("Error occurred: " + e.getMessage());
        }
    }

    // Метод, который автоматически запускается
    //cron - один из параметров автозапуска (в определенное время запускает что-то)
    // cron имеет 7 параметров: секунды, минуты, часы, дата, месяц, день недели
    //* - любое значение
    //например: ****** - каждую секунду, 0***** - каждую минуту, 00**** - каждый час
    @Scheduled(cron = "${cron.scheduler}")
    private void sendAds() {

        //список обхявлений для отправки
        List<Ads> ads = adsRepository.findAll();

        //получаем список все пользователей, чтоб всем отправить
        List<User> users = userRepository.findAll();

        //отправить каждому user каждый ad
        for (Ads ad : ads) {
            for (User user : users) {
                sendMessage(user.getChatId(), ad.getAd());
            }
        }
    }
}
