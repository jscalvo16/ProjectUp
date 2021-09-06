package com.projectup.Controller;


import com.projectup.Service.GrupoService;
import com.projectup.beans.Grupo;
import com.projectup.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("ALL")
@Controller
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    //Mostrar la informacion del grupo
    @GetMapping("/descripcion/{id}")
    public String grupoId(@PathVariable("id") int id, Model model) {
        Grupo grupo = grupoService.grupoById(id).get();
        model.addAttribute("infoGrupo", grupo);
        List<User> listIntegrantes = grupo.getUserG();
        model.addAttribute("integrantes", listIntegrantes);
        return "integrantes";
    }

    // Crear un grupo de proyecto
    @PostMapping("/creargrupo")
    public String mostrarGrupo(@Valid Grupo grupo, Errors errores, Model model){
        if(errores.hasErrors()){
            System.out.println("Validación realizada con exito");
            return "fichas";
        }

        grupo = grupoService.guardarGrupo(grupo);
        if(grupo != null){
            System.out.println("Información del grupo guardada correctamente");
        }else {
            System.out.println("Error en el proceso de guardado");
        }
        return "fichas";
    }

}
