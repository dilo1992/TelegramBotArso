package by.dilo1992.telegrambotarso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TelegramBotArsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotArsoApplication.class, args);
    }
}
