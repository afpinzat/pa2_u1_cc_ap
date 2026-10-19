package ec.edu.uce.pa;

import ec.edu.uce.pa.negocio.CineService;
import ec.edu.uce.pa.negocio.EntradaCine;

public class App {
    public static void main(String[] args) throws Exception {


        EntradaCine entrada = new EntradaCine("Camilla Corleone", "Avatar 3", "Sala 4 (IMAX)", "H-12", 8.50);
        
        CineService cineService = new CineService();
        
        cineService.procesarReserva(entrada);
        
        // Asignamos null para que los objetos sean elegibles por el GC
        entrada = null;
        cineService = null;

}
}
