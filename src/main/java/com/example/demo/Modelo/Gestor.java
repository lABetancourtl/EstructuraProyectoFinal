package com.example.demo.Modelo;


import com.example.demo.Persistence.Persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

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
    public void eliminarTarea(String nombre) throws IOException {
        LinkedList<Tarea> tareas = new LinkedList<>();
        while (listaTareas.size() > 0) {
                tareas.add(listaTareas.poll());
        }

        tareas.remove(nombre);

        System.out.println(listaTareas.size());
        listaTareas.addAll(tareas);
        System.out.println(listaTareas.size());
        guardaArchivos();
    }

    public void guardaArchivos() throws IOException {
        Persistencia.guardarProceso(listaProcesos);
        Persistencia.guardarActividad(listaActividades);
//        Persistencia.guardarTareas(listaTareas);
    }
    public void guardaArchivosTarea() throws IOException {
        Persistencia.guardarTareas(listaTareas);

    }

    public void cargarDatosArchivos() {
        try {
            listaProcesos = Persistencia.cargarProcesos();

            listaActividades = Persistencia.cargarActividades();

            listaTareas = Persistencia.cargarTareas();

//            cargarActividades();
//            cargarTareas();
 // Asigna las tareas cargadas a la variable de instancia
            // Utiliza listaProcesos según sea necesario

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
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
    public HashMap<String,Proceso> buscarActividad(String nombreActividad) {
        HashMap<String, Proceso> procesosConActividad = new HashMap<>();

            for (Proceso proceso : listaProcesos.values()) {
                System.out.println("Buscando procesos");
                LinkedList<Actividad> actividades = proceso.getLista_Actividades_In_Proceso();

                for (Actividad actividad : actividades) {
                    if (actividad.getNombre_Actividad() != null && actividad.getNombre_Actividad().equals(nombreActividad)) {
                        System.out.println("Añadir proceso");
                        procesosConActividad.put(proceso.getId_Proceso(),proceso);
                        break;
                    }
                }
            }


        return procesosConActividad;
    }
    public List<String> buscarActividadesYProcesosAsociados(String nombreActividad) {
        List<String> procesosConActividad = new LinkedList<>();

        for (Proceso proceso : listaProcesos.values()) {
            if (contieneActividad(nombreActividad)) {
                procesosConActividad.add("Actividad '" + nombreActividad + "' encontrada en proceso: " + proceso.getId_Proceso());
            }
        }

        return procesosConActividad;
    }
    public boolean contieneActividad(String nombreActividad) {
        for (Actividad actividad : listaActividades) {
            if (actividad.getNombre_Actividad().equalsIgnoreCase(nombreActividad)) {
                return true;
            }
        }
        return false;
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
