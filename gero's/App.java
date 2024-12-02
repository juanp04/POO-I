import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Empleado> empleados = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println("\nGestión de Empleados - Elige una opción:");
            System.out.println("1. Listar Empleados");
            System.out.println("2. Añadir Empleado");
            System.out.println("3. Modificar Empleado");
            System.out.println("4. Detalles de Empleado");
            System.out.println("5. Baja de Empleado");
            System.out.println("6. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (opcion) {
                case 1:
                    listar(empleados);
                    break;
                case 2:
                    alta(empleados);
                    break;
                case 3:
                    modificar();
                    break;
                case 4:
                    detalles();
                    break;
                case 5:
                    baja();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void listar(List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay Empleados en el sistema.");
        } else {
            empleados.forEach(empleado -> System.out.println(empleado.mostrarDetalles()));
        }
    }

    private static void alta(List<Empleado> empleados){
        System.out.println("Ingrese nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese ID del empleado: ");
        String id = scanner.nextLine();
        System.out.println("Ingrese salario del empleado (sin incluir beneficios)");
        int salario = scanner.nextInt();
        System.out.println("¿A qué departamento pertenece?");
        String nombreDept = scanner.nextLine();
        Departamento departamento = new Departamento(nombreDept);
        scanner.nextLine();

        List<Proyecto> proyectos = new ArrayList<>();
        System.out.println("¿Cuántos proyectos tiene?");
        int cantidadProyectos = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < cantidadProyectos; i++) {
            System.out.println("Nombre del Proyecto " + (i + 1) + ":");
            String nombreProyecto = scanner.nextLine();
            System.out.println("Descripción del Proyecto " + (i + 1) + ":");
            String descripcionProyecto = scanner.nextLine();
            proyectos.add(new Proyecto(nombreProyecto,descripcionProyecto));
        }

        List<Bonus> beneficios = new ArrayList<>();
        System.out.println("¿Cuántos beneficios tiene?");
        int cantidadBeneficios = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < cantidadBeneficios; i++) {
            System.out.println("Tipo de Beneficio " + (i + 1) + ":");
            String tipoBeneficio = scanner.nextLine();
            System.out.println("Descripción del Beneficio " + (i + 1) + ":");
            String descripcionBeneficio = scanner.nextLine();
            beneficios.add(new Bonus(tipoBeneficio, descripcionBeneficio));
        }

        System.out.println("¿Que tipo de empleado es: ?");
        String tipoEmpleado = scanner.nextLine();
        Empleado empleado = null;
        switch(tipoEmpleado){
            case "Tiempo Completo":
            empleado = new empleadoTiempoCompleto(nombre, id, salario, departamento, proyectos, beneficios);
            break;
            default:
            System.out.println("Tipo de empleado no válido.");
            return;
        }
        empleados.add(empleado);
        System.out.println("Empleado cargado");
    }

    private static void baja(){
        System.out.println("Nombre del Empleado a eliminar:");
        String nombre = scanner.nextLine();
        boolean eliminado = empleados.removeIf(empleado -> empleado.nombre.equalsIgnoreCase(nombre));
        if (eliminado) {
            System.out.println("Empleado eliminado con éxito.");
        } else {
            System.out.println("No se encontró el Empleado.");
        }
    }
    

    private static void modificar(){
        
    }

    private static void detalles(){

    }

    
}
