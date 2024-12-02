package VEHICULO;

public class Vehiculo {
    String  marca;
    String modelo;
    Vehiculo(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }

    public void acelerar(){};
    public void frenar(){};
}
