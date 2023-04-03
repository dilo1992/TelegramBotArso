package by.dilo1992.telegrambotarso.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "feedbacks")
@Data
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "rating")
    private double rating;

    public Comment(User user, Product product, String feedback, int rating) {
        this.user = user;
        this.product = product;
        this.feedback = feedback;
        this.rating = rating;
    }
}
