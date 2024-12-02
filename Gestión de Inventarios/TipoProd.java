public class TipoProd extends Producto{
    private String categoria;
    private double descuento;

    public TipoProd(int codigo, String nombre, int precio, int cant, String categoria, double descuento){
        super(codigo, nombre, precio, cant);
        this.categoria = categoria;
        this.descuento = descuento;
    }
    public String getCategoria(){return categoria;}
    public double getDescuento(){return descuento;}

    @Override
    public boolean verificarDisponibilidad(){return getCant()>0;};
    @Override
    public void actualizarCantidad(int cantidad){this.cant = cantidad;};
}
