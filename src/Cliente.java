import java.util.Vector;

class Cliente extends Persona {
    private Vector<Producto> carrito;
    
    public Cliente(String nombre, String id) {
        super(nombre, id);
        carrito = new Vector<Producto>();
    }
    
    public Vector<Producto> getCarrito() {
        return carrito;
    }


}