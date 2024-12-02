import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Pokemon pokemons[]= new Pokemon[5];
        Pokemon newPokemon;
        int i=0;
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Bucle principal para la interacción con el usuario
        while (continuar && pokemons.length<=5) {
            mostrarMenu(); // Mostrar el menú de opciones
            int opcion = scanner.nextInt(); // Leer la opción seleccionada por el usuario

            switch (opcion) {
                case 1:
                    newPokemon = altaPokemon(scanner);
                    pokemons[i] = newPokemon;
                    i++;
                    System.out.println(pokemons);
                    break; // Alta de Pokemon
                case 2:
                    bajaPokemons(scanner, pokemons);
                    break; //Baja de Pokemon
                case 3:
                    mostrarPokemons(pokemons);
                    break; //Listar Pokemon
                case 4:
                    //mostrarDetalles(scanner);
                    break; //Mostrar detalles Pokemon
                case 5:
                    System.out.println("Gracias por todo ¡Hasta luego!");
                    continuar = false; // Salir del bucle y finalizar el programa
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del 1 al 3.");
                    break;
            }
        }

        scanner.close(); // Cerrar el Scanner al finalizar
    }

    // Método para mostrar el menú de opciones
    private static void mostrarMenu() {
        System.out.println("\n--- Centro Pokemon ---");
        System.out.println("1. Alta de Pokemon:");
        System.out.println("2. Baja de Pokemon:");
        System.out.println("3. Listar Pokemons:");
        System.out.println("4. Mostrar detalles de Pokemon: ");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }

    private static Pokemon altaPokemon(Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n\nIngrese el tipo:");
            System.out.println("1. Hierba:");
            System.out.println("2. Fuego:");
            System.out.println("3. Agua:");
            int tipo = scanner.nextInt(); // Leer la opción seleccionada por el usuario
            scanner.nextLine(); // Limpiar el buffer

            switch (tipo){
                case 1:
                    Pokemon pokemonHierba = new Hierba();
                    System.out.println("Ingrese el nombre: ");        
                    String nombreHierba = scanner.next();
                    pokemonHierba.setNombre(nombreHierba);
                    pokemonHierba.setTipo("Hierba");
                    return pokemonHierba;
                case 2:
                    Pokemon pokemonFuego = new Fuego();
                    System.out.println("Ingrese el nombre: ");        
                    String nombreFuego = scanner.next();
                    pokemonFuego.setNombre(nombreFuego);
                    pokemonFuego.setTipo("Fuego");
                    return pokemonFuego;
                case 3:
                    Pokemon pokemonAgua = new Agua();
                    System.out.println("Ingrese el nombre: ");        
                    String nombreAgua = scanner.next();
                    pokemonAgua.setNombre(nombreAgua);
                    pokemonAgua.setTipo("Agua");
                    return pokemonAgua;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del 1 al 3.");
            }
        }
        return null;
    }
    private static void mostrarPokemons(Pokemon pokemons[]){
        int i;
        for(i = 0; pokemons[i]!=null; i++){
            System.out.println("Pokemon N°" + (i+1) + ":");
            System.out.println("Nombre: " + pokemons[i].getNombre());
            System.out.println("Tipo: " + pokemons[i].getTipo() + "\n");

        }
    }
    private static void bajaPokemons(Scanner scanner, Pokemon pokemons[]) {
        mostrarPokemons(pokemons);
        System.out.println("Ingrese el nombre del pokemon que desea eliminar: ");
        String opcion = scanner.nextLine().toLowerCase(); // Convertir entrada a minúsculas
    
        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i] != null && pokemons[i].getNombre().equalsIgnoreCase(opcion)) {
                pokemons[i] = null;
                System.out.println("Pokemon eliminado correctamente.");
                break; // Salir del bucle una vez que se elimine el Pokémon
            }
        }
    }
}
