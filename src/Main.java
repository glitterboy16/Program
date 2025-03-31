import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TiendaVeterinaria tienda = new TiendaVeterinaria();
        Admin admin = new Admin("Admin1", 1);

        tienda.agregarProducto(new Producto("Antiparasitarios", 25.99, 50));
        tienda.agregarProducto(new Producto("Pienso Premium", 45.50, 30));

        while (true) {
            System.out.println("\n1. Cliente\n2. Admin\n3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuCliente(tienda);
                    break;
                case 2:
                    menuAdmin(tienda, admin);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuCliente(TiendaVeterinaria tienda) {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese su ID: ");
        int id = scanner.nextInt();

        Cliente cliente = new Cliente(nombre, id);
        tienda.registrarCliente(cliente);

        while (true) {
            System.out.println("\n1. Añadir producto\n2. Finalizar compra\n3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.println("\nProductos disponibles:");
                for (int i = 0; i < tienda.productosDisponibles.size(); i++) {
                    Producto p = tienda.productosDisponibles.get(i);
                    System.out.println((i + 1) + ". " + p.getNombre() + " - $" + p.getPrecio() + " - Stock: " + p.getStock());
                }
                System.out.print("\nSeleccione el número del producto que desea añadir al carrito: ");
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
                double total = 0.0;
                System.out.println("\nResumen de su carrito:");
                for (Producto p : cliente.getCarrito()) {
                    System.out.println(p.getNombre() + " - $" + p.getPrecio());
                    total += p.getPrecio();
                }
                System.out.println("Total: $" + total);
                tienda.generarPedido(cliente);
                System.out.println("Compra finalizada. ¡Gracias por su preferencia!");
            } else if (opcion == 3) {
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuAdmin(TiendaVeterinaria tienda, Admin admin) {
        System.out.println("Bienvenido, " + admin.nombre + " (ID: " + admin.id + ")");
        
        while (true) {
            System.out.println("\n1. Ver clientes\n2. Ver pedidos\n3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (tienda.clientes.isEmpty()) {
                        System.out.println("\nNo hay clientes registrados.");
                    } else {
                        System.out.println("\nClientes registrados:");
                        for (int i = 0; i < tienda.clientes.size(); i++) {
                            Cliente cliente = tienda.clientes.get(i);
                            System.out.println((i + 1) + ". Nombre: " + cliente.nombre + " | ID: " + cliente.id);
                        }
                    }
                    break;

                case 2:
                    if (tienda.pedidos.isEmpty()) {
                        System.out.println("\nNo hay pedidos registrados.");
                    } else {
                        System.out.println("\nPedidos registrados:");
                        for (int i = 0; i < tienda.pedidos.size(); i++) {
                            Pedido pedido = tienda.pedidos.get(i);
                            System.out.println("Pedido #" + pedido.getIdPedido() + " | Cliente: " + pedido.getCliente().nombre +
                                               " | Fecha: " + pedido.getFecha());
                        }
                    }
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}