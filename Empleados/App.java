import java.util.ArrayList;
import java.util.Scanner;

public class App{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Empleado> empleados = new ArrayList<>();
    public static void main(String[] args) {
        boolean continuar = true;
        try{
            while(continuar){
                menu();
                int opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        altaEmpleado();
                        break;
                    case 2:
                        bajaEmpleado();
                        break;
                    case 3:
                        listarEmpleados();
                        break;
                    case 4:
                        detallesEmpleados();
                        break;
                    case 5:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opcion invalida!");
                        break;
                }
            }
        }catch (Exception e) {
            System.out.println("Error! Caracter invalido.");
            scanner.nextLine();
        }
        scanner.close();
    }
    private static void menu(){
        System.out.println("\n\tMENU");
        System.out.println("1. Alta de Empleado");
        System.out.println("2. Baja de Empleado");
        System.out.println("3. Listar Empleados");
        System.out.println("4. Detalles Empleados");
        System.out.println("5. Salir");
        System.out.print("Ingrese opcion: ");
    }
    private static void menuEmpleados(){
        System.out.println("1. Administrativo");
        System.out.println("2. Tecnico");
        System.out.println("3. Directivo");
        System.out.print("Ingrese opcion: ");
    }
    private static void tipoDeEmpleado(String nombre, int id){
        menuEmpleados();
        int opcion = opcionEntera();
        switch (opcion){
            case 1:
                empleados.add(new Administrativo(nombre, id));
                break;
            case 2:
                empleados.add(new Tecnico(nombre, id));
                break;
            case 3:
                empleados.add(new Directivo(nombre, id));
                break;
            default:
                System.out.println("Opcion invalida.");
                break;
        }
    }
    private static void altaEmpleado(){
        System.out.print("Ingrese el id: ");
        int id = opcionEntera();
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        tipoDeEmpleado(nombre, id);
    }
    private static void bajaEmpleado(){
        System.out.println("Empleados disponibles: ");
        detallesEmpleados();
        System.out.print("Ingrese el id a eliminar");
        int idABorrar = opcionEntera();
        if(empleados.removeIf(empleado -> empleado.getId()==idABorrar)){
            System.out.println("Empleado eliminado existosamente.");
        }else{
            System.out.println("No se hayo dicho empleado.");
        };
    }
    private static void listarEmpleados(){
        empleados.forEach(empleado -> System.out.println("Nombre: " + empleado.getNombre() + " - Cargo: " + empleado.getTipo()));
    }
    private static void detallesEmpleados(){
        empleados.forEach(empleado -> empleado.mostrarInformación());
    }
    private static int opcionEntera(){
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
}