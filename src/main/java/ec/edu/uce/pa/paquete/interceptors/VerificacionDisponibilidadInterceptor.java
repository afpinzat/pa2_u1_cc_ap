package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.EntradaCine;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@VerificacionDisponibilidad
@Interceptor
@Priority(2002)
public class VerificacionDisponibilidadInterceptor {

    @AroundInvoke
    public Object verificar(InvocationContext context) throws Exception {

        EntradaCine entrada = (EntradaCine) context.getParameters()[0];

        if (entrada.getAsiento().isDisponible()) {
            System.out.println("[Verificacion]: Asiento " + entrada.getAsiento().getId() + " disponible");
            return context.proceed();
        } else {
            System.out.println("Asiento no disponible");
            throw new Exception("El Asiento " + entrada.getAsiento().getId() + " esta ocupado");
        }
    }

}
