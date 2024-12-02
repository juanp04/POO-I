public class Moto extends Vehiculo{
    private static int contador = 1;
    Moto(){
        super(1000,2,"M" + contador++);
    }
}