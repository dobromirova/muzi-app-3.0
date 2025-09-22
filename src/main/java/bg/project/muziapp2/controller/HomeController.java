package bg.project.muziapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    public HomeController() {
    }


    @GetMapping("/")
    public String nonLoggedIndex(){



        return "index";
    }

    @GetMapping("/home")
    public String loggedInIndex(){

        return "home";
    }



//    @GetMapping("/access-denied")
//    public String accessDenied(){
//
//        return "home";
//    }





}
