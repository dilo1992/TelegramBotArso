package by.dilo1992.telegrambotarso.repository;

import by.dilo1992.telegrambotarso.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByTypeOfProduct(String typeOfProduct);

    Product findByTypeOfProductAndModelOfTypeOfProduct(String typeOfProduct, String modelOfType);

    void deleteByTypeOfProductAndModelOfTypeOfProduct(String typeOfProduct, String modelOfTypeOfProduct);
}
