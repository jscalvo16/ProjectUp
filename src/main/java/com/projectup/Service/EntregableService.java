package com.projectup.Service;

import com.projectup.beans.Entregable;
import com.projectup.repository.EntregableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregableService {

    @Autowired
    private EntregableRepository entregableRepository;

    public List<Entregable>listAll(){
        return (List<Entregable>) entregableRepository.findAll();
    }

    public Optional<Entregable>entregableById(int id){
        return entregableRepository.findById(id);
    }

    public Entregable guardarEntregable(Entregable entregable){
        return entregableRepository.save(entregable);
    }
}
