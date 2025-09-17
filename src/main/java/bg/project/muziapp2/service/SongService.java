package bg.project.muziapp2.service;

import bg.project.muziapp2.model.*;
import bg.project.muziapp2.model.DTO.AddSongDTO;
import bg.project.muziapp2.model.DTO.ViewSongDTO;
import bg.project.muziapp2.repo.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SongService {

    private final SongRepository songRepository;
    private final UserRepository userRepository;
    private final GenreRepository genreRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public SongService(SongRepository songRepository,
                       UserRepository userRepository,
                       GenreRepository genreRepository, ArtistRepository artistRepository,
                       AlbumRepository albumRepository) {

        this.songRepository = songRepository;
        this.userRepository = userRepository;
        this.genreRepository = genreRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }


    public boolean create(AddSongDTO data) {


        //TODO: Get user ID
        // Optional<UserEntity> byId = userRepository.findById(userSession.getId());

        /* if (byId.isEmpty()) {
            return false;
        } */


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
      // TODO: Get user ID  song.setAddedBy(byId.get());


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

        userOptional.get().addFavourite(songOptional.get());

        userRepository.save(userOptional.get());


    }



}
