package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class VentaService {

    private int contador = 0;
    private final String uuid = UUID.randomUUID().toString();;

    @Inject
    private Auditoria auditoria;

    private final CalculadoraDescuento descuentoRegular;
    private final CalculadoraDescuento descuentoVIP;

    @Inject
    public VentaService(@Named("REGULAR") CalculadoraDescuento descuentoRegular,
            @Named("VIP") CalculadoraDescuento descuentoVIP) {
        this.descuentoRegular = descuentoRegular;
        this.descuentoVIP = descuentoVIP;
        System.out.println("[CREADO] VentaService: " + uuid);
    }

    public void realizar(Pedido pedido) {

        this.contador++;

        CalculadoraDescuento calc = pedido.getTipoDescuento() == TipoDescuento.VIP
                ? this.descuentoVIP
                : this.descuentoRegular;

                pedido.setPrecioFInal(calc.calcular(pedido.getPrecioInicial()));

       
       System.out.println("Venta  | Tipo       |      Monto |       Desc |      Total");

        // Fila (en VentaService.realizar)
        System.out.printf("%-6d | %-10s | %10.2f | %9.2f%% | %10.2f%n",
                this.contador,
                pedido.getTipoDescuento(),
                pedido.getPrecioInicial(),
                calc.getPorcentaje(),
                pedido.getPrecioFInal());

        auditoria.registrar("Venta " + this.contador + " procesada por VentaService[" +
                this.uuid.substring(0, 8) + "]");
    }

}
