import java.util.ArrayList;

public class Simple extends Habitacion{
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private boolean disponibilidad;
    Simple(int numero, float precioPorNoche) {
        super(numero, "Simple", precioPorNoche);
        setServicios("Desayuno");
    }
    
    public ArrayList<Servicio> getServicios() {
        return this.servicios;
    }
    public void setServicios(String servicio) {
        this.servicios.add(new Servicio(servicio));
    }
    @Override
    public boolean disponibilidad(){
        return this.disponibilidad;
    };
    @Override
    public void reservar(){
        setDisponibilidad(false);;
    };
    @Override
    public void cancelar(){
        setDisponibilidad(true);
    }
}
