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

    private String typeOfProduct;

    private String modelOfTypeOfProduct;

    private int price;

    private String information;

    public String printToInformation() {
        return typeOfProduct + ": " + modelOfTypeOfProduct + "\n\n" +
                "price: " + price + " roubles\n\n" + information + "\n\n";
    }
}
