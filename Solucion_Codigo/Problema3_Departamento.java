public class Problema3_Departamento {
    private String nombre;
    private int numEmpleados;
    private double produccionAnual;
    private char categoria;

    public Problema3_Departamento(String nombre, int numEmpleados, double produccionAnual) {
        this.nombre = nombre;
        this.numEmpleados = numEmpleados;
        this.produccionAnual = produccionAnual;
        determinarCategoria();
    }

    public String getNombre() { return nombre; }
    public int getNumEmpleados() { return numEmpleados; }
    public double getProduccionAnual() { return produccionAnual; }
    public char getCategoria() { return categoria; }

    public void determinarCategoria() {
        if (numEmpleados > 20 && produccionAnual > 1_000_000) {
            categoria = 'A';
        } else if (numEmpleados == 20 && produccionAnual == 1_000_000) {
            categoria = 'B';
        } else if (numEmpleados == 10 && produccionAnual == 500_000) {
            categoria = 'C';
        } else {
            categoria = 'N'; // categoria no encontrada
        }
    }

    @Override
    public String toString() {
        return String.format("%s | Empleados: %d | ProducciónAnual: $%.2f | Categoría: %s",
                nombre, numEmpleados, produccionAnual,
                categoria == 'N' ? "Sin categoría" : String.valueOf(categoria));
    }
}
