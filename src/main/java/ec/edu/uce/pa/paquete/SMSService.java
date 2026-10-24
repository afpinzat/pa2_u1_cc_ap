package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Dependent  
@Named ("sms")
public class SMSService implements Notificacion{
    
 //private Integer cantidad = 0;


     @Override 
    public void enviar(String destino, String mensaje){
        System.out.println("Enviando corrreo a: " +destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo emviado con exito.");
        System.out.println("Fin del envio del sms.");
    }

  public Integer getCantidad() {
        return null;
    }

    public void setCantidad(Integer cantidad) {
       // this.cantidad = cantidad;
    }

     public String getNombre() {
        return null;
    }

    public void setNombre(String nombre) {
       // this.nombre = nombre;
    }
}
