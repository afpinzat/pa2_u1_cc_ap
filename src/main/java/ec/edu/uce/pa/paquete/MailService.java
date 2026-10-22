package ec.edu.uce.pa.paquete;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

//@ApplicationScoped //le delego el control al contenedor
//@RequestScoped //Para aplicaciones web

@Singleton
@Named ("mail")
public class MailService implements Notificacion {

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando corrreo a: " + destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo emviado con exito.");
        System.out.println("Fin del envio del mensaje.");
    }

}
