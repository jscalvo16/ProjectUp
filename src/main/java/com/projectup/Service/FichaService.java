package com.projectup.Service;

import com.projectup.beans.Ficha;
import com.projectup.repository.FichaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaService {
    @Autowired private FichaRepository fichre;

    public List<Ficha> fichaList(){
        return (List<Ficha>) fichre.findAll();
    }
}
