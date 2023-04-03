package by.dilo1992.telegrambotarso.controller;

import by.dilo1992.telegrambotarso.dto.CommentDto;
import by.dilo1992.telegrambotarso.dto.ProductDto;
import by.dilo1992.telegrambotarso.service.CommentService;
import by.dilo1992.telegrambotarso.service.ProductService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

@Controller
@RequestMapping("/products")
@Data
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;
    private final CommentService commentService;

    @GetMapping
    public String getAllProducts(Model model, Principal principal) {
        model.addAttribute("products", productService.findAll());
        commentService.initModelForGet(model);
        commentService.getAttributeIsAdmin(model, principal);
        return "products";
    }

    @GetMapping("/")
    public String getProductByTypeAndModelOfProduct(@RequestParam String typeOfProduct, @RequestParam String modelOfTypeOfProduct, Model model, Principal principal) {
        model.addAttribute("product", productService.findByTypeOfProductAndModelOfTypeOfProduct(typeOfProduct, modelOfTypeOfProduct));
        commentService.getAttributeIsAdmin(model, principal);
        return "products";
    }

    @GetMapping("/formForCorrectPrice")
    public String getEmptyFormForCorrectPriceOfProduct(Model model, Principal principal) {
        commentService.getAttributeIsAdmin(model, principal);
        return "correctPrice";
    }

    @PostMapping("/correctPrice")
    public String correctPrice(@Valid ProductDto productDto, Errors errors, Model model, SessionStatus status, Principal principal) {
        try {
            if (errors.hasErrors()) {
                log.info("Product is incorrect: {}", productDto);
                model.addAttribute("products", productService.findAll());
                commentService.getAttributeIsAdmin(model, principal);
                return "errorCorrectPrice";
            }
            log.info("Comment is correct: {}", productDto);
            commentService.getAttributeIsAdmin(model, principal);

            ProductDto productDtoForSave = new ProductDto(productDto.getTypeAndModelOfProduct(), productDto.getPrice());
            productService.correctPrice(productDtoForSave);

            // для очистки сессии
            status.setComplete();

            // КОСТЫЛЬНЫЙ МЕТОД для удаления введенных нами данных в поля
            // для ввода (потому что после сохранения нами введенные нами данные
            // не стирались из самого поля для ввода, а оставались они)
            // А теперь после ввода вместо введенных нами данных вставляются пустые строки
            productService.resetEnteredProductDto(productDto);

            return "successCorrectPrice";
        } catch (Exception e) {
            log.error(e.getMessage());
            model.addAttribute("error", e.getMessage());
            commentService.getAttributeIsAdmin(model, principal);
            return "errorCorrectPrice";
        }
    }


    @ModelAttribute(name = "product")
    public ProductDto getNewProduct() {
        return new ProductDto();
    }

}
