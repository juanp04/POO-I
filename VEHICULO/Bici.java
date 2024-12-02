package VEHICULO;

public class Bici extends Vehiculo{
    String tipo;
    String color;

    Bici(String marca, String modelo, String tipo, String color){
        super(marca,modelo);
        this.tipo = tipo;
        this.color = color;
    }

    public void encender(){};
    public void apagar(){};
    public void pedalear(){
        System.out.println("La bici esta pedaleando.");
    };

    @Override
    public void acelerar(){
        super.acelerar();
        System.out.println("La bici esta acelerando.");
    }
    
    @Override
    public void frenar(){
        super.frenar();
        System.out.println("La bici esta frenando.");
    }
}
