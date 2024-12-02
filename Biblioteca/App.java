import java.util.ArrayList;
import java.util.Scanner;

public class App{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Documento> biblioteca = new ArrayList<>();
    public static void main(String args[]){
        Boolean continuar = true;   
        while(continuar){
            menu();
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    registrarDocumento();
                    break;
                case 2:
                    eliminarDocumento();
                    break;
                case 3:
                    listarDocumentos();
                    break;
                case 4:
                    detallarDocumentos();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }

    private static void menu(){
        System.out.println("");
        System.out.println("-------- MENU --------");
        System.out.println("1. Registrar Documento");
        System.out.println("2. Eliminar Documento");
        System.out.println("3. Listar Documentos");
        System.out.println("4. Detallar Documento");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opcion: ");
    };
    private static void menuDocumentos(){
        System.out.println("");
        System.out.println("- TIPOS DE DOCUMENTOS -");
        System.out.println("1. Libro");
        System.out.println("2. Articulo");
        System.out.println("3. Revista");
        System.out.println("4. Ejemplar Unico");
        System.out.print("Ingrese una opcion: ");
    };
    private static Documento crearDocumento(String titulo, String autor){
        Boolean continuar = true;
        Documento res = null;

        while(continuar){
            menuDocumentos();
            int opcion = scanner.nextInt();
            
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    continuar = false;
                    res = new Libro(titulo, autor);
                case 2:
                    continuar = false;
                    res =  new Articulo(titulo, autor);
                case 3:
                    continuar = false;
                    res =  new Revista(titulo, autor);
                case 4:
                    continuar = false;
                    res =  new EjemplarUnico(titulo, autor);
                default:
                    System.out.println("Opcion invalida");
            }
        }
        return res;
    };
    private static void registrarDocumento(){
        System.out.print("Ingrese el titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine();
        biblioteca.add(crearDocumento(titulo, autor));
    };
    private static void eliminarDocumento(){
        listarDocumentos();
        String tituloAEliminiar = scanner.nextLine();
        if (!biblioteca.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(tituloAEliminiar))){
            System.out.println("Elemento no hallado en biblioteca.");
        };
    };
    private static void listarDocumentos(){
        biblioteca.forEach(libro -> System.out.println("-"+libro.getTitulo()));
    }
    private static void detallarDocumentos(){
        biblioteca.forEach(libro -> libro.mostrarInfo());
    }
}