public abstract class Habitacion{
    private boolean disponibilidad;
    private int numero;
    private String tipo;
    private float precioPorNoche;
    Habitacion(int numero, String tipo, float precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponibilidad = true;
    }
    
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public float getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecioPorNoche(float precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    abstract boolean disponibilidad();
    abstract void reservar();
    abstract void cancelar();

    public boolean getDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}