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

    // A method that is automatically run
    //cron is one of the parameters of autostart (starts something at a certain time)
    // cron has 7 parameters: seconds, minutes, hours, date, month, day of the week
    //* - any value
    //for example: ****** - every second, 0***** - every minute, 00**** - every hour
    //it's also possible @hourly, @yearly, @monthly, @weekly, @daily
    @Scheduled(cron = "${cron.scheduler-every-minute}")
    private void sendAdsEveryMinute() {

// list of ads to send
        List<Ads> ads = adsRepository.findAllByRhythm("MINUTE");

//get a list of all users to send to everyone
        List<User> users = userRepository.findAll().stream().filter(user -> user.isActive()).toList();

//send every user every ad
        for (Ads ad : ads) {
            for (User user : users) {
                bot.sendMessage(user.getId(), ad.getAd());
            }
        }
    }

    @Scheduled(cron = "${cron.scheduler-every-hour}")
    private void sendAdsEveryHour() {

        List<Ads> ads = adsRepository.findAllByRhythm("HOUR");
        List<User> users = userRepository.findAll().stream().filter(user -> user.isActive()).toList();
        for (Ads ad : ads) {
            for (User user : users) {
                bot.sendMessage(user.getId(), ad.getAd());
            }
        }
    }

    @Scheduled(cron = "${cron.scheduler-every-day}")
    private void sendAdsEveryDay() {

        List<Ads> ads = adsRepository.findAllByRhythm("DAY");
        List<User> users = userRepository.findAll().stream().filter(user -> user.isActive()).toList();
        for (Ads ad : ads) {
            for (User user : users) {
                bot.sendMessage(user.getId(), ad.getAd());
            }
        }
    }

    @Scheduled(cron = "${cron.scheduler-every-month}")
    private void sendAdsEveryMonth() {

        List<Ads> ads = adsRepository.findAllByRhythm("MONTH");
        List<User> users = userRepository.findAll().stream().filter(user -> user.isActive()).toList();
        for (Ads ad : ads) {
            for (User user : users) {
                bot.sendMessage(user.getId(), ad.getAd());
            }
        }
    }

    @Scheduled(cron = "${cron.scheduler-every-year}")
    private void sendAdsEveryYear() {

        List<Ads> ads = adsRepository.findAllByRhythm("YEAR");
        List<User> users = userRepository.findAll().stream().filter(user -> user.isActive()).toList();
        for (Ads ad : ads) {
            for (User user : users) {
                bot.sendMessage(user.getId(), ad.getAd());
            }
        }
    }
}
