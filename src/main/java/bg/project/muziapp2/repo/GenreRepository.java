package bg.project.muziapp2.repo;

import bg.project.muziapp2.model.Enums.GenreName;
import bg.project.muziapp2.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByName(GenreName name);
}
