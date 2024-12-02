public abstract class Producto{
    int codigo;
    String nombre;
    int precio;
    int cant;

    public Producto(int codigo, String nombre, int precio, int cant){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cant = cant;
    }

    public int getCant() {
        return cant;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }
    
    abstract boolean verificarDisponibilidad();
    abstract void actualizarCantidad(int cantidad);
}
