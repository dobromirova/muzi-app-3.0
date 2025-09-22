package bg.project.muziapp2.model.DTO;

import bg.project.muziapp2.model.Enums.GenreName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ViewAlbumDTO {

    private String title;

    private String artistName;

    private GenreName genre;

    private List<String> songs;

    public ViewAlbumDTO(String title, String artistName, GenreName genre, List<String> songs) {
        this.title = title;
        this.artistName = artistName;
        this.genre = genre;
        this.songs = songs;
    }
}
