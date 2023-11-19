package com.example.demo.Persistence;

import com.example.demo.Modelo.Actividad;
import com.example.demo.Modelo.Proceso;
import com.example.demo.Modelo.Tarea;
import com.example.demo.Modelo.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Persistencia {

    public static final String RUTA_ARCHIVO_TAREA = "C://td//Archivo_Tarea//ArchivoTarea.txt";
    public static final String RUTA_ARCHIVO_ACTIVIDAD = "C://td//Archivo_Actividad//ArchivoActividad.txt";
    public static final String RUTA_ARCHIVO_PROCESO = "C://td//Achivo_Proceso//ArchivoProceso.txt";
    public static final String RUTA_ARCHIVO_USUARIOS = "C://td//Achivo_Usuario//AchivoUsuarios.txt";

    //Metodo para guardar los datos del Proceso en un txt seprado por ;

    /*
     * EXPORTAR PRODUCTO EN ARCHIVO DE TEXTO
     *
     * @param idProceso
     * @param nombreProceso
     * @throws IOException
     */
    public static void guardarProceso(HashMap<String, Proceso> listaProceso) throws IOException {
        String contenido = "";
        String contenidoAxuliar = "";

        for (Proceso proceso : listaProceso.values()) {
            for (Actividad actividad : proceso.getLista_Actividades_In_Proceso()) {
                contenidoAxuliar += actividad.getNombre_Actividad() + "@";
            }
            contenido += proceso.getId_Proceso() + ";" + proceso.getNombre_Proceso() + ";" + contenidoAxuliar + "\n";
            contenidoAxuliar = "";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PROCESO, contenido, false);
    }

    //    public static void guardarActividad(LinkedList<Actividad> listaActividad) throws IOException {
//        Actividad activi = new Actividad();
//        String contenido = "";
//
//        LinkedList<Tarea> tareas = (LinkedList<Tarea>) activi.getTareas();
//        LinkedList<Tarea> listaTareas = new LinkedList<>();
//        if (tareas != null) {
//            for (Tarea dato : tareas) {
//                listaTareas.add(dato);
//            }
//            for (Actividad actividad : listaActividad) {
//                String contenidoAuxiliar = "";
//                for (Tarea tarea : actividad.getTareas()) {
//                    contenidoAuxiliar += tarea.getNombre_Tarea() + "$";
//                }
//                contenido += actividad.getNombre_Actividad() + "@" + actividad.getDescripcion_Actividad() + "@" + actividad.getEsObligatoria_Actividad() + "@" + contenidoAuxiliar + "\n";
//            }
//            ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ACTIVIDAD, contenido, true);
//        }
//    }
    public static void guardarActividad(LinkedList<Actividad> listaActividad) throws IOException {
        Actividad activi = new Actividad();
        String contenido = "";

        for (Actividad actividad : listaActividad) {
            String contenidoAuxiliar = "";
            LinkedList<Tarea> tareas = (LinkedList<Tarea>) activi.getTareas();
            LinkedList<Tarea> listaTareas = new LinkedList<>();
            if (tareas != null) {
                for (Tarea tarea : tareas) {
                    contenidoAuxiliar += tarea.getNombre_Tarea() + "$";
                }
            }
            contenido += actividad.getNombre_Actividad() + "@" + actividad.getDescripcion_Actividad() + "@" + actividad.getEsObligatoria_Actividad() + "@" + contenidoAuxiliar + "\n";
        }

        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ACTIVIDAD, contenido, false); // Cambié 'true' a 'false' para sobrescribir el archivo
    }


    public static void guardarTareas(Queue<Tarea> listaTareas) throws IOException {
        String contenido = "";
        for (Tarea tarea : listaTareas) {
            contenido = tarea.getNombre_Tarea() + "$" + tarea.getDescripcion_Tarea() + "$" + tarea.getEsObligatoria_Tarea() + "$" + tarea.getTiempoDuracion_Tarea() + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_TAREA, contenido, false);
    }

    public static void guardarUsuario(HashMap<String, Usuario> listaUsuarios) throws IOException {
        String contenido = "";
        for (Usuario usuario : listaUsuarios.values()) {
            contenido += usuario.getIdUsuario() + ";" +
                    usuario.getContrasena() + ";" +
                    usuario.getNombreUsuario() + ";" +
                    usuario.getIdUsuario() + ";" +
                    usuario.getTipoUsuario();
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIOS, contenido, true);
    }
    public static HashMap<String, Proceso> cargarProcesos () throws IOException {
        HashMap<String, Proceso> listaProcesosCargados = new HashMap<>();
        List<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PROCESO);
        String linea;
        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);
            String[] partes = linea.split(";");
            if (partes.length < 2) {
                continue;
            }
            Proceso proceso = new Proceso();
            proceso.setId_Proceso(partes[0]);
            proceso.setNombre_Proceso(partes[1]);
            // Aquí puedes añadir más lógica para manejar otras propiedades y listas
            listaProcesosCargados.put(proceso.getId_Proceso(), proceso);
        }
        return listaProcesosCargados;
    }
    public static LinkedList<Actividad> cargarActividades() throws IOException {
        LinkedList<Actividad> listaActividades = new LinkedList<>();
        List<String> lineas = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ACTIVIDAD);

        for (String linea : lineas) {
            String[] partesActividad = linea.split("@");
//            if (partesActividad.length < 4) {
//                continue; // O manejar el error de formato
//            }
            Actividad actividad = new Actividad();
            actividad.setNombre_Actividad(partesActividad[0]);
            actividad.setDescripcion_Actividad(partesActividad[1]);
            actividad.setEsObligatoria_Actividad(String.valueOf(Boolean.parseBoolean(partesActividad[2])));
            listaActividades.add(actividad);

        }
        return listaActividades;
    }

    public static Queue<Tarea> cargarTareas() throws IOException {
        List<String> lineas = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_TAREA);
        Queue<Tarea> colaTareas = new LinkedList<>();
        for (String linea : lineas) {
            String[] partes = linea.split("\\$");
            Tarea tarea = new Tarea();
            tarea.setNombre_Tarea(partes[0]);
            tarea.setDescripcion_Tarea(partes[1]);
            tarea.setEsObligatoria_Tarea(partes[2]);
//            tarea.setEsObligatoria_Tarea(String.valueOf(Boolean.parseBoolean(partes[2])));
            tarea.setTiempoDuracion_Tarea(String.valueOf(Integer.parseInt(partes[3])));
            colaTareas.add(tarea);
        }
        return colaTareas;
    }
}

