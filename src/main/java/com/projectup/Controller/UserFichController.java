package com.projectup.Controller;

import com.projectup.Service.UsuaFichService;
import com.projectup.beans.UsuaFich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserFichController {
    @Autowired private UsuaFichService service;

    @GetMapping("/listaficha")
    public String muestra(Model model){
        List<UsuaFich> listaUsFich = service.lista();
        model.addAttribute("listaUsFich",listaUsFich);
        System.out.println("Estamos en la lista de aprendices");

        return "temporal";
    }
}
