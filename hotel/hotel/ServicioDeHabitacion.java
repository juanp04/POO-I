public class ServicioDeHabitacion {
    private String tipoDeServicio;

    public ServicioDeHabitacion(String servicio) {
        setServicio(servicio);
    }

    public String getServicio() {
        return this.tipoDeServicio;
    }

    public void setServicio(String servicio) {
        this.tipoDeServicio = servicio;
    }

}
