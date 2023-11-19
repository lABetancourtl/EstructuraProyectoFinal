package com.example.demo.Modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class Actividad implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre_Actividad;
    private String descripcion_Actividad;
    private String esObligatoria_Actividad;
    private Queue<Tarea> tareas;

    public Actividad() {
    }

    public Actividad(String nombre, String descripcion, String esObligatoria) {
        this.nombre_Actividad = nombre;
        this.descripcion_Actividad = descripcion;
        this.esObligatoria_Actividad = esObligatoria;
        this.tareas = new LinkedList<>();
    }


    // Getters y setters


    public String getNombre_Actividad() {
        return nombre_Actividad;
    }

    public void setNombre_Actividad(String nombre_Actividad) {
        this.nombre_Actividad = nombre_Actividad;
    }

    public String getDescripcion_Actividad() {
        return descripcion_Actividad;
    }

    public void setDescripcion_Actividad(String descripcion_Actividad) {
        this.descripcion_Actividad = descripcion_Actividad;
    }

    public String getEsObligatoria_Actividad() {
        return esObligatoria_Actividad;
    }

    public void setEsObligatoria_Actividad(String esObligatoria_Actividad) {
        this.esObligatoria_Actividad = esObligatoria_Actividad;
    }

    public Queue<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(Queue<Tarea> tareas) {
        this.tareas = tareas;
    }


    @Override
    public String toString() {
        return "Actividad{" +
                "nombre_Actividad='" + nombre_Actividad + '\'' +
                ", descripcion_Actividad='" + descripcion_Actividad + '\'' +
                ", esObligatoria_Actividad='" + esObligatoria_Actividad + '\'' +
                ", tareas=" + tareas +
                '}';
    }
}