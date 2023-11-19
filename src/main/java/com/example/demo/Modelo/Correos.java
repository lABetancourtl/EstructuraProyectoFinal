package com.example.demo.Modelo;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class Correos {
    private static String Mailfrom = "zpayitaz@gmail.com";
    private static String pasword = "bqkj uads oixr xvkj";
    //Para que correo se envia
    private String emailTo;
    private String Asunto;
    private String contenido;

    private Properties mProperties;
    private Session session;
    private MimeMessage mimeMessage;
    public Correos(){
        mProperties = new Properties();
    }
    private void crearCorreo(){

    }
    private void enviarCorreo(){

    }
}
