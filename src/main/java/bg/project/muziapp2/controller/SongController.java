package bg.project.muziapp2.controller;

import bg.project.muziapp2.model.DTO.AddSongDTO;
import bg.project.muziapp2.model.DTO.ViewSongDTO;
import bg.project.muziapp2.model.Song;
import bg.project.muziapp2.service.SongService;
import bg.project.muziapp2.service.UserHelperService;
import bg.project.muziapp2.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;
    private final UserService userService;
    private final UserHelperService userHelperService;

    @ModelAttribute("songData")
    public AddSongDTO songData(){
        return new AddSongDTO();
    }


    @GetMapping("/add-song")
   // @PreAuthorize("hasRole('ADMIN')") // THIS IS OPTIONAL FOR THE SAKE OF TESTING ROLES IN SPRING SECURITY. REMOVE IN CASE IT BREAKS
    public String addSong(){


        return "song-add";
    }



    @PostMapping("/add-song")
    public String doAddSong(
            @Valid AddSongDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("songData", data);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.songData", bindingResult);

            return "redirect:/add-song";
        }

        boolean success = songService.create(data);

        if (!success) {
            redirectAttributes.addFlashAttribute("songData", data);

            return "redirect:/add-song";
        }


        return "redirect:/home";
    }


    // View ALL songs
    @GetMapping("/view-songs")
    public String songView(Model model) {

        List<ViewSongDTO> songs = songService.getAllSongs();
        model.addAttribute("songs", songs);

        return "songs-view";
    }


    @PostMapping("/add-to-favourites/{songId}")
    public String addToFavourites(@PathVariable long songId) {

        songService.addToFavourites(userHelperService.getUserId(), songId);



        return "songs-view";
    }


    @GetMapping("/view-favourites")
    @Transactional
    public String viewFavourites(Model model) {


        List<Song> favourites = userService.findFavourites(userHelperService.getUserId());

        model.addAttribute("favouritesData", favourites);


        return "favourites-view";
    }


}
