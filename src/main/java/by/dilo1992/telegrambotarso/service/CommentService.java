package by.dilo1992.telegrambotarso.service;

import by.dilo1992.telegrambotarso.converter.ConverterFromCommentDtoToComment;
import by.dilo1992.telegrambotarso.dto.CommentDto;
import by.dilo1992.telegrambotarso.entity.Comment;
import by.dilo1992.telegrambotarso.entity.Product;
import by.dilo1992.telegrambotarso.model.TypesOfProduct;
import by.dilo1992.telegrambotarso.repository.CommentRepository;
import by.dilo1992.telegrambotarso.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    public static final String CONCRETE = TypesOfProduct.CONCRETE.name();
    public static final String CEMENT = TypesOfProduct.CEMENT.name();
    public static final String CFB_BLOCK = TypesOfProduct.CFB_BLOCK.name();

    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;
    private static final DecimalFormat df = new DecimalFormat("#.#");
    private final ConverterFromCommentDtoToComment converterFromCommentDtoToComment;


    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public List<Comment> findAllByProduct(Product product) {
        return commentRepository.findAllByProduct(product).orElseThrow();
    }

    public List<Comment> findAllByTypeAndModelOfProduct(String typeOfProduct, String modelOfTypeOfProduct) {
        Product product = productRepository.findByTypeOfProductAndModelOfTypeOfProduct(typeOfProduct, modelOfTypeOfProduct);
        return commentRepository.findAllByProduct(product).orElseThrow();
    }

    public String getAverageRatingForPrint(String typeOfProduct, String modelOfTypeOfProduct) {
        List<Comment> comments = findAllByTypeAndModelOfProduct(typeOfProduct, modelOfTypeOfProduct);
        List<Double> ratings = new ArrayList<>();
        for (Comment comment : comments) {
            ratings.add(comment.getRating());
        }
        double avgRatingWithoutFormat = ratings.stream().mapToDouble(rating -> rating).average().orElse(0);
        return df.format(avgRatingWithoutFormat);
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public void save(CommentDto commentDto) {
        Comment comment = converterFromCommentDtoToComment.convert(commentDto);
        commentRepository.save(comment);
    }

    public void initModelForGet(Model model) {
        model.addAttribute("sizeOfArrConcreteM100", findAllByTypeAndModelOfProduct(CONCRETE, "M100").size());
        model.addAttribute("sizeOfArrConcreteM150", findAllByTypeAndModelOfProduct(CONCRETE, "M150").size());
        model.addAttribute("sizeOfArrConcreteM200", findAllByTypeAndModelOfProduct(CONCRETE, "M200").size());
        model.addAttribute("sizeOfArrConcreteM250", findAllByTypeAndModelOfProduct(CONCRETE, "M250").size());
        model.addAttribute("sizeOfArrConcreteM300", findAllByTypeAndModelOfProduct(CONCRETE, "M300").size());
        model.addAttribute("sizeOfArrConcreteM350", findAllByTypeAndModelOfProduct(CONCRETE, "M350").size());
        model.addAttribute("sizeOfArrConcreteM400", findAllByTypeAndModelOfProduct(CONCRETE, "M400").size());
        model.addAttribute("sizeOfArrConcreteM450", findAllByTypeAndModelOfProduct(CONCRETE, "M450").size());
        model.addAttribute("sizeOfArrConcreteM500", findAllByTypeAndModelOfProduct(CONCRETE, "M500").size());
        model.addAttribute("sizeOfArrCementM50", findAllByTypeAndModelOfProduct(CEMENT, "M50").size());
        model.addAttribute("sizeOfArrCementM75", findAllByTypeAndModelOfProduct(CEMENT, "M75").size());
        model.addAttribute("sizeOfArrCementM100", findAllByTypeAndModelOfProduct(CEMENT, "M100").size());
        model.addAttribute("sizeOfArrCementM150", findAllByTypeAndModelOfProduct(CEMENT, "M150").size());
        model.addAttribute("sizeOfArrCementM200", findAllByTypeAndModelOfProduct(CEMENT, "M200").size());
        model.addAttribute("sizeOfArrCfbF200", findAllByTypeAndModelOfProduct(CFB_BLOCK, "F200").size());
        model.addAttribute("sizeOfArrCfbF250", findAllByTypeAndModelOfProduct(CFB_BLOCK, "F250").size());


        model.addAttribute("averageRatingConcreteM100", getAverageRatingForPrint(CONCRETE, "M100"));
        model.addAttribute("averageRatingConcreteM150", getAverageRatingForPrint(CONCRETE, "M150"));
        model.addAttribute("averageRatingConcreteM200", getAverageRatingForPrint(CONCRETE, "M200"));
        model.addAttribute("averageRatingConcreteM250", getAverageRatingForPrint(CONCRETE, "M250"));
        model.addAttribute("averageRatingConcreteM300", getAverageRatingForPrint(CONCRETE, "M300"));
        model.addAttribute("averageRatingConcreteM350", getAverageRatingForPrint(CONCRETE, "M350"));
        model.addAttribute("averageRatingConcreteM400", getAverageRatingForPrint(CONCRETE, "M400"));
        model.addAttribute("averageRatingConcreteM450", getAverageRatingForPrint(CONCRETE, "M450"));
        model.addAttribute("averageRatingConcreteM500", getAverageRatingForPrint(CONCRETE, "M500"));
        model.addAttribute("averageRatingCementM50", getAverageRatingForPrint(CEMENT, "M50"));
        model.addAttribute("averageRatingCementM75", getAverageRatingForPrint(CEMENT, "M75"));
        model.addAttribute("averageRatingCementM100", getAverageRatingForPrint(CEMENT, "M100"));
        model.addAttribute("averageRatingCementM150", getAverageRatingForPrint(CEMENT, "M150"));
        model.addAttribute("averageRatingCementM200", getAverageRatingForPrint(CEMENT, "M200"));
        model.addAttribute("averageRatingCfbF200", getAverageRatingForPrint(CFB_BLOCK, "F200"));
        model.addAttribute("averageRatingCfbF250", getAverageRatingForPrint(CFB_BLOCK, "F250"));


    }

    public void resetEnteredCommentDto(CommentDto commentDto) {
        commentDto.setUsername(null);
        commentDto.setTypeAndModelOfProduct(null);
        commentDto.setFeedback("");
        commentDto.setRating(0);
    }

    public void getAttributeIsAdmin(Model model, Principal principal) {
        try {
            String username = principal.getName();
            model.addAttribute("username", username);
        } catch (NullPointerException e) {
            model.addAttribute("username", "anonymous");
        }
    }
}
