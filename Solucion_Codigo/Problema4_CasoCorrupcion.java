import java.time.LocalDate;
        import java.time.temporal.ChronoUnit;
        import java.util.ArrayList;
        import java.util.List;

public class Problema4_CasoCorrupcion {
    private String nombre;
    private LocalDate fechaInicio;
    private String estado;
    private String detalles;
    private List<Problema4_PersonaImplicada> personas;

    public Problema4_CasoCorrupcion(String nombre, LocalDate fechaInicio, String detalles) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.detalles = detalles;
        this.estado = "Iniciado";
        this.personas = new ArrayList<>();
    }

    public void agregarPersona(Problema4_PersonaImplicada persona) {
        personas.add(persona);
    }

    public void actualizarEstado() {
        double totalDanio = 0;
        boolean acusadoNoColabora = false;

        for (Problema4_PersonaImplicada p : personas) {
            totalDanio += p.getDanioEconomico();
            if (p.getImplicacion().equalsIgnoreCase("acusado") && !p.isColabora()) {
                acusadoNoColabora = true;
            }
        }

        long diasTranscurridos = ChronoUnit.DAYS.between(fechaInicio, LocalDate.now());

        if (diasTranscurridos > 14) {
            estado = "Urgente";
        } else if (diasTranscurridos > 7) {
            estado = "Alerta";
        } else if (totalDanio > 1_000_000) {
            estado = "Grave";
        } else if (acusadoNoColabora || totalDanio > 500_000) {
            estado = "Alerta";
        } else {
            estado = "Investigación";
        }
    }


    public String getEstado() {
        actualizarEstado();
        return estado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Caso: ").append(nombre).append("\n")
                .append("Fecha de inicio: ").append(fechaInicio).append("\n")
                .append("Estado: ").append(getEstado()).append("\n")
                .append("Detalles: ").append(detalles).append("\n")
                .append("Personas implicadas:\n");

        for (Problema4_PersonaImplicada p : personas) {
            sb.append("  - ").append(p.toString()).append("\n");
        }

        return sb.toString();
    }
}
