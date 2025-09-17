package bg.project.muziapp2.controller;

import bg.project.muziapp2.model.DTO.AddSongDTO;
import bg.project.muziapp2.model.DTO.ViewSongDTO;
import bg.project.muziapp2.model.Song;
import bg.project.muziapp2.service.SongService;
import bg.project.muziapp2.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
public class SongController {

    private final SongService songService;
    private final UserService userService;

    public SongController(SongService songService, UserService userService) {
        this.songService = songService;
        this.userService = userService;
    }

    @ModelAttribute("songData")
    public AddSongDTO songData(){
        return new AddSongDTO();
    }




    @GetMapping("/add-song")
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


/*
    @GetMapping("/view-songs")
    public String songView(Model model) {
        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }

    //    Map<GenreName, List<Song>> allSongs = songService.findAllByGenre();


    //    model.addAttribute("POP",allSongs.get(GenreName.POP));




                              <option value="POP">Pop</option>
                                <option value="ROCK">Rock</option>
                                <option value="RNB">R&B</option>
                                <option value="JAZZ">Jazz</option>
                                <option value="KPOP">K-pop</option>
                                <option value="LATIN">Latin</option>

        //    songService.findFavourites(userSession.getId());

        List<Song> songs = songService.getAllSongs();
        model.addAttribute("songs", songs);


        return "/songs-view";
    }   */

    @GetMapping("/view-songs")
    public String songView(Model model) {

        List<ViewSongDTO> songs = songService.getAllSongs();
        model.addAttribute("songs", songs);

        return "songs-view";
    }


    @PostMapping("/add-to-favourites/{songId}")
    public String addToFavourites(@PathVariable long songId) {


        //TODO: Get user ID and add song to user favourites.


      //  songService.addToFavourites(, songId);



        return "redirect:/home";
    }


    @GetMapping("/view-favourites")
    @Transactional
    public String viewFavourites(Model model) {

       //TODO: Get user favourites


      //  List<Song> favourites = userService.findFavourites(userSession.getId());
      //  model.addAttribute("favouritesData", favourites);


        return "favourites-view";
    }


}
