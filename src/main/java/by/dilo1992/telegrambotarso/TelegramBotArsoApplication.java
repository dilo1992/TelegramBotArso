package by.dilo1992.telegrambotarso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories
@PropertySource("classpath:database.properties")
public class TelegramBotArsoApplication {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);  //для кодировки
        // используем, в скобках указываем силу кодировки
        // (рекомендуется сила от 6 (до 31), по дефолту -1)
    }

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotArsoApplication.class, args);
    }
}
