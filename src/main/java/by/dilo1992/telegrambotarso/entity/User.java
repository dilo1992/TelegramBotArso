package by.dilo1992.telegrambotarso.entity;

import jakarta.persistence.Column;
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
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "nickname")
    private String username;

    @Column(name = "registered_at")
    private Timestamp registeredAt;

    @Column(name = "is_active")
    private boolean isActive;
}
