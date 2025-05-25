import java.time.LocalDate;
        import java.util.Scanner;

public class Problema4_AppFiscaliaEjecutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del caso propuesto: ");
        String nombreCaso = sc.nextLine();

        System.out.print("Detalles del caso propuesto: ");
        String detalles = sc.nextLine();

        Problema4_CasoCorrupcion caso = new Problema4_CasoCorrupcion(nombreCaso, LocalDate.now().minusDays(10), detalles);

        System.out.print("¿Cuántas personas desea ingresar en el caso?: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("Persona " + i + ":");

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Edad: ");
            int edad = sc.nextInt(); sc.nextLine();

            System.out.print("Ocupación: ");
            String ocupacion = sc.nextLine();

            System.out.print("Nivel de implicación en el caso propuesto (acusado, testigo, víctima): ");
            String nivel = sc.nextLine();

            System.out.print("Sentencia en años: ");
            double sentencia = sc.nextDouble();

            System.out.print("¿Colabora con la justicia? si/no: ");
            boolean colabora = sc.nextBoolean();

            System.out.print("Daño económico causado : ");
            double dano = sc.nextDouble(); sc.nextLine();

            Problema4_PersonaImplicada persona = new Problema4_PersonaImplicada(nombre, edad, ocupacion, nivel, sentencia, colabora, dano);
            caso.agregarPersona(persona);
        }

        System.out.println("\n--- INFORMACIÓN DEL CASO ---");
        System.out.println(caso.toString());
    }
}
