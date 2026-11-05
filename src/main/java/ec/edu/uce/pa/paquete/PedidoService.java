package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import ec.edu.uce.pa.paquete.interceptors.Mail;
import ec.edu.uce.pa.paquete.interceptors.MedirTiempo;
import ec.edu.uce.pa.paquete.interceptors.Sms;
import jakarta.enterprise.context.ApplicationScoped;

//Puedo crear los interceptores que haga falta
//Medir tiempo
//Auditoria
//Sms
//Mail
@ApplicationScoped
public class PedidoService {

    @Auditoria 
    @MedirTiempo 
    @Sms 
    @Mail 

    public String realizar(Pedido pedido, String valor) {
       
        try{
        Thread.sleep(1500);
        }catch(Exception e){
        }
        
        System.out.println("realizando pedido...");
        System.out.println("Pedido realizado por el cliente :" + pedido.getCliente());
        System.out.println("Producto :" + pedido.getProducto());
        System.out.println("Total:" + pedido.getTotal());
        System.out.println("Correo:" + pedido.getCorreo());
        System.out.println("Pedido realizado con exito...");

        return "Pedido realizado con exito";
    
    }

}
