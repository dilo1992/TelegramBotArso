package by.dilo1992.telegrambotarso.entity;

import jakarta.persistence.*;
import lombok.Data;

//class for the advertising object, which will be stored in the DB and sent over time
@Entity
@Table(name = "ads_table")
@Data
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad")
    private String ad;
}
