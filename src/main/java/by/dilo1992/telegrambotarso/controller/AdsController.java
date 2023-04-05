package by.dilo1992.telegrambotarso.controller;

import by.dilo1992.telegrambotarso.entity.Ads;
import by.dilo1992.telegrambotarso.repository.AdsRepository;
import by.dilo1992.telegrambotarso.service.AdsService;
import by.dilo1992.telegrambotarso.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/ads")
@RequiredArgsConstructor
@Slf4j
public class AdsController {

    private final AdsRepository adsRepository;
    private final AdsService adsService;
    private final CommentService commentService;

    @GetMapping()
    public String getAllAds(Model model, Principal principal) {
        commentService.getAttributeIsAdmin(model, principal);
        model.addAttribute("ads", adsRepository.findAll());
        return "ads";
    }

    @GetMapping("/form")
    public String getEmptyPageForAddAds(Model model, Principal principal) {
        commentService.getAttributeIsAdmin(model, principal);
        return "addNewAds";
    }

    @PostMapping("/new")
    public String createAd(@Valid Ads ads, Errors errors, Model model, SessionStatus status, Principal principal) {
        try {
            if (errors.hasErrors()) {
                log.info("Ad is incorrect: {}", ads);
                model.addAttribute("ads", adsRepository.findAll());
                commentService.getAttributeIsAdmin(model, principal);
                return "errorAddNewAd";
            }
            log.info("Ad is correct: {}", ads);
            commentService.getAttributeIsAdmin(model, principal);
            Ads adForSave = new Ads(ads.getAd(), ads.getRhythm());
            adsRepository.save(adForSave);

            status.setComplete();

            adsService.resetEnteredAds(ads);

            return "successAddNewAd";
        } catch (NoSuchElementException e) {
            log.error(e.getMessage());
            model.addAttribute("error", "Please, check entered data");
            commentService.getAttributeIsAdmin(model, principal);
            return "errorAddNewAd";
        }
    }

    @GetMapping("/removeForm")
    public String getRemoveForm(Model model, Principal principal) {
        commentService.getAttributeIsAdmin(model, principal);
        return "removeAds";
    }


    @GetMapping("remove/id")
    public String removeAdById(@RequestParam("id") Long id, Model model, HttpServletRequest request, SessionStatus status, Principal principal) {
        commentService.getAttributeIsAdmin(model, principal);
        if (adsRepository.findById(id).isPresent()) {

            adsService.delete(id);
            model.addAttribute("ads", adsRepository.findAll());
            status.setComplete();
            return "successRemoveAd";
        } else {
            model.addAttribute("error", "Ad with this id is not found");
            commentService.getAttributeIsAdmin(model, principal);
            return "errorRemoveAd";
        }
    }

    @ModelAttribute(name = "ad")
    public Ads getNewAd() {
        return new Ads();
    }
}

