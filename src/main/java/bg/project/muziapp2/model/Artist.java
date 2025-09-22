package bg.project.muziapp2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists")
@Getter
@Setter
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "artist")
    private List<Album> albums;

    @OneToMany(mappedBy = "artist")
    private List<Song> songs;

    public Artist() {
        this.albums = new ArrayList<>();
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
        song.setArtist(this);
    }

}
