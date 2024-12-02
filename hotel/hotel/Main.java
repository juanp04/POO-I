import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Habitacion> listaDeHabitaciones = new ArrayList<>();
    private static ArrayList<Habitacion> listaDeHabitacionesReservadas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        generadorDeHabitaciones();

        boolean continuar = true;
        try {
            while (continuar) {
                menuInteractivo();
                int opcion = opcionEntera();

                switch (opcion) {
                    case 1:
                        reservarHabitacion();
                        break;

                    case 2:
                        cancelarReserva();
                        break;

                    case 3:
                        listarHabitaciones(listaDeHabitaciones);
                        break;

                    case 4:
                        detallesDeReserva();
                        break;

                    case 5:
                        continuar = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error. Entrada no valida.");
            scanner.nextLine();
        }
        scanner.close();
    }

    public static void generadorDeHabitaciones() {
        listaDeHabitaciones.add(new Simple(107, 500));
        listaDeHabitaciones.add(new Doble(406, 1200));
        listaDeHabitaciones.add(new Suite(1209, 2500));
    }

    public static void menuInteractivo() {
        System.out.println(
                "\n\n1.Reservar habitacion. \n2.Cancelar reserva. \n3.Listar habitaciones \n4.Detalles de reserva");
    }

    public static void reservarHabitacion() {
        listarHabitaciones(listaDeHabitaciones);
        System.out.print("\nSeleccione numero de habitacion a reservar: ");
        int opcion = opcionEntera();

        listaDeHabitaciones.forEach(habitacion -> {
            if (opcion == habitacion.getNumeroDeHabitacion() && habitacion.disponibilidad()) {
                listaDeHabitacionesReservadas.add(habitacion);
            }
        });
    }

    public static void cancelarReserva() {
        if (!listaDeHabitacionesReservadas.isEmpty()) {
            listarHabitaciones(listaDeHabitacionesReservadas);
            System.out.print("\nSeleccione numero de habitacion para cancelar dicha reserva: ");
            int opcion = opcionEntera();
            Habitacion reservaACancelar = null;
            for (Habitacion habitacion : listaDeHabitacionesReservadas) {
                if (opcion == habitacion.getNumeroDeHabitacion()) {
                    habitacion.setDisponibilidad(true);
                    reservaACancelar = habitacion;
                }
            }
            listaDeHabitacionesReservadas.remove(reservaACancelar);
            System.out.println("Reserva cancelada con exito.");
        } else {
            System.out.println("No hay habitaciones reservadas a cancelar.");
        }
    }

    public static void listarHabitaciones(ArrayList<Habitacion> lista) {
        System.out.println("\nLista de habitaciones:");
        lista.forEach(habitacion -> System.out.printf(
                "Numero de habitacion: [%d], tipo: [%s], precio por noche: [$%.2f]\n",
                habitacion.getNumeroDeHabitacion(), habitacion.getTipoDeHabitacion(), habitacion.getPrecioPorNoche()));
    }

    public static void detallesDeReserva() {
        if (!listaDeHabitacionesReservadas.isEmpty()) {
            listarHabitaciones(listaDeHabitacionesReservadas);
            listaDeHabitacionesReservadas.forEach(habitacion -> {
                System.out.printf("\nHabitacion: [%d], \nTipo: [%s], \nPrecio por noche: [%.2f], \nServicio/s:\n", habitacion.getNumeroDeHabitacion(), habitacion.getTipoDeHabitacion(), habitacion.getPrecioPorNoche());
                habitacion.getServiciosDeHabitacion().forEach(servicio -> System.out.println("\t" + servicio.getServicio()));
                siEsDoble(habitacion);
                siEsTriple(habitacion);
            });
        }else {
            System.out.println("No hay habitaciones reservadas.");
        }
    }

    public static void siEsDoble(Habitacion habitacion) {
        if (habitacion instanceof Doble) {
            Doble habitacionDoble = (Doble) habitacion;
            System.out.println("\nAmenidad/es: ");
            habitacionDoble.getAmenidades().forEach(amenidad -> System.out.println("\t" + amenidad.getAmenidad()));
        }
    }

    public static void siEsTriple(Habitacion habitacion) {
        if (habitacion instanceof Doble) {
            if (habitacion instanceof Suite) {
                Suite habitacionSuite = (Suite) habitacion;
                System.out.println("\nAmenidad/es: ");
                habitacionSuite.getAmenidades().forEach(amenidad -> System.out.println("\t" + amenidad.getAmenidad()));
                System.out.println("\nTipo/s de cama/s: ");
                habitacionSuite.getOpcionesDeCama().forEach(cama -> System.out.println("\t" + cama.getTipoDeCama()));
            }
        }
    }

    public static int opcionEntera() {
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
}
