package ec.edu.uce.pa.paquete;

public class EntradaCine {

    private String cliente;
    private String pelicula;
    private String sala;
    private Asiento asiento;
    private double precio;

    public EntradaCine() {
    }

    public EntradaCine(String cliente, String pelicula, String sala, Asiento asiento, double precio) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.sala = sala;
        this.asiento = asiento;
        this.precio = precio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

     public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

}
