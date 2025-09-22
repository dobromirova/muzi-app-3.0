package bg.project.muziapp2.service;

import bg.project.muziapp2.model.*;
import bg.project.muziapp2.model.DTO.AddSongDTO;
import bg.project.muziapp2.model.DTO.ViewSongDTO;
import bg.project.muziapp2.model.Enums.GenreName;
import bg.project.muziapp2.repo.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final UserRepository userRepository;
    private final GenreRepository genreRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;
    private final UserHelperService userHelperService;



    public boolean create(AddSongDTO data) {



        if (getUser().isEmpty()) {
            return false;
        }


        Optional<Genre> genre = genreRepository.findByName(data.getGenre());

        if (genre.isEmpty()) {
            return false;
        }

        Song song = new Song();


        // TITLE
        song.setTitle(data.getTitle());

        // ARTIST
        Artist artist = artistRepository.findByName(data.getArtist())
                .orElseGet(() -> {
                    Artist newArtist = new Artist();
                    newArtist.setName(data.getArtist());
                    return artistRepository.save(newArtist);
                });
        song.setArtist(artist);

        // ALBUM
        Album album = albumRepository.findByTitle(data.getAlbum())
                .orElseGet(() -> {
                    Album newAlbum = new Album();
                    newAlbum.setTitle(data.getAlbum());
                    newAlbum.setArtist(artist);
                    newAlbum.setGenre(genre.get());
                    return albumRepository.save(newAlbum);
                });
        song.setAlbum(album);

        // GENRE
        song.setGenre(genre.get());


        // ADDED BY


        song.setAddedBy(userHelperService.getUser());

        artist.addSong(song);
        album.addSong(song);


        songRepository.save(song);

        return true;
    }

    public List<ViewSongDTO> getAllSongs() {
        return songRepository.findAll().stream()
                .map(song -> new ViewSongDTO(
                        song.getId(),
                        song.getTitle(),
                        song.getArtist() != null ? song.getArtist().getName() : "Unknown",
                        song.getAlbum() != null ? song.getAlbum().getTitle() : "Unknown",
                        song.getGenre().getName()
                ))
                .collect(Collectors.toList());
    }


    /*
    public Map<GenreName, List<Song>> findAllByGenre() {
        Map<GenreName, List<Song>> result = new HashMap<>();

        List<Genre> allGenres = genreRepository.findAll();

        for (Genre gen : allGenres) {
            List<Song> songs = songRepository.findAllByGenre(gen);

            result.put(gen.getName(), songs);
        }


        return result;
    } */



    @Transactional
    public void addToFavourites(Long id, long songId){

        Optional<UserEntity> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            return;
        }

        Optional<Song> songOptional = songRepository.findById(songId);

        if (songOptional.isEmpty()) {
            return;
        }

        userOptional.get().setFavouriteSongs(List.of(songOptional.get()));

        userRepository.save(userOptional.get());


    }

    public Optional<UserEntity> getUser() {

        return userRepository.findById(userHelperService.getUserId());
    }


    public ViewSongDTO getSongById(long id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Song with ID " + id + " not found"));

        return mapToDTO(song);
    }

    private ViewSongDTO mapToDTO(Song song) {
        Long id = song.getId();
        String title = song.getTitle();
        String artistName = song.getArtist() != null ? song.getArtist().getName() : null;
        String albumTitle = song.getAlbum() != null ? song.getAlbum().getTitle() : null;
        GenreName genre = song.getGenre() != null ? song.getGenre().getName() : null;

        return new ViewSongDTO(id, title, artistName, albumTitle, genre);

    }





}
