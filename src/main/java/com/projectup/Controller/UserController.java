package com.projectup.Controller;

import com.projectup.Service.UserService;
import com.projectup.beans.Rol;
import com.projectup.Service.RolService;
import com.projectup.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.Validate;

import java.util.List;
@SuppressWarnings("All")
@Controller
public class UserController {
    @Autowired private UserService userSer;
    @Autowired private RolService rolSer;

    @GetMapping("/lista")
    public String verLista(Model model){
        List<User> listaUser = userSer.listAll();
        model.addAttribute("listaUser",listaUser);
        List<Rol> listaRol = rolSer.listaRol();
        model.addAttribute("listRol",listaRol);
        System.out.println("estas en la lista de los usuarios");
        return "ListaUsuarios";
    }

    @GetMapping("/nuevo")
    public String mostrarRegister(User user, RedirectAttributes re, Model model){
        System.out.println("Estas en el registro de usuarios");
        List<Rol> listaRol = rolSer.listaRol();
        model.addAttribute("listRol",listaRol);

        model.addAttribute("user",new User());
        return "register";
    }
    @PostMapping("/registrar")
    public String registrarUsario(User user,Model model){
         user  = userSer.save(user);
        if(user != null){
            System.out.println("se registro exitosamente");
        }else{
            System.out.println("Ocurrio un error");
        }

        return "redirect:lista";
    }

}
