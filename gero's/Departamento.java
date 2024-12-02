public class Departamento {
    private String dpto;

    public Departamento(String dpto){
        this.dpto=dpto;
    }
    
    public String getDepartamento(){
        return dpto;
    }

    @Override
    public String toString() {
        return dpto;
    }
}
