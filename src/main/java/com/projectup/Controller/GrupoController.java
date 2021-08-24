package com.projectup.Controller;


import com.projectup.Service.GrupoService;
import com.projectup.Service.UserService;
import com.projectup.beans.Grupo;
import com.projectup.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@SuppressWarnings("ALL")
@Controller
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private UserService userService;


    //Mostrar la informacion del grupo
    @GetMapping("/descripcion/{id}")
    public String grupoId(@PathVariable("id") int id, Model model) {
        Grupo grupo = grupoService.grupoById(id).get();
        model.addAttribute("infoGrupo", grupo);
        List<User> listIntegrantes = grupo.getUserG();
        model.addAttribute("integrantes", listIntegrantes);
        return "integrantes";
    }

    //Mostrar información dentro del modal
    @PostMapping("/grupo/nuevo")
    public String guardarGrupo(Grupo grupo, Model model){
        System.out.println("Formulario para crear un nuevo grupo");
        model.addAttribute("grupoInfo", new Grupo());
        List<User> usersSinGrupo = userService.listAll();
        model.addAttribute("sinGrupo", usersSinGrupo);
        return "plantilla/modal";
    }


}
