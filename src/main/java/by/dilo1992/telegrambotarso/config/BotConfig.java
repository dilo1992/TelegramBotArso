package by.dilo1992.telegrambotarso.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

//аннотация обозначает, что есть методы, подлежащие автоматическому запуску
//должна быть в классе с аннотацией @Configuration
@EnableScheduling
@Configuration
@Data
public class BotConfig {

    @Value("${bot.name}")
    private String botName;

    @Value("${bot.token}")
    private String token;

    @Value("${bot.owner}")
    private Long ownerId;
}
