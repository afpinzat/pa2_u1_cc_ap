package ec.edu.uce.pa.paquete;

public class Pedido {

    private String nombreProducto;
    private Double precioInicial;
    private Double precioFInal;
    private TipoDescuento tipoDescuento;
    

   
    public Pedido (){

    }

    public Pedido(String nombreProducto, Double precioInicial, TipoDescuento tipoDescuento) {
        this.nombreProducto = nombreProducto;
        this.precioInicial = precioInicial;
        this.tipoDescuento = tipoDescuento;
        this.precioFInal=0.0;
    }


    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public Double getPrecioInicial() {
        return precioInicial;
    }
    public void setPrecioInicial(Double precioInicial) {
        this.precioInicial = precioInicial;
    }
    public Double getPrecioFInal() {
        return precioFInal;
    }
    public void setPrecioFInal(Double precioFInal) {
        this.precioFInal = precioFInal;
    }

     public TipoDescuento getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(TipoDescuento tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    
}
