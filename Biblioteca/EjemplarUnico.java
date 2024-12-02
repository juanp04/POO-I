public class EjemplarUnico extends Documento{
    public EjemplarUnico(String titulo, String autor) {
        super(titulo, autor);
    }

    void mostrarInfo(){
        System.out.println("'"+getTitulo()+"' es de "+getAutor()+".");
    };
    public void registrarPrestamo(){
        System.out.println("No se puede realizar prestamo.");
    };
}
