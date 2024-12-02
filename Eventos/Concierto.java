public class Concierto extends Evento implements IOrganizable{
    Concierto(String nombre, int id){
        super(nombre, id, "Concierto");
    }
    //implementacion de metodos abstractos de la clase padre
    @Override
    public void mostrarInformación(){
        System.out.println("[" + this.getTipo() + "] Id: " + this.getId()+ ", Nombre:" + this.getNombre());
    };
    @Override
    public void calcularPresupuesto(){
        int precio = 2500;
        System.out.println("Precio: $" + precio);
    };
    //implementacion de metodos abstractos de la interfaz
    @Override
    public void asignarActividad(){

    };
    @Override
    public void evaluarSatisfacción(){
    
    };
}