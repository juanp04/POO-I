import java.util.ArrayList;
import java.util.Scanner;

public class App{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Evento> eventos = new ArrayList<>();
    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            menu();
            int opcion = opcionEntera("Ingrese la opcion: ");
            switch (opcion) {
                case 1:
                    crearEvento();
                    break;
                case 2:
                    cancelarEvento();
                    break;
                case 3:
                    listarEventos();
                    break;
                case 4:
                    detallarEventos();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    break;
            }
        }
    }
    public static int opcionEntera(String texto){
        boolean continuar = true;
        int opcion = 0;
        while (continuar) {
            try {
                System.out.print(texto);
                opcion = scanner.nextInt();
                scanner.nextLine();
                continuar = false;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Entrada invalida");
            }
        }
        return opcion;
    }
    public static void menu(){
        System.out.println("\n\tMENU");
        System.out.println("1. Crear Evento");
        System.out.println("2. Eliminar Evento");
        System.out.println("3. Listar Eventos");
        System.out.println("4. Detallar Eventos");
        System.out.println("5. Salir");
    }
    public static void menuEventos(){
        System.out.println("\n\tMENU EVENTOS");
        System.out.println("1. Conferencia");
        System.out.println("2. Concierto");
        System.out.println("3. Taller");
    }
    public static void tipoEvento(String nombre, int id){
        menuEventos();
        int opcion = opcionEntera("Ingrese la opcion: ");
        switch (opcion) {
            case 1:
                eventos.add(new Conferencia(nombre, id));
                break;
            case 2:
                eventos.add(new Concierto(nombre, id));
                break;
            case 3:
                eventos.add(new Taller(nombre, id));
                break;
            default:
                break;
        }
    }
    public static void crearEvento(){
        System.out.print("Ingrese el nombre del evento: ");
        String nombre = scanner.nextLine();
        int id = opcionEntera("Ingrese el Id: ");
        tipoEvento(nombre, id);
    }
    public static void cancelarEvento(){
        int idAEliminar = opcionEntera("Ingrese el Id: ");
        if(eventos.removeIf(evento -> evento.getId()==idAEliminar)){
            System.out.println("Evento eliminado con exito!");
        }else{
            System.out.println("Evento no hallado!");
        };
    }
    public static void listarEventos(){
        eventos.forEach(evento -> System.out.println("Nombre del Evento: " + evento.getNombre()));
    }
    public static void detallarEventos(){
        eventos.forEach(evento -> evento.mostrarInformación());
    }
}
