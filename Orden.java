import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Orden {
    private int id;

    // Decisiones de Diseño: Se elige List (ArrayList) para almacenar productos en la orden
    // porque permite elementos duplicados y su orden no importa para el negocio.
    // ArrayList ofrece inserciones amortizadas O(1) y recorrido eficiente.
    private List<Producto> productos;

    public Orden(int id) {
        this.id = id;
        this.productos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    public Collection<Producto> getProductos() {
        return productos;
    }

    public Collection<Producto> obtenerProductosUnicos() {
        // Pista aplicada: convertir a Set elimina duplicados en O(n) esperado.
        Set<Producto> unicos = new HashSet<>(productos);
        return unicos;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", items=" + productos.size() +
                '}';
    }
}


