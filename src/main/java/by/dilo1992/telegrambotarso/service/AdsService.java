package by.dilo1992.telegrambotarso.service;

import by.dilo1992.telegrambotarso.entity.Ads;
import by.dilo1992.telegrambotarso.repository.AdsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdsService {

    private final AdsRepository adsRepository;

    public void resetEnteredAds(Ads ads) {
        ads.setAd(null);
        ads.setRhythm(null);
    }

    public void delete(Long id) {
        adsRepository.deleteById(id);
    }
}
