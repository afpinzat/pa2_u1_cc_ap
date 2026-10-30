package ec.edu.uce.pa.paquete;

import java.util.ArrayList;
import java.util.List;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

//@RequestScoped 
@QuarkusMain
public class App implements QuarkusApplication {

   @Inject
    private ReservaService cineService;

    public static void main(String[] args) {

        Quarkus.run(App.class, args);

    }

    @Override
    public int run(String... args) {
        System.out.println("Iniciando Aplicacion Quarkus...");
        Asiento asiento = new Asiento("A1", true);
        List<Asiento> asientos = new ArrayList<>();
        asientos.add(asiento);

         EntradaCine entrada = new EntradaCine("Camilla Corleone", "Avatar 3", "Sala 4 (IMAX)", asiento, 8.50);
        this.cineService.procesarReserva(entrada);
        return 0;
    }
}
