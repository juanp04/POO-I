package VEHICULO;

public class Moto extends Vehiculo{
    String matricula;
    String color;

    Moto(String marca, String modelo, String matricula, String color){
        super(marca, modelo);
        this.matricula = matricula;
        this.color = color;
    }

    public void encender(){};
    public void apagar(){};

    @Override
    public void acelerar(){
        super.acelerar();
        System.out.println("La moto esta acelerando.");
    }
    
    @Override
    public void frenar(){
        super.frenar();
        System.out.println("La moto esta frenando.");
    }
}
