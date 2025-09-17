package bg.project.muziapp2.model.DTO;

import bg.project.muziapp2.model.Enums.GenreName;

import java.util.List;

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

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }

    public GenreName getGenre() {
        return genre;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setGenre(GenreName genre) {
        this.genre = genre;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }
}
