import java.util.ArrayList;

public class Suite extends Habitacion{
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private ArrayList<OpcionesDeCama> opcionesDeCama = new ArrayList<>();
    private ArrayList<Amenidades> amenidades = new ArrayList<>();
    boolean disponibilidad;

    Suite(int numero, float precioPorNoche) {
        super(numero, "Suite", precioPorNoche);
        setServicios("All Inclusive");
        setOpcionesDeCama("Matrimonial");
        setAmenidades("Spa & Resort");
    }
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    public void setServicios(String servicio) {
        this.servicios.add(new Servicio(servicio));
    }
    public ArrayList<Amenidades> getAmenidades() {
        return amenidades;
    }
    public void setAmenidades(String amenidades) {
        this.amenidades.add(new Amenidades(amenidades));
    }
    public ArrayList<OpcionesDeCama> getOpcionesDeCamas() {
        return opcionesDeCama;
    }
    public void setOpcionesDeCama(String servicio) {
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