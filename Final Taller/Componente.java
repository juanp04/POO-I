public abstract class Componente{
    private String nombre;
    private int precio;
    private int stock;
    
    Componente(String nombre, int precio, int stock){
        setNombre(nombre);
        setPrecio(precio);
        setStock(precio);
    }

    //Getters
    public String getNombre() {
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}
