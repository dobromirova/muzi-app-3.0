package bg.project.muziapp2.model.DTO;

import bg.project.muziapp2.model.Enums.GenreName;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public GenreName getGenre() {
        return genre;
    }

    public void setGenre(GenreName genre) {
        this.genre = genre;
    }
}
