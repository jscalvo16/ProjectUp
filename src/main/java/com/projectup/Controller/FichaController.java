package com.projectup.Controller;

import com.projectup.Service.FichaService;
import com.projectup.beans.Ficha;
import com.projectup.beans.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@SuppressWarnings("All")
@Controller
public class FichaController {

    @Autowired
    private FichaService fichser;

    // Mostrar el listado de fichas
    @GetMapping("/fichas")
    public String listaFichas(Model model) {
        List<Ficha> listaFichas = fichser.fichaList();
        model.addAttribute("listaFichas", listaFichas);
        System.out.println("estas en las lista de fichas que debemos arreglar:)");
        return "plantilla/plantilla";
    }

    // Mostrar la información de la ficha seleccionada por id
    @GetMapping("/ficha/{id}")
    public String fichaId(@PathVariable("id") int id, Model model){
        // Mostrar información de la ficha
        Ficha ficha=fichser.fichaById(id).get();
        model.addAttribute("infoFicha", ficha);

        // Mostrar información de los grupos de la ficha
        model.addAttribute("grupos", ficha.getListGrupos());

        // Mostar información de los integrantes de la ficha
        model.addAttribute("lista", ficha.getListaPivoteF());

        // Mostrar información para crear un grupo de proyecto
        model.addAttribute("grupoInfo", new Grupo());
        return "fichas";
    }
    @GetMapping("/crearfich")
    public String MostrarFich(Ficha ficha, Model model){
        model.addAttribute("listado",ficha.getListaPivoteF());
        model.addAttribute("ficha", new Ficha());
        System.out.println("interfaz para crear fichas");
        return "CrearFicha";
    }
    @PostMapping("/registrarfich")
    public String crearFich(Ficha ficha, Model model, BindingResult res){
        ficha = fichser.guardarfich(ficha);
        if (res.hasErrors()){
            System.out.println("Algo courrio !!!");
            return "CrearFicha";
        }
        System.out.println("Se registro e forma exitosa !!!");
        return "redirect:fichas";
    }
}

