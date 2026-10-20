package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

//@RequestScoped 
@QuarkusMain
public class App implements QuarkusApplication {

   @Inject
    private CineService cineService;

    public static void main(String[] args) {

        Quarkus.run(App.class, args);

    }

    @Override
    public int run(String... args) {
        System.out.println("Iniciando Aplicacion Quarkus...");
         EntradaCine entrada = new EntradaCine("Camilla Corleone", "Avatar 3", "Sala 4 (IMAX)", "H-12", 8.50);
        this.cineService.procesarReserva(entrada);

        return 0;
    }
}
