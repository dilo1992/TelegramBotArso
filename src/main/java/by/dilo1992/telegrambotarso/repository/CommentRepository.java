package by.dilo1992.telegrambotarso.repository;

import by.dilo1992.telegrambotarso.entity.Comment;
import by.dilo1992.telegrambotarso.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByProduct (Product product);
}
