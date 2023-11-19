package com.example.demo.Modelo;


import com.example.demo.Persistence.Persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Gestor implements Serializable {
    private static final long serialVersionUID = 1L;
    private HashMap<String, Usuario> listaUsuarios = new HashMap<>();

    boolean admin = false;
    private HashMap<String, Proceso> listaProcesos = new HashMap<>();
    private LinkedList<Actividad> listaActividades = new LinkedList<>();
    private Queue<Tarea> listaTareas = new LinkedList<>();


    public Gestor() {

        Usuario usuario = new Usuario("123", "123", "Anderson", "123", "Administrador");
        listaUsuarios.put(usuario.getUsuario(),usuario);

    }

    public void crearProceso(String idProceso, String nombreProceso) throws IOException {
        if (idProceso != null && nombreProceso != null) {
            Proceso proceso = new Proceso();
            proceso.setId_Proceso(idProceso);
            proceso.setNombre_Proceso(nombreProceso);
            listaProcesos.put(idProceso, proceso);
            guardaArchivos();
        } else {
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
        Persistencia.guardarTareas(listaTareas);
    }

    public void cargarDatosArchivos() {
        try {
            HashMap<String, Proceso> listaProcesos1 = Persistencia.cargarProcesos();
            listaProcesos = listaProcesos1;
            cargarActividades();
            cargarTareas();
            // Utiliza listaProcesos según sea necesario
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void cargarActividades() throws IOException {
        try {
            LinkedList<Actividad> listaActividades1 = Persistencia.cargarActividades();
            listaActividades = listaActividades1;
        } catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado: " + e.getMessage());
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void cargarTareas() throws  IOException{
        try {
            Queue<Tarea> listaTareas1 = Persistencia.cargarTareas();
            listaTareas1 = listaTareas;
        } catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado: " + e.getMessage());
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void inicializarDatos() {
        Actividad actividad = new Actividad();
        Actividad actividad1 = new Actividad("Comer", "3 veces al dia", "Si");
        LinkedList<Actividad> lista = new LinkedList<>();
        Proceso proceso1 = new Proceso("12", "Cocinar", lista);
        Proceso proceso2 = new Proceso("34", "Planchar", lista);
        Tarea tarea = new Tarea("Anderson", "salir", "Si", "60");

        listaProcesos.put(proceso1.getId_Proceso(), proceso1);
        listaProcesos.put(proceso2.getId_Proceso(), proceso2);


        listaActividades.add(actividad1);
        listaTareas.add(tarea);

        lista.add(actividad);
    }


    // Aqui edito Ruben
    public ArrayList<Proceso> buscarActividad(String nombreActividad) {
        ArrayList<Proceso> procesosConActividad = new ArrayList<>();

        HashMap<String, Proceso> listaProcesos = getListaProcesos();


            for (Proceso proceso : listaProcesos.values()) {
                LinkedList<Actividad> actividades = proceso.getLista_Actividades_In_Proceso();

                for (Actividad actividad : actividades) {
                    if (actividad.getNombre_Actividad() != null && actividad.getNombre_Actividad().equals(nombreActividad)) {
                        System.out.println("Añadir proceso");
                        procesosConActividad.add(proceso);
                        break;
                    }
                }
            }


        return procesosConActividad;
    }


    public Actividad obtenerActividadPorNombre(String nombreActividad) {
        for (Actividad actividad : listaActividades) {
            if (actividad.getNombre_Actividad().equalsIgnoreCase(nombreActividad)) {
                return actividad;
            }
        }
        return null; // Si no se encuentra la actividad
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
