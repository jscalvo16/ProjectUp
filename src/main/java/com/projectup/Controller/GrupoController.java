package com.projectup.Controller;


import com.projectup.Service.GrupoService;
import com.projectup.beans.Grupo;
import com.projectup.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class GrupoController {

    private List<User> listIntegrantes;

    @Autowired
    private GrupoService grupoService;


    //Mostrar la informacion del grupo
    @GetMapping("/descripcion/{id}")
    public String grupoId(@PathVariable("id") int id, Model model) {
        Grupo grupo = grupoService.grupoById(id).get();
        model.addAttribute("infoGrupo", grupo);
        listIntegrantes = grupo.getUserG();
        model.addAttribute("integrantes", listIntegrantes);
        return "integrantes";
    }

    //Crear grupos



}
