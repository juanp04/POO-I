import java.util.ArrayList;

public class Doble extends Habitacion{
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private ArrayList<OpcionesDeCama> opcionesDeCama = new ArrayList<>();
    boolean disponibilidad;
    Doble(int numero, float precioPorNoche) {
        super(numero, "Doble", precioPorNoche);
        setServicios("Desayuno");
        setOpcionesDeCama("Matrimonial");
    }
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    public void setServicios(String servicio) {
        this.servicios.add(new Servicio(servicio));
    }
    public ArrayList<OpcionesDeCama> getOpcionesDeCamas() {
        return opcionesDeCama;
    }
    public void setOpcionesDeCama(String servicio) {
        this.opcionesDeCama.add(new OpcionesDeCama(servicio));
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