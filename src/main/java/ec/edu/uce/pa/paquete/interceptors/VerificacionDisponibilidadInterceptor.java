package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.EntradaCine;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@VerificacionDisponibilidad 
@Interceptor 
public class VerificacionDisponibilidadInterceptor {

    @AroundInvoke 
    public Object verificar (InvocationContext context)throws Exception{

       EntradaCine entrada = (EntradaCine) context.getParameters()[0];

        
        if(entrada.getAsiento().isDisponible()){
            System.out.println("Asiento Disponible");
            return context.proceed();
        }else{
            System.out.println("Asiento no disponible");
            throw new Exception ("El Asiento " + entrada.getAsiento().getId()+ " esta ocupado");
        }
    }

}
