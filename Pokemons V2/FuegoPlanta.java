public class FuegoPlanta extends Pokemon{
    public FuegoPlanta(String nombre, String tipo){
        super(nombre,tipo);
    };

    @Override
    public void obtenerDatos(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Tipo: " + getTipo());
    };
    @Override
    public void atacar(){System.out.println(this.getNombre() + " usa Ascuas y Látigo Cepa.");};
}