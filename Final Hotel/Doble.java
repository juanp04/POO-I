public class Doble extends Habitacion{
    private static int contador = 1;
    Doble(){
        super(2, 2000, "D"+contador++);
    }
}