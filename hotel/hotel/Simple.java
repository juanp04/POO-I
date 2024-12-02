public class Simple extends Habitacion {

    public Simple(int numeroDeHabitacion, double precioPorNoche) {
        super(numeroDeHabitacion, "Simple", precioPorNoche);
        this.setServicioDeHabitacion("Limpieza diaria");
    }

    @Override
    public boolean disponibilidad() {
        if (this.getDisponibilidad()) {
            System.out.printf(
                    "\nla habitacion [%d] de tipo [%s] se encuentra disponible y su valor es de [%.2f] por noche.", this.getNumeroDeHabitacion(), this.getTipoDeHabitacion(), this.getPrecioPorNoche());
            this.reservar();
            return true;
        }
        System.out.printf("\nla habitacion [%d] de tipo [%s] no esta disponible actualmente.", getNumeroDeHabitacion(), getTipoDeHabitacion());
        return false;
    }

    @Override
    protected void reservar() {
        this.setDisponibilidad(false);
        System.out.println("\nReserva realizada con exito.");
    }
}