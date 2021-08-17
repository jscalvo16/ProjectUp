package com.projectup.Controller;

import com.projectup.Service.UserService;
import com.projectup.beans.Rol;
import com.projectup.Service.RolService;
import com.projectup.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@SuppressWarnings("All")
@Controller
public class UserController {
    @Autowired private UserService userService;
    @Autowired private RolService rolService;

    // Mostrar los usuarios existentes
    @GetMapping("/lista")
    public String verLista(Model model){
        List<User> listaUser = userService.listAll();
        model.addAttribute("listaUser",listaUser);
        List<Rol> listaRol = rolService.listaRol();
        model.addAttribute("listRol",listaRol);
        System.out.println("estas en la lista de los usuarios");
        return "ListaUsuarios";
    }

    // Vista para agregar un usuario
    @GetMapping("/nuevo")
    public String mostrarRegister(User user, RedirectAttributes re, Model model){
        model.addAttribute("user",new User());
        System.out.println("Estas en el registro de usuarios");
        List<Rol> listaRol = rolService.listaRol();
        model.addAttribute("listRol",listaRol);
        model.addAttribute("titulo", "Registrar usuarios");

        return "register";
    }

    // Método gregar un nuevo usuario
    @PostMapping("/registrar")
    public String registrarUsario(User user,Model model){
        user  = userService.save(user);
        if(user != null){
            System.out.println("se registro exitosamente");
        }else{
            System.out.println("Ocurrio un error");
        }

        return "redirect:lista";
    }

    // Vista para modificar un usuario
    @GetMapping("usuario/editar/{id}")
    public String modificarUsuario(@PathVariable("id") int id, Model model){
        User user = userService.findUserById(id).get();
        model.addAttribute("user", user);
        System.out.println("id usuario: " + id);
        List<Rol> listaRol = rolService.listaRol();
        model.addAttribute("listRol",listaRol);
        model.addAttribute("titulo", "Modificar usuarios");
        return "register";
    }

}
