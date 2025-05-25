import java.util.Scanner;

public class Problema2_EstudianteEjecutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre estudiante: ");
        String nombreEst = sc.nextLine();

        System.out.print("Edad estudiante: ");
        int edadEst = sc.nextInt();
        sc.nextLine();

        Problema2_Estudiante estudiante = new Problema2_Estudiante(nombreEst, edadEst);

        System.out.print("Nombre de la materia: ");
        String nombreMat = sc.nextLine();

        double acd = leerNota(sc, "Nota ACD máximo 3.5: ", 3.5);
        double ape = leerNota(sc, "Nota APE máximo 3.5: ", 3.5);
        double aa = leerNota(sc, "Nota AA máximo 3.0: ", 3.0);

        Problema2_Materia materia = new Problema2_Materia(nombreMat, acd, ape, aa);
        estudiante.setMateria(materia);

        System.out.println("\nResumen:");
        System.out.println(estudiante.toString());

        double notaTotal = materia.calcularNotaTotal();
        System.out.printf("Nota final obtenida: %.2f/10\n", notaTotal);

        if (notaTotal < 7.0) {
            double notaRec = leerNota(sc, "No alcanzó 70%. Ingrese por favor la nota de recuperación sobre 3.5: ", 3.5);
            System.out.println(estudiante.verificarAprobacion(notaRec));
        } else {
            System.out.println(estudiante.verificarAprobacion(0));
        }
    }

    // Método auxiliar para validar ingreso de notas
    public static double leerNota(Scanner sc, String mensaje, double maxPermitido) {
        double nota;
        do {
            System.out.print(mensaje);
            nota = sc.nextDouble();
            if (nota < 0 || nota > maxPermitido) {
                System.out.println("️ Nota incorrecta. Debe poner entre 0 y " + maxPermitido);
            }
        } while (nota < 0 || nota > maxPermitido);
        return nota;
    }
}
