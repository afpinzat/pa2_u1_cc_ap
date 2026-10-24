package ec.edu.uce.pa.paquete;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

//singleton para lo que no es logica del negocio
//dependet necesito crear diferentes objetos

//Ambitos y contextos
//@ApplicationScoped // su ambito es durante toda la aplicacion es decir se crea un objeto una sola instancia de la clase  y se comparte entre todas los componentes que lo utilizan
//@Singleton //su ambito es durante toda la aplicacion es decir se crea un objeto una sola instancia de la clase  y se comparte entre todas los componentes que lo utilizan
//@RequestScoped //Su ambito es en aplicaciones web durante el request/peticion http su ambito es durante toda la aplicacion es decir se crea un objeto una sola instancia de la clase  y se comparte entre todas los componentes que lo utilizan durante el request
//@SessionScoped // Su ambito es durante toda la aplicacion es decir se crea un objeto una sola instancia de la clase  y se comparte entre todas los componentes que lo utilizan durante la sesion de usuario
//@Dependet // su ambito es durante toda la aplicacion es decir se crea un objeto una sola instancia de la clase  y se comparte entre todas los componentes que lo utilizan durante la inyeccion (Cada vez que se inyecte se creara un nuevo objeto)



@Dependent 
@Named("mail")
public class MailService implements Notificacion {

    private Integer cantidad = 0;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando corrreo a: " + destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo emviado con exito.");
        System.out.println("Fin del envio del correo.");
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
