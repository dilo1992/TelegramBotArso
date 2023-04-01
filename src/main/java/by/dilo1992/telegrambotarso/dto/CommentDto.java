package by.dilo1992.telegrambotarso.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    @NotNull
    private String username;

    @NotBlank(message = "This field can`t be empty")
    private String typeAndModelOfProduct;

    @NotBlank(message = "This field can`t be empty")
    private String feedback;

    @Min(value = 1, message = "rating can`t be less than 1")
    @Max(value = 5, message = "rating can`t be more than 5")
    private double rating;
}
