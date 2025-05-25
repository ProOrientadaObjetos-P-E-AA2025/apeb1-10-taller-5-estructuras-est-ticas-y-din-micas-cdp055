
public class Problema4_PersonaImplicada {
    private String nombre;
    private int edad;
    private String ocupacion;
    private String nivelImplicacion;
    private double sentenciaAnios;
    private boolean colaborador;
    private double danoEconomico;

    public Problema4_PersonaImplicada(String nombre, int edad, String ocupacion, String nivelImplicacion,
                            double sentenciaAnios, boolean colaborador, double danoEconomico) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.nivelImplicacion = nivelImplicacion;
        this.sentenciaAnios = sentenciaAnios;
        this.colaborador = colaborador;
        this.danoEconomico = danoEconomico;
    }

    public double calcularFianza() {
        if (nivelImplicacion.equalsIgnoreCase("acusado")) {
            if (colaborador && sentenciaAnios < 5) {
                return danoEconomico * 0.3;
            } else if (!colaborador && sentenciaAnios >= 5) {
                return danoEconomico * 0.6;
            }
        }
        return 0.0;
    }


    @Override
    public String toString() {
        String fianzaInfo = calcularFianza() > 0 ? ", Fianza: " + calcularFianza() : "";
        return nombre + " (" + ocupacion + ", " + nivelImplicacion + "), " +
                "Edad: " + edad + ", Sentencia: " + sentenciaAnios + " años" +
                (colaborador ? ", Colaborador" : "") + fianzaInfo;
    }
    // Getters necesarios para evaluación de estado del caso
    public double getDanioEconomico() {
        return danoEconomico;
    }

    public String getImplicacion() {
        return nivelImplicacion;
    }

    public boolean isColabora() {
        return colaborador;
    }
}

