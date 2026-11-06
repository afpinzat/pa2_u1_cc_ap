package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.EntradaCine;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Autenticacion 
@Interceptor 
@Priority (2000)
public class AutenticacionInterceptor {

    @AroundInvoke 
    public Object autenticar (InvocationContext context) throws Exception{

        EntradaCine entrada = (EntradaCine) context.getParameters()[0];

        System.out.println("[Autenticacion]: Bienvenido/a "+ entrada.getCliente());

        Object resultado = context.proceed();

        return resultado;

    }

}
