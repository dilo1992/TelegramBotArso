package by.dilo1992.telegrambotarso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "users_data_table")
@Data
public class User {

    @Id
    private Long chatId;

    private String firstname;

    private String lastname;

    private String username;

    private Timestamp registeredAt;

    private boolean isActive;
}
