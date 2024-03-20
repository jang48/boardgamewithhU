package project.thirdproject.games;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class GamesController {
    private final GamesService gamesService;

    @GetMapping({"/product"})
    public String showGamesInfo(Model model) throws IOException {

        List<Games> gamesList = this.gamesService.findGames();
        if(gamesList.size() < 0){
            getGamesInfo();
        }

        model.addAttribute("gamesList", gamesList);
        return "games";
    }

    public void getGamesInfo() throws IOException {
        String URL = "https://www.koreaboardgames.com/shop/big_section.php";
        Map<String, String> details = new HashMap<>();
        String playerNm = null;
        String playerAg = null;
        String playTime = null;

        for (int p = 0; p < 11; ++p) {
            String params = "?page=" + p + "&cno1=1001";
            Document doc = Jsoup.connect(URL + params).get();
//            Elements prdimgElements = doc.select(".prdimg img");
//            Elements explanationElements = doc.select(".explanation li");
//            Elements nameElements = doc.select(".name a");
//            Elements priceElements = doc.select(".price p");

            Elements products = doc.select("#prd_basic .box");
            for (Element product : products) {
                Elements prdimgElements = product.select(".prdimg img");
                Elements explanationElements = product.select(".explanation li");
                if (!explanationElements.isEmpty()) {
                    playerNm = ((Element) explanationElements.get(0)).text();
                    playerAg = ((Element) explanationElements.get(1)).text();
                    playTime = ((Element) explanationElements.get(2)).text();
                }
                Elements nameElements = product.select(".name a");
                Elements priceElements = product.select(".price p");

                String imageUrl = ((Element) prdimgElements.get(0)).attr("src");
                String href = ((Element) nameElements.get(0)).attr("href");
                DetailGamesInfo DetailGamesInfo = getGamesDetailInfo(href);
                String name = ((Element) nameElements.get(0)).text();
                String priceText = ((Element) priceElements.get(0)).text();
                String price = priceText.replaceAll(",", "").replaceAll("원", "");
                this.gamesService.saveGames(name, playerNm, playerAg, playTime, price, imageUrl, DetailGamesInfo.getDetailInfo().get("국내"), DetailGamesInfo.getDetailInfo().get("해외"), DetailGamesInfo.getDetailInfo().get("장르"),DetailGamesInfo.getImgYoutube(),DetailGamesInfo.getImgUrls());
            }
        }
    }

    public DetailGamesInfo getGamesDetailInfo(String href) throws IOException {
        Map<String, String> detailInfo = new HashMap<>();
        String detailURL = href;
        Document doc = Jsoup.connect(detailURL).get();
        Elements infoElements = doc.select(".tbl_prdinfo th");
        Elements infotxElements = doc.select(".tbl_prdinfo td");

        Elements infoYoutube = doc.select(".detail_info iframe");
        List<String> imgYoutube = new ArrayList<>();
        if(!infoYoutube.isEmpty())
        {
            for (Element iframe : infoYoutube) {
                imgYoutube.add(iframe.attr("src"));
            }
        }

        Elements infoimgs = doc.select(".detail_info img");
        List<String> imgUrls = new ArrayList<>();

        for (Element img : infoimgs) {
            imgUrls.add(img.attr("src"));
        }

        for (int i = 0; i < infoElements.size(); i++) {
            String idx = infoElements.get(i).text();
            if (idx.contains("국내")) {
                detailInfo.put("국내", infotxElements.get(i).text());
            } else if (idx.contains("해외")) {
                detailInfo.put("해외", infotxElements.get(i).text());
            } else if (idx.contains("장르")) {
                detailInfo.put("장르", infotxElements.get(i).text());
            }
        }
        return new DetailGamesInfo(imgYoutube, imgUrls, detailInfo);
    }
}
