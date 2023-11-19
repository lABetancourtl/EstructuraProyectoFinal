package com.example.demo.Controller;

import com.example.demo.Modelo.*;
import com.example.demo.Persistence.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;


public class HelloController implements Initializable {

    int opcionCrearActividad = 0;
    int opcionCrearTarea = 0;
    Gestor gestor = new Gestor();
    TreeSet<Proceso> listaProcesos = new TreeSet<>();

    private Actividad ultimaActividadCreada;
    private Actividad actividadSeleccionada;
    private Actividad actividadDisponibleSeleccionadaInEditarProceso;
    private Actividad actividadDelProcesoSeleccionadaInEditarProceso;
    private Tarea tareaSeleccionada;
    private Tarea tareaPresenteSeleccionada_In_editarActividades;
    private Tarea tareaDisponibleSeleccionada_In_editarActividades;
    private Tarea ultimaTareaCreada;
    private Proceso procesoSeleccionado;
    private Proceso procesoDisponibleSeleccionadoInEditarUsuario;
    private Proceso procesosDelUsuarioSeleccionadoInEditarUsuario;
    private Usuario usuarioSeleccionado;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

//    ObservableList<Proceso> procesosList = FXCollections.observableArrayList(procesos);
//    TreeSet<Proceso> estudiantes = gestor.();

    @FXML
    private AnchorPane AP_Editar_Actividad;
    @FXML
    private AnchorPane AP_Archivos;
    @FXML
    private AnchorPane AP_Crear_Proceso;
    @FXML
    private AnchorPane AP_Crear_Actividad;
    @FXML
    private AnchorPane AP_Crear_Tarea;
    @FXML
    private AnchorPane AP_Recordatorios;
    @FXML
    private AnchorPane APInicio;
    @FXML
    private AnchorPane AP_Usuarios;
    @FXML
    private AnchorPane AP_Editar_Proceso;
    @FXML
    private AnchorPane AP_Editar_Tarea;
    @FXML
    private AnchorPane AP_Crear_Usuario;
    @FXML
    private AnchorPane AP_Editar_Usuario;

    @FXML
    private Button BT_Actualizar_In_EditarUsuario;
    @FXML
    private Button BT_Editar_Actividad;
    @FXML
    private Button BT_Cancelar_In_EditarUsuario;
    @FXML
    private Button BT_Usuarios;
    @FXML
    private Button BT_Inicio;
    @FXML
    private Button BT_Recordatorios;
    @FXML
    private Button BT_Archivos;
    @FXML
    private Button BT_Editar_Proceso;
    @FXML
    private Button BT_Crear_Proceso;
    @FXML
    private Button BT_Eliminar_Proceso;
    @FXML
    private Button BT_Fin_CrearActividad;
    @FXML
    private Button BT_Cancelar_Crear_Actividad;
    @FXML
    private Button BT_Fin_Crear_Tarea;
    @FXML
    private Button BT_Cancelar_Crear_Tarea;
    @FXML
    private Button BT_Eliminar_Tarea;
    @FXML
    private Button BT_Guardar_In_EditarProceso;
    @FXML
    private Button BT_Cancelar_In_EditarProceso;
    @FXML
    private Button BT_Add_Actividad_In_Crear_Proceso;
    @FXML
    private Button BT_Editar_Tarea;
    @FXML
    private Button BT_Cancelar_Editar_Tarea;
    @FXML
    private Button BT_Fin_Actualizar_Tarea;
    @FXML
    private Button BT_Editar_Usuario;
    @FXML
    private Button BT_Crear_Usuario;
    @FXML
    private Button BT_Eliminar_Usuario;
    @FXML
    private Button BT_Fin_Crear_Usuario;
    @FXML
    private Button BT_Cancelar_Crear_Usuario;
    @FXML
    private Button BT_Actualizar_In_EditarProceso1;
    @FXML
    private Button BT_Cancelar_In_EditarProceso1;
    @FXML
    private Button BT_RemoveProceso_In_EditarUsuario;
    @FXML
    private Button BT_Add_Proceso_In_EditarUsuario;
    @FXML
    private Button BT_Remove_In_EditarActividad;
    @FXML
    private Button BT_AddTarea_In_EditarActividad;
    @FXML
    private Button BT_Actualizar_In_EditarActividad;
    @FXML
    private Button BT_Cancelar_In_EditarActividad;

    @FXML
    private RadioButton RadioButton_AlFinal_Crear_Tarea;
    @FXML
    private RadioButton RadioButton_PosicionDada_Crear_Tarea;
    @FXML
    private RadioButton RadioButton_TF_Posicion_Crear_Actividad;

    //TexField
    @FXML
    private TextField TF_Nombre_EditarActividad;
    @FXML
    private TextField TF_Id_Crear_Proceso;
    @FXML
    private TextField TF_Nombre_Crear_Proceso;
    @FXML
    private TextField TF_Nombre_Crear_Actividad;
    @FXML
    private TextField TF_Nombre_Editar_Tarea;
    @FXML
    private TextField TF_Duracion_Editar_Tarea;
    @FXML
    private TextField TF_Id_Crear_Usuario;
    @FXML
    private TextField TF_Nombre_Crear_Usuario;
    @FXML
    private TextField TF_Id_EditarUsuario;
    @FXML
    private TextField TF_Nombre_EditarUsuario;
    @FXML
    private ComboBox<String> CB_Obligatorio_In_EditarActividad;
    @FXML
    private ComboBox<String> CB_Obligatorio_Crear_Actividad;
    @FXML
    private ComboBox<String> CB_Obligatorio_Crear_Tarea;
    @FXML
    private ComboBox<String> CB_Opciones_CrearActividad;
    @FXML
    private ComboBox<String> CB_Obligatorio_Editar_Tarea;
    @FXML
    private ComboBox<String> CB_TipoUsuario_CrearUsuario;
    @FXML
    private ComboBox<String> CB_TipoUsuario_EditarUsuario;
    @FXML
    private TextField TF_Posicion_Crear_Actividad;
    @FXML
    private TextArea TA_Descripcion_Crear_Actividad;
    @FXML
    private TextArea TA_Descripccion_Actividad_Seleccionada;
    @FXML
    private TextArea TA_Descripcion_Tarea_Seleccionada;
    @FXML
    private TextArea TA_Descripcion_Editar_Tarea;
    @FXML
    private TextField TF_Nombre_Crear_Tarea;
    @FXML
    private TextField TF_Duracion_Crear_Tarea;
    @FXML
    private TextField TF_Posicion_Dada_Crear_Tarea;
    @FXML
    private TextField TF_Nombre_EditarProceso;
    @FXML
    private TextArea TA_Descripcion_Crear_Tarea;

