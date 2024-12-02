import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Producto> inventario = new ArrayList<>();
    public static void main(String[] args){
        boolean continuar = true;
        while (continuar){
            menu();
            int opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    anadir(scanner);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Hasta luego...");
                    continuar=false;
                    return;
                default:
                    System.out.println("Error! Opcion no valida.");
                    break;
            }
        }
        scanner.close();
    }
    public static void menu(){
        System.out.println("1. Añadir Producto");
        System.out.println("2. Actualizar Producto");
        System.out.println("3. Listar Producto");
        System.out.println("4. Detallar Producto");
        System.out.println("5. Salir");
    };
    public static void anadir(Scanner scanner){
        boolean continuar = true;
        while(continuar){
            System.out.println("Ingrese el codigo del producto: ");
            int codigo = scanner.nextInt();
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el precio del producto: ");
            int precio = scanner.nextInt();
            System.out.println("Ingrese la cantidad disponible del  producto: ");
            int cantidad = scanner.nextInt();
            System.out.println("Ingrese el tipo de producto: ");
            String categoria = scanner.nextLine();
            System.out.println("Ingrese descuento: ");
            double descuento = scanner.nextDouble();

            inventario.add(new TipoProd(codigo,nombre,precio,cantidad,categoria,descuento));

        };
    };
}
