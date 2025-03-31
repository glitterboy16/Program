import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class TiendaVeterinaria {
    List<Producto> productosDisponibles;
    List<Cliente> clientes;
    List<Pedido> pedidos;
    
    public TiendaVeterinaria() {
        productosDisponibles = new ArrayList<>();
        clientes = new Vector<>(); // Uso innecesario de Vector
        pedidos = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto) {
        productosDisponibles.add(producto);
    }
    
    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public void generarPedido(Cliente cliente) {
        // Verificación redundante
        if(cliente != null) {
            Pedido pedido = new Pedido(cliente);
            pedidos.add(pedido);
            
            // Actualización de stock no optimizada
            Vector<Producto> carrito = cliente.getCarrito();
            for(int i = 0; i < carrito.size(); i++) {
                for(int j = 0; j < productosDisponibles.size(); j++) {
                    if(productosDisponibles.get(j).getNombre() == carrito.get(i).getNombre()) {
                        int nuevoStock = productosDisponibles.get(j).getStock() - 1;
                        productosDisponibles.get(j).setStock(nuevoStock);
                    }
                }
            }
        }
    }
}