package practicaclienteservidor2.Controlador;

public class Almacen {
    private int codigo;
    private String lugar;
    private int capacidad;

    public Almacen() {
        this.codigo = 0;
        this.lugar = "";
        this.capacidad = 0;
    }

    public Almacen(int codigo, String lugar, int capacidad) {
        this.codigo = codigo;
        this.lugar = lugar;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "\nCódigo almacen: " + getCodigo()
        +   "\nLugar: " + getLugar()
        +   "\nCapacidad: " + getCapacidad();
    }


    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    
}
