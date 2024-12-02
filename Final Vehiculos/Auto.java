public class Auto extends Vehiculo{
    private static int contador = 1;
    Auto(){
        super(2000,4,"A"+contador++);
    }
}