    //Table View
    @FXML
    private TableView TW_ActividadesUsuarioSeleccionado;
    @FXML
    private TableView TW_TareasUsuarioSeleccionado;
    @FXML
    private TableView TW_TareasDisponibles_InEditarActividad;
    @FXML
    private TableView TW_TareasPresentes_In_EditarActividad;
    @FXML
    private TableView TW_Actividades_In_Crear_Proceso;
    @FXML
    private TableView TW_Editar_ProcesoInUsuario;
    @FXML
    private TableView TW_ProcesosDisponibles_In_Crear_Usuario;
    @FXML
    private TableView TW_Actividades;
    @FXML
    private TableView TW_Procesos;
    @FXML
    private TableView TW_Tareas;
    @FXML
    private TableView TW_Editar_ActividadesInProceso;
    @FXML
    private TableView TW_ActividadesDisponibles_In_Crear_Proceso;
    @FXML
    private TableView TW_Usuarios;
    @FXML
    private TableColumn TC_Editar_NombreActividadInProceso;
    @FXML
    private TableColumn TC_Editar_ObligarorioActividadInProceso;
    @FXML
    private TableColumn TC_Nombre_ActividadDisponible_In_Crear_Proceso;
    @FXML
    private TableColumn TC_Obligatorio_ActividadDisponible_In_Crear_Proceso;
    @FXML
    private TableColumn TC_Nombre_Actividad_In_Crear_Proceso;
    @FXML
    private TableColumn TC_Obligatorio_Actividad_In_Crear_Proceso;
    @FXML
    private TableColumn TC_ID_Proceso;
    @FXML
    private TableColumn TC_Nombre_Proceso;
    @FXML
    private TableColumn TC_Nombre_Actividad;
    @FXML
    private TableColumn TC_Obligatorio_Actividad;
    @FXML
    private TableColumn TC_Nombre_Tarea;
    @FXML
    private TableColumn TC_Obligatorio_Tarea;
    @FXML
    private TableColumn TC_ID_Usuario;
    @FXML
    private TableColumn TC_Nombre_Usuario;
    @FXML
    private TableColumn TC_Tipo_Usuario;
    @FXML
    private TableColumn TC_IdProcesoUsuario_In_EditarUsuario;
    @FXML
    private TableColumn TC_NombreProcesoUsuario_In_EditarUsuario;
    @FXML
    private TableColumn TC_IdProcesosDisponibles_In_EditarUsuario;
    @FXML
    private TableColumn TC_NombreProcesosDisponibles_In_EditarUsuario;
    @FXML
    private TableColumn TC_NombreTareaPresente_In_EditarActividad;
    @FXML
    private TableColumn TC_ObligatorioTareaPresente_In_EditarActividad;
    @FXML
    private TableColumn TC_NombreTareaDisponible_In_EditarActividad;
    @FXML
    private TableColumn TC_ObligatorioTareaDisponible_In_EditarActividad;

    @FXML
    private TableColumn TC_NombreActividadUsuarioSeleccionado;
    @FXML
    private TableColumn TC_ObligatorioActividadUsuarioSeleccionado;
    @FXML
    private TableColumn TC_NombreTareaUsuarioSelccionado;
    @FXML
    private TableColumn TC_ObligatorioTareaUsuarioSeleccionado;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TA_Descripccion_Actividad_Seleccionada.setWrapText(true);
        TA_Descripcion_Tarea_Seleccionada.setWrapText(true);

        configureNumericTextField(TF_Id_Crear_Proceso);
        configureNumericTextField(TF_Posicion_Crear_Actividad);
        configureNumericTextField(TF_Duracion_Crear_Tarea);
        configureNumericTextField(TF_Posicion_Dada_Crear_Tarea);
        configureNumericTextField(TF_Id_Crear_Usuario);

        CB_Obligatorio_Crear_Actividad.getItems().addAll("Si", "No");
        CB_Obligatorio_In_EditarActividad.getItems().addAll("Si", "No");
        CB_Opciones_CrearActividad.getItems().addAll("Crear al final de todo", "Crear despues de la ultima creaccion");
        CB_Obligatorio_Crear_Tarea.getItems().addAll("Si", "No");
        CB_Obligatorio_Editar_Tarea.getItems().addAll("Si", "No");
        CB_TipoUsuario_CrearUsuario.getItems().addAll("Normal", "Administrador");
        CB_TipoUsuario_EditarUsuario.getItems().addAll("Normal", "Administrador");

