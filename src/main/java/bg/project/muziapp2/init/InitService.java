package bg.project.muziapp2.init;

import bg.project.muziapp2.model.Enums.GenreName;
import bg.project.muziapp2.model.Genre;
import bg.project.muziapp2.repo.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class InitService implements CommandLineRunner {

    private final Map<GenreName, String> descriptions = Map.of(
            GenreName.POP, "", //TODO: ADD DESC
            GenreName.ROCK, "",
            GenreName.RNB, "",
            GenreName.JAZZ, "",
            GenreName.KPOP, "",
            GenreName.LATIN, ""
    );


    private final GenreRepository genreRepository;

    @Override
    public void run(String... args) throws Exception {

        long count = this.genreRepository.count();

        if (count > 0) {
            return;
        }

        List<Genre> toInsert = Arrays.stream(GenreName.values()).map(
                gen -> new Genre(gen, descriptions.get(gen))
        ).toList();

        this.genreRepository.saveAll(toInsert);


    }
}
