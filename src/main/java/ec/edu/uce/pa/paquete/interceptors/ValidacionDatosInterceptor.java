package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.EntradaCine;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@ValidacionDatos
@Interceptor
@Priority(2001)
public class ValidacionDatosInterceptor {

    @AroundInvoke
    public Object validar(InvocationContext context) throws Exception {

        EntradaCine entrada = (EntradaCine) context.getParameters()[0];

        if (entrada != null && entrada.getAsiento() != null) {
            System.out.println("[Validacion]: Datos validos ");
            return context.proceed();
        } else {
            throw new Exception("Entrada no valida");
        }
    }
}
