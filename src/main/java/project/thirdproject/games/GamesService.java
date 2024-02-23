package project.thirdproject.games;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GamesService {
    private final GamesRepository gamesRepository;

    public List<Games> findGames() {
        return this.gamesRepository.findAll();
    }

    public void saveGames(String name, String playerNm, String playerAg, String playTime, String price, String imgUrl, String releaseKr, String releaseAb, String genre, List<String> video, List<String> detailImg) {
        Games games = this.gamesRepository.findByName(name);
        if (games == null) {
            Games games1 = new Games();
            games1.setName(name);
            games1.setPlayerNm(playerNm);
            games1.setPlayerAg(playerAg);
            games1.setPlayTime(playTime);
            games1.setPrice(price);
            games1.setImgUrl(imgUrl);
            games1.setReleaseKr(releaseKr);
            games1.setReleaseAb(releaseAb);
            games1.setGenre(genre);
            if(detailImg.size() >= 3){
                games1.setDeImgUrls(detailImg.get(0));
                games1.setDeImgUrls2(detailImg.get(1));
                games1.setDeImgUrls3(detailImg.get(2));
            } else if(detailImg.size() == 2){
                games1.setDeImgUrls(detailImg.get(0));
                games1.setDeImgUrls2(detailImg.get(1));
            }else{
                games1.setDeImgUrls(detailImg.get(0));
            }

            if (!video.isEmpty()) {
                games1.setVideoUrl(video.get(0));
            }
            this.gamesRepository.save(games1);
        }

    }
}
