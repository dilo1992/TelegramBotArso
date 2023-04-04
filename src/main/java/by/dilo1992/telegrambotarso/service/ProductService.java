package by.dilo1992.telegrambotarso.service;

import by.dilo1992.telegrambotarso.converter.ProductDtoToProductConverter;
import by.dilo1992.telegrambotarso.dto.ProductDto;
import by.dilo1992.telegrambotarso.entity.Product;
import by.dilo1992.telegrambotarso.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoToProductConverter converterFromProductDtoToProduct;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findByTypeOfProductAndModelOfTypeOfProduct(String typeOfProduct, String modelOfTypeOfProduct) {
        return productRepository.findByTypeOfProductAndModelOfTypeOfProduct(typeOfProduct, modelOfTypeOfProduct);
    }


    public void correctPrice(ProductDto productDto) {
        Product product = converterFromProductDtoToProduct.convert(productDto);
//        productRepository.delete(product);
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }

    public void deleteByTypeAndModelOfProduct(String typeOfProduct, String modelOfTypeOfProduct) {
        productRepository.deleteByTypeOfProductAndModelOfTypeOfProduct(typeOfProduct, modelOfTypeOfProduct);
    }

    public void resetEnteredProductDto(ProductDto productDto) {
        productDto.setPrice(0);
        productDto.setTypeAndModelOfProduct(null);
    }

}
