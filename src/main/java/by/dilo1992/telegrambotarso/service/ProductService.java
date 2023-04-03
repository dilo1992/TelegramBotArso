package by.dilo1992.telegrambotarso.service;

import by.dilo1992.telegrambotarso.converter.ConverterFromProductDtoToProduct;
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
    private final ConverterFromProductDtoToProduct converterFromProductDtoToProduct;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByTypeOfProduct(String typeOfProduct) {
        return productRepository.findAllByTypeOfProduct(typeOfProduct);
    }

    public Product findByTypeOfProductAndModelOfTypeOfProduct(String typeOfProduct, String modelOfTyoeOfProduct) {
        return productRepository.findByTypeOfProductAndModelOfTypeOfProduct(typeOfProduct, modelOfTyoeOfProduct);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void save(ProductDto productDto) {
        Product product = converterFromProductDtoToProduct.convert(productDto);
        productRepository.save(product);
    }

    public void correctPrice(ProductDto productDto) {
        Product product = converterFromProductDtoToProduct.convert(productDto);
        productRepository.delete(product);
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
