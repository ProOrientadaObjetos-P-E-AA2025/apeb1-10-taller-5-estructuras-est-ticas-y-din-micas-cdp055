
import java.util.ArrayList;

public class Problema3_Empresa {
    private String nombre;
    private String ruc;
    private String direccion;
    private ArrayList<Problema3_Departamento> departamentos;

    public Problema3_Empresa(String nombre, String ruc, String direccion) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.departamentos = new ArrayList<>();
    }

    public void agregarDepartamento(Problema3_Departamento dep) {
        departamentos.add(dep);
    }

    public void mostrarDepartamentos() {
        System.out.println(" Listado Departamentos:");
        for (Problema3_Departamento d : departamentos) {
            System.out.println(d);
        }
    }

    @Override
    public String toString() {
        return String.format("Empresa: %s | RUC: %s | Dirección: %s", nombre, ruc, direccion);
    }
}
