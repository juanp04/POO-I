public abstract class Empleado{
    private String nombre;
    private int id;
    private String tipo;

    Empleado(String nombre, int id, String tipo) {
        this.nombre = nombre;
        this.id = id;
        this.tipo = tipo;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public String getNombre() {
        return nombre;
    }
    //setter
    public void setId(int id) {
        this.id = id;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract void mostrarInformación();
    public abstract void calcularSalario();
}
