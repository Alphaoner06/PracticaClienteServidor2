package practicaclienteservidor2.Controlador;

/**
 *
 * @author Usuario
 */
public class Articulo {
private int codigo; 
private String descripcion; 
private float precio;


public Articulo(){
    this.codigo=0;
    this.descripcion="";
    this.precio=0.0f;
}

    public Articulo(int codigo, String descripcion, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
   
    
    
}
