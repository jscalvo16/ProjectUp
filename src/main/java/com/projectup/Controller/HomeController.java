package com.projectup.Controller;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/inicio")
    public String goHome() {
        System.out.println("Pagina de inicio");
        return "index";
    }

    @GetMapping("/login")
    public String goLogin(){
        System.out.println("Pagina de login");
        return "login";
    }
}

