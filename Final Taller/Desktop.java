public class Desktop extends Computadora{
    static private int contador = 1;
    Desktop(){
        super(500, "D"+ contador++);
    }
}