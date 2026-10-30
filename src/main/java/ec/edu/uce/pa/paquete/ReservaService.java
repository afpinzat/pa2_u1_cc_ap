package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.interceptors.VerificacionDisponibilidad;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class ReservaService {

    @VerificacionDisponibilidad 
    public void procesarReserva(EntradaCine entrada) {
        System.out.println("Procesando compra de entrada...");
        System.out.println("Cliente : " + entrada.getCliente());
        System.out.println("Película: " + entrada.getPelicula());
        System.out.println("Sala: " + entrada.getSala());
        System.out.println("Asiento: "+ entrada.getAsiento().getId());
        System.out.println("Compra confirmada con éxito!\n");
        entrada.getAsiento().setisDisponible(false);
    }
}
