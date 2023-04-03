package by.dilo1992.telegrambotarso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String getMainView(Model model, Principal principal) {
        try {
            String username = principal.getName();
            model.addAttribute("username", username);
        } catch (NullPointerException e) {
            model.addAttribute("username", "anonymous");
        }
        return "main";
    }
}
