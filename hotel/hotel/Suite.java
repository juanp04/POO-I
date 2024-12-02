import java.util.ArrayList;

public class Suite extends Habitacion {
    private static ArrayList<Amenidad> amenidades = new ArrayList<>();
    private static ArrayList<OpcionDeCama> opcionesDeCama = new ArrayList<>();

    public Suite(int numeroDeHabitacion, double precioPorNoche) {
        super(numeroDeHabitacion, "Suite", precioPorNoche);

        this.setServicioDeHabitacion("Limpieza diaria");
        this.setServicioDeHabitacion("Desayuno incluido");
        this.setServicioDeHabitacion("Servicio a la habitación 24h");

        this.setAmenidad("Wi-Fi gratis");
        this.setAmenidad("Televisión por cable");

        this.setTipoDeCama("Doble");
        this.setTipoDeCama("King-Size");
    }

    public ArrayList<Amenidad> getAmenidades() {
        return amenidades;
    }

    public ArrayList<OpcionDeCama> getOpcionesDeCama() {
        return opcionesDeCama;
    }

    public void setAmenidad(String amenidad) {
        amenidades.add(new Amenidad(amenidad));
    }

    public void setTipoDeCama(String cama) {
        opcionesDeCama.add(new OpcionDeCama(cama));
    }

    @Override
    public boolean disponibilidad() {
        if (this.getDisponibilidad()) {
            System.out.printf(
                    "\nla habitacion [%d] de tipo [%s] se encuentra disponible y su valor es de [%.2f] por noche.",
                    this.getNumeroDeHabitacion(), this.getTipoDeHabitacion(), this.getPrecioPorNoche());
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