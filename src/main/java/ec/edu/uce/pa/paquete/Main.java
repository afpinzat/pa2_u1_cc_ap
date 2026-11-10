package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionMail;
import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionSMS;
import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionWhatsApp;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

//@RequestScoped 
@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private CompraService compraService;

    @Inject
    private NotificacionExtensionMail notificacionExtensionMail;

    @Inject
    private NotificacionExtensionSMS notificacionExtensionSMS;

    @Inject
    private NotificacionExtensionWhatsApp notificacionExtensionWhatsApp;

    public static void main(String[] args) {

        Quarkus.run(Main.class, args);

    }

    @Override
    public int run(String... args) {

        //Sorporta la extension de la funcionalidad de notificaciones sobre la Clase CompraService
        System.out.println("Iniciando Aplicacion Quarkus...");
        Compra compra = new Compra("Juan Perez", "Laptop", 1500.00, "juan.perez@example"); // creamos el objeto de la
        compra.setTelefono("0999887765");
        compraService.realizar(compra, this.notificacionExtensionMail);

        Compra compra1 = new Compra("Luis Perez", "Laptop", 1500.00, "juan.perez@example"); // creamos el objeto de la
        compra.setTelefono("0999887765");
        compraService.realizar(compra1, this.notificacionExtensionSMS);

        Compra compra3 = new Compra("Pepito Perez", "Laptop", 1500.00, "juan.perez@example"); // creamos el objeto de la
        compra.setTelefono("0999887765");
        compraService.realizar(compra3, this.notificacionExtensionWhatsApp);

        return 0;
    }
}
