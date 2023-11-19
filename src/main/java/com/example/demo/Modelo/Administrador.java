package com.example.demo.Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Administrador implements Serializable {
    private static final long serialVersionUID = 1L;
    private String usuario;
    private String contrasena;
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();


    public Administrador(){}
    public Administrador(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }



    public void agregarUsuario(Usuario u) {
        listaUsuarios.add(u); // esto agrega el usuario u al final de la lista
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

}
