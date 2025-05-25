import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.List;

public class Problema5_Conflicto {
    private String nombre;
    private List<String> paisesInvolucrados;
    private LocalDate fechaInicio;
    private String estadoActual;
    private List<Problema5_Evento> eventos;

    public Problema5_Conflicto(String nombre, List<String> paisesInvolucrados, LocalDate fechaInicio) {
        this.nombre = nombre;
        this.paisesInvolucrados = paisesInvolucrados;
        this.fechaInicio = fechaInicio;
        this.estadoActual = "En curso";
        this.eventos = new ArrayList<>();
    }

    public void agregarEvento(Problema5_Evento evento) {
        eventos.add(evento);
        actualizarEstado();
    }

    public void actualizarEstado() {
        int totalPaises = paisesInvolucrados.size();
        int eventosBatalla = 0;
        int nuclearesEnPrimerMundo = 0;
        boolean bajasAltas = false;

        for (Problema5_Evento e : eventos) {
            if (e.getTipo().equalsIgnoreCase("batalla")) {
                eventosBatalla++;
                if (e.getPorcentajeBajas() >= 50) {
                    bajasAltas = true;
                }
                if (e.isUsoNuclear() && esPrimerMundo(e.getPaisInvolucrado())) {
                    nuclearesEnPrimerMundo++;
                }
            }
        }

        double porcentajeBatalla = (double) eventosBatalla / totalPaises * 100;

        if (porcentajeBatalla > 50 || nuclearesEnPrimerMundo > 0) {
            estadoActual = "Guerra Mundial";
        } else if (porcentajeBatalla >= 30 || bajasAltas) {
            estadoActual = "Reunión con la ONU Urgente";
        } else {
            estadoActual = "En curso";
        }
    }

    private boolean esPrimerMundo(String pais) {
        // Lista básica de países desarrollados
        String[] desarrollados = {"Estados Unidos", "Alemania", "Francia", "Reino Unido", "Japón", "Canadá"};
        for (String p : desarrollados) {
            if (p.equalsIgnoreCase(pais)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Conflicto: " + nombre + "\nEstado: " + estadoActual + "\nPaises: ");
        sb.append(String.join(", ", paisesInvolucrados)).append("\nEventos:\n");
        for (Problema5_Evento e : eventos) {
            sb.append("- ").append(e).append("\n");
        }
        return sb.toString();
    }
}
