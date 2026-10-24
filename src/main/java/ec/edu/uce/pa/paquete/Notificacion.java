package ec.edu.uce.pa.paquete;

import jakarta.inject.Named;

 
public interface Notificacion {

    public void enviar (String destino, String mensaje);

    public void setCantidad(Integer cantidad);
    public Integer getCantidad();

 public String getNombre();
    public void setNombre(String nombre);

}
