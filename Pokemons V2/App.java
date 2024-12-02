import java.util.Scanner;

public class App{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Pokemon pokemons[] = new Pokemon[5];
        boolean continuar = true;
        int i=0;
        
        while (continuar){
            System.out.println("\nMenu");
            System.out.println("1. Alta de pokemon.");
            System.out.println("2. Baja de pokemon.");
            System.out.println("3. Lista de pokemons.");
            System.out.println("4. Detalles de pokemon.");
            System.out.println("5. Salir.");
            System.out.print("\nIngrese una opcion: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    if(i < pokemons.length){
                        pokemons[i] = altaPokemon(scanner);
                        i++;
                    }else{
                        System.out.println("El equipo esta lleno.");
                    }
                    break;
                case 2:
                    bajaPokemon(pokemons, scanner);
                    break;
                case 3:
                    listarPokemons(pokemons, scanner);
                    break;
                case 4:
                    mostrarDetalles(pokemons, scanner);
                    break;
                case 5:
                    System.out.print("Gracias por todo! Hasta luego...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no valida! Ingrese una de las opciones disponibles.");
                    break;
            }
        }
        scanner.close();
    }
    public static Pokemon altaPokemon(Scanner scanner){ //                      1
        boolean continuar = true;
        String nombre;
        while (continuar){
            System.out.println("Tabla de tipos:");
            System.out.println("1. Agua:");
            System.out.println("2. Fuego y Agua:");
            System.out.println("3. Fuego:");
            System.out.println("4. Planta y Fuego:");
            System.out.println("5. Planta:");
            System.out.println("6. Agua y Planta:");
            System.out.print("Ingrese el tipo: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1: //Fuego
                    System.out.print("Ingrese el nombre: ");
                    nombre = scanner.next();
                    return new Agua(nombre, "Agua");
                case 2:
                    System.out.print("Ingrese el nombre: ");
                    nombre = scanner.next();
                    return new AguaFuego(nombre, "Fuego y Agua");
                case 3:
                    System.out.print("Ingrese el nombre: ");
                    nombre = scanner.next();
                    return new Fuego(nombre, "Fuego");
                case 4:
                    System.out.print("Ingrese el nombre: ");
                    nombre = scanner.next();
                    return new FuegoPlanta(nombre, "Planta y Fuego");
                case 5:
                    System.out.print("Ingrese el nombre: ");
                    nombre = scanner.next();
                    return new Planta(nombre, "Planta");
                case 6:
                    System.out.print("Ingrese el nombre: ");
                    nombre = scanner.next();
                    return new PlantaAgua(nombre, "Agua y Planta");
                default:
                    System.out.println("Opcion no valida! Ingrese una de las opciones validas...");
                    break;
            }
        }
        return null;
    }
    public static void bajaPokemon(Pokemon pokemons[], Scanner scanner){ //     2
        boolean continuar = true;
        int i,j;

        if (pokemons[0] == null){
            System.out.println("No hay pokemons en el equipo.");
            continuar = false;
        }
        listarPokemons(pokemons, scanner);
        while (continuar) {
            int opcion = scanner.nextInt();
            while (opcion <= 0){
                System.out.print("Ingrese un numero valido:");
                opcion = scanner.nextInt();
            }
            if (pokemons[opcion-1]!=null){
                System.out.println("El pokemon " + pokemons[opcion-1].getNombre() + " fue removido del equipo...");
                pokemons[opcion-1] = null;
                for (i=0; i < pokemons.length-1; i++){
                    for (j=i+1; j < pokemons.length; j++){
                        if (pokemons[i]==null && pokemons[j]!=null){
                            pokemons[i] = pokemons[j];
                            pokemons[j] = null;
                        }
                    }
                }
                continuar = false;
            }
        }
    };
    public static void listarPokemons(Pokemon pokemons[], Scanner scanner){ //  3
        int i, j=1;
        if (pokemons[0] == null){
            System.out.println("No hay pokemons cargados al equipo");
        }else{
            System.out.println("\nLos pokemons del equipo son:");
            for (i=0;i<pokemons.length && pokemons[i] != null; i++, j++){
                System.out.println(j + ". " + pokemons[i].getNombre());
            }
        }
    };
    public static void mostrarDetalles(Pokemon pokemons[], Scanner scanner){ // 4
        boolean continuar = true, accion = true;

        if (pokemons[0] == null){
            System.out.println("No hay pokemons en el equipo.");
            continuar = false;
        }
        listarPokemons(pokemons, scanner);
        while (continuar) {
            int opcion = scanner.nextInt();
            while (opcion <= 0){
                System.out.print("Ingrese un numero valido:");
                opcion = scanner.nextInt();
            }
            if (pokemons[opcion-1]!=null){
                System.out.println("El pokemon " + pokemons[opcion-1].getNombre() + " puede:");
                System.out.println("1. Mostrar detalles.");
                System.out.println("2. Atacar.");
                System.out.println("3. Capturar.");
                while(accion){
                    System.out.print("Ingrese el metodo que desea realizar: ");
                    int metodo= scanner.nextInt();
                    switch (metodo) {
                        case 1:
                            pokemons[opcion-1].obtenerDatos();
                            accion = false;
                            break;
                        case 2:
                            pokemons[opcion-1].atacar();
                            accion = false;
                            break;
                        case 3:
                            pokemons[opcion-1].capturar();
                            accion = false;
                            break;
                        default:
                            System.out.print("Opcion invalida. ");
                            break;
                    }
                }
                continuar = false;
            }else if(pokemons[opcion-1]==null){
                System.out.print("No existe un pokemon en esa casilla. Ingrese un numero valido: ");
            }
        }
    };
}