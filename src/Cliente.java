import java.util.ArrayList;
import java.util.List;

class Cliente extends Persona {
    private List<Producto> carrito;

    public Cliente(String nombre, int id) {
        super(nombre, id);
        this.carrito = new ArrayList<>();
    }

    public List<Producto> getCarrito() {
        return carrito;
    }
}