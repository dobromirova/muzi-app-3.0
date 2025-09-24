package bg.project.muziapp2.model;

import bg.project.muziapp2.model.Enums.GenreName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenreName name;

    @Lob
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


}
