package by.dilo1992.telegrambotarso.repository;

import by.dilo1992.telegrambotarso.entity.Comment;
import by.dilo1992.telegrambotarso.entity.Product;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findByProduct(Product product);
}
