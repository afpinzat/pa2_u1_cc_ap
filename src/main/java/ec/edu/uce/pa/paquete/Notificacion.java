package ec.edu.uce.pa.paquete;

import jakarta.inject.Named;

@Named 
public interface Notificacion {

    public void enviar (String destino, String mensaje);


}
