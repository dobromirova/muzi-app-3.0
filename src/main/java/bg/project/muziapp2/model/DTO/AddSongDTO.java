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
import org.springframework.web.multipart.MultipartFile;

public class AddSongDTO {


    @NotNull
    @Size(min = 1, max = 40)
    private String title;

    @NotNull
    private String artist;

    private String album;

    @NotNull
    private GenreName genre;


    public AddSongDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public GenreName getGenre() {
        return genre;
    }

    public void setGenre(GenreName genre) {
        this.genre = genre;
    }

}
