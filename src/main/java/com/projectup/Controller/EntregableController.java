package com.projectup.Controller;

import com.projectup.Service.EntregableService;
import com.projectup.Service.FaseService;
import com.projectup.Service.UserService;
import com.projectup.beans.Entregable;
import com.projectup.beans.Fase;
import com.projectup.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EntregableController {


    @Autowired
    private EntregableService entregableService;

    @Autowired
    private FaseService faseService;

    //Mostrar formulario para crear el entregable
    @GetMapping("/crearentregable")
    public String mostrarFormularioEntregable(Entregable entregable,Model model){
        model.addAttribute("infoEntregable",entregable);

        System.out.println("Estas en el registro de los entregables");
        List<Fase>listaFase=faseService.listaFase();
        model.addAttribute("listaFase",listaFase);
        return "entregables";
    }



}
