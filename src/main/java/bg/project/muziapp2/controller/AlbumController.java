package bg.project.muziapp2.controller;

import bg.project.muziapp2.model.DTO.AddAlbumDTO;
import bg.project.muziapp2.model.DTO.ViewAlbumDTO;
import bg.project.muziapp2.service.AlbumService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {

    private final AlbumService albumService;


    public AlbumController(AlbumService albumService) {

        this.albumService = albumService;
    }

    @ModelAttribute("albumData")
    public AddAlbumDTO albumData(){
        AddAlbumDTO dto = new AddAlbumDTO();
        dto.setSongs(new ArrayList<>(List.of("")));

        return dto;
    }


    @GetMapping("/add-album")
    public String addAlbum(){

        return "album-add";
    }

    @PostMapping("/add-album")
    public String doAddAlbum(
            @Valid @ModelAttribute("albumData") AddAlbumDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            @RequestParam(required = false) String action,
            Model model
    ) {


        if ("addSong".equals(action)) {
            if (data.getSongs() == null) {
                data.setSongs(new ArrayList<>());
            }
            data.getSongs().add("");
            model.addAttribute("albumData", data);
            return "album-add";
        }


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumData", data);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.albumData", bindingResult);

            return "redirect:/add-album";
        }


        boolean success = albumService.create(data);

        if (!success) {
            redirectAttributes.addFlashAttribute("albumData", data);

            return "redirect:/add-album";
        }


        return "redirect:/home";
    }

    @GetMapping("/view-albums")
    public String albumView(Model model) {


        List<ViewAlbumDTO> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);

        return "albums-view";
    }



}
