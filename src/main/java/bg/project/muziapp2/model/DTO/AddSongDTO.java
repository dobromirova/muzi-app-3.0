package bg.project.muziapp2.model.DTO;

import bg.project.muziapp2.model.Album;
import bg.project.muziapp2.model.Artist;
import bg.project.muziapp2.model.Enums.GenreName;
import bg.project.muziapp2.model.Genre;
import jakarta.annotation.Nullable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@NoArgsConstructor
public class AddSongDTO {

    private String title;
    private String artist;
    private String album;
    private GenreName genre;

}
