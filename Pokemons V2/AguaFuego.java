public class AguaFuego extends Pokemon{
    public AguaFuego(String nombre, String tipo){
        super(nombre,tipo);
    };

    @Override
    public void obtenerDatos(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Tipo: " + getTipo());
    };
    @Override
    public void atacar(){System.out.println(this.getNombre() + " usa Pistola Agua y Ascuas.");};
}