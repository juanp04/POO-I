public class Triple extends Habitacion{
    private static int contador = 1;
    Triple(){
        super(3, 2800, "T"+contador++);
    }
}