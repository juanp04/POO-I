public class Laptop extends Computadora{
    static private int contador = 1;
    Laptop(){
        super(700, "L"+ contador++);
    }
}