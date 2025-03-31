import java.util.ArrayList;
import java.util.List;

class TiendaVeterinaria {
    List<Producto> productosDisponibles = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    List<Pedido> pedidos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productosDisponibles.add(producto);
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void generarPedido(Cliente cliente) {
        Pedido pedido = new Pedido(cliente);
        pedidos.add(pedido);
        for (Producto producto : cliente.getCarrito()) {
            for (Producto p : productosDisponibles) {
                if (p.getNombre().equals(producto.getNombre())) {
                    p.setStock(p.getStock() - 1);
                }
            }
        }
        cliente.getCarrito().clear();
    }
}