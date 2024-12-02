public class Motocicleta extends Vehiculo{
    Motocicleta(String marca, String modelo, int anio, Motor motor, Rueda ruedas, Asiento asientos){
        super(marca, modelo, anio, motor, ruedas, asientos);
    }
    public void mostrarDatos(){
        System.out.println("[Motocicleta] Marca: "+ getMarca() + ", Modelo: "+ getModelo() + ", Anio: " + getAnio());
    };
    public void iniciarMarcha(){
        System.out.println("La motocicleta encendió.");
    };
}
