package com.projectup.Controller;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/inicio")
    public String goHome() {
        System.out.println("pagina de inicio");
        return "index";
    }
}

