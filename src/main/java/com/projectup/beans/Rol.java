package com.projectup.beans;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("All")
@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @Column(name = "IdRol")
    private int idRol;

    @Column(name = "TipoRol")
    private String tipoRol;

    @OneToMany( mappedBy = "rol")
    private List<User> listUsers;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public List<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }
}
