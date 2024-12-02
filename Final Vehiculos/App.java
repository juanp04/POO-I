import java.util.ArrayList;
import java.util.Scanner;

public class App{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    static ArrayList<Vehiculo> vehiculosAlquilados = new ArrayList<>();
    public static void main(String[] args) {
        boolean continuar = true;
        crearVehiculosHardcodeados();
        while (continuar) {
            menu();
            int opcion = opcionEntera("Ingrese la opcion: ");
            switch (opcion) {
                case 1:
                    alquilarVehiculo();
                    break;
                case 2:
                    entregarVehiculo();
                    break;
                case 3:
                    listarVehiculos();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no hallada");
                    break;
            }
        }
        scanner.close();
    }
    public static void menu() {
        System.out.println("\n\tMENU");
        System.out.println("1. Alquiler de Vehiculo");
        System.out.println("2. Entrega de Vehiculo");
        System.out.println("3. Listado de Vehiculos");
        System.out.println("4. Salir");
    }
    private static int opcionEntera(String textoPredeterminado) {
        int opcion = 0;
        boolean continuar = true;
        while (continuar) {
            try {
                System.out.print(textoPredeterminado);
                opcion = scanner.nextInt();
                scanner.nextLine();
                continuar = false;
            } catch (Exception e) {
                System.out.println("Opcion Invalida!");
                scanner.nextLine();
            }
        }
        return opcion;
    }
    public static String elegirVehiculo(String textoPredeterminado){
        ArrayList<String> codigos = new ArrayList<>();
        vehiculos.forEach(vehiculo -> codigos.add(vehiculo.getCodigo()));
        System.out.print(textoPredeterminado);
        String vehiculoElegido = scanner.nextLine();
        while (!codigos.contains(vehiculoElegido.toUpperCase())) {
            System.out.print("Ingrese el vehiculo que desea alquilar: ");
            vehiculoElegido = scanner.nextLine();
        }
        return vehiculoElegido.toUpperCase();
    };
    public static void alquilarVehiculo(){
        listarVehiculos();
        String vehiculoElegido = elegirVehiculo("Ingrese el vehiculo que desea alquilar: ");
        for(Vehiculo vehiculo : vehiculos){
            if (vehiculo.getCodigo().equals(vehiculoElegido)){
                if(vehiculo.getDisponibilidad()){
                    Persona conductor = registrarConductor();
                    vehiculo.setDisponibilidad(false);
                    vehiculo.setConductor(conductor);
                }else{
                    System.out.println("El vehiculo ingresado no esta disponible");
                }
            }
        }
    };
    public static Persona registrarConductor(){
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();
        int dni = opcionEntera("Ingrese el dni: ");
        System.out.print("Ingrese el genero: ");
        String genero = scanner.nextLine();
        while(!genero.toUpperCase().equals("MASCULINO") && !genero.toUpperCase().equals("FEMENINO")){
            System.out.print("Error! Debe ser masculino o femenino. Ingrese el genero: ");
            genero = scanner.nextLine();
        }
        int edad = opcionEntera("Ingrese la edad: ");
        return new Persona(nombre, apellido, dni, genero, edad);
    };
    public static void entregarVehiculo(){
        listarVehiculos();
        String vehiculoElegido = elegirVehiculo("Ingrese el vehiculo que desea entregar: ");
        for(Vehiculo vehiculo : vehiculos){
            if (vehiculo.getCodigo().equals(vehiculoElegido)){
                if(!vehiculo.getDisponibilidad()){
                    int diasAlquilados = opcionEntera("Dias alquilados: ");
                    if(vehiculo.getConductor().getEdad()>=70 && vehiculo.getConductor().getGenero().equalsIgnoreCase("masculino") || vehiculo.getConductor().getEdad()>=65 && vehiculo.getConductor().getGenero().equalsIgnoreCase("femenino")){
                        System.out.println("El monto total a pagar es de $" + diasAlquilados*vehiculo.getPrecioDiario()*0.8);
                    }else{
                        System.out.println("El monto total a pagar es de $" + diasAlquilados*vehiculo.getPrecioDiario());
                    }
                    vehiculo.setConductor(null);
                    vehiculo.setDisponibilidad(true);
                }else{
                    System.out.println("El vehiculo no esta alquilado.");
                }
            }
        } 
    };
    public static void listarVehiculos(){
        vehiculos.forEach(vehiculo -> System.out.println(vehiculo.getCodigo() + " - " + vehiculo.getEstadoDisponibilidad()));
    };
    public static void crearVehiculosHardcodeados(){
        //Motos x 5
        for (int i = 0; i < 5; i++) {
            vehiculos.add(new Moto());    
        }
        //Autos x 8
        for (int i = 0; i < 8; i++) {
            vehiculos.add(new Auto());    
        }
        //Camionetas x 3
        for (int i = 0; i < 3; i++) {
            vehiculos.add(new Camioneta());    
        }
    }
}