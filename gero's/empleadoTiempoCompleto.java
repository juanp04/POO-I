import java.util.List;

public class empleadoTiempoCompleto extends Empleado {
    private Departamento dpto; 
    private List<Bonus> bns;
    private List<Proyecto> pry;


    public empleadoTiempoCompleto(String nombre,String id,int salario,Departamento dpto, List<Proyecto> pry, List<Bonus> bns){
        super(nombre,id,salario);
        this.dpto = dpto;
        this.pry = pry;
        this.bns = bns;
    }
    @Override
    public int  calcularSalario(){
        System.out.println("Salario Total: ");
        return getSalario();
    }
    @Override
    public String mostrarDetalles(){
        return("Nombre: " + getNombre() + " Id: " + getId() + " Salario: " + getSalario() + " Tipo de Empleado: Tiempo Completo" + 
        " Departamento: " + dpto.getDepartamento() + " Proyectos: " + pry + " Beneficios: " + bns);
    }

}



