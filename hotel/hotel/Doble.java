import java.util.ArrayList;

public class Doble extends Habitacion {
    private static ArrayList<Amenidad> amenidades = new ArrayList<>();

    public Doble(int numeroDeHabitacion, double precioPorNoche) {
        super(numeroDeHabitacion, "Doble", precioPorNoche);
        this.setServicioDeHabitacion("Limpieza diaria");
        this.setServicioDeHabitacion("Desayuno incluido");

        this.setAmenidades("Wi-Fi gratis");
    }

    public ArrayList<Amenidad> getAmenidades(){
        return amenidades;
    }

    public void setAmenidades(String amenidad) {
        amenidades.add(new Amenidad(amenidad));
    }

    @Override
    public boolean disponibilidad() {
        if (this.getDisponibilidad()) {
            System.out.printf(
                    "\nla habitacion [%d] de tipo [%s] se encuentra disponible y su valor es de [%.2f] por noche.", this.getNumeroDeHabitacion(), this.getTipoDeHabitacion(), this.getPrecioPorNoche());
            this.reservar();
            return true;
        }
        System.out.printf("\nla habitacion [%d] de tipo [%s] no esta disponible actualmente.", getNumeroDeHabitacion(),
                getTipoDeHabitacion());
        return false;
    }

    @Override
    public void reservar() {
        this.setDisponibilidad(false);
        System.out.println("\nReserva realizada con exito.");
    }
}