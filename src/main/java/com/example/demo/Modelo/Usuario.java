package com.example.demo.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    ArrayList<Usuario> listaUsuarios = new ArrayList<>();


    private String usuario;
    private String contrasena;
    private String nombreUsuario;
    private String idUsuario;
    private String tipoUsuario;

    private HashMap<String, Proceso> listaProcesosDelUsuario = new HashMap<>();


    public Usuario(){}

    public Usuario(HashMap<String, Proceso> listaProcesosDelUsuario) {
        this.listaProcesosDelUsuario = listaProcesosDelUsuario;
    }

    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Usuario(String usuario, String contrasena, String nombreUsuario, String idUsuario, String tipoUsuario) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
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


    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public HashMap<String, Proceso> getListaProcesosDelUsuario() {
        return listaProcesosDelUsuario;
    }

    public void setListaProcesosDelUsuario(HashMap<String, Proceso> listaProcesosDelUsuario) {
        this.listaProcesosDelUsuario = listaProcesosDelUsuario;
    }
}
