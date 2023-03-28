package by.dilo1992.telegrambotarso.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="type_of_product")
    private String typeOfProduct;

    @Column(name="model_of_type_of_product")
    private String modelOfTypeOfProduct;

    @Column(name="price")
    private int price;

    @Column(name="information_about_product")
    private String information;

    public String printToInformation() {
        return typeOfProduct + ": " + modelOfTypeOfProduct + "\n\n" +
                "price: " + price + " roubles\n\n" + information + "\n\n";
    }
}
