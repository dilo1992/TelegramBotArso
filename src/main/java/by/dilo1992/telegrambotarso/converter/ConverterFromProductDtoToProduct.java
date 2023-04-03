package by.dilo1992.telegrambotarso.converter;

import by.dilo1992.telegrambotarso.dto.ProductDto;
import by.dilo1992.telegrambotarso.entity.Product;
import by.dilo1992.telegrambotarso.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ConverterFromProductDtoToProduct implements Converter<ProductDto, Product> {

    private final ProductRepository productRepository;

    @Override
    public Product convert(ProductDto productDto) {
        List<String> valuesFromFormWithTypeAndModelOfProduct = Arrays.stream(productDto.getTypeAndModelOfProduct().split("_")).toList();
        String typeOfProduct;
        String modelOfTypeOfProduct;
        if (valuesFromFormWithTypeAndModelOfProduct.size() == 2) {
            typeOfProduct = valuesFromFormWithTypeAndModelOfProduct.get(0);
            modelOfTypeOfProduct = valuesFromFormWithTypeAndModelOfProduct.get(1);
        } else
            throw new ArrayIndexOutOfBoundsException("Invalid type or model of product");
        return productRepository.findByTypeOfProductAndModelOfTypeOfProduct(typeOfProduct, modelOfTypeOfProduct);

    }
}
