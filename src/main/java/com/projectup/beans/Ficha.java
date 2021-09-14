package com.projectup.beans;


import javax.persistence.*;
import java.util.Date;
import java.util.List;


@SuppressWarnings("ALL")
@Entity
@Table(name = "Ficha")
public class Ficha {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )//auto incrementable
    @Column(name = "IdFicha")
    private int idFicha;

    @Column(name = "NumbFich")
    private int numFicha;

    @Column(name = "InicEtapElec")
    private String etapaElectiva;

    @Column(name = "FinEtapElec")
    private String finEtapaElectiva;

    @Column(name = "JornFicha")
    private String jornadaFicha;

    // Relacionar la entidad ficha con la entidad grupo
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ficha")
    private List<Grupo> listGrupos;

    // Relación con la entidad UsuaFicha
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fich")
    private List<UsuaFich> listaPivoteF;

    public int getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    public int getNumFicha() {
        return numFicha;
    }

    public void setNumFicha(int numFicha) {
        this.numFicha = numFicha;
    }

    public String getEtapaElectiva() {
        return etapaElectiva;
    }

    public void setEtapaElectiva(String etapaElectiva) {
        this.etapaElectiva = etapaElectiva;
    }

    public String getFinEtapaElectiva() {
        return finEtapaElectiva;
    }

    public void setFinEtapaElectiva(String finEtapaElectiva) {
        this.finEtapaElectiva = finEtapaElectiva;
    }

    public String getJornadaFicha() {
        return jornadaFicha;
    }

    public void setJornadaFicha(String jornadaFicha) {
        this.jornadaFicha = jornadaFicha;
    }

    public List<Grupo> getListGrupos() {
        return listGrupos;
    }

    public void setListGrupos(List<Grupo> listGrupos) {
        this.listGrupos = listGrupos;
    }

    public List<UsuaFich> getListaPivoteF() {
        return listaPivoteF;
    }

    public void setListaPivoteF(List<UsuaFich> listaPivoteF) {
        this.listaPivoteF = listaPivoteF;
    }

}
