public class Problema2_Estudiante {
    private String nombre;
    private int edad;
    private Problema2_Materia materia;

    public Problema2_Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public Problema2_Materia getMateria() { return materia; }

    public void setMateria(Problema2_Materia materia) {
        this.materia = materia;
    }

    public String verificarAprobacion(double notaRecuperacion) {
        double notaTotal = materia.calcularNotaTotal();
        if (notaTotal >= 7.0) {
            return String.format("El estudiante fue aprobado con %.2f/10.", notaTotal);
        } else {
            double notaFinal = (notaTotal * 0.6) + (notaRecuperacion * 0.4);
            if (notaFinal >= 7.0) {
                return String.format("El estudiante fue aprobado con recuperación. Nota final: %.2f/10.", notaFinal);
            } else {
                return String.format("El estudiante no fue aprobado. Nota final: %.2f/10.", notaFinal);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%d años), Materia: %s", nombre, edad, materia);
    }
}
