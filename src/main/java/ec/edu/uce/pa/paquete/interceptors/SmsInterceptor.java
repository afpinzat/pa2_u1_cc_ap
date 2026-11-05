package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo 
@Interceptor 
@Priority (Interceptor.Priority.APPLICATION+3)
public class SmsInterceptor {

    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception {
     
         Object resultado = context.proceed();
        
        System.out.println("[Sms]: Sms enviado con exito");
        
        return resultado ;
    }
}