        inicializar_Datos_TW_Proceso(TC_ID_Proceso, TC_Nombre_Proceso, TC_IdProcesosDisponibles_In_EditarUsuario, TC_NombreProcesosDisponibles_In_EditarUsuario);
        inicializar_Datos_TW_Actividad(TC_Nombre_Actividad, TC_Obligatorio_Actividad, TC_Nombre_ActividadDisponible_In_Crear_Proceso, TC_Obligatorio_ActividadDisponible_In_Crear_Proceso);
        inicializar_Datos_TW_Tarea(TC_Nombre_Tarea, TC_Obligatorio_Tarea, TC_NombreTareaDisponible_In_EditarActividad, TC_ObligatorioTareaDisponible_In_EditarActividad);
        inicializar_Datos_TW_Usuario(TC_ID_Usuario, TC_Nombre_Usuario, TC_Tipo_Usuario);
    }

    private void inicializar_Datos_TW_Actividad(TableColumn TC_Nombre_Actividad, TableColumn TC_Obligatorio_Actividad, TableColumn TC_Nombre_ActividadDisponible_In_Crear_Proceso, TableColumn TC_Obligatorio_ActividadDisponible_In_Crear_Proceso) {
        TC_Nombre_Actividad.setCellValueFactory(new PropertyValueFactory<>("nombre_Actividad"));
        TC_Obligatorio_Actividad.setCellValueFactory(new PropertyValueFactory<>("esObligatoria_Actividad"));

        TC_Nombre_ActividadDisponible_In_Crear_Proceso.setCellValueFactory(new PropertyValueFactory<>("nombre_Actividad"));
        TC_Obligatorio_ActividadDisponible_In_Crear_Proceso.setCellValueFactory(new PropertyValueFactory<>("esObligatoria_Actividad"));

        TW_Actividades.getItems().clear();
        TW_Actividades.setItems(cargarDatos(gestor.getListaActividades()));

        TW_ActividadesDisponibles_In_Crear_Proceso.getItems().clear();
        TW_ActividadesDisponibles_In_Crear_Proceso.setItems(cargarDatos(gestor.getListaActividades()));

        TW_Actividades.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            actividadSeleccionada = (Actividad) newSelection;
            mostrarDescripccionActividadSeleccionada(actividadSeleccionada);
        });

        TW_ActividadesDisponibles_In_Crear_Proceso.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            actividadDisponibleSeleccionadaInEditarProceso = (Actividad) newSelection;
        });
    }

    private void inicializar_Datos_TW_tareasPresentes_In_editarActividad(TableColumn tcNombreTareaPresenteInEditarActividad, TableColumn tcObligatorioTareaPresenteInEditarActividad) {
        tcNombreTareaPresenteInEditarActividad.setCellValueFactory(new PropertyValueFactory<>("nombre_Tarea"));
        tcObligatorioTareaPresenteInEditarActividad.setCellValueFactory(new PropertyValueFactory<>("esObligatoria_Tarea"));

        TW_TareasPresentes_In_EditarActividad.getItems().clear();
        TW_TareasPresentes_In_EditarActividad.setItems(cargarDatos(actividadSeleccionada.getTareas()));

        TW_TareasPresentes_In_EditarActividad.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            tareaPresenteSeleccionada_In_editarActividades = (Tarea) newSelection;
        });
    }

    private void inicializar_Datos_TW_Proceso(TableColumn<Proceso, String> TC_ID_Proceso, TableColumn<Proceso, String> TC_Nombre_Proceso, TableColumn<Proceso, String> TC_IdProcesosDisponibles_In_EditarUsuario, TableColumn<Proceso, String> TC_NombreProcesosDisponibles_In_EditarUsuario) {
        TC_ID_Proceso.setCellValueFactory(new PropertyValueFactory<>("id_Proceso"));
        TC_Nombre_Proceso.setCellValueFactory(new PropertyValueFactory<>("nombre_Proceso"));

        TC_IdProcesosDisponibles_In_EditarUsuario.setCellValueFactory(new PropertyValueFactory<>("id_Proceso"));
        TC_NombreProcesosDisponibles_In_EditarUsuario.setCellValueFactory(new PropertyValueFactory<>("nombre_Proceso"));

        TW_Procesos.getItems().clear();
        TW_Procesos.setItems(convertirHasmap(gestor.getListaProcesos()));

        TW_ProcesosDisponibles_In_Crear_Usuario.getItems().clear();
        TW_ProcesosDisponibles_In_Crear_Usuario.setItems(convertirHasmap(gestor.getListaProcesos()));

        TW_Procesos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            procesoSeleccionado = (Proceso) newSelection;
        });
        TW_ProcesosDisponibles_In_Crear_Usuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            procesoDisponibleSeleccionadoInEditarUsuario = (Proceso) newSelection;
        });
    }

    private void inicializar_Datos_TW_Usuario(TableColumn tcIdUsuario, TableColumn tcNombreUsuario, TableColumn tcTipoUsuario) {
        tcIdUsuario.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        tcNombreUsuario.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        tcTipoUsuario.setCellValueFactory(new PropertyValueFactory<>("tipoUsuario"));

        TW_Usuarios.getItems().clear();
        TW_Usuarios.setItems(convertirHasmapUsuario(gestor.getListaUsuarios()));

        TW_Usuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            usuarioSeleccionado = (Usuario) newSelection;
        });
    }


    private void inicializar_Datos_TW_Tarea(TableColumn tcNombreTarea, TableColumn tcObligatorioTarea, TableColumn TC_NombreTareaDisponible_In_EditarActividad, TableColumn TC_ObligatorioTareaDisponible_In_EditarActividad) {
        tcNombreTarea.setCellValueFactory(new PropertyValueFactory<>("nombre_Tarea"));
        tcObligatorioTarea.setCellValueFactory(new PropertyValueFactory<>("esObligatoria_Tarea"));

        TC_NombreTareaDisponible_In_EditarActividad.setCellValueFactory(new PropertyValueFactory<>("nombre_Tarea"));
        TC_ObligatorioTareaDisponible_In_EditarActividad.setCellValueFactory(new PropertyValueFactory<>("esObligatoria_Tarea"));

        TW_Tareas.getItems().clear();
        TW_Tareas.setItems(cargarDatos(gestor.getListaTareas()));

        TW_TareasDisponibles_InEditarActividad.getItems().clear();
        TW_TareasDisponibles_InEditarActividad.setItems(cargarDatos(gestor.getListaTareas()));

        TW_Tareas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            tareaSeleccionada = (Tarea) newSelection;
            mostrarDescripccionTareaSeleccionada(tareaSeleccionada);
        });

        TW_TareasDisponibles_InEditarActividad.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            tareaDisponibleSeleccionada_In_editarActividades = (Tarea) newSelection;
        });
    }

    private void inicializar_Datos_TW_Actividades_In_Editar_Proceso(TableColumn tcEditarNombreActividadInProceso, TableColumn tcEditarIdActividadInProceso) {
        tcEditarNombreActividadInProceso.setCellValueFactory(new PropertyValueFactory<>("nombre_Actividad"));
        tcEditarIdActividadInProceso.setCellValueFactory(new PropertyValueFactory<>("esObligatoria_Actividad"));

        TW_Editar_ActividadesInProceso.getItems().clear();
        TW_Editar_ActividadesInProceso.setItems(convertirHasmap(usuarioSeleccionado.getListaProcesosDelUsuario()));

        TW_Editar_ActividadesInProceso.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            actividadDelProcesoSeleccionadaInEditarProceso = (Actividad) newSelection;
        });
    }

    private void inicializar_Datos_TW_Procesos_In_Editar_Usuario(TableColumn TC_IdProcesoUsuario_In_EditarUsuario, TableColumn TC_NombreProcesoUsuario_In_EditarUsuario) {
        TC_IdProcesoUsuario_In_EditarUsuario.setCellValueFactory(new PropertyValueFactory<>("id_Proceso"));
        TC_NombreProcesoUsuario_In_EditarUsuario.setCellValueFactory(new PropertyValueFactory<>("nombre_Proceso"));

        TW_Editar_ProcesoInUsuario.getItems().clear();
        TW_Editar_ProcesoInUsuario.setItems(convertirHasmap(usuarioSeleccionado.getListaProcesosDelUsuario()));

        TW_Editar_ProcesoInUsuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            procesosDelUsuarioSeleccionadoInEditarUsuario = (Proceso) newSelection;
        });
    }

    private void mostrarDescripccionActividadSeleccionada(Actividad actividadSeleccionada) {
        if (actividadSeleccionada != null) {
            String a = actividadSeleccionada.getDescripcion_Actividad();
            TA_Descripccion_Actividad_Seleccionada.setText(a);
        }
    }

    private void mostrarDescripccionTareaSeleccionada(Tarea tareaSeleccionada) {
        if (tareaSeleccionada != null) {
            String a = tareaSeleccionada.getDescripcion_Tarea();
            TA_Descripcion_Tarea_Seleccionada.setText(a);
        }
    }
    public ObservableList convertirHasmap(HashMap<String, Proceso> listaProcesoss) {
        ObservableList<Proceso> a = FXCollections.observableArrayList();
        for (String id : listaProcesoss.keySet()) {
            Proceso p = new Proceso();
            p.setId_Proceso((listaProcesoss.get(id).getId_Proceso()));
            p.setNombre_Proceso(listaProcesoss.get(id).getNombre_Proceso());
//            p.setLista_Actividades_In_Proceso();
            a.add(p);
        }
        return a;
    }
    private ObservableList convertirHasmapUsuario(HashMap<String, Usuario> listaUsuarios) {
        ObservableList<Usuario> a = FXCollections.observableArrayList();
        for (String id : listaUsuarios.keySet()) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(listaUsuarios.get(id).getIdUsuario());
            usuario.setNombreUsuario(listaUsuarios.get(id).getNombreUsuario());
            usuario.setTipoUsuario(listaUsuarios.get(id).getTipoUsuario());
            a.add(usuario);
        }
        return a;
    }

    private <T> ObservableList<T> cargarDatos(Iterable<T> lista) {
        ObservableList<T> a = FXCollections.observableArrayList();
        for (T elemento : lista) {
            a.add(elemento);
        }
        return a;
    }


    //Falta agregar para que se cambie el id
    @FXML
    void AC_Editar_Proceso(ActionEvent event) {
        if (procesoSeleccionado != null) {
            AP_Editar_Proceso.setVisible(true);
            TF_Nombre_EditarProceso.setText(procesoSeleccionado.getNombre_Proceso());
            inicializar_Datos_TW_Actividades_In_Editar_Proceso(TC_Editar_NombreActividadInProceso, TC_Editar_ObligarorioActividadInProceso);
        }
    }

    @FXML
    void AC_Add_Actividad_In_Crear_Proceso(ActionEvent event) {
        if (actividadDisponibleSeleccionadaInEditarProceso != null) {
        String name = actividadDisponibleSeleccionadaInEditarProceso.getNombre_Actividad();
            if (AP_Editar_Proceso.isVisible() && nameActividadIsRepetido(name, procesoSeleccionado.getLista_Actividades_In_Proceso())) {
                procesoSeleccionado.getLista_Actividades_In_Proceso().add(actividadDisponibleSeleccionadaInEditarProceso);
                inicializar_Datos_TW_Actividades_In_Editar_Proceso(TC_Editar_NombreActividadInProceso, TC_Editar_ObligarorioActividadInProceso);
                TW_ActividadesDisponibles_In_Crear_Proceso.getSelectionModel().clearSelection();
                mostrarMensaje("Notificacion", "Actividad agregada", "Esta actividad fue agregada en el proceso", Alert.AlertType.INFORMATION);
            } else {
                TW_ActividadesDisponibles_In_Crear_Proceso.getSelectionModel().clearSelection();
                mostrarMensaje("Notificacion", "Actividad no agregada", "Esta actividad ya existe en el proceso", Alert.AlertType.INFORMATION);
            }
        } else {
            mostrarMensaje("Notificacion", "Actividad no agregada", "No selecciono ninguna actividad valida", Alert.AlertType.INFORMATION);
        }
    }
    @FXML
    void AC_BT_RemoveActividad_In_Crear_Proceso(ActionEvent event) {
        if (actividadDelProcesoSeleccionadaInEditarProceso != null) {
            boolean rsMensaje = mostrarMensajeConfirmacion("¿Seguro de eliminar remover la actividad?"+"\n"+"Al aceptar, se removera la actividad en el proceso");
            if (rsMensaje) {
                procesoSeleccionado.getLista_Actividades_In_Proceso().remove(actividadDelProcesoSeleccionadaInEditarProceso);
                inicializar_Datos_TW_Actividades_In_Editar_Proceso(TC_Editar_NombreActividadInProceso, TC_Editar_ObligarorioActividadInProceso);
            }
        }
    }


    @FXML
    void AC_Crear_Activiad(ActionEvent event) {
        AP_Crear_Actividad.setVisible(true);
    }

    @FXML
    void AC_Cancelar_Crear_Actividad(ActionEvent event) {
        AP_Crear_Actividad.setVisible(false);
    }

    @FXML
    void AC_RadioButton_Posicion_Crear_Actividad(ActionEvent event) {
        CB_Opciones_CrearActividad.getSelectionModel().clearSelection();

        if (RadioButton_TF_Posicion_Crear_Actividad.isSelected()) {
            TF_Posicion_Crear_Actividad.setEditable(true);
            opcionCrearActividad = 3;
        }
    }
    @FXML
    void AC_CB_Opciones_CrearActividad(ActionEvent event) {
        RadioButton_TF_Posicion_Crear_Actividad.setSelected(false);
        TF_Posicion_Crear_Actividad.clear();
        TF_Posicion_Crear_Actividad.setEditable(false);

        String opcionSeleccionada = CB_Opciones_CrearActividad.getValue();
        if (opcionSeleccionada.equals("Crear al final de todo")) {
            opcionCrearActividad = 1;
        } else if (opcionSeleccionada.equals("Crear despues de la ultima creaccion")) {
            opcionCrearActividad = 2;
        }
    }

    @FXML
    void AC_RadioButton_AlFinal_Crear_Tarea(ActionEvent event) {
        if (RadioButton_AlFinal_Crear_Tarea.isSelected()) {
            RadioButton_PosicionDada_Crear_Tarea.setSelected(false);
            TF_Posicion_Dada_Crear_Tarea.clear();
            opcionCrearTarea = 1;
        }
    }
    @FXML
    void AC_RadioButton_PosicionDada_Crear_Tarea(ActionEvent event) {
        if (RadioButton_PosicionDada_Crear_Tarea.isSelected()) {
            TF_Posicion_Dada_Crear_Tarea.setEditable(true);
            RadioButton_AlFinal_Crear_Tarea.setSelected(false);
            opcionCrearTarea = 2;
        }
    }

    private void limpiar_Campos_Crear_Proceso() {
        TF_Id_Crear_Proceso.clear();
        TF_Nombre_Crear_Proceso.clear();
    }

    @FXML
    void AC_Eliminar_Proceso(ActionEvent event) throws IOException {
        boolean rsMensaje = false;
        if (procesoSeleccionado != null) {
            rsMensaje = mostrarMensajeConfirmacion("¿Seguro de eliminar el proceso?"+"\n"+"Al aceptar, el proceso sera eliminado");
            if (rsMensaje) {
                String key = procesoSeleccionado.getId_Proceso();
                gestor.eliminarProceso(key);
                inicializar_Datos_TW_Proceso(TC_ID_Proceso, TC_Nombre_Proceso, TC_IdProcesosDisponibles_In_EditarUsuario, TC_NombreProcesosDisponibles_In_EditarUsuario);
                mostrarMensaje("Notificacion", "Proceso eliminado", "El proceso se elimino con exito", Alert.AlertType.INFORMATION);
            }
        }
    }

    @FXML
    void AC_BT_Eliminar_Actividad(ActionEvent event) {
        boolean actividadEliminada = false, rsMensaje;
        if (actividadSeleccionada != null) {
            rsMensaje = mostrarMensajeConfirmacion("¿Seguro de eliminar la actividad?" + "\n" + "Al aceptar, la actividad sera eliminada");
            if (rsMensaje) {
                Iterator<Actividad> iterator = gestor.getListaActividades().iterator();
                while (iterator.hasNext()) {
                    Actividad actividad = iterator.next();
                    if (actividad.equals(actividadSeleccionada)) {
                        iterator.remove();
                        actividadEliminada = true;
                        break;
                    }
                }
                if (actividadEliminada) {
                    inicializar_Datos_TW_Actividad(TC_Nombre_Actividad, TC_Obligatorio_Actividad, TC_Nombre_ActividadDisponible_In_Crear_Proceso, TC_Obligatorio_ActividadDisponible_In_Crear_Proceso);
                    mostrarMensaje("Notificacion", "Actividad eliminada", "La actividad se elimino con exito", Alert.AlertType.INFORMATION);
                }
            }
        }
    }

    @FXML
    void AC_BT_Eliminar_Tarea(ActionEvent event) {
        boolean tareaEliminada = false, rsMensaje;
        if (tareaSeleccionada != null) {
            rsMensaje = mostrarMensajeConfirmacion("¿Seguro de eliminar la tarea?" + "\n" + "Al aceptar, la tarea sera eliminada");
            if (rsMensaje) {
                Iterator<Tarea> iterator = gestor.getListaTareas().iterator();
                while (iterator.hasNext()) {
                    Tarea tarea = iterator.next();
                    if (tarea.equals(tareaSeleccionada)) {
                        iterator.remove();

                        tareaEliminada = true;
                        break;
                    }
                }
                if (tareaEliminada) {
                    inicializar_Datos_TW_Tarea(TC_Nombre_Tarea, TC_Obligatorio_Tarea, TC_NombreTareaDisponible_In_EditarActividad, TC_ObligatorioTareaDisponible_In_EditarActividad);
                    mostrarMensaje("Notificacion", "Tarea eliminada", "La tarea se elimino con exito", Alert.AlertType.INFORMATION);
                }
            }
        }
    }

    private void limpiar_Campos_Crear_Tarea() {
        TF_Nombre_Crear_Tarea.clear();
        CB_Obligatorio_Crear_Tarea.getSelectionModel().clearSelection();
        TF_Duracion_Crear_Tarea.clear();
        TA_Descripcion_Crear_Tarea.clear();
    }

    private void limpiar_Campos_Crear_Actividad() {
        TF_Nombre_Crear_Actividad.clear();
        TA_Descripcion_Crear_Actividad.clear();
        CB_Obligatorio_Crear_Actividad.getSelectionModel().clearSelection();
    }

    @FXML
    void AC_Cancelar_Crear_Proceso(ActionEvent event) {
        AP_Crear_Proceso.setVisible(false);
    }

    @FXML
    void AC_BT_Cancelar_In_EditarProceso(ActionEvent event) {
        AP_Editar_Proceso.setVisible(false);
    }
    @FXML
    void AC_BT_Guardar_In_EditarProceso(ActionEvent event) {

    }

    @FXML
    void AC_Crear_Tarea(ActionEvent event) {
        AP_Crear_Tarea.setVisible(true);
    }

    @FXML
    void AC_Cancelar_Crear_Tarea(ActionEvent event) {
        AP_Crear_Tarea.setVisible(false);
    }

    @FXML
    void AC_Inicio(ActionEvent event) {
        AP_Usuarios.setVisible(false);
        AP_Recordatorios.setVisible(false);
        AP_Archivos.setVisible(false);
    }

    @FXML
    void AC_Usuarios(ActionEvent event) {
        AP_Usuarios.setVisible(true);

        AP_Recordatorios.setVisible(false);
        AP_Archivos.setVisible(false);
    }


    @FXML
    void AC_Recordatorios(ActionEvent event) {
        AP_Recordatorios.setVisible(true);

        AP_Usuarios.setVisible(false);
        AP_Archivos.setVisible(false);
    }

    @FXML
    void AC_Archivos(ActionEvent event) {
        AP_Archivos.setVisible(true);

        AP_Usuarios.setVisible(false);
        AP_Recordatorios.setVisible(false);
    }

    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }




    private void configureNumericTextField(TextField textField) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (Pattern.matches("[0-9]*", newText)) {
                return change;
            }
            return null;
        };
        TextFormatter<Integer> textFormatter = new TextFormatter<>(new IntegerStringConverter(), null, filter);
        textField.setTextFormatter(textFormatter);
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmacion");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();

        return action.get() == ButtonType.OK;
    }


    private String generarCodigo() {
        Random random = new Random();
        int numero = random.nextInt(9000) + 1000;
        String codigo = String.valueOf(numero);
        return codigo;
    }

    @FXML
    void AC_Crear_Proceso(ActionEvent event) {
        AP_Crear_Proceso.setVisible(true);
    }
    //Metodos para curd Proceso con Persistencia
    @FXML
    void AC_Fin_Crear_Proceso(ActionEvent event) throws IOException {
        String idCrearProceso = TF_Id_Crear_Proceso.getText();
        String nombreCrearProceso = TF_Nombre_Crear_Proceso.getText();

        if (!gestor.getListaProcesos().containsKey(idCrearProceso)) {
            if (!idCrearProceso.isEmpty() && !nombreCrearProceso.isEmpty()) {
                Proceso proceso = new Proceso();
                proceso.setId_Proceso(idCrearProceso);
                proceso.setNombre_Proceso(nombreCrearProceso);
                gestor.crearProceso(idCrearProceso, nombreCrearProceso);

                mostrarMensaje("Crear Proceso", "Creación Exitosa", "Se creo con exito el proceso", Alert.AlertType.INFORMATION);
                AP_Crear_Proceso.setVisible(false);
                inicializar_Datos_TW_Proceso(TC_ID_Proceso, TC_Nombre_Proceso, TC_IdProcesosDisponibles_In_EditarUsuario, TC_NombreProcesosDisponibles_In_EditarUsuario);
                limpiar_Campos_Crear_Proceso();
            } else {
                mostrarMensaje("Crear Proceso", "Creación Fallida", "No se pudo crear el proceso", Alert.AlertType.INFORMATION);
            }
        } else {
            mostrarMensaje("Crear Proceso", "Creación Fallida", "Ya existe un proceso con este Id", Alert.AlertType.INFORMATION);
        }
        limpiar_Campos_Crear_Proceso();
    }
    @FXML
    void AC_Eliminar_Usuario(ActionEvent event) {
        boolean rsMensaje = false;
        if (usuarioSeleccionado != null) {
            rsMensaje = mostrarMensajeConfirmacion("¿Seguro de eliminar el usuario?"+"\n"+"Al aceptar, el usuario sera eliminado");
            String key = usuarioSeleccionado.getIdUsuario();
            gestor.getListaUsuarios().remove(key);
            inicializar_Datos_TW_Usuario(TC_ID_Usuario, TC_Nombre_Usuario, TC_Tipo_Usuario);
            mostrarMensaje("Notificacion", "Usuario eliminado", "El usuario se elimino con exito", Alert.AlertType.INFORMATION);
        }
    }
    //Funcion para actualizar el proceso
    public void ActualizarProceso(String idProceso, String nuevoNombre) {
        try{
            gestor.actualizarProceso(procesoSeleccionado.getId_Proceso(), procesoSeleccionado.getNombre_Proceso());
            Persistencia.guardarProceso(gestor.getListaProcesos());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Metodos para crud Actvidad con persistencia
    @FXML
    void AC_Fin_CrearActividad(ActionEvent event) throws IOException {
        String nombreCrearActividad = TF_Nombre_Crear_Actividad.getText();
        String obligatorioCrearActividad = CB_Obligatorio_Crear_Actividad.getValue();
        String descripcionCrearActividad = TA_Descripcion_Crear_Actividad.getText();

        String posicionCrearProceso = TF_Posicion_Crear_Actividad.getText();
        String opcionesCrearProceso = CB_Opciones_CrearActividad.getValue();

        if (!nombreCrearActividad.isEmpty() && !descripcionCrearActividad.isEmpty() && !obligatorioCrearActividad.isEmpty() && nameActividadIsRepetido(nombreCrearActividad, gestor.getListaActividades())) {
            Actividad actividad = new Actividad();
            actividad.setNombre_Actividad(nombreCrearActividad);
            actividad.setEsObligatoria_Actividad(obligatorioCrearActividad);
            actividad.setDescripcion_Actividad(descripcionCrearActividad);
            switch (opcionCrearActividad) {
                case 0, 1:
                    gestor.getListaActividades().add(actividad);
                    ultimaActividadCreada = actividad;
                    break;
                case 2:
                    int index = gestor.getListaActividades().indexOf(ultimaActividadCreada);
                    gestor.getListaActividades().add(index+1, actividad);
                    ultimaActividadCreada = actividad;
                    break;
                case 3:
                    int i = Integer.parseInt(TF_Posicion_Crear_Actividad.getText());
                    if (i <= gestor.getListaActividades().size() && i > 0) {
                        gestor.getListaActividades().add(i-1,actividad);
                        ultimaActividadCreada = actividad;
                    }
                    break;
            }
            gestor.guardaArchivos();
            System.out.println("Se guardo la actividad");
            mostrarMensaje("Crear Actividad", "Creación Exitosa", "Se creo con exito la actividad", Alert.AlertType.INFORMATION);
            AP_Crear_Actividad.setVisible(false);
            inicializar_Datos_TW_Actividad(TC_Nombre_Actividad, TC_Obligatorio_Actividad, TC_Nombre_ActividadDisponible_In_Crear_Proceso, TC_Obligatorio_ActividadDisponible_In_Crear_Proceso);
        } else {
            mostrarMensaje("Crear Proceso", "Creación Fallida", "No se pudo crear el proceso", Alert.AlertType.INFORMATION);
        }
        limpiar_Campos_Crear_Actividad();
    }

    @FXML
    void AC_Fin_Crear_Tarea(ActionEvent event) throws IOException {
        String nombreCrearTarea = TF_Nombre_Crear_Tarea.getText();
        String obligatorioCrearTarea = CB_Obligatorio_Crear_Tarea.getValue();
        String duracionCrearTarea = TF_Duracion_Crear_Tarea.getText();
        String descripcionCrearTarea = TA_Descripcion_Crear_Tarea.getText();
        String posicionCrearTarea = TF_Posicion_Dada_Crear_Tarea.getText();
        if (!nombreCrearTarea.isEmpty() && !duracionCrearTarea.isEmpty() && !descripcionCrearTarea.isEmpty() && !obligatorioCrearTarea.isEmpty()) {
            Tarea tarea = new Tarea();
            tarea.setNombre_Tarea(nombreCrearTarea);
            tarea.setEsObligatoria_Tarea(obligatorioCrearTarea);
            tarea.setTiempoDuracion_Tarea(duracionCrearTarea);
            tarea.setDescripcion_Tarea(descripcionCrearTarea);
            switch (opcionCrearTarea) {
                case 0,1:
                    Object ultimoElemento = ((LinkedList<Tarea>) gestor.getListaTareas()).getLast();
                    if (((LinkedList<Tarea>) gestor.getListaTareas()).getLast().getEsObligatoria_Tarea().equals("Si") || (((LinkedList<Tarea>) gestor.getListaTareas()).getLast().getEsObligatoria_Tarea().equals("No")) && obligatorioCrearTarea.equals("Si")) {
                        gestor.getListaTareas().add(tarea);
                        ultimaTareaCreada = tarea;
                        mostrarMensaje("Crear Tarea", "Creación Exitosa", "Se creo con exito la tarea", Alert.AlertType.INFORMATION);
                    } else {
                        mostrarMensaje("Crear Actividad", "Creación Fallida", "No se permiten tareas opcionales seguidas", Alert.AlertType.INFORMATION);
                    }



                    break;
                case 2:
                    int i = Integer.parseInt(TF_Posicion_Dada_Crear_Tarea.getText());
                    if (i > 0 && i <= gestor.getListaTareas().size()) {
                        LinkedList<Tarea> ax = new LinkedList<>(gestor.getListaTareas());
                        if ((i == 1 || "Si".equals(ax.get(i-2).getEsObligatoria_Tarea())) && "Si".equals(ax.get(i-1).getEsObligatoria_Tarea())) {
                            ax.add(i-1, tarea);
                            gestor.getListaTareas().clear();
                            gestor.getListaTareas().addAll(ax);
                            mostrarMensaje("Crear Tarea", "Creación Exitosa", "Se creó con éxito la tarea", Alert.AlertType.INFORMATION);
                        } else {
                            mostrarMensaje("Crear Actividad", "Creación Fallida", "No se permiten tareas opcionales seguidas", Alert.AlertType.INFORMATION);
                        }
                    }


//                    int i = Integer.parseInt(TF_Posicion_Dada_Crear_Tarea.getText()); // indice dado por el usuario
//                    if (i > 0 && i <= gestor.getListaTareas().size()) { // validadion si el indice dado esta en el rango del tamanio de la lista ciendo el minimo valor 1
//                        LinkedList<Tarea> ax = new LinkedList<>();
//                        ax.addAll(gestor.getListaTareas());
//
//                        if (i == 1 && ax.get(i-1).getEsObligatoria_Tarea() == "Si") {
//                            ax.add(i-1,tarea);
//                            gestor.getListaTareas().clear();
//                            gestor.getListaTareas().addAll(ax);
//                            mostrarMensaje("Crear Tarea", "Creación Exitosa", "Se creo con exito la tarea", Alert.AlertType.INFORMATION);
//                            break;
//                        }
//                        if (ax.get(i-1).getEsObligatoria_Tarea() == "Si" && i != 1 && i == gestor.getListaTareas().size()) {
//                            ax.add(i,tarea);
//                            gestor.getListaTareas().clear();
//                            gestor.getListaTareas().addAll(ax);
//                            mostrarMensaje("Crear Tarea", "Creación Exitosa", "Se creo con exito la tarea", Alert.AlertType.INFORMATION);
//                            break;
//                        }
//                        if (ax.get(i-1).getEsObligatoria_Tarea() == "Si" && ax.get(i).getEsObligatoria_Tarea() == "Si"  && i != 1 && i != gestor.getListaTareas().size()) {
//                            ax.add(i,tarea);
//                            gestor.getListaTareas().clear();
//                            gestor.getListaTareas().addAll(ax);
//                            mostrarMensaje("Crear Tarea", "Creación Exitosa", "Se creo con exito la tarea", Alert.AlertType.INFORMATION);
//                            break;
//                        } else {
//                            mostrarMensaje("Crear Actividad", "Creación Fallida", "No se permite tareas opcioales seguidas", Alert.AlertType.INFORMATION);
//                            break;
//                        }
//                    }
                    break;
            }
            gestor.guardaArchivos();
            AP_Crear_Tarea.setVisible(false);
            inicializar_Datos_TW_Tarea(TC_Nombre_Tarea, TC_Obligatorio_Tarea, TC_NombreTareaDisponible_In_EditarActividad, TC_ObligatorioTareaDisponible_In_EditarActividad);
        } else {
            mostrarMensaje("Crear Actividad", "Creación Fallida", "No se creo la tarea", Alert.AlertType.INFORMATION);
        }
        limpiar_Campos_Crear_Tarea();
    }

    private boolean nameTareaIsRepetido(String name, Queue<Tarea> listaProcesosDelUsuario) {
        for (Tarea tarea : listaProcesosDelUsuario) {
            if (tarea.getNombre_Tarea().equals(name)) {
                return false;
            }
        }
        return true;
    }
    private boolean nameActividadIsRepetido(String nombreCrearActividad, LinkedList<Actividad> listaActividades) {
        for (Actividad actividad : listaActividades) {
            if (actividad.getNombre_Actividad().equals(nombreCrearActividad)) {
                return false;
            }
        }
        return true;
    }

    private boolean nameProcesoIsRepetido(String name, HashMap<String, Proceso> listaProcesosDelUsuario) {
        for (String id : listaProcesosDelUsuario.keySet()) {
            if (listaProcesosDelUsuario.get(id).getNombre_Proceso().equals(name)) {
                return false;
            }
        }
        return true;
    }

    @FXML
    void AC_BT_Editar_Tarea(ActionEvent event) {
        if (tareaSeleccionada != null) {
            TF_Nombre_Editar_Tarea.setText(tareaSeleccionada.getNombre_Tarea());
            CB_Obligatorio_Editar_Tarea.setValue(tareaSeleccionada.getEsObligatoria_Tarea());
            TF_Duracion_Editar_Tarea.setText(tareaSeleccionada.getTiempoDuracion_Tarea());
            TA_Descripcion_Editar_Tarea.setText(tareaSeleccionada.getDescripcion_Tarea());
            AP_Editar_Tarea.setVisible(true);
        }
    }
    @FXML
    void AC_BT_Cancelar_Editar_Tarea(ActionEvent event) {
            AP_Editar_Tarea.setVisible(false);
    }
    @FXML
    void AC_BT_Fin_Actualizar_Tarea(ActionEvent event) {
        String nombre = TF_Nombre_Editar_Tarea.getText();
        String obligatoio = CB_Obligatorio_Editar_Tarea.getValue();
        String duracion = TF_Duracion_Editar_Tarea.getText();
        String descripcion = TA_Descripcion_Editar_Tarea.getText();

        boolean editarEstado = editarEstadoTarea(tareaSeleccionada.getNombre_Tarea(), obligatoio);
        if (!nombre.isEmpty() && !obligatoio.isEmpty() && !duracion.isEmpty() && !descripcion.isEmpty() && editarEstado) {

            tareaSeleccionada.setNombre_Tarea(nombre);
            tareaSeleccionada.setEsObligatoria_Tarea(obligatoio);
            tareaSeleccionada.setTiempoDuracion_Tarea(duracion);
            tareaSeleccionada.setDescripcion_Tarea(descripcion);
            inicializar_Datos_TW_Tarea(TC_Nombre_Tarea, TC_Obligatorio_Tarea, TC_NombreTareaDisponible_In_EditarActividad, TC_ObligatorioTareaDisponible_In_EditarActividad);
        } else {
            mostrarMensaje("Editar Actividad", "Edicion Fallida", "No se permiten tareas opcionales seguidas", Alert.AlertType.INFORMATION);
        }
        AP_Editar_Tarea.setVisible(false);
    }


    public boolean editarEstadoTarea(String nombreTarea, String nuevoEstado) {
        boolean retorno = true;
        boolean is = true;
        boolean s = false;
        // Encuentra la tarea en la cola
        Tarea tareaActual = null;
        Tarea tareaAnterior = null;
        Tarea tareaSiguiente = null;

        for (Tarea tarea : gestor.getListaTareas()) {
            if (tarea.getNombre_Tarea().equals(nombreTarea)) {
                tareaActual = tarea;
            } else if (tareaActual == null) {
                tareaAnterior = tarea;
            } else {
                tareaSiguiente = tarea;
                break;
            }
        }
        if (tareaActual != null) {
            boolean a = tareaAnterior != null && tareaAnterior.getEsObligatoria_Tarea().equals("No");
            boolean c = tareaSiguiente != null && tareaSiguiente.getEsObligatoria_Tarea().equals("No");
            if ((a || c) && tareaSiguiente != null) {
                System.out.println("Advertencia: Dos tareas opcionales seguidas.");
                retorno = false;
            } else if ((tareaSiguiente != null && tareaAnterior == null) || (tareaAnterior != null && tareaSiguiente == null)) {
            }
        } else {
            System.out.println("La tarea no se encontró en la cola.");
        }

        return retorno;
    }

    @FXML
    void AC_Editar_Usuario(ActionEvent event) {
        if (usuarioSeleccionado != null) {
            AP_Editar_Usuario.setVisible(true);
            TF_Id_EditarUsuario.setText(usuarioSeleccionado.getIdUsuario());
            TF_Nombre_EditarUsuario.setText(usuarioSeleccionado.getNombreUsuario());
            CB_TipoUsuario_EditarUsuario.setValue(usuarioSeleccionado.getTipoUsuario());
            inicializar_Datos_TW_Procesos_In_Editar_Usuario(TC_IdProcesoUsuario_In_EditarUsuario, TC_NombreProcesoUsuario_In_EditarUsuario);
        }
    }
    @FXML
    void AC_Crear_Usuario(ActionEvent event) {
        AP_Crear_Usuario.setVisible(true);
    }


    @FXML
    void AC_Fin_Crear_Usuario(ActionEvent event) throws IOException {
        String id = TF_Id_Crear_Usuario.getText();
        String nombre = TF_Nombre_Crear_Usuario.getText();
        String tipo = CB_TipoUsuario_CrearUsuario.getValue();

        if (!id.isEmpty() && !nombre.isEmpty() && !tipo.isEmpty()) {
            Usuario usuario = new Usuario();

            usuario.setIdUsuario(id);
            usuario.setNombreUsuario(nombre);
            usuario.setTipoUsuario(tipo);

            gestor.getListaUsuarios().put(id,usuario);
            Persistencia.guardarUsuario(gestor.getListaUsuarios());
            mostrarMensaje("Crear Usuario", "Creación Exitosa", "Se creo con exito el usuario", Alert.AlertType.INFORMATION);
            limpiar_Campos_Crear_Usuario();
            AP_Crear_Usuario.setVisible(false);

            inicializar_Datos_TW_Proceso(TC_ID_Proceso, TC_Nombre_Proceso, TC_IdProcesosDisponibles_In_EditarUsuario, TC_NombreProcesosDisponibles_In_EditarUsuario);
            inicializar_Datos_TW_Usuario(TC_ID_Usuario, TC_Nombre_Usuario, TC_Tipo_Usuario);
        }
    }

    @FXML
    void AC_Cancelar_Crear_Usuario(ActionEvent event) {
        AP_Crear_Usuario.setVisible(false);
    }

    private void limpiar_Campos_Crear_Usuario() {
        TF_Id_Crear_Usuario.clear();
        TF_Nombre_Crear_Usuario.clear();
        CB_TipoUsuario_CrearUsuario.getSelectionModel().clearSelection();
    }

    @FXML
    void AC_BT_RemoveProceso_In_EditarUsuario(ActionEvent event) {
        if (procesosDelUsuarioSeleccionadoInEditarUsuario != null) {
            boolean rsMensaje = mostrarMensajeConfirmacion("¿Seguro de remover el proceso?"+"\n"+"Al aceptar, se removera el proceso del usuario");
            if (rsMensaje) {
                usuarioSeleccionado.getListaProcesosDelUsuario().remove(procesosDelUsuarioSeleccionadoInEditarUsuario.getId_Proceso());
                inicializar_Datos_TW_Procesos_In_Editar_Usuario(TC_IdProcesoUsuario_In_EditarUsuario, TC_NombreProcesoUsuario_In_EditarUsuario);
            }
        }
    }

    @FXML
    void AC_BT_Add_Proceso_In_EditarUsuario(ActionEvent event) {
        if (procesoDisponibleSeleccionadoInEditarUsuario != null) {
            String name = procesoDisponibleSeleccionadoInEditarUsuario.getNombre_Proceso();
            if (AP_Editar_Usuario.isVisible() && nameProcesoIsRepetido(name, usuarioSeleccionado.getListaProcesosDelUsuario())) {
                usuarioSeleccionado.getListaProcesosDelUsuario().put(procesoDisponibleSeleccionadoInEditarUsuario.getId_Proceso(),procesoDisponibleSeleccionadoInEditarUsuario);
                inicializar_Datos_TW_Procesos_In_Editar_Usuario(TC_IdProcesoUsuario_In_EditarUsuario, TC_NombreProcesoUsuario_In_EditarUsuario);
                TW_ProcesosDisponibles_In_Crear_Usuario.getSelectionModel().clearSelection();
                mostrarMensaje("Notificacion", "Proceso agregado", "Este proceso fue agregado al usuario", Alert.AlertType.INFORMATION);
            } else{
                TW_ProcesosDisponibles_In_Crear_Usuario.getSelectionModel().clearSelection();
                mostrarMensaje("Notificacion", "Proceso no agregado", "Este proceso ya pertence al usuario", Alert.AlertType.INFORMATION);
            }
        } else {
            mostrarMensaje("Notificacion", "Proceso no agregado", "No selecciono ningun proceso valido", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    void AC_BT_Actualizar_In_EditarUsuario(ActionEvent event) {
        String id = TF_Id_EditarUsuario.getText();
        String nombre = TF_Nombre_EditarUsuario.getText();
        String tipo = CB_TipoUsuario_EditarUsuario.getValue();

        if (!id.isEmpty() && !nombre.isEmpty() && !tipo.isEmpty()) {
            gestor.getListaUsuarios().get(usuarioSeleccionado.getIdUsuario()).setIdUsuario(id);
            gestor.getListaUsuarios().get(usuarioSeleccionado.getIdUsuario()).setNombreUsuario(nombre);
            gestor.getListaUsuarios().get(usuarioSeleccionado.getIdUsuario()).setTipoUsuario(tipo);

            inicializar_Datos_TW_Usuario(TC_ID_Usuario, TC_Nombre_Usuario, TC_Tipo_Usuario);
        }
        AP_Editar_Usuario.setVisible(false);
    }

    @FXML
    void AC_BT_Cancelar_In_EditarUsuario(ActionEvent event) {
        AP_Editar_Usuario.setVisible(false);
    }

    @FXML
    void AC_BT_Editar_Actividad(ActionEvent event) {
        if (actividadSeleccionada != null) {
            AP_Editar_Actividad.setVisible(true);
            TF_Nombre_EditarActividad.setText(actividadSeleccionada.getNombre_Actividad());
            CB_Obligatorio_In_EditarActividad.setValue(actividadSeleccionada.getEsObligatoria_Actividad());
            inicializar_Datos_TW_tareasPresentes_In_editarActividad(TC_NombreTareaPresente_In_EditarActividad, TC_ObligatorioTareaPresente_In_EditarActividad);
        }
    }
    @FXML
    void AC_BT_Actualizar_In_EditarActividad(ActionEvent event) {
        String nombre = TF_Nombre_EditarActividad.getText();
        String obligatorio = CB_Obligatorio_In_EditarActividad.getValue();

        if (!nombre.isEmpty() && !obligatorio.isEmpty()) {
            actividadSeleccionada.setNombre_Actividad(nombre);
            actividadSeleccionada.setEsObligatoria_Actividad(obligatorio);

            inicializar_Datos_TW_Actividad(TC_Nombre_Actividad, TC_Obligatorio_Actividad, TC_Nombre_ActividadDisponible_In_Crear_Proceso, TC_Obligatorio_ActividadDisponible_In_Crear_Proceso);
        }
        AP_Editar_Actividad.setVisible(false);
    }
    @FXML
    void AC_BT_Cancelar_In_EditarActividad(ActionEvent event) {
        AP_Editar_Actividad.setVisible(false);
    }
    @FXML
    void AC_BT_AddTarea_In_EditarActividad(ActionEvent event) {
        if (tareaDisponibleSeleccionada_In_editarActividades != null) {
            String name = tareaDisponibleSeleccionada_In_editarActividades.getNombre_Tarea();
            if (AP_Editar_Actividad.isVisible() && nameTareaIsRepetido(name, actividadSeleccionada.getTareas())) {
                actividadSeleccionada.getTareas().add(tareaDisponibleSeleccionada_In_editarActividades);
                inicializar_Datos_TW_tareasPresentes_In_editarActividad(TC_NombreTareaPresente_In_EditarActividad, TC_ObligatorioTareaPresente_In_EditarActividad);
                TW_TareasPresentes_In_EditarActividad.getSelectionModel().clearSelection();
                mostrarMensaje("Notificacion", "Tarea agregado", "Esta tarea fue agregado a la actividad", Alert.AlertType.INFORMATION);
            } else {
                TW_TareasPresentes_In_EditarActividad.getSelectionModel().clearSelection();
                mostrarMensaje("Notificacion", "Tarea no agregado", "Esta tarea ya pertence a la actividad", Alert.AlertType.INFORMATION);
            }
        } else {
            mostrarMensaje("Notificacion", "Tarea no agregado", "No selecciono ninguna tarea valido", Alert.AlertType.INFORMATION);
        }

    }
    @FXML
    void AC_BT_Remove_In_EditarActividad(ActionEvent event) {
        if (tareaPresenteSeleccionada_In_editarActividades != null) {
            boolean rsMensaje = mostrarMensajeConfirmacion("¿Seguro de remover la tarea?"+"\n"+"Al aceptar, se removera la tarea de la actividad");
            if (rsMensaje) {
                actividadSeleccionada.getTareas().remove(tareaDisponibleSeleccionada_In_editarActividades);
                inicializar_Datos_TW_tareasPresentes_In_editarActividad(TC_NombreTareaPresente_In_EditarActividad, TC_ObligatorioTareaPresente_In_EditarActividad);
            }
        }
    }

}