import java.util.ArrayList;

public abstract class Habitacion {
    //atributos
    private int numeroDeHabitacion;
    private String tipoDeHabitacion;
    private double precioPorNoche;
    private boolean disponibilidad;

    private ArrayList<ServicioDeHabitacion> serviciosDeHabitacion = new ArrayList<>();

    //constructor
    public Habitacion(int numeroDeHabitacion, String tipoDeHabitacion, double precioPorNoche) {
        setNumeroDeHabitacion(numeroDeHabitacion);
        setTipoDeHabitacionl(tipoDeHabitacion);
        setPrecioPorNoche(precioPorNoche);
        setDisponibilidad(true);
    }

    //metodos abstractos
    public abstract boolean disponibilidad();
    protected abstract void reservar();


    //getters
    public int getNumeroDeHabitacion() {
        return this.numeroDeHabitacion;
    }

    public String getTipoDeHabitacion() {
        return this.tipoDeHabitacion;
    }

    public double getPrecioPorNoche() {
        return this.precioPorNoche;
    }

    public boolean getDisponibilidad() {
        return this.disponibilidad;
    }

    public ArrayList<ServicioDeHabitacion> getServiciosDeHabitacion(){
        return this.serviciosDeHabitacion;
    }

    //setters
    public void setNumeroDeHabitacion(int numeroDeHabitacion) {
        this.numeroDeHabitacion = numeroDeHabitacion;
    }

    public void setTipoDeHabitacionl(String tipoDeHabitacion) {
        this.tipoDeHabitacion = tipoDeHabitacion;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setServicioDeHabitacion(String servicio){
        serviciosDeHabitacion.add(new ServicioDeHabitacion(servicio));
    }
}