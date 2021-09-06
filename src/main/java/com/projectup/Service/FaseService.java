package com.projectup.Service;

import com.projectup.beans.Fase;
import com.projectup.repository.FaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaseService {
    @Autowired private FaseRepository fase;

    public List<Fase> listaFase(){
        return (List<Fase>) fase.findAll();
    }
}
