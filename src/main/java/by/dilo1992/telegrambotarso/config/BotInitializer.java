package by.dilo1992.telegrambotarso.config;


import by.dilo1992.telegrambotarso.service.TelegramBotArso;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

//класс для инициализации бота
@Component
@Slf4j
@RequiredArgsConstructor
public class BotInitializer {

    private final TelegramBotArso bot;

    @EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            log.error("Error occurred: {}", e.getMessage());
            throw new TelegramApiException("Bot does not register");
        }
    }
}
