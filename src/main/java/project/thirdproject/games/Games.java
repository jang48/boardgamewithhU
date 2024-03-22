package project.thirdproject.games;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;            // 이름

    String playTime;        // 플레이 시간

    String playerNm;        // 플레이어 인원

    String playerAg;        // 플레이어 나이

    String price;           // 가격

    @Column(columnDefinition = "text")
    String imgUrl;          // 이미지 URL

    String releaseKr;       // 출시연도(한국)

    String releaseAb;       // 출시연도(외국)

    String Genre;           // 장르

    @Column(columnDefinition = "text")
    String deImgUrls; // 상세 이미지 URL

    @Column(columnDefinition = "text")
    String deImgUrls2; // 상세 이미지 URL

    @Column(columnDefinition = "text")
    String deImgUrls3; // 상세 이미지 URL

    @Column(columnDefinition = "text")
    String videoUrl;  // 비디오 URL
}
