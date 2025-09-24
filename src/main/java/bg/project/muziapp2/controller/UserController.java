package bg.project.muziapp2.controller;

import bg.project.muziapp2.model.DTO.UserLoginDTO;
import bg.project.muziapp2.model.DTO.UserRegisterDTO;
import bg.project.muziapp2.model.DTO.ViewProfileDTO;
import bg.project.muziapp2.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @ModelAttribute("registerData")
    public UserRegisterDTO registerDTO() {
        return new UserRegisterDTO();
    }

    @ModelAttribute("loginData")
    public UserLoginDTO loginDTO() {
        return new UserLoginDTO();
    }

    @GetMapping("/register")
    public String viewRegister(Model model){
        if (!model.containsAttribute("registerData")) {
            model.addAttribute("registerData", new UserRegisterDTO());
        }

        return "register";
    }


    @PostMapping("/register")
    public String doRegister(@Valid UserRegisterDTO data,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes
    ) {

        boolean passwordDiff = !data.getPassword().equals(data.getConfirmPassword());

        if (bindingResult.hasErrors() || passwordDiff) {
            redirectAttributes.addFlashAttribute("registerData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData", bindingResult);

            if (passwordDiff) {
                redirectAttributes.addFlashAttribute("passwordError", "Passwords do not match");
            }

            return "redirect:/register";
        }

        boolean success = userService.register(data);

        if (!success) {
            redirectAttributes.addFlashAttribute("registerError", "Username or email already exists.");
            redirectAttributes.addFlashAttribute("registerData", data);
            return "redirect:/register";
        }

        return "redirect:/login";

    }


    @GetMapping("/login")
    public ModelAndView viewLogin() {
        ModelAndView modelAndView = new ModelAndView("login");

        modelAndView.addObject("loginData", new UserLoginDTO());

        return modelAndView;
    }



    @GetMapping("/login-error")
    public ModelAndView viewLoginError() {
        ModelAndView modelAndView = new ModelAndView("login");

        modelAndView.addObject("showErrorMessage", true);
        modelAndView.addObject("loginData", new UserLoginDTO());

        return modelAndView;
    }





    @GetMapping("/profile")
    @Transactional
    public String profile(Model model) {


        ViewProfileDTO profileData = userService.getProfileData();
        model.addAttribute("profileView", profileData);

        return "profile";
    }













}
