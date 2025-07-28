package practicaclienteservidor2.Controlador;

public class Caja {
    private int numeroReferencia;
    private String contenido;
    private int precio;
    private int almacen;

    public Caja() {
        this.numeroReferencia = 0;
        this.contenido = "";
        this.precio = 0;
        this.almacen = 0;
    }

    public Caja(int numeroReferencia, String contenido, int precio, int almacen) {
        this.numeroReferencia = numeroReferencia;
        this.contenido = contenido;
        this.precio = precio;
        this.almacen = almacen;
    }
    public int getNumeroReferencia() {
        return numeroReferencia;
    }
    public void setNumeroReferencia(int numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getAlmacen() {
        return almacen;
    }
    public void setAlmacen(int almacen) {
        this.almacen = almacen;
    }

    
}
