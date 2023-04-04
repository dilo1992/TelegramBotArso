package by.dilo1992.telegrambotarso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = {"by.dilo1992"})
@EnableJpaRepositories
@PropertySource("classpath:application.properties")
public class TelegramBotArsoApplication {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
        //for encoding
        // we use, in brackets we indicate the encoding strength
        // (recommended strength from 6 (up to 31), by default -1)
    }

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotArsoApplication.class, args);
    }
}
