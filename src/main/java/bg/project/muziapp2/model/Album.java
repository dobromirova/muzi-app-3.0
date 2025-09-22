package bg.project.muziapp2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "albums")
@Getter
@Setter
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    private String releaseDate;

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private Genre genre;

    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
    private List<Song> songs;
    @ManyToOne
    private UserEntity addedBy;


    public Album() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
        song.setAlbum(this);

    }

}
