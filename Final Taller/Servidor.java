public class Servidor extends Computadora{
    static private int contador = 1;
    Servidor(){
        super(1000, "S"+ contador++);
    }
}