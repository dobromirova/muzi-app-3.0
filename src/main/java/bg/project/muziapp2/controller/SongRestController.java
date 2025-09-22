package bg.project.muziapp2.controller;

import bg.project.muziapp2.model.DTO.ViewSongDTO;
import bg.project.muziapp2.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongRestController {

    private final SongService songService;

    @GetMapping
    public List<ViewSongDTO> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public ViewSongDTO getSongById(@PathVariable long id) {
        return songService.getSongById(id);
    }


}
