package VEHICULO;

public class App {
    public static void main(String args[]){
        Auto auto1 = new Auto("BMW","m3","AAA 000","negro");
        auto1.acelerar();

        Moto moto1 = new Moto("Kawazaki","R300","AA345","Azul");
        moto1.frenar();

        Bici bici1 = new Bici("Benzo", "9500", "Carreras","Celeste");
        bici1.pedalear(); /*El metodo en realidad deberia estar en private, pero por temas de conveniencia lo puse en public*/
    }
}
