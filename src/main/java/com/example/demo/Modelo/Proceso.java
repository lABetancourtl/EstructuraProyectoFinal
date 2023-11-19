package com.example.demo.Modelo;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedList;

public class Proceso implements Serializable {
    private static final long serialVersionUID = 1L;
    String id_Proceso;
    String nombre_Proceso;
    private LinkedList<Actividad> lista_Actividades_In_Proceso;

    public Proceso() {
        lista_Actividades_In_Proceso = new LinkedList<>();
    }

    public Proceso(LinkedList<Actividad> lista_Actividades_In_Proceso) {
        this.lista_Actividades_In_Proceso = lista_Actividades_In_Proceso;
    }

    public Proceso(String id, String nombre, LinkedList<Actividad> lista_Actividades_In_Proceso) {
        this.id_Proceso = id;
        this.nombre_Proceso = nombre;
        this.lista_Actividades_In_Proceso = lista_Actividades_In_Proceso;
    }

    // Agregar tarea al final de la cola
//    public void addTareaAlFinal(Tarea nuevaTarea) {
//        // Regla de negocio: no pueden existir dos tareas opcionales seguidas.
//        if (!tareas.isEmpty() && !nuevaTarea.isObligatoria() && !actividades.peek().isObligatoria()) {
//            throw new IllegalStateException("No pueden existir dos tareas opcionales consecutivas.");
//        }
//        tareas.offer(nuevaTarea);
//    }
//
//    // Agregar tarea en una posición específica
//    public void addTareaEnPosicion(Tarea nuevaTarea, int posicion) {
//        if (posicion < 0 || posicion > actividades.size()) {
//            throw new IndexOutOfBoundsException("Posición fuera de rango.");
//        }
//        if (posicion == actividades.size()) {
//            addTareaAlFinal(nuevaTarea);
//            return;
//        }
//        LinkedList<Tarea> listaTemporal = new LinkedList<>(tareas);
//        listaTemporal.add(posicion, nuevaTarea);
//        this.tareas = listaTemporal; // Actualizar la cola con la nueva lista
//    }
//
//    // Tiempo de duración total de las tareas de la actividad
//    public int getTiempoDuracionTotal() {
//        int tiempoTotal = 0;
//        for (Actividad actividad : actividades) {
//            tiempoTotal += actividad.getTiempoDuracion();
//        }
//        return tiempoTotal;
//    }


//Aqui edito Ruben
    //obtengo el numero de actividades
    public int obtenerNumeroActividad(String nombreActividad) {
        for (int i = 0; i < lista_Actividades_In_Proceso.size(); i++) {
            if (lista_Actividades_In_Proceso.get(i).getNombre_Actividad().equals(nombreActividad)) {
                return i + 1; // Devuelve el número de la actividad (1-indexed)
            }
        }
        return -1; // Si no se encuentra la actividad
    }



    // Getters y setters


    public String getId_Proceso() {
        return id_Proceso;
    }

    public void setId_Proceso(String id_Proceso) {
        this.id_Proceso = id_Proceso;
    }

    public String getNombre_Proceso() {
        return nombre_Proceso;
    }

    public void setNombre_Proceso(String nombre_Proceso) {
        this.nombre_Proceso = nombre_Proceso;
    }

    public LinkedList<Actividad> getLista_Actividades_In_Proceso() {
        return lista_Actividades_In_Proceso;
    }

    public void setLista_Actividades_In_Proceso() {
        this.lista_Actividades_In_Proceso = lista_Actividades_In_Proceso;
    }
}
