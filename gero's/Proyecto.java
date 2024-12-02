public class Proyecto {
    private String proyectos;
    private String descp;

    public Proyecto(String proyectos, String descp) {
        this.proyectos=proyectos;
        this.descp=descp;
    }

    public String getProyectos(){
        return proyectos;
    }

    public String getDescp(){
        return descp;
    }

    @Override
    public String toString() {
        return proyectos;
    }
}
