package ec.edu.uce.pa.paquete.interceptors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.interceptor.InterceptorBinding;

@InterceptorBinding //Da el comportamiento de interceptor
@Retention(RetentionPolicy.RUNTIME) // en q momento se ejecuta
@Target({ ElementType.TYPE, ElementType.METHOD }) // El objetivo (lo voy a poner sobre un metodo)

public @interface Auditoria {

}
