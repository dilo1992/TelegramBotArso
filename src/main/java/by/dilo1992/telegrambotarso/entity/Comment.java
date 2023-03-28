package by.dilo1992.telegrambotarso.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Table(name = "feedbacks")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

//    @SelectTypeOfProductFromEnum
//    private String typeOfProduct;
//
//    @SelectProductModelFromEnum
//    private String productModel;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Product product;

    @NotNull
    @Column(name = "feedback")
    private String feedback;

    @NotNull
    @Column(name = "rating")
    private int rating;

}
