public class Problema1_Producto {
    private String nombre;
    private double precio;
    private int cantidadDisponible;

    public Problema1_Producto(String nombre, double precio, int cantidadDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;

    }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio + " x " + cantidadDisponible;
    }
}
