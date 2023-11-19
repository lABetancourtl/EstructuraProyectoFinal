package com.example.demo.observables;

public class ProcesosObservables {
    String idPrestamo;
    String nombrePrestamo;

    public ProcesosObservables() {

    }

    public ProcesosObservables(String idPrestamo, String nombrePrestamo) {
        this.idPrestamo = idPrestamo;
        this.nombrePrestamo = nombrePrestamo;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getNombrePrestamo() {
        return nombrePrestamo;
    }

    public void setNombrePrestamo(String nombrePrestamo) {
        this.nombrePrestamo = nombrePrestamo;
    }
}
