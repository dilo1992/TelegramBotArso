package by.dilo1992.telegrambotarso.controller;

import by.dilo1992.telegrambotarso.service.CommentService;
import by.dilo1992.telegrambotarso.service.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
@Data
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;
    private final CommentService commentService;

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        commentService.initModelForGet(model);
        return "products";
    }

    @GetMapping("{typeOfProduct}&{modelOfTypeOfProduct}")
    public String getProductByTypeAndModelOfProduct(String typeOfProduct, String modelOfTypeOfProduct, Model model) {
        model.addAttribute("product", productService.findByTypeOfProductAndModelOfTypeOfProduct(typeOfProduct, modelOfTypeOfProduct));
        return "products";
    }
}
