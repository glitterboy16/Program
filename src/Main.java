import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        TiendaVeterinaria tienda = new TiendaVeterinaria();
        Admin admin = new Admin("Admin1", "1");
        
        
        tienda.agregarProducto(new Producto("Antiparasitarios", 25.99, 50));
        tienda.agregarProducto(new Producto("Pienso Premium", 45.50, 30));
        
        while(true) {
            System.out.println("1. Cliente\n2. Admin\n3. Salir");
            int opcion = scanner.nextInt();
            
            switch(opcion) {
                case 1:
                    menuCliente(tienda);
                    break;
                case 2:
                    menuAdmin(tienda, admin);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
    
    private static void menuCliente(TiendaVeterinaria tienda) {
        // Lógica redundante de login
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.next();
        scanner.nextLine();
        System.out.println("Ingrese su ID:");
        String id = scanner.nextLine();
        
        Cliente cliente = new Cliente(nombre, id);
        tienda.registrarCliente(cliente);
        
        while (true) {
            System.out.println("\n1. Añadir producto\n2. Finalizar compra\n3. Salir");
            int opcion = scanner.nextInt();
            
            if (opcion == 1) {
                System.out.println("\nProductos disponibles:");
                
                for (int i = 0; i < tienda.productosDisponibles.size(); i++) {
                    Producto p = tienda.productosDisponibles.get(i);
                    System.out.println((i + 1) + ". " + p.getNombre() + " - " + p.getPrecio() + " - Stock: " + p.getStock());
                }
                
                
                System.out.println("\nSeleccione el número del producto que desea añadir al carrito:");
                int seleccionProducto = scanner.nextInt();
                
                if (seleccionProducto > 0 && seleccionProducto <= tienda.productosDisponibles.size()) {
                    Producto productoSeleccionado = tienda.productosDisponibles.get(seleccionProducto - 1);
                    
                    
                    if (productoSeleccionado.getStock() > 0) {
                        cliente.getCarrito().add(productoSeleccionado); 
                        System.out.println("Producto añadido al carrito: " + productoSeleccionado.getNombre());
                    } else {
                        System.out.println("Lo sentimos, no hay stock disponible para este producto.");
                    }
                } else {
                    System.out.println("Selección inválida.");
                }
            } else if (opcion == 2) {
                
                System.out.println("\nResumen de su carrito:");
                double total = 0.0;
                for (Producto p : cliente.getCarrito()) {
                    System.out.println(p.getNombre() + " - " + p.getPrecio());
                    total += p.getPrecio();
                }
                System.out.println("Total: $" + total);
                
                tienda.generarPedido(cliente); 
                cliente.getCarrito().clear(); 
                System.out.println("Compra finalizada. ¡Gracias por su preferencia!");
            } else if (opcion == 3) {
                break; 
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
    
    
    private static void menuAdmin(TiendaVeterinaria tienda, Admin admin) {
        System.out.println("Bienvenido " + admin.nombre);
        while (true) {
            System.out.println("\n1. Ver clientes\n2. Ver pedidos\n3. Salir");
            int opcion = scanner.nextInt();
            
            if (opcion == 1) {
                
                List<Cliente> clientes = tienda.clientes;
                if (clientes.isEmpty()) {
                    System.out.println("No hay clientes registrados.");
                } else {
                    System.out.println("\nClientes registrdos:");
                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente c = clientes.get(i);
                        System.out.println((i + 1) + ". " + c.nombre + " (ID: " + c.id + ")");
                    }
                }
            } else if (opcion == 2) {
                
                List<Pedido> pedidos = tienda.pedidos;
                if (pedidos.isEmpty()) {
                    System.out.println("No hay pedidos registrados.");
                } else {
                    System.out.println("\nPedidos registrados:");
                    for (int i = 0; i < pedidos.size(); i++) {
                        Pedido p = pedidos.get(i);
                        System.out.println("Pedido #" + p.idPedido + " - Cliente: " + p.cliente.nombre);
                    }
                }
            } else if (opcion == 3) {
                
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
    
}