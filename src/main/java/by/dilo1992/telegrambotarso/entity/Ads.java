package by.dilo1992.telegrambotarso.entity;

import by.dilo1992.telegrambotarso.annotation.SelectRhythmToSendAd;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//class for the advertising object, which will be stored in the DB and sent over time
@Entity
@Table(name = "ads_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "rhythm")
    @SelectRhythmToSendAd
    private String rhythm;

    public Ads(String ad, String rhythm) {
        this.ad = ad;
        this.rhythm = rhythm;
    }
}
