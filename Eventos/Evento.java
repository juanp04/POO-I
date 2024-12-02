public abstract class Evento{
    private String nombre;
    private int id;
    private String tipo;

    Evento(String nombre, int id, String tipo) {
        this.nombre = nombre;
        this.id = id;
        this.tipo = tipo;
    }

    //getters
    public String getNombre() {
        return nombre;
    }
    public int getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }

    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //metodos abstractos
    public abstract void mostrarInformación();
    public abstract void calcularPresupuesto();
}