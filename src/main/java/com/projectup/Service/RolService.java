package com.projectup.Service;

import com.projectup.beans.Rol;
import com.projectup.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired private RolRepository rolp;

    public List<Rol> listaRol(){
        return (List<Rol>) rolp.findAll();
    }
}
