package org.correo;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Carlos Andres Charris 
 */
public class Controlador {
    
     
/**
 * Metodo que confirgura los aprametros del Correo Electronico
 * @param correo
 * @return 
 */    
    
    public boolean enviarCorreo(Correo correo){
       
        try {
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", correo.getUsuarioCorreo());
            p.setProperty("mail.smtp.auth", "true");
            
            Session s = Session.getDefaultInstance(p, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(correo.getMensaje());
            
            /*Linea para enviar archivos adjuntos
            
            BodyPart adjunto = new MimeBodyPart();
            
            if (!correo.getRutaArchivo().equals("")) {
                adjunto.setDataHandler(new DataHandler(new FileDataSource(correo.getRutaArchivo())));
                adjunto.setFileName(correo.getNombreArchivo());
            }
            
            if (!correo.getRutaArchivo().equals("")) {
                m.addBodyPart(adjunto);
            }
              */
              
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);             
            Message mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(correo.getUsuarioCorreo()));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correo.getDestino()));
            mensaje.setSubject(correo.getAsunto());
            mensaje.setSentDate(new Date());
            mensaje.setContent(m);
            
            Transport t = s.getTransport("smtp");
            t.connect(correo.getUsuarioCorreo(), correo.getContrasenia());
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            return true;
            
        } catch (Exception e) {
            System.out.println("Error" + e);
            return false;
        }
        
        
        
    }
    
}