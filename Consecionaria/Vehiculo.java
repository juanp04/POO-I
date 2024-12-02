public abstract class Vehiculo {
    String marca;
    String modelo;
    int anio;
    Motor motor;
    Rueda ruedas;
    Asiento asientos;
    public Vehiculo(String marca, String modelo, int anio, Motor motor, Rueda ruedas, Asiento asientos) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.motor = motor;
        this.ruedas = ruedas;
        this.asientos = asientos;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    abstract void mostrarDatos();
    abstract void iniciarMarcha();
}
