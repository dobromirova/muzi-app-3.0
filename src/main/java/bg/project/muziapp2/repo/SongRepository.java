package bg.project.muziapp2.repo;

import bg.project.muziapp2.model.Enums.GenreName;
import bg.project.muziapp2.model.Genre;
import bg.project.muziapp2.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByTitle(String songTitle);


}
