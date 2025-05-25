import java.util.ArrayList;

public class Problema1_CarritoDeCompras {
    private ArrayList<Problema1_Producto> productosCarrito = new ArrayList<>();

    public void agregarProducto(String nombre, int cantidad, ArrayList<Problema1_Producto> inventario) {
        for (Problema1_Producto prod : inventario) {
            if (prod.getNombre().equalsIgnoreCase(nombre)) {
                if (prod.getCantidadDisponible() >= cantidad) {
                    productosCarrito.add(new Problema1_Producto(nombre, prod.getPrecio(), cantidad));
                    System.out.println("Producto correctamente guardado: " + nombre);
                    return;
                } else {
                    System.out.println("No se encuentra en stock el producto " + nombre);
                    return;
                }
            }
        }
        System.out.println("No se encontro el producto en el inventario.");
    }

    public double calcularTotal() {
        double total = 0;
        for (Problema1_Producto prod : productosCarrito) {
            total += prod.getPrecio() * prod.getCantidadDisponible();
        }
        return total;
    }

    public String realizarPago(double montoPagado, double descuento, ArrayList<Problema1_Producto> inventario) {
        double total = calcularTotal();

        if (total > 1000) {
            total -= total * (descuento / 100);
        }

        if (montoPagado >= total) {
            // Actualizar inventario
            for (Problema1_Producto comprado : productosCarrito) {
                for (Problema1_Producto inv : inventario) {
                    if (comprado.getNombre().equalsIgnoreCase(inv.getNombre())) {
                        inv.setCantidadDisponible(inv.getCantidadDisponible() - comprado.getCantidadDisponible());
                    }
                }
            }
            return "Gracias por comprar. Su cambio: " + (montoPagado - total);
        } else {
            return "Dinero insuficiente. Faltan: " + (total - montoPagado);
        }
    }

    public String mostrarDetalleCompra() {
        StringBuilder detalles = new StringBuilder("Detalle de la compra:\n");
        for (Problema1_Producto prod : productosCarrito) {
            detalles.append(prod.getCantidadDisponible()).append(" x ").append(prod.getNombre()).append(" - $")
                    .append(prod.getPrecio()).append("\n");
        }
        return detalles.toString();
    }
}
