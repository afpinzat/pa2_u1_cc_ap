package ec.edu.uce.pa.negocio;

public class CineService {

    public void procesarReserva(EntradaCine entrada) {
        System.out.println("Procesando compra de entrada...");
        System.out.println("Cliente : " + entrada.getCliente());
        System.out.println("Película: " + entrada.getPelicula());
        System.out.println("Reserva confirmada con éxito!\n");

        // Instanciamos el servicio de impresión de tickets
        TicketPrinterService printerService = new TicketPrinterService();

        // Método de impresión
        printerService.imprimirTicket(entrada.getPelicula(),
                entrada.getSala(),
                entrada.getAsiento(),
                entrada.getPrecio());

        printerService = null; // Elejible para el Garbage Collector
    }
}
