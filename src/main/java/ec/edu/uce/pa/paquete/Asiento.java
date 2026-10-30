package ec.edu.uce.pa.paquete;

public class Asiento {

    private String id;
    private boolean isDisponible;

    public Asiento(String id, boolean isDisponible) {
        this.id = id;
        this.isDisponible = isDisponible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    public void setisDisponible(boolean isDisponible) {
        this.isDisponible = isDisponible;
    }

    
    
}
