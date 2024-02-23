package project.thirdproject.games;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepository extends JpaRepository<Games,Long> {
    Games findByName(String name);
}
