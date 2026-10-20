package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class TicketPrinterService {
    
      public void imprimirTicket(String pelicula, String sala, String asiento, double precio) {
        System.out.println("Enviando datos a la impresora...");
        System.out.println("----------------------------------------");
        System.out.println("         Multicines       ");
        System.out.println(" Película : " + pelicula);
        System.out.println(" Sala     : " + sala);
        System.out.println(" Asiento  : " + asiento);
        System.out.println(" Precio   : $" + precio);
        System.out.println("----------------------------------------");
        System.out.println("Ticket impreso con éxito!");
    }
}
