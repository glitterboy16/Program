import java.util.Date;

class Pedido {
    private static int contadorPedidos = 0;
    private int idPedido;
    private Cliente cliente;
    private Date fecha;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.idPedido = ++contadorPedidos;
        this.fecha = new Date();
    }

    public int getIdPedido() {
        return idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }
}
