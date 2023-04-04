package by.dilo1992.telegrambotarso.converter;


import by.dilo1992.telegrambotarso.dto.CommentDto;
import by.dilo1992.telegrambotarso.entity.Comment;
import by.dilo1992.telegrambotarso.repository.UserRepository;
import by.dilo1992.telegrambotarso.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentDtoToCommentConverter implements Converter<CommentDto, Comment> {

    private final ProductService productService;
    private final UserRepository userRepository;

    @Override
    public Comment convert(CommentDto commentDto) {
        Comment comment = new Comment();
        List<String> valuesFromFormWithTypeAndModelOfProduct = Arrays.stream(commentDto.getTypeAndModelOfProduct().split("_")).toList();
        String typeOfProduct;
        String modelOfTypeOfProduct;
        if (valuesFromFormWithTypeAndModelOfProduct.size() == 2) {
            typeOfProduct = valuesFromFormWithTypeAndModelOfProduct.get(0);
            modelOfTypeOfProduct = valuesFromFormWithTypeAndModelOfProduct.get(1);
        } else
            throw new ArrayIndexOutOfBoundsException("Invalid type or model of product");
        comment.setUser(userRepository.findByUsername(commentDto.getUsername()).orElseThrow());
        comment.setProduct(productService.findByTypeOfProductAndModelOfTypeOfProduct(typeOfProduct, modelOfTypeOfProduct));
        comment.setFeedback(commentDto.getFeedback());
        comment.setRating(commentDto.getRating());
        return comment;
    }
}
