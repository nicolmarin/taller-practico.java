public class Main {
    public static void main(String[] args){
        // Simulación del sistema de e-commerce
        SistemaDePedidos sistema = new SistemaDePedidos();

        // 1) Agregar productos al catálogo
        Producto p1 = new Producto("TEC-001", "Teclado Mecánico RGB", 120.00);
        Producto p2 = new Producto("MOU-002", "Mouse Inalámbrico", 35.50);
        Producto p3 = new Producto("MON-003", "Monitor 24''", 210.99);
        sistema.agregarProductoAlCatalogo(p1);
        sistema.agregarProductoAlCatalogo(p2);
        sistema.agregarProductoAlCatalogo(p3);

        // 2) Crear órdenes (incluyendo productos repetidos)
        Orden o1 = new Orden(101);
        o1.agregarProducto(p1);
        o1.agregarProducto(p2);

        Orden o2 = new Orden(102);
        o2.agregarProducto(p1);
        o2.agregarProducto(p1); // repetido
        o2.agregarProducto(p3);

        Orden o3 = new Orden(103);
        o3.agregarProducto(p2);

        // 3) Registrar órdenes en el sistema
        sistema.registrarOrden(o1);
        sistema.registrarOrden(o2);
        sistema.registrarOrden(o3);

        // 4) Mostrar estado de la cola de pedidos con el método genérico
        SistemaDePedidos.imprimirColeccion("Cola de pedidos actual:", sistema.getColaDePedidos());

        // 5) Procesar todas las órdenes
        while (sistema.getColaDePedidos().peek() != null) {
            sistema.procesarSiguienteOrden();
        }
        // Confirmar mensaje de cola vacía
        sistema.procesarSiguienteOrden();

        // 6) Verificar productos únicos para una orden con repetidos
        SistemaDePedidos.imprimirColeccion(
            "Productos únicos en Orden #" + o2.getId() + ":",
            o2.obtenerProductosUnicos()
        );
    }
}
