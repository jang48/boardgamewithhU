package project.thirdproject;

import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.thirdproject.games.Games;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class map {

    private Map<String, Map<String, Long>> gameFeatures;
    @GetMapping("/map")
    public void getMap(List<Games> gamesList){
        this.gameFeatures = new HashMap<>();

        // 각 게임의 특성 벡터를 생성하여 맵에 저장
        for (Games game : gamesList) {
            Map<String, Long> features = new HashMap<>();
            features.put("playerAg", Long.valueOf(game.getPlayerAg().replaceAll("[^0-9]","")));
            gameFeatures.put(game.getName(), features);
        }
    }
}
