package by.dilo1992.telegrambotarso.controller;

import by.dilo1992.telegrambotarso.entity.Comment;
import by.dilo1992.telegrambotarso.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/comments")
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @GetMapping()
    public String getAllComments(Model model) {
        List<Comment> comments = commentService.findAll();
        model.addAttribute("comments", comments);
        return "viewAllPupils";
    }

}
