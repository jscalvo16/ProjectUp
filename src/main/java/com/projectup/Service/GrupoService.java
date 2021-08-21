package com.projectup.Service;

import com.projectup.beans.Grupo;
import com.projectup.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    //buscar por id
    public Optional<Grupo> grupoById(int id){
        return grupoRepository.findById(id);
    }

//metodo para guardar un grupo

    public Grupo guardarGrupo(Grupo grupo){

        return grupoRepository.save(grupo);
    }
}
