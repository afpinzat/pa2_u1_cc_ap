package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;

@ApplicationScoped
//@RequestScopped
//@Singleton  //Delego el control al contenedor Arc

public class PedidoService {

  /*   @Inject 
    private MailService mailService;*/


    
  /*   private MailService mailService;

    //Inyeccion de dependencias por constructor
    @Inject 
    public PedidoService(MailService mailService){
        this.mailService = mailService;
    }*/

    /*    private MailService mailService;
       
       //Inyeccion de dependencia por setter
       @Inject 
       public void setMailService(MailService mailService) {
        System.out.println("Se esta inyectando el servicio de correo electronico service");
        this.mailService = mailService;
    }*/


      // @Inject 
      // private MailService diferente;

    public void realizar(Pedido pedido) {

        //Lookup de la clase MailService
        MailService mailService = CDI.current().select(MailService.class).get();

        System.out.println("realizando pedido...");
        System.out.println("Pedido realizado por el cliente :" + pedido.getCliente());
        System.out.println(" Producto :" + pedido.getProducto());
        System.out.println("Total:" + pedido.getTotal());
        System.out.println("Correo:" + pedido.getCorreo());
        System.out.println(" Pedido realizado con exito...");

       
        String asunto = " Confirmacion de pedido";
        String cuerpo = "Estimado" + pedido.getCliente() + ", su pedido de  " +
                pedido.getProducto() + " por un total de $" + pedido.getTotal() + " ha sido realizado con exito.";
        mailService.enviar(pedido.getCorreo(), asunto, cuerpo);

    }




    
}
