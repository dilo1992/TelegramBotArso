package by.dilo1992.telegrambotarso.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotBlank(message = "This field can`t be empty")
    private String typeAndModelOfProduct;

    @NotNull(message = "This field can`t be empty")
    private int price;
}