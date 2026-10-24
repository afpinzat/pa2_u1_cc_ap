package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@ApplicationScoped
// @RequestScopped
// @Singleton //Delego el control al contenedor Arc

public class PedidoService {

    // @Inject
    // private MailService diferente;
    //Por tener 2 impementaciones de la misma interfaz da problema de ambiguedad
    @Inject
    @Named("mail")
    private Notificacion notificacionCorreo;


    @Inject
    @Named("sms")
    private Notificacion notificacionSMS;

    public void realizar(Pedido pedido) {

        System.out.println("realizando pedido...");
        System.out.println("Pedido realizado por el cliente :" + pedido.getCliente());
        System.out.println(" Producto :" + pedido.getProducto());
        System.out.println("Total:" + pedido.getTotal());
        System.out.println("Correo:" + pedido.getCorreo());
        System.out.println(" Pedido realizado con exito...");

        String cuerpo = "Estimado " + pedido.getCliente() + ", su pedido de  " +
                pedido.getProducto() + " por un total de $" + pedido.getTotal() +
                " ha sido realizado con exito.";

        // Notificacion de pedido por correo electronico
        this.notificacionCorreo.enviar(pedido.getCorreo(), cuerpo);
        this.notificacionCorreo.setCantidad(this.notificacionCorreo.getCantidad()+1);
        this.notificacionCorreo.setNombre("Correo de pedido");

       System.out.println("Cantidad de correos enviados: " + this.notificacionCorreo.getCantidad());
        // Notificacion de pedido por SMS
        this.notificacionSMS.enviar(pedido.getTelefono(), cuerpo);

    }

}
