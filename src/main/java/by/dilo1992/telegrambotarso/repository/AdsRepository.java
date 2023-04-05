package by.dilo1992.telegrambotarso.repository;

import by.dilo1992.telegrambotarso.entity.Ads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdsRepository extends JpaRepository<Ads, Long> {
    List<Ads> findAllByRhythm(String rhythm);
}
