public abstract class Empleado {
    protected  String nombre;
    protected  String id;
    protected  int salario;

    public Empleado(String nombre,String id,int salario){
        this.nombre=nombre;
        this.id=id;
        this.salario=salario;
    }
    
    abstract int calcularSalario();
    abstract String mostrarDetalles();

    public String getNombre(){return nombre;}
    public String getId(){return id;}
    public int getSalario(){return salario;}

}
