package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.extensiones.NotificacionExtension;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompraService {

    // Cuando tengo una funcionalidad sin extencion, uso el named (Inyeccion)
    // Si es potencialmente extensible usar extensiones

    public void realizar(Compra compra, NotificacionExtension notificacionExtension) {

        System.out.println("realizando compra...");
        System.out.println("Pedido realizado por el cliente :" + compra.getCliente());
        System.out.println("Producto :" + compra.getProducto());
        System.out.println("Total:" + compra.getTotal());
        System.out.println("Correo:" + compra.getCorreo());
        System.out.println("Compra realizado con exito...");

        // Aqui voy a programar la logica del envio de la notificacion
        // Debo recibir como parametro por constructor o argumento de metodo una
        // interfaz
        // Debo garantizar que mi funcionalidad no se vea afectada

        notificacionExtension.enviar("Su pedido ha sido realizado con exito", compra.getCliente());


    }

}
