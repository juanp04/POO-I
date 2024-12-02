import java.util.ArrayList;

public abstract class Computadora{
    private int costoReparacion;
    private String codigo;
    private ArrayList<Componente> componentes = new ArrayList<>();
    
    public Computadora(int costoReparacion, String codigo) {
        setCostoReparacion(costoReparacion);
        setCodigo(codigo);
        setComponentes(null);
    }

    //Getters
    public int getCostoReparacion() {
        return costoReparacion;
    }
    public String getCodigo() {
        return codigo;
    }
    public ArrayList<Componente> getComponentes() {
        return componentes;
    }
    //Setters
    public void setCostoReparacion(int costoReparacion) {
        this.costoReparacion = costoReparacion;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }
}
