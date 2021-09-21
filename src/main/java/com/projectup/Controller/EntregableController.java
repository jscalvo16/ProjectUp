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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EntregableController {


    @Autowired
    private EntregableService entregableService;

    @Autowired
    private FaseService faseService;

//mostrar los entregables existentes

    @GetMapping("/listaentregables")
    public String verListaEntregable(Model model) {
        List<Entregable> listaEntregable = entregableService.listAll();
        model.addAttribute("listaEntregable", listaEntregable);
        List<Fase> listaFase = faseService.listaFase();
        model.addAttribute("listaFase", listaFase);
        System.out.println("Estas en la lista de los entregables");
        return "entregables";
    }


    //Mostrar formulario para crear el entregable

    @PostMapping("/crearentregable")
    public String resgitrarEntregable(Entregable entregable, BindingResult result, Model model) {
        entregable = entregableService.guardarEntregable(entregable);
        if (entregable != null) {
            System.out.println("Se creo el entregable correctamente");
        } else {
            System.out.println("Ocurrio un error al crear el entregable");
        }

        return "fichas";
    }

    //Modificar el entregable
    @GetMapping("entregable/modificar/{id}")
    public String mosificarEntregable(@PathVariable("id") int id, Model model) {
        Entregable entregable = entregableService.entregableById(id).get();
        model.addAttribute("entregable", entregable);
        System.out.println("id entregable" + id);
        List<Fase> listaFase = faseService.listaFase();
        model.addAttribute("listRol", listaFase);
        return "entregables";
    }

}
