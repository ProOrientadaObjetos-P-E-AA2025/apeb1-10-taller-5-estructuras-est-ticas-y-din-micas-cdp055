import java.time.LocalDate;
import java.util.List;

public class Problema5_ConflictoEjecutor {
    public static void main(String[] args) {
        // Añadimos "Japón" porque se usa en un evento
        List<String> paises = List.of("Estados Unidos", "Rusia", "Ucrania", "Alemania", "Francia", "China", "Japón");
        Problema5_Conflicto conflicto = new Problema5_Conflicto("Conflicto Europa 2025", paises, LocalDate.of(2025, 3, 1));

        // Crear un evento como objeto
        Problema5_Evento evento1 = new Problema5_Evento(
                "Batalla en Kiev", LocalDate.of(2025, 3, 3), "Kiev", "batalla",
                "Batalla intensa entre Ucrania y Rusia", "Ucrania", 40, false);

        conflicto.agregarEvento(evento1);

        // Otro evento con uso nuclear en país desarrollado
        Problema5_Evento evento2 = new Problema5_Evento(
                "Ataque nuclear en Tokio", LocalDate.of(2025, 3, 7), "Tokio", "batalla",
                "Uso de armas nucleares en contra de Japón", "Japón", 55, true);

        conflicto.agregarEvento(evento2);

        // Evento diplomático
        conflicto.agregarEvento(new Problema5_Evento(
                "Tratado de paz en Berlín", LocalDate.of(2025, 3, 12), "Berlín", "tratado",
                "Negociaciones para cese del conflicto", "Alemania", 0, false));

        // Mostrar estado antes de actualizar evento
        System.out.println("ESTADO INICIAL:");
        System.out.println(conflicto);

        // Ahora modificamos el evento1 (como pide el enunciado)
        evento1.setPorcentajeBajas(60);
        evento1.setDescripcion("Se incremento la batalla en Kiev con grandes pérdidas");
        evento1.setUsoNuclear(true);  // Aunque Ucrania no sea desarrollada, esto puede testear otros cambios

        // Actualizar estado del conflicto tras editar el evento
        conflicto.actualizarEstado();

        // Mostrar estado después de modificar el evento
        System.out.println("\nESTADO DESPUÉS DE ACTUALIZAR EVENTO:");
        System.out.println(conflicto);
    }
}

