package com.projectup.Service;

import com.projectup.beans.UsuaFich;
import com.projectup.repository.UserFichaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuaFichService {
    @Autowired
    UserFichaRepository repo;
    public List<UsuaFich> lista(){
        return (List<UsuaFich>) repo.findAll();
    }

}
