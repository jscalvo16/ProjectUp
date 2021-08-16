package com.projectup.beans;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "GrupoDeProyecto")
public class Grupo {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )//auto incrementable
    @Column(name = "IdGrupo")
    private int idGrupo;

    @Column(name = "NombGrupo")
    private String nombreGrupo;

    @Column(name = "DescriGrupo")
    private String descGrupo;

    @Column(name = "AlcanGrupo")
    private String alcanGrupo;

    // Relación con la entidad Ficha
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "FkIdFicha", referencedColumnName = "IdFicha")
    private Ficha ficha;

    // Relación con la entidad Avance
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo")
    private List<Avance> listAvances;

    // Relación con la entidad User
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoU")
    private List<User> userG;

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getDescGrupo() {
        return descGrupo;
    }

    public void setDescGrupo(String descGrupo) {
        this.descGrupo = descGrupo;
    }

    public String getAlcanGrupo() {
        return alcanGrupo;
    }

    public void setAlcanGrupo(String alcanGrupo) {
        this.alcanGrupo = alcanGrupo;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public List<Avance> getListAvances() {
        return listAvances;
    }

    public void setListAvances(List<Avance> listAvances) {
        this.listAvances = listAvances;
    }

    public List<User> getUserG() {
        return userG;
    }

    public void setUserG(List<User> userG) {
        this.userG = userG;
    }
}
