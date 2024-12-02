public class Camioneta extends Vehiculo{
    private static int contador = 1;
    Camioneta(){
        super(1000,2,"C" + contador++);
    }
}