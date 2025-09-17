package bg.project.muziapp2.repo;

import bg.project.muziapp2.model.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsernameOrEmail(String username, String email);

    Optional<UserEntity> findByUsername(String username);

    @EntityGraph(attributePaths = {
            "favouriteSongs",
            "favouriteSongs.artist",
            "favouriteSongs.album"
    })
    Optional<UserEntity> findFavouritesById(Long id);
}
