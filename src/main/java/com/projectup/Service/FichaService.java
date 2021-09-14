package com.projectup.Service;

import com.projectup.beans.Ficha;
import com.projectup.repository.FichaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichaService {
    @Autowired private FichaRepository fichre;

    public List<Ficha> fichaList(){
        return (List<Ficha>) fichre.findAll();
    }

    public Optional<Ficha> fichaById(int id){
        return fichre.findById(id);
    }

    public Ficha guardarfich(Ficha ficha){
        return fichre.save(ficha);
    }
}
