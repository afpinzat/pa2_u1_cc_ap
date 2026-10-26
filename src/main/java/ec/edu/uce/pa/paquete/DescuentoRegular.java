package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("REGULAR")
public class DescuentoRegular implements CalculadoraDescuento {

    private static final double PORCENTAJE = 5.0;   // 5 %

    private final String uuid;

    public DescuentoRegular() {
        this.uuid = UUID.randomUUID().toString();
        System.out.println("[CREADO] DescuentoRegular: " + uuid);
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