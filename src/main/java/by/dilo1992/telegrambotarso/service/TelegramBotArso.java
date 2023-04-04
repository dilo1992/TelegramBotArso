package by.dilo1992.telegrambotarso.service;


import by.dilo1992.telegrambotarso.config.BotConfig;
import by.dilo1992.telegrambotarso.converter.ChatToUserConverter;
import by.dilo1992.telegrambotarso.entity.User;
import by.dilo1992.telegrambotarso.model.BotCommands;
import by.dilo1992.telegrambotarso.model.TypesOfProduct;
import by.dilo1992.telegrambotarso.repository.ProductRepository;
import by.dilo1992.telegrambotarso.repository.RoleRepository;
import by.dilo1992.telegrambotarso.repository.UserRepository;
import com.vdurmont.emoji.EmojiParser;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
// TelegramLongPollingBot - что бот периодически сам проверяет не написали ли ему что-то
public class TelegramBotArso extends TelegramLongPollingBot {

    public static final String COMMAND_FOR_SEND_MESSAGE = "/send";
    private static final String INFO_TEXT = "This bot was created to get acquainted with the work of LLC \"ArsoBeton\" " +
            "- a manufacturer of concrete, cement mixtures and CFB blocks of the highest quality.\n" +
            "Production of products is carried out at three production sites in Minsk with delivery " +
            "throughout Belarus by truck mixers and dump trucks.\n" +
            "This telegram bot will help you with the following questions:\n" +
            BotCommands.getAllCommandsAndTheirDescription();

    private static final String INFO_IN_MAIN_MENU_OF_PRODUCTS = "Select the type of product you are interested in\n";

    private static final String CONTACTS = "Contacts of our competent and friendly staff:" +
            "\n@JuliaLovova - главный специалист по продажам\n";

    private static final String LINK_TO_WEBSITE = "All relevant information is contained on the " +
            "resource of our company\n" + "http://127.0.0.1:8080/";

    private final UserRepository userRepository;
    private final BotConfig config;
    private final ReplyKeyboards replyKeyboards;
    private final ProductRepository productRepository;
    private final ChatToUserConverter converterFromChatToUser;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    //объявляем переменную, в которой будет храниться тип продукта после его выбора
    // в меню для поиска модели
    private String typeOfProductForFindToModelOfTypeOfProductIfBlock;

    //предоставляем имя бота
    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    //для предоставления нашего токена
    @Override
    public String getBotToken() {
        return config.getToken();
    }

    //метод для создания меню
    private void createMenu() {
        //создаем список команд для меню (добавляем список команд для бота в меню и краткое описание)
//        //нельзя использовать верхний регистр в командах
        List<BotCommand> listOfCommands = new ArrayList<>(); //лист содержащий команды бота
        for (BotCommands botCommands : BotCommands.values()) {
            listOfCommands.add(new BotCommand(botCommands.getName(), botCommands.getDescription()));
        }

//        //передаем созданный выше список в бот
        try {
            this.execute(new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error("Error settings bot`s command list: {}", e.getMessage());
        }
    }

    //отправка стартового сообщения
    private void startCommandReceived(long id, String name) {
        String answer = EmojiParser.parseToUnicode("Hi, " + name + " , nice to meet you!" + " :blush:"
                + "The team of LLC \"ArsoBeton\" welcomes you!");
        log.info("Replied to user: {}", name);
        sendMessage(id, answer);
    }

    //отправка сообщения с логином и паролем
    private void getCredentialsForAuthentication(long id, String username, String password) {
        String answer = "We have generated a password for you to access some of the functions of our resource.\n" +
                "Login details:\n\nLogin: " + username + "\nPassword: " + password;
        log.info("User is given login parameters: login {}, password {}", username, password);
        sendMessage(id, answer);
    }

    //метод для регистрации пользователя и занесения в таблицу данных о нем
    private void registerUser(Message message) throws TelegramApiException {
        //проверяем не зарегистрирован ли пользователь уже,
        // если да - то мы его не сохраняем, если нет - сохраняем в БД
        if (userRepository.findById(message.getChatId()).isEmpty()) {

            User user = converterFromChatToUser.convert(message);
            userRepository.save(user);
            log.info("user saved: {}", user);
        } else if (!userRepository.findById(message.getChatId()).orElseThrow().isActive()) {
            User user = userRepository.findById(message.getChatId())
                    .orElseThrow(() -> new NotFoundException("User is not found"));
            user.setActive(true);
            userRepository.save(user);
            log.info("user is active again: {}", user);
        }
    }

    //что должен делать бот если ему кто-то пишет
    @Override
    public void onUpdateReceived(Update update) {

        //проверка того, что у нас есть что проверять в сообщении (что не пусто, чтоб не получить исключение)
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            //чтоб бот знал кому и что отправлять, передаем сразу
            long chatId = update.getMessage().getChatId(); //id чата, в котором работает бот

            //регистрируем пользователя и создаем меню при каждой
            // поступающей от него команды
            try {
                registerUser(update.getMessage());
                createMenu();
            } catch (TelegramApiException e) {
                log.error("We catch TelegramApiException with message: {}", e.getMessage());
            }

            //код для того, чтоб делать рассылку (набирать команду /send
            // и дальше писать текст для рассылки) + проверка на владельца бота (сравниваем chatId)
            if (messageText.contains(COMMAND_FOR_SEND_MESSAGE) && config.getOwnerId() == chatId) {
                //находим текст после /send
                sendOwnerCustomMessage(messageText, chatId);
            } else {
                if (Arrays.stream(BotCommands.values()).anyMatch(command -> command.getName().equals(messageText.toLowerCase()))) {
                    setActionsOnCommandsInBot(update, messageText, chatId);
                }
                //ищем совпадения по типу продукта
                else if (TypesOfProduct.contains(messageText)) {
                    sendMessageWithReplyKeyboard(chatId, TypesOfProduct.getDescriptionByTypeOfProduct(messageText), replyKeyboards.getReplyKeyboardForTypeOfProduct(messageText));
                    typeOfProductForFindToModelOfTypeOfProductIfBlock = messageText;
                } else if (productRepository.findByTypeOfProductAndModelOfTypeOfProduct(typeOfProductForFindToModelOfTypeOfProductIfBlock, messageText) != null) {
                    sendMessage(chatId, productRepository.findByTypeOfProductAndModelOfTypeOfProduct(typeOfProductForFindToModelOfTypeOfProductIfBlock, messageText.toUpperCase()).printInfo());
                } else {
                    sendMessage(chatId, "Sorry, command was not recognized");
                }

            }
        }
    }

    private void sendOwnerCustomMessage(String messageText, long chatId) {
        try {
            String textToSend = EmojiParser.parseToUnicode(messageText.substring(messageText.indexOf(" ")));
            List<User> users = userRepository.findAll();
            for (User user : users) {
                sendMessage(user.getId(), textToSend);
            }
        } catch (StringIndexOutOfBoundsException e) {
            String answer = "This message can contains more than a one symbol which follow after '/send'"; //текст ответа
            log.error("We catch StringIndexOutOfBoundsException: {}", e.getMessage());
            sendMessage(chatId, answer);
        }
    }

    private void setActionsOnCommandsInBot(Update update, String messageText, long chatId) {
        switch (messageText) {
            case "/start" -> startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
            // update.getMessage().getChat().getFirstName() - имя пользователя, с которым ведется чат

            case "/info" -> sendMessage(chatId, INFO_TEXT);
            case "/products" -> sendMessageWithReplyKeyboard(chatId, INFO_IN_MAIN_MENU_OF_PRODUCTS,
                    replyKeyboards.getReplyKeyboardCategoryOfProduct());
            case "/contacts" -> sendMessage(chatId, CONTACTS);
            case "/mycreds" -> {
                User user = userRepository.findById(chatId).orElseThrow();
                String username = user.getUsername();
                String password = String.valueOf(chatId);
                getCredentialsForAuthentication(chatId, username, password);
            }
            case "/website" -> sendMessage(chatId, LINK_TO_WEBSITE);
            case "/exit" -> makeUserInactive(chatId);

            //на все остальные запросы кроме /start будем отвечать
            default -> sendMessage(chatId, "Sorry, command was not recognized");
        }
    }

    private void makeUserInactive(long chatId) {
        try {
            User removableUser = userRepository.findById(chatId).orElseThrow(NotFoundException::new);
            removableUser.setActive(false);
            userRepository.save(removableUser);
            log.info("user is not active: {}", removableUser);
        } catch (NotFoundException e) {
            log.error("A user with id is {} is not found", chatId);
        }
    }

    // метод для отправки сообщений
    public void sendMessage(Long chatId, String textToSend) {
        SendMessage message = new SendMessage(); //sendMessage - исходящее сообщение
        message.setChatId(chatId);
        message.setText(textToSend); //сект сообщения

        //отправка сообщений
        executeSendMessage(message);
    }

    private void executeSendMessage(SendMessage message) {
        //отправка сообщений
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.info("Error occurred: {}", e.getMessage());
        }
    }

    // Метод для использования при команде /products. Здесь определяем
    // кнопки, прикрепленные к сообщению с вариантами ответов
    private void sendMessageWithReplyKeyboard(Long chatId, String descriptionForTypeOfProduct,
                                              ReplyKeyboardMarkup keyboardMarkup) {

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(descriptionForTypeOfProduct);
        message.setReplyMarkup(keyboardMarkup);
        executeSendMessage(message);
    }
}
