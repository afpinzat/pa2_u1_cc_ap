package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped 
public class CineService {

@Inject 
private TicketPrinterService ticketPrinterService;

    public void procesarReserva(EntradaCine entrada) {
        System.out.println("Procesando compra de entrada...");
        System.out.println("Cliente : " + entrada.getCliente());
        System.out.println("Película: " + entrada.getPelicula());
        System.out.println("Reserva confirmada con éxito!\n");


        // Método de impresión
        this.ticketPrinterService.imprimirTicket(entrada.getPelicula(),
                entrada.getSala(),
                entrada.getAsiento(),
                entrada.getPrecio());

    }
}
