package by.dilo1992.telegrambotarso.entity;

import jakarta.persistence.*;
import lombok.Data;

//класс для объекта рекламы, которая будет храниться в БД и отправляться по времени
@Entity
@Table(name = "ads_table")
@Data
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
}
