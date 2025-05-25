import java.util.Scanner;

public class Problema3_EmpresaEjecutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre de la empresa: ");
        String nombreEmp = sc.nextLine();

        System.out.print("RUC de la empresa: ");
        String ruc = sc.nextLine();

        System.out.print("Dirección de la empresa: ");
        String direccion = sc.nextLine();

        Problema3_Empresa empresa = new Problema3_Empresa(nombreEmp, ruc, direccion);

        System.out.print("¿Cuántos departamentos usted quiere ingresar?: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\n🔹 Departamento " + i);
            System.out.print("Nombre: ");
            String nombreDep = sc.nextLine();

            System.out.print("Número de empleados: ");
            int empleados = sc.nextInt();

            System.out.print("Producción anual: ");
            double produccion = sc.nextDouble();
            sc.nextLine();

            Problema3_Departamento departamento = new Problema3_Departamento(nombreDep, empleados, produccion);
            empresa.agregarDepartamento(departamento);
        }

        System.out.println("\n🏢 " + empresa);
        empresa.mostrarDepartamentos();
    }
}
