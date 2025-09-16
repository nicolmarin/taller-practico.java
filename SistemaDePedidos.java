import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SistemaDePedidos {

    // Decisiones de Diseño: Para el catálogo, se usa Map<String, Producto> (HashMap)
    // porque permite búsqueda por sku en tiempo esperado O(1), clave para eficiencia.
    private Map<String, Producto> catalogoProductos;

    // Decisiones de Diseño: Para la cola de pedidos, se usa Queue<Orden> (LinkedList)
    // para garantizar procesamiento FIFO (primero en entrar, primero en salir) de manera natural.
    private Queue<Orden> colaDePedidos;

    public SistemaDePedidos() {
        this.catalogoProductos = new HashMap<>();
        this.colaDePedidos = new LinkedList<>();
    }

    public void agregarProductoAlCatalogo(Producto producto) {
        if (producto == null || producto.getSku() == null) {
            return;
        }
        catalogoProductos.put(producto.getSku(), producto);
    }

    public Producto buscarProducto(String sku) {
        return catalogoProductos.get(sku);
    }

    public void registrarOrden(Orden orden) {
        if (orden == null) return;
        colaDePedidos.offer(orden);
    }

    public Orden procesarSiguienteOrden() {
        Orden siguiente = colaDePedidos.poll();
        if (siguiente == null) {
            System.out.println("No hay órdenes pendientes. La cola está vacía.");
            return null;
        }
        double total = siguiente.calcularTotal();
        System.out.println("Procesando Orden #" + siguiente.getId() + " con un total de $" + String.format("%.2f", total));
        return siguiente;
    }

    public Queue<Orden> getColaDePedidos() {
        return colaDePedidos;
    }

    public static <T> void imprimirColeccion(String titulo, Collection<T> coleccion) {
        System.out.println(titulo);
        for (T elemento : coleccion) {
            System.out.println(elemento);
        }
    }
}


