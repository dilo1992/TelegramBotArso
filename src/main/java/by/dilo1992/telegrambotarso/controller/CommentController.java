package by.dilo1992.telegrambotarso.controller;

import by.dilo1992.telegrambotarso.converter.ConverterFromCommentDtoToComment;
import by.dilo1992.telegrambotarso.dto.CommentDto;
import by.dilo1992.telegrambotarso.entity.Comment;
import by.dilo1992.telegrambotarso.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping(value = "/comments")//, method = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor
@Slf4j
@SessionAttributes("comment")
public class CommentController {

    private final CommentService commentService;
    private final ConverterFromCommentDtoToComment converterFromCommentDtoToComment;

    @GetMapping()
    public String getAllComments(Model model, @RequestParam String typeOfProduct, @RequestParam String modelOfTypeOfProduct) {
        model.addAttribute("typeOfProduct", typeOfProduct);
        model.addAttribute("modelOfTypeOfProduct", modelOfTypeOfProduct);
        List<Comment> comments = commentService.findAllByTypeAndModelOfProduct(typeOfProduct, modelOfTypeOfProduct);
        model.addAttribute("comments", comments);
        return "comments";
    }

    @GetMapping("/addComment")
    public String createNewComment(Model model) {
        model.addAttribute("comments", commentService.findAll());
        return "addNewComments";
    }

    @PostMapping("/addComment")
    public String create(@Valid CommentDto commentDto, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            log.info("Comment is incorrect: {}", commentDto);
            model.addAttribute("org.springframework.validation.BindingResult.comment", result);
            model.addAttribute("comments", commentService.findAll());
            return "errorAddNewComment";
        }
        log.info("Comment is correct: {}", commentDto);

        CommentDto commentDtoForConvertToComment = new CommentDto(commentDto.getUsername(), commentDto.getTypeAndModelOfProduct(), commentDto.getFeedback(), commentDto.getRating());
        Comment comment = converterFromCommentDtoToComment.convert(commentDtoForConvertToComment);
        commentService.save(comment);
        model.addAttribute("comments", commentService.findAll());

        // для очистки сессии
        status.setComplete();

        // КОСТЫЛЬНЫЙ МЕТОД для удаления введенных нами данных в поля
        // для ввода (потому что после сохранения нами введенные нами данные
        // не стирались из самого поля для ввода, а оставались они)
        // А теперь после ввода вместо введенных нами данных вставляются пустые строки
        commentDto.setUsername(null);
        commentDto.setTypeAndModelOfProduct(null);
        commentDto.setFeedback("");
        commentDto.setRating(0);

        return "successAddNewComment";
    }

    @ModelAttribute(name = "comment")
    public CommentDto getNewComment() {
        return new CommentDto();
    }
}
