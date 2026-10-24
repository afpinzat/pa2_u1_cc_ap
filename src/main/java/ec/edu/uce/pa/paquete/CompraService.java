package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped 
public class CompraService {

    @Inject
    @Named("mail")
    private Notificacion notificacionCorreo;

    public void realizar(Compra compra) {

        System.out.println("realizando compra...");
        System.out.println("Pedido realizado por el cliente :" + compra.getCliente());
        System.out.println(" Producto :" + compra.getProducto());
        System.out.println("Total:" + compra.getTotal());
        System.out.println("Correo:" + compra.getCorreo());
        System.out.println(" Compra realizado con exito...");

        String cuerpo = "Estimado" + compra.getCliente() + ", su pedido de  " +
                compra.getProducto() + " por un total de $" + compra.getTotal() +
                " ha sido realizado con exito.";

        // Notificacion de pedido por correo electronico
        this.notificacionCorreo.enviar(compra.getCorreo(), cuerpo);
        this.notificacionCorreo.setCantidad(this.notificacionCorreo.getCantidad() + 1);

        System.out.println("Cantidad de correos enviados: " + this.notificacionCorreo.getCantidad());
        System.out.println("Nombre: " + this.notificacionCorreo.getNombre());
    }

}
