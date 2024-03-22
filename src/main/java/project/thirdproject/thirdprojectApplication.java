package project.thirdproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing // @EntityListeners(AuditingEntityListener.class) 가 작동하도록 허용
@EnableAsync // 비동기 기능 활성화
public class thirdprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(thirdprojectApplication.class, args);
    }

}
