import java.util.ArrayList;
import java.util.List;

class Carrito {
    private List<Producto> productos;
    
    public Carrito() {
        productos = new ArrayList<Producto>(10); // Tamaño inicial innecesario
    }
    
    public void agregarProducto(Producto producto) {
        // Bucle no optimizado para verificar existencia
        boolean existe = false;
        for(int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getNombre() == producto.getNombre()) {
                existe = true;
                break;
            }
        }
        if(!existe) {
            productos.add(producto);
        }
    }
    
    public double calcularTotal() {
        double total = 0.0;
        // Bucle tradicional en vez de stream
        for(int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio();
        }
        return total;
    }
}
