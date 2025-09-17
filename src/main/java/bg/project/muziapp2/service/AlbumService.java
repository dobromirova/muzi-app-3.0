package bg.project.muziapp2.service;

import bg.project.muziapp2.model.*;
import bg.project.muziapp2.model.DTO.AddAlbumDTO;
import bg.project.muziapp2.model.DTO.ViewAlbumDTO;
import bg.project.muziapp2.repo.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AlbumService {

    private final SongRepository songRepository;
    private final UserRepository userRepository;
    private final GenreRepository genreRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public AlbumService(SongRepository songRepository,
                        UserRepository userRepository,
                        GenreRepository genreRepository,
                        ArtistRepository artistRepository,
                        AlbumRepository albumRepository) {

        this.songRepository = songRepository;
        this.userRepository = userRepository;
        this.genreRepository = genreRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }


    @Transactional
    public boolean create(AddAlbumDTO data){

        // TODO: Get user ID.

       /* Optional<UserEntity> user = userRepository.findById(userSession.getId());

        if (user.isEmpty()) {
            return false;
        }*/

        Optional<Genre> genre = genreRepository.findByName(data.getGenre());

        if (genre.isEmpty()) {
            return false;
        }

        List<Song> songs = new ArrayList<>();

        Album album = new Album();


        // TITLE
        album.setTitle(data.getTitle());

        // RELEASED
        album.setReleaseDate(data.getReleaseDate());

        // ARTIST
        Artist artist = artistRepository.findByName(data.getArtist())
                .orElseGet(() -> {
                    Artist newArtist = new Artist();
                    newArtist.setName(data.getArtist());

                    return artistRepository.save(newArtist);
                });
        album.setArtist(artist);


        // GENRE
        album.setGenre(genre.get());

        // ADDED BY
        /*
        album.setAddedBy(user.get());*/


        albumRepository.save(album);

        // SONGS

        for (String songTitle : data.getSongs()) {
            Optional<Song> byTitleSong = songRepository.findByTitle(songTitle);

            Song song = byTitleSong.orElseGet(() -> {

                Song newSong = new Song();
                newSong.setTitle(songTitle);
                newSong.setArtist(artist);
                newSong.setGenre(genre.get());
              //  newSong.setAddedBy(user.get());
                newSong.setAlbum(album);



                return songRepository.save(newSong);

            });

            song.setAlbum(album);
            songs.add(song);

        }


        songRepository.saveAll(songs);

        album.setSongs(songs);
        albumRepository.save(album);

        return true;
    }


    public List<ViewAlbumDTO> getAllAlbums() {
        return albumRepository.findAll().stream()
                .map(album -> new ViewAlbumDTO(
                        album.getTitle(),
                        album.getArtist() != null ? album.getArtist().getName() : "Unknown",
                        album.getGenre().getName(),
                        album.getSongs().stream()
                                .map(Song::getTitle)
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }




}
