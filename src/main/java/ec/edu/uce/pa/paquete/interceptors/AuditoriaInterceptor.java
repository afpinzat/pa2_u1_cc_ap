package ec.edu.uce.pa.paquete.interceptors;

import java.lang.reflect.Parameter;
 
import ec.edu.uce.pa.paquete.AuditoriaService;
import ec.edu.uce.pa.paquete.Pedido;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
 
@Auditoria
@Interceptor
public class AuditoriaInterceptor {
    @Inject
    private AuditoriaService auditoriaService ;
// context todo lo que gira alrededor del metodo como el nombre , atributos como entrada , los nombres todo el contexto del emtodo por eso se llama inovcation context
//toda la informacion del metodo dicha de otra manera
    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
     
        Object resultado = context.proceed() ; // ejecuta el metodo interceptado
        System.out.println( " Retorno :" + resultado);
        String nomreMetodo= context.getMethod().getName();
        System.out.println("Auditoria : se esta ejecutando el metodo" + nomreMetodo);
        System.out.println(" Ejecuto todo lo que quiero q haga el interceptor");
       
        Parameter[] parametros =context.getMethod().getParameters();
        for (Parameter parametro : parametros){
            System.out.println(" Parametro :" + parametro.getName());
        }
        Object [] valores = context.getParameters();
 
        Pedido pedido = (Pedido)valores[0]; //cast
 
 
 
        String cliente = pedido.getCliente();
        double  total = pedido.getTotal() ;
        String correo = pedido.getCorreo();
       
        this.auditoriaService.guardarEnlaBase(cliente , total , correo);
        // todo lo que esta arria se ejecuta an
        System.out.println(" Mensaje luego de que se ejecuta el metodo");
        return resultado ;
    }
}