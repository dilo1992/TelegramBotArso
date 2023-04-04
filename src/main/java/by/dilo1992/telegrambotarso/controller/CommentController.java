package by.dilo1992.telegrambotarso.controller;

import by.dilo1992.telegrambotarso.dto.CommentDto;
import by.dilo1992.telegrambotarso.entity.Comment;
import by.dilo1992.telegrambotarso.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping(value = "/comments")
@RequiredArgsConstructor
@Slf4j
@SessionAttributes("comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping()
    public String getAllComments(Model model, @RequestParam String typeOfProduct, @RequestParam String modelOfTypeOfProduct, Principal principal) {
        model.addAttribute("typeOfProduct", typeOfProduct);
        model.addAttribute("modelOfTypeOfProduct", modelOfTypeOfProduct);
        List<Comment> comments = commentService.findAllByTypeAndModelOfProduct(typeOfProduct, modelOfTypeOfProduct);
        model.addAttribute("comments", comments);
        commentService.getAttributeIsAdmin(model, principal);
        return "comments";
    }


    @GetMapping("/form")
    public String getAddCommentEmptyPage(Model model, Principal principal) {
        commentService.getAttributeIsAdmin(model, principal);
        return "addNewComments";
    }

    @PostMapping("/new")
    public String create(@Valid CommentDto commentDto, Errors errors, Model model, SessionStatus status, Principal principal) {
        try {
            if (errors.hasErrors()) {
                log.info("Comment is incorrect: {}", commentDto);
                model.addAttribute("comments", commentService.findAll());
                commentService.getAttributeIsAdmin(model, principal);
                return "errorAddNewComment";
            }
            log.info("Comment is correct: {}", commentDto);
            commentService.getAttributeIsAdmin(model, principal);
            CommentDto commentDtoForSave = new CommentDto(commentDto.getUsername(), commentDto.getTypeAndModelOfProduct(), commentDto.getFeedback(), commentDto.getRating());
            commentService.save(commentDtoForSave);

            // для очистки сессии
            status.setComplete();

            commentService.resetEnteredCommentDto(commentDto);

            return "successAddNewComment";
        } catch (NoSuchElementException e) {
            log.error(e.getMessage());
            model.addAttribute("error", "Оставлять комментарии могут только зарегистрированные пользователи");
            commentService.getAttributeIsAdmin(model, principal);
            return "errorAddNewComment";
        }
    }


    @ModelAttribute(name = "comment")
    public CommentDto getNewComment() {
        return new CommentDto();
    }


}
