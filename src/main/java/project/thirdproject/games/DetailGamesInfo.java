package project.thirdproject.games;

import java.util.List;
import java.util.Map;

public class DetailGamesInfo {
    private List<String> imgYoutube;
    private List<String> imgUrls;
    private Map<String, String> detailInfo;

    public DetailGamesInfo(List<String> imgYoutube, List<String> imgUrls, Map<String, String> detailInfo) {
        this.imgYoutube = imgYoutube;
        this.imgUrls = imgUrls;
        this.detailInfo = detailInfo;
    }

    public List<String> getImgYoutube() {
        return imgYoutube;
    }

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public Map<String, String> getDetailInfo() {
        return detailInfo;
    }
}
