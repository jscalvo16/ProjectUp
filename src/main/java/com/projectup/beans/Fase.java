package com.projectup.beans;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "Fase")
public class Fase {
    @Id
    @Column(name = "IdFase")
    private int idFase;

    @Column(name = "NombFase")
    private String nomFase;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fase")
    private List<Entregable> listEntre;

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public String getNomFase() {
        return nomFase;
    }

    public void setNomFase(String nomFase) {
        this.nomFase = nomFase;
    }

    public List<Entregable> getListEntre() {
        return listEntre;
    }

    public void setListEntre(List<Entregable> listEntre) {
        this.listEntre = listEntre;
    }
}
