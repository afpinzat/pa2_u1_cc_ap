package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("VIP")
public class DescuentoVip implements CalculadoraDescuento {

    private static final double PORCENTAJE = 15.0;   // 15 %

    private final String uuid  = UUID.randomUUID().toString();;

    public DescuentoVip() {
        System.out.println("[CREADO] DescuentoVip: " + uuid);
    }

    @Override
    public double calcular(double monto) {
        return monto * (1 - PORCENTAJE / 100.0);
    }

    @Override
    public double getPorcentaje() {
        return PORCENTAJE;
    }

    public String getId() {
        return uuid;
    }
}