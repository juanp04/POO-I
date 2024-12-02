public class Administrativo extends Empleado implements IAccionable{
    Administrativo(String nombre, int id){
        super(nombre, id, "Administrativo");
    }

    @Override
    public void mostrarInformación(){
        System.out.println("Id: " + this.getId() + " - Nombre: " + this.getNombre() + " - Cargo: " + this.getTipo());
    };
    @Override
    public void calcularSalario(){

    };
    @Override
    public void asignarTarea(){

    };
    @Override
    public void evaluarDesempeño(){
        
    };
}
