package by.dilo1992.telegrambotarso.scheduled;

import by.dilo1992.telegrambotarso.entity.Ads;
import by.dilo1992.telegrambotarso.entity.User;
import by.dilo1992.telegrambotarso.repository.AdsRepository;
import by.dilo1992.telegrambotarso.repository.UserRepository;
import by.dilo1992.telegrambotarso.service.TelegramBotArso;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
@RequiredArgsConstructor
public class AdScheduler {

    private final AdsRepository adsRepository;
    private final UserRepository userRepository;
    private final TelegramBotArso bot;

    // Метод, который автоматически запускается
    //cron - один из параметров автозапуска (в определенное время запускает что-то)
    // cron имеет 7 параметров: секунды, минуты, часы, дата, месяц, день недели
    //* - любое значение
    //например: ****** - каждую секунду, 0***** - каждую минуту, 00**** - каждый час
    //можно еще так @hourly, @yearly, @monthly, @weekly, @daily
    @Scheduled(cron = "${cron.scheduler}")
    private void sendAds() {

        //список объявлений для отправки
        List<Ads> ads = adsRepository.findAll();

        //получаем список все пользователей, чтоб всем отправить
        List<User> users = userRepository.findAll().stream().filter(user -> user.isActive()).toList();

        //отправить каждому user каждый ad
        for (Ads ad : ads) {
            for (User user : users) {
                bot.sendMessage(user.getId(), ad.getAd());
            }
        }
    }
}
