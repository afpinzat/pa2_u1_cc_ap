package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.Pedido;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 4)
public class MailInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {

        String txt = (String) context.getParameters()[1];
        Pedido pedido = (Pedido) context.getParameters()[0];

        Object resultado = context.proceed();

        System.out.println("[Mail]: Mail enviado con exito a "+ txt);

        return resultado;
    }
}