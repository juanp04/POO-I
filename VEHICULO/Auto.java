package VEHICULO;

public class Auto extends Vehiculo{
    String matricula;
    String color;

    Auto(String marca, String modelo, String matricula, String color){
        super(marca,modelo);
        this.matricula = matricula;
        this.color = color;
    }

    public void encender(){};
    public void apagar(){};

    @Override
    public void acelerar(){
        super.acelerar();
        System.out.println("El auto esta acelerando.");
    }
    
    @Override
    public void frenar(){
        super.frenar();
        System.out.println("El auto esta frenando.");
    }
}