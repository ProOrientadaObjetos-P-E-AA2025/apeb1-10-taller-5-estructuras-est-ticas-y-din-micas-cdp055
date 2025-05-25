public class Problema2_Materia {
    private String nombre;
    private double notaACD;
    private double notaAPE;
    private double notaAA;

    public Problema2_Materia(String nombre, double notaACD, double notaAPE, double notaAA) {
        this.nombre = nombre;
        this.notaACD = notaACD;
        this.notaAPE = notaAPE;
        this.notaAA = notaAA;
    }

    public String getNombre() { return nombre; }
    public double getNotaACD() { return notaACD; }
    public double getNotaAPE() { return notaAPE; }
    public double getNotaAA() { return notaAA; }

    public double calcularNotaTotal() {
        return notaACD + notaAPE + notaAA;
    }

    @Override
    public String toString() {
        return String.format("%s: ACD=%.2f, APE=%.2f, AA=%.2f", nombre, notaACD, notaAPE, notaAA);
    }
}
