package ec.edu.uce.pa.paquete;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.Dependent;

@Dependent
public class Auditoria {

    private final String uuid = UUID.randomUUID().toString();

    public Auditoria() {
        System.out.println("[CREADO] Auditoria: " + uuid);
    }

    private List<String> registros = new ArrayList<>();

    public void registrar(String mensaje) {
        String linea = "[AUDITORIA] " + mensaje;
        registros.add(linea);
        System.out.println(linea);
    }

    public void imprimirRegistros() {
        for (String x : registros) {
            System.out.println(x);
        }
    }

    public String getId() {
        return uuid;
    }

}
