package by.dilo1992.telegrambotarso.entity;

import by.dilo1992.telegrambotarso.annotation.SelectProductModels;
import by.dilo1992.telegrambotarso.annotation.SelectTypeOfProducts;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_of_product")
    @SelectTypeOfProducts(message = "this is a non-transmission field")
    private String typeOfProduct;

    @Column(name = "model_of_type_of_product")
    @SelectProductModels
    private String modelOfTypeOfProduct;

    @Column(name = "price")
    @NotNull
    private int price;

    @Column(name = "information")
    private String information;

    public String printInfo() {
        return typeOfProduct + ": " + modelOfTypeOfProduct + "\n\n" +
                "price: " + price + " roubles\n\n" + information + "\n\n";
    }
}
