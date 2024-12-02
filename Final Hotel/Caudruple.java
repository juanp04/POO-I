public class Caudruple extends Habitacion{
    private static int contador = 1;
    Caudruple(){
        super(4, 3500, "C"+contador++);
    }
}