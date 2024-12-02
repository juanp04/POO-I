import java.util.ArrayList;
import java.util.Scanner;

public class App{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Habitacion> habitaciones = new ArrayList<>();
    public static void main(String[] args) {
        boolean continuar = true;
        generarHabitacionesHardCodeadas(12, 8, 5);
        while (continuar) {
            menu();
            int opcion = opcionEntera("Ingrese opcion: ");
            switch (opcion) {
                case 1:
                    alquilarHabitacion();
                    break;
                case 2:
                    devolverHabitacion();
                    break;
                case 3:
                    listarHabitaciones();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Error, opcion no valida.");
                    break;
            }
        }
        scanner.close();
    }
    public static void menu(){
        System.out.println("\n\tMENU");
        System.out.println("1. Alquilar Habitacion");
        System.out.println("2. Devolver Habitacion");
        System.out.println("3. Listar Habitaciones");
        System.out.println("4. Salir");
    }
    private static int opcionEntera(String textoPredeterminado) {
        int opcion = 0;
        boolean continuar = true;
        while(continuar){
            try {
                System.out.print(textoPredeterminado);
                opcion = scanner.nextInt();
                scanner.nextLine();
                continuar = false;
            } catch (Exception e) {
                System.out.print("Error, caracter no valido! ");
                scanner.nextLine();
            }
        }
        return opcion;
    }
    private static String opcionString(String textoPredeterminado) {
        System.out.print(textoPredeterminado);
        String opcion = scanner.nextLine();
        while(opcion.equals("")){
            System.out.print("Error, no se ingresaron caracteres. " + textoPredeterminado);
            opcion = scanner.nextLine();
        }
        return opcion;
    }
    public static String elegirHabitacion(String textoPredeterminado){
        ArrayList<String> codigos = new ArrayList<>();
        habitaciones.forEach(habitacion -> codigos.add(habitacion.getCodigo()));
        System.out.print(textoPredeterminado);
        String codigoHabitacion = scanner.nextLine();
        while(!codigos.contains(codigoHabitacion.toUpperCase())){
            System.out.print("Error, habitacion no hallada. " + textoPredeterminado);
            codigoHabitacion = scanner.nextLine();
        }
        return codigoHabitacion.toUpperCase();
    }
    public static Persona registrarPropietario(){
        String nombre = opcionString("Ingrese el nombre: ");
        String apellido = opcionString("Ingrese el apellido: ");
        int dni = opcionEntera("Ingrese el dni: ");
        String genero = elegirGenero("Ingrese el genero: ");
        int edad = opcionEntera("Ingrese la edad: ");
        return new Persona(nombre, apellido, dni, genero, edad);
    }
    public static String elegirGenero(String textoPredeterminado){
        System.out.print(textoPredeterminado);
        String genero = scanner.nextLine();
        while(!genero.toUpperCase().equals("MASCULINO") && !genero.toUpperCase().equals("FEMENINO")){
            System.out.print("Error, genero no valido. " + textoPredeterminado);
            genero = scanner.nextLine();
        }
        return genero.toUpperCase();
    }
    public static void alquilarHabitacion(){
        listarHabitaciones();
        String codigoHabitacion = elegirHabitacion("Ingrese el codigo de la habitacion: ");
        for(Habitacion habitacion : habitaciones){
            if(habitacion.getCodigo().equals(codigoHabitacion)){
                if(habitacion.getDisponibilidad()){
                    Persona propietario = registrarPropietario();
                    habitacion.setPropietario(propietario);
                    habitacion.setDisponibilidad(false);
                }else{
                    System.out.println("Habitacion no disponible");
                }
            }
        }
    }
    public static void devolverHabitacion(){
        listarHabitaciones();
        String codigoHabitacion = elegirHabitacion("Ingrese el codigo de la habitacion que desea devolver: ");
        for(Habitacion habitacion : habitaciones){
            if(habitacion.getCodigo().equals(codigoHabitacion)){
                if(!habitacion.getDisponibilidad()){
                    int diasAlquilados = opcionEntera("Ingrese los dias alquilados: ");
                    habitacion.calcularMonto(diasAlquilados);
                    habitacion.setDisponibilidad(true);
                    habitacion.setPropietario(null);
                }else{
                    System.out.println("Habitacion disponible.");
                }
            }
        }
    }
    public static void listarHabitaciones(){
        habitaciones.forEach(habitacion -> System.out.println(habitacion.getCodigo() + " - " + habitacion.getInfoPropietario()));
    }
    public static void generarHabitacionesHardCodeadas(int cantDobles, int cantTriples, int cantCuadruples){
        //Dobles
        for (int i = 0; i < cantDobles; i++) {
            habitaciones.add(new Doble());
        }
        //Triples
        for (int i = 0; i < cantTriples; i++) {
            habitaciones.add(new Triple());
        }
        //Cuadruples
        for (int i = 0; i < cantCuadruples; i++) {
            habitaciones.add(new Caudruple());
        }
    }
}