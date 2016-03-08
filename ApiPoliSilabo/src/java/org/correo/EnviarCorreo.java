package org.correo;

/**
 *
 * @author Carlos Andres Charris 
 */
public class EnviarCorreo {
    Correo correo = new Correo();
    
    public static void main(String[] args) {
        EnviarCorreo ec = new EnviarCorreo();
        ec.enviarCorreo();
    }
    
    /**
     * Metodo para realizar el set de los campos a enviar por correo
     */
    
    public void enviarCorreo(){
        correo.setContrasenia("fyluwljzzkkghnie");
        correo.setUsuarioCorreo("darkklitos@gmail.com");
        correo.setAsunto("Correo de prueba");
        correo.setMensaje("Correo de prueba con Java");
        correo.setDestino("darkklitos@gmail.com");
        /*
        Linea para enviar archivos adjuntos
        correo.setNombreArchivo("logo.png");
        correo.setRutaArchivo("logo.png");
        */
        Controlador c = new Controlador();
        
        if (c.enviarCorreo(correo)) {
            System.out.println("Correo enviado Correctamente");
            
        }else{
            System.out.println("Error con el envio del Correo");
        }
    }
}