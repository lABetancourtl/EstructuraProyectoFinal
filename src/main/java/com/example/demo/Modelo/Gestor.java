package com.example.demo.Modelo;


import com.example.demo.Persistence.Persistencia;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Gestor implements Serializable {
    private static final long serialVersionUID = 1L;
    private HashMap<String, Usuario> listaUsuarios = new HashMap<>();

    Usuario usuario = new Usuario("123","123","Anderson","123","Administrador");


    private HashMap<String, Proceso> listaProcesos = new HashMap<>();
    private LinkedList<Actividad> listaActividades = new LinkedList<>();
    private Queue<Tarea> listaTareas = new LinkedList<>();



    Actividad actividad = new Actividad();
    Actividad actividad1 = new Actividad("Comer", "3 veces al dia", "Si");

    LinkedList<Actividad> lista = new LinkedList<>();

    Proceso proceso1 = new Proceso("12", "Cocinar", lista);
    Proceso proceso2 = new Proceso("34", "Planchar", lista);

    Tarea tarea = new Tarea("Anderson", "salir", "Si","60" );


    public Gestor() {
        listaProcesos.put(proceso1.getId_Proceso(),proceso1);
        listaProcesos.put(proceso2.getId_Proceso(),proceso2);

        listaUsuarios.put(usuario.getIdUsuario(), usuario);

        listaActividades.add(actividad1);

        listaTareas.add(tarea);

        lista.add(actividad);
    }
    public void crearProceso(String idProceso, String nombreProceso) throws IOException {
        if (idProceso!= null && nombreProceso!=null) {
            Proceso proceso = new Proceso();
            proceso.setId_Proceso(idProceso);
            proceso.setNombre_Proceso(nombreProceso);
            listaProcesos.put(idProceso, proceso);
            guardaArchivos();
        }else {
            System.out.println("Proceso no creado");
        }

    }
    public void actualizarProceso(String idProceso, String nuevoNombre) throws IOException {
        if (listaProcesos.containsKey(idProceso)) {
            Proceso proceso = listaProcesos.get(idProceso);
            proceso.setNombre_Proceso(nuevoNombre);
            guardaArchivos();
            // Actualizar cliquier otra propiedad necesaria
        } else {
            System.out.println("Proceso no actualizado");
        }
    }
    public void eliminarProceso(String idProceso) throws IOException {
        if (listaProcesos.containsKey(idProceso)) {
            listaProcesos.remove(idProceso);
            // Actualizar el archivo de persistencia
            guardaArchivos();
        } else {
            System.out.println("Proceso no guardado");
        }
    }

    public void guardaArchivos() throws IOException {
        Persistencia.guardarProceso(listaProcesos);
        Persistencia.guardarActividad(listaActividades);
    }



    public Gestor(HashMap<String, Proceso> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public Gestor(LinkedList<Actividad> lista_Actividades) {
        this.listaActividades = lista_Actividades;
    }

    public HashMap<String, Proceso> getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(HashMap<String, Proceso> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public LinkedList<Actividad> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(LinkedList<Actividad> listaActividades) {
        this.listaActividades = listaActividades;
    }

    public Queue<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(Queue<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public HashMap<String, Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(HashMap<String, Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
