package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

//@RequestScoped 
@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private VentaService ventaService;

    public static void main(String[] args) {

        Quarkus.run(Main.class, args);

    }

    @Override
    public int run(String... args) {

        System.out.println("Iniciando Aplicacion Quarkus...");
        Pedido pedido = new Pedido("Dualsense", 100.0, TipoDescuento.REGULAR); // creamos el objeto de la
        Pedido pedido2 = new Pedido("Dualsense elite ", 200.0, TipoDescuento.VIP);
        Pedido pedido3 = new Pedido("Xbox One ", 300.0, TipoDescuento.REGULAR);
        Pedido pedido4 = new Pedido("PlayStation 5 ", 500.0, TipoDescuento.VIP);

        this.ventaService.realizar(pedido);
        this.ventaService.realizar(pedido2);
        this.ventaService.realizar(pedido3);
        this.ventaService.realizar(pedido4);

        return 0;
    }
}
