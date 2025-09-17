package bg.project.muziapp2.model;

import bg.project.muziapp2.model.Enums.GenreName;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenreName name;


    private String description;


    @OneToMany(mappedBy = "genre")
    private List<Song> songs;

    @OneToMany(mappedBy = "genre")
    private List<Album> albums;

    public Genre() {
        this.songs = new ArrayList<>();
        this.albums = new ArrayList<>();
    }

    public Genre(GenreName name, String description) {
        this();


        this.name = name;
        this.description = description;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GenreName getName() {
        return name;
    }

    public void setName(GenreName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
