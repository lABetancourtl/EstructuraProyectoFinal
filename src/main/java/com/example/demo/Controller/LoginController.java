package com.example.demo.Controller;
import com.example.demo.HelloApplication;
import com.example.demo.Modelo.Administrador;
import com.example.demo.Modelo.Gestor;
import com.example.demo.Modelo.Usuario;
import com.example.demo.Modelo.UsuarioNoEncontradoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LoginController {
    Gestor gestor = new Gestor();

    @FXML
    private PasswordField textPassword_Contrasena;

    @FXML
    private TextField textField_Usuario;

    @FXML
    private Button boton_Ingresar;

    @FXML
    private Hyperlink link_Registro;

    HelloApplication principal;

    private String codigoUsuario;
    private Usuario userConectado;


    @FXML
    void ingresar(ActionEvent event)  {
        iniciar();
//        cargarVentanaPrincipal();
    }

    private void iniciar()  {
        String usuario = textField_Usuario.getText();
        String contrasena = textPassword_Contrasena.getText();
        try {
            boolean[] acceso = iniciarSesion(usuario, contrasena);
            if (acceso[0] ) {
                if (acceso[1]) {

                    //cargarVentanaPrincipal();
                    gestor.setAdmin(true);
                } else {

                }
            }
        } catch (UsuarioNoEncontradoException e) {
            // Mostrar un mensaje de error al usuario
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean[] iniciarSesion(String usuario,String contrasena) throws UsuarioNoEncontradoException, IOException {
        boolean[] datosLogin = new boolean[2];
        datosLogin[0] = false;
        datosLogin[1] = false;
//        for (Usuario u: getListaUsuarios()) {
        for (String id: gestor.getListaUsuarios().keySet()) {
            if (usuario.equals(gestor.getListaUsuarios().get(id).getIdUsuario()) && contrasena.equals(gestor.getListaUsuarios().get(id).getContrasena())) {

//            if (usuario.equals(u.getUsuario()) && contrasena.equals(u.getContrasena())){ // Comparar el usuario y la
                datosLogin[0] = true;

                if (!gestor.getListaUsuarios().get(id).equals("Normal")) {
                    datosLogin[1] = true;
                }
//                codigoUsuario = u.getContrasena();
//                userConectado = u;
                break; // Salir del ciclo
            }
        }

        if(datosLogin[0] == false) { // Si el usuario no existe
            throw new UsuarioNoEncontradoException("mal"); // Lanzar la excepción
        }
        return datosLogin; // Devolver el arreglo
    }




    @FXML
    void registro(ActionEvent event){

    }

    // Declarar una lista de usuarios
    private List<Usuario> listaUsuarios;

    // Crear el método getListaUsuarios
    public List<Usuario> getListaUsuarios() {
        // Si la lista está vacía, inicializarla con algunos usuarios de ejemplo
        if (listaUsuarios == null) {
            listaUsuarios = new ArrayList<>();
            // Crear un usuario con usuario "juan" y contraseña "1234"
            Usuario u1 = new Usuario("juan", "123");
            // Agregar el usuario a la lista
            listaUsuarios.add(u1);
            // Crear otro usuario con usuario "ana" y contraseña "5678"
            Usuario u2 = new Usuario("ana", "5678");
            // Agregar el usuario a la lista
            listaUsuarios.add(u2);
        }
        // Retornar la lista de usuarios
        return listaUsuarios;
    }

    // Declarar una lista de administradores
    private List<Administrador> listaAdmi;

    // Crear el método getListaAdmi
    public List<Administrador> getListaAdmi() {
        // Si la lista está vacía, inicializarla con algunos administradores de ejemplo
        if (listaAdmi == null) {
            listaAdmi = new ArrayList<>();
            // Crear un administrador con usuario "admin" y contraseña "admin"
            Administrador a1 = new Administrador("admin", "admin");
            // Agregar el administrador a la lista
            listaAdmi.add(a1);
            // Crear otro administrador con usuario "root" y contraseña "root"
            Administrador a2 = new Administrador("root", "root");
            // Agregar el administrador a la lista
            listaAdmi.add(a2);
        }
        // Retornar la lista de administradores
        return listaAdmi;
    }

    public void cargarVentanaPrincipal() {

        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

            double screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            double screenHeight =java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
            Parent root = loader.load();

            Scene scene = new Scene(root, screenHeight, screenWidth );
            Stage stage = new Stage ();
            stage.centerOnScreen();
            stage.setTitle("UQGESTOR");
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



