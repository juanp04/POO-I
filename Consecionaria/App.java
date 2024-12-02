import java.util.ArrayList;
import java.util.Scanner;

public class App{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    public static void main(String args[]){
        boolean continuar = true;
        while(continuar){
            menu();
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    altaVehiculo();
                    break;
                case 2:
                    bajaVehiculo();
                    break;  
                case 3:
                    listarVehiculos();
                    break;
                case 4:
                    mostrarDetallesVehiculo();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
        scanner.close();
    }
    private static void menu(){
        System.out.println("\nMENU");
        System.out.println("1. Alta Vehiculo");
        System.out.println("2. Baja Vehiculo");
        System.out.println("3. Listar Vehiculos");
        System.out.println("4. Mostrar Detalles Vehiculos");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opcion: ");
    };
    private static void altaVehiculo() {
        System.out.print("Ingrese el modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese la marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el anio de fabricacion: ");
        int anio = scanner.nextInt();
        scanner.nextLine();
        vehiculos.add(tipoDeVehiculo(marca, modelo, anio));
        
    }
    private static void bajaVehiculo(){
        listarVehiculos();
        System.out.print("¿Cual desea eliminar? Ingrese el modelo: ");
        String modeloABorrar = scanner.nextLine();
        if(vehiculos.removeIf(vehiculo -> vehiculo.getModelo().equalsIgnoreCase(modeloABorrar))){
            System.out.println("Modelo no encontrado.");
        }
    }
    private static void listarVehiculos(){
        vehiculos.forEach(vehiculo -> System.out.println(vehiculo.getModelo()));
    }
    private static void mostrarDetallesVehiculo(){
        vehiculos.forEach(vehiculo -> vehiculo.mostrarDatos());
    }
    private static void menuVehiculos(){
        System.out.println("Ingrese el tipo de vehiculo:");
        System.out.println("1. Automovil");
        System.out.println("2. Motocicleta");
        System.out.println("3. Camion");
        System.out.print("Ingrese una opcion: ");
    }
    private static Vehiculo tipoDeVehiculo(String marca, String modelo, int anio){
        boolean continuar = true;
        Vehiculo res = null;
        while(continuar){
            menuVehiculos();
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    continuar = false;
                    res = new Automovil(marca, modelo, anio, new Motor("v8"), new Rueda(4) , new Asiento(5));
                    break;
                case 2:
                    continuar = false;
                    res = new Motocicleta(marca, modelo, anio, new Motor("250 cc"), new Rueda(2) , new Asiento(1));
                    break;
                case 3:
                    continuar = false;
                    res = new Camion(marca, modelo, anio, new Motor("motor diessel"), new Rueda(6) , new Asiento(3));
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }
        return res;
    }
}