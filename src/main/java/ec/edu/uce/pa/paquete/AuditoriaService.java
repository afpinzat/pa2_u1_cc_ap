package ec.edu.uce.pa.paquete;

import java.time.LocalDateTime;

import jakarta.inject.Singleton;

@Singleton 
public class AuditoriaService {

    public void guardarEnlaBase (String cliente, double total, String correo){
        System.out.println("Guardando en la base de datos la auditoria: Cliente: "+cliente+", Total: "+total+", Correo: "+ correo);
        System.out.println("Con fecha y hora: "+ LocalDateTime.now());
    }

}
