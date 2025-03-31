import java.util.Date;

class Pedido {
    private static int contadorPedidos = 0;
    int idPedido;
    Cliente cliente;
    private Date fecha;
    
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.idPedido = ++contadorPedidos;
        this.fecha = new Date(); // Fecha no utilizada
    }
    
    // Método redundante
    public void mostrarDetalles() {
        System.out.println("Pedido #" + idPedido);
        System.out.println("Cliente: " + cliente.getNombre());
    }
}