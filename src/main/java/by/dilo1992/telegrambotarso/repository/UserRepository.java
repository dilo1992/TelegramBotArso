package by.dilo1992.telegrambotarso.repository;


import by.dilo1992.telegrambotarso.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
