package bg.project.muziapp2.model.DTO;

import bg.project.muziapp2.model.Artist;
import bg.project.muziapp2.model.Enums.GenreName;
import bg.project.muziapp2.model.Song;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AddAlbumDTO {

    private String title;
    private String releaseDate;
    private String artist;
    private GenreName genre;
    private List<String> songs;


}
