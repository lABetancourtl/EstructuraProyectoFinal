package com.example.demo.Modelo;

import java.io.Serializable;

public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre_Tarea;
    private String descripcion_Tarea;
    private String esObligatoria_Tarea;
    private String tiempoDuracion_Tarea; // Tiempo de duración en minutos

    public Tarea() {
    }

    public Tarea(String nombre_Tarea, String descripcion_Tarea, String esObligatoria_Tarea, String tiempoDuracion_Tarea) {
        this.nombre_Tarea = nombre_Tarea;
        this.descripcion_Tarea = descripcion_Tarea;
        this.esObligatoria_Tarea = esObligatoria_Tarea;
        this.tiempoDuracion_Tarea = tiempoDuracion_Tarea;
    }

    public String getNombre_Tarea() {
        return nombre_Tarea;
    }

    public void setNombre_Tarea(String nombre_Tarea) {
        this.nombre_Tarea = nombre_Tarea;
    }

    public String getDescripcion_Tarea() {
        return descripcion_Tarea;
    }

    public void setDescripcion_Tarea(String descripcion_Tarea) {
        this.descripcion_Tarea = descripcion_Tarea;
    }

    public String getEsObligatoria_Tarea() {
        return esObligatoria_Tarea;
    }

    public void setEsObligatoria_Tarea(String esObligatoria_Tarea) {
        this.esObligatoria_Tarea = esObligatoria_Tarea;
    }

    public String getTiempoDuracion_Tarea() {
        return tiempoDuracion_Tarea;
    }

    public void setTiempoDuracion_Tarea(String tiempoDuracion_Tarea) {
        this.tiempoDuracion_Tarea = tiempoDuracion_Tarea;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "nombre_Tarea='" + nombre_Tarea + '\'' +
                ", descripcion_Tarea='" + descripcion_Tarea + '\'' +
                ", esObligatoria_Tarea='" + esObligatoria_Tarea + '\'' +
                ", tiempoDuracion_Tarea='" + tiempoDuracion_Tarea + '\'' +
                '}';
    }
}
