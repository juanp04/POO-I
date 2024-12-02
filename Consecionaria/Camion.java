public class Camion extends Vehiculo{
    Camion(String marca, String modelo, int anio, Motor motor, Rueda ruedas, Asiento asientos){
        super(marca, modelo, anio, motor, ruedas, asientos);
    }
    public void mostrarDatos(){
        System.out.println("[Camion] Marca: "+ getMarca() + ", Modelo: "+ getModelo() + ", Anio: " + getAnio());
    };
    public void iniciarMarcha(){
        System.out.println("El camion encendió.");
    };
}
