package ec.edu.uce.pa.paquete.interceptors;

import java.time.LocalDate;
import java.util.Date;

import ec.edu.uce.pa.paquete.EntradaCine;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditoria
@Interceptor
@Priority(2003)
public class AuditoriaInterceptor {

    @AroundInvoke
    public Object auditar(InvocationContext context) throws Exception {

        EntradaCine entrada = (EntradaCine) context.getParameters()[0];

        System.out.println("[Auditoria]: " + LocalDate.now() + " Asiento " + entrada.getAsiento().getId() + " reservado por "
                + entrada.getCliente());

        Object resultado = context.proceed();

        return resultado;

    }
}
