package by.dilo1992.telegrambotarso.converter;


import by.dilo1992.telegrambotarso.dto.CommentDto;
import by.dilo1992.telegrambotarso.entity.Comment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentToCommentDtoConverter implements Converter<Comment, CommentDto> {

    @Override
    public CommentDto convert(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setUsername(comment.getUser().getUsername());
        String typeAndModelOfProduct = comment.getProduct().getTypeOfProduct() + "_" + comment.getProduct().getModelOfTypeOfProduct();
        commentDto.setTypeAndModelOfProduct(typeAndModelOfProduct);
        commentDto.setFeedback(comment.getFeedback());
        commentDto.setRating(comment.getRating());
        return commentDto;
    }


}
