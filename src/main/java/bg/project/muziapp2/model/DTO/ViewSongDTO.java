package bg.project.muziapp2.model.DTO;

import bg.project.muziapp2.model.Enums.GenreName;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ViewSongDTO {

    private Long id;

    private String title;

    private String artistName;

    private String albumTitle;

    private GenreName genre;

    public ViewSongDTO(Long id, String title, String artistName, String albumTitle, GenreName genre) {
        this.id = id;
        this.title = title;
        this.artistName = artistName;
        this.albumTitle = albumTitle;
        this.genre = genre;
    }

}
