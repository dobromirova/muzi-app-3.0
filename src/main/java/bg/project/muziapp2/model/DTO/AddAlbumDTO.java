package bg.project.muziapp2.model.DTO;

import bg.project.muziapp2.model.Artist;
import bg.project.muziapp2.model.Enums.GenreName;
import bg.project.muziapp2.model.Song;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class AddAlbumDTO {


    @NotNull
    @Size(min = 1, max = 40)
    private String title;

    private String releaseDate;

    @NotNull
    private String artist;

    @NotNull
    private GenreName genre;

    @NotNull
    private List<String> songs;



    public AddAlbumDTO() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    public GenreName getGenre() {
        return genre;
    }

    public void setGenre(GenreName genre) {
        this.genre = genre;
    }

    public List<String> getSongs() {

        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

}
