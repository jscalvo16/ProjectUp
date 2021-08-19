package com.projectup.Controller;

import com.projectup.Service.FichaService;
import com.projectup.beans.Ficha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@SuppressWarnings("All")
@Controller
public class FichaController {
    @Autowired private FichaService fichser;

    @GetMapping("/fichas")
    public String listaFichas(Model model){
        List<Ficha> listaFichas = fichser.fichaList();
        model.addAttribute("listaFichas",listaFichas);
        System.out.println("estas en las lista de fichas que debemos arreglar:)");
        return "plantilla/plantilla";
  }
}

