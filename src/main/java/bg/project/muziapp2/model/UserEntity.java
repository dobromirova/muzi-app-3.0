package bg.project.muziapp2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "addedBy")
    private List<Song> songsAdded;

    @OneToMany
    private List<Album> albumsAdded;

    @ManyToMany
    private List<Song> favouriteSongs;

    public UserEntity() {
        this.songsAdded = new ArrayList<>();
        this.favouriteSongs = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Song> getSongsAdded() {
        return songsAdded;
    }

    public void setSongsAdded(List<Song> songsAdded) {
        this.songsAdded = songsAdded;
    }


    public List<Song> getFavouriteSongs() {
        return favouriteSongs;
    }

    public void setFavouriteSongs(List<Song> favouriteSongs) {
        this.favouriteSongs = favouriteSongs;
    }

    public List<Album> getAlbumsAdded() {
        return albumsAdded;
    }

    public void setAlbumsAdded(List<Album> albumsAdded) {
        this.albumsAdded = albumsAdded;
    }

    public void addFavourite(Song song) {
        this.favouriteSongs.add(song);
    }
}
