import java.util.ArrayList;
import java.util.Scanner;

public class App{
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<>();
    private static ArrayList<Habitacion> habitacionesReservadas = new ArrayList<>();
    public static void main(String[] args) {
        boolean continuar = true;
        cargarHabitacionesHardcodeadas();
        try {
            while(continuar){
                menu();
                int opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        reservarHabitacion();
                        break;
                    case 2:
                        cancelarReservaHabitacion();
                        break;
                    case 3:
                        listarHabitaciones(habitacionesDisponibles);
                        break;
                    case 4:
                        detallarHabitaciones(habitacionesDisponibles);
                        break;
                    case 5:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error! Caracteres invalidos. Ingrese de vuelta.");
            scanner.nextLine();
        }
        scanner.close();
        
    }
    private static void menu(){
        System.out.println("\nMENU");
        System.out.println("1. Reservar Habitacion");
        System.out.println("2. Cancelar Reserva Habitacion");
        System.out.println("3. Listar Habitaciones");
        System.out.println("4. Detallar Habitaciones");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opcion: ");
    };
    private static void reservarHabitacion(){
        if(!habitacionesDisponibles.isEmpty()){
            System.out.println("Habitaciones Disponibles para reservar:");
            detallarHabitaciones(habitacionesDisponibles);
            System.out.print("Ingrese el numero de habitacion que desea reservar: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            habitacionesDisponibles.forEach(habitacion ->{
                if(habitacion.getNumero()==opcion){
                    habitacionesReservadas.add(habitacion);
                    habitacion.setDisponibilidad(false);
                };
            }); 
        }else{
            System.out.println("No hay habiataciones para reservar.");
        }
    };
    private static void cancelarReservaHabitacion(){
        if(!habitacionesReservadas.isEmpty()){
            System.out.println("Habitaciones Disponibles para reservar:");
            detallarHabitaciones(habitacionesReservadas);
            System.out.print("Ingrese el numero de habitacion que desea reservar: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            habitacionesReservadas.forEach(habitacion ->{
                if(habitacion.getNumero()==opcion){
                    habitacion.setDisponibilidad(true);
                };
            }); 
            if(habitacionesReservadas.removeIf(habitacion -> habitacion.getNumero()==opcion)){
                System.out.println("Reserva eliminada con exito!");
            };
        }else{
            System.out.println("No hay habiataciones para reservar.");
        }
    };
    private static void listarHabitaciones(ArrayList<Habitacion> habitaciones){
        habitaciones.forEach(habitacion -> {System.out.println("N° " + habitacion.getNumero()+" Tipo: [" + habitacion.getTipo() + "]");});
    };
    public static void detallarHabitaciones(ArrayList<Habitacion> habitaciones) {
        if (habitaciones == habitacionesDisponibles) {
            System.out.println("Habitaciones disponibles:");
            habitaciones.forEach(habitacion -> {
                if (habitacion.getDisponibilidad()) {
                    System.out.println("Habitacion " + habitacion.getTipo() + " N°" + habitacion.getNumero() +
                            " vale $" + habitacion.getPrecioPorNoche() + " por noche");
                }
            });
        }else{
            System.out.println("Habitaciones reservadas:");
            habitaciones.forEach(habitacion -> {
                if (!habitacion.getDisponibilidad()) {
                    System.out.println("Habitacion " + habitacion.getTipo() + " N°" + habitacion.getNumero() +
                            " vale $" + habitacion.getPrecioPorNoche() + " por noche");
                }
            });
        };
    };
    public static void cargarHabitacionesHardcodeadas(){
        habitacionesDisponibles.add(new Simple(1,6500));
        habitacionesDisponibles.add(new Doble(2,12000));
        habitacionesDisponibles.add(new Suite(3,15000));
    };
}