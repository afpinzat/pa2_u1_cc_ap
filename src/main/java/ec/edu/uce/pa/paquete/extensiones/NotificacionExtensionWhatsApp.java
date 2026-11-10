package ec.edu.uce.pa.paquete.extensiones;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class NotificacionExtensionWhatsApp implements NotificacionExtension{

    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println();
        System.out.println("Envio WhatsApp a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("SMS enviado con exito. ");
        
    }

}