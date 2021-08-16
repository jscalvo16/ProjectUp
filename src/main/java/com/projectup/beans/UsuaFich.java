package com.projectup.beans;

import javax.persistence.*;

//Tabla pivote entre usuario y ficha
@SuppressWarnings("ALL")
@Entity
@Table(name = "UsuaFich")
public class UsuaFich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuaFich")
    private int idUsuaFich;

    @Column(name = "EstaUsuaFich")
    private int estado;

    // Relación con la entidad User
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="FkIdUsua", referencedColumnName = "IdUsua")
    private User userF;

    // Relación con la entidad Ficha
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FkIdFicha", referencedColumnName = "IdFicha")
    private Ficha fich;

    public int getIdUsuaFich() {
        return idUsuaFich;
    }

    public void setIdUsuaFich(int idUsuaFich) {
        this.idUsuaFich = idUsuaFich;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public User getUserF() {
        return userF;
    }

    public void setUserF(User userF) {
        this.userF = userF;
    }

    public Ficha getFich() {
        return fich;
    }

    public void setFich(Ficha fich) {
        this.fich = fich;
    }
}
