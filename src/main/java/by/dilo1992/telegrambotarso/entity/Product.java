package by.dilo1992.telegrambotarso.entity;

import by.dilo1992.telegrambotarso.annotation.SelectProductModelFromEnum;
import by.dilo1992.telegrambotarso.annotation.SelectTypeOfProductFromEnum;
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

    @SelectTypeOfProductFromEnum(message = "this is a non-transmission field")
    private String typeOfProduct;

    @SelectProductModelFromEnum
    private String modelOfTypeOfProduct;

    @NotNull
    private int price;

    private String information;

    public String printToInformation() {
        return typeOfProduct + ": " + modelOfTypeOfProduct + "\n\n" +
                "price: " + price + " roubles\n\n" + information + "\n\n";
    }
}
