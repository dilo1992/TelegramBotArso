package by.dilo1992.telegrambotarso.model;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public enum TypesOfProduct {

    CEMENT("A large-scale construction process rarely " +
            "does without concrete. It is necessary for pouring the foundation, " +
            "sealing cracks and voids. The main advantage of the material is durability. " +
            "A high-quality mortar will allow you to build a safe structure, the strength " +
            "of which will retain its original characteristics for many years.\n" +
            "Select the type of product you are interested in"),
    CFB_BLOCK("FBS blocks or foundation blocks are the basis " +
            "of any construction. They are used in laying the foundation, erecting walls and " +
            "other structures. These blocks are not designed for heavy loads, as they are made " +
            "from low grades of concrete. Additionally, blocks can be reinforced to improve the " +
            "reliability of the structure. FBS blocks are often also used for buildings without " +
            "heating. This is due to the characteristics of the product.\n" +
            "Select the type of product you are interested in"),
    CONCRETE("For the manufacture of this type, binder " +
            "components of the mixture are used. Cement is the main binding element, depending " +
            "on the brand, the class and strength of concrete are determined. With strict " +
            "adherence to manufacturing technology, the final properties of the material are " +
            "comparable to natural granite. This quality is used for the construction of " +
            "complex structures:\n" + "load-bearing structures;\n" + "power plants;\n" +
            "high security facilities.\n" + "Select the type of product you are interested in");

    private String description;

    TypesOfProduct() {}

    TypesOfProduct(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static String getDescriptionByTypeOfProduct(String typeOfProduct) throws IllegalArgumentException {
        try {
            TypesOfProduct.valueOf(typeOfProduct);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage() + "Our company does not produce products of the introduced type {}", typeOfProduct);
        }
        return TypesOfProduct.valueOf(typeOfProduct).getDescription();
    }

    public static boolean contains(String typeOfProduct) {
        return Arrays.stream(TypesOfProduct.values()).anyMatch(type -> type.name().equals(typeOfProduct.toUpperCase()));
    }
}

