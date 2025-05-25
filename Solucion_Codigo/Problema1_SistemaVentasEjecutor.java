import java.util.ArrayList;
import java.util.Scanner;

public class Problema1_SistemaVentasEjecutor {
    public static void main(String[] args) {
        ArrayList<Problema1_Producto> inventario = new ArrayList<>();
        inventario.add(new Problema1_Producto("Laptop", 1200.0, 5));
        inventario.add(new Problema1_Producto("Mouse", 25.0, 30));
        inventario.add(new Problema1_Producto("Teclado", 45.0, 15));

        Problema1_CarritoDeCompras carrito = new Problema1_CarritoDeCompras();
        Scanner sc = new Scanner(System.in);

        String opcion;
        do {
            System.out.println("Ingrese el nombre de producto que desea cambiar:");
            String nombre = sc.nextLine();
            System.out.println("Ingrese la cantidad del producto:");
            int cantidad = Integer.parseInt(sc.nextLine());

            carrito.agregarProducto(nombre, cantidad, inventario);

            System.out.println("¿Desea agregar otro producto? si / no");
            opcion = sc.nextLine();
        } while (opcion.equalsIgnoreCase("si"));

        System.out.println(carrito.mostrarDetalleCompra());
        double total = carrito.calcularTotal();
        System.out.println("Precio sin descuento: " + total);

        System.out.println("Ingrese la cantidad a pagar:");
        double pago = Double.parseDouble(sc.nextLine());

        System.out.println("Ingrese el debido descuento (%), solo si aplica:");
        double descuento = Double.parseDouble(sc.nextLine());

        String resultadoPago = carrito.realizarPago(pago, descuento, inventario);
        System.out.println(resultadoPago);
    }
}
