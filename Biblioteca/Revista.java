public class Revista extends Documento implements IPrestable{
    private Boolean disponible;

    public Revista(String titulo, String autor) {
        super(titulo, autor);
        this.disponible = true;
    }

    public Boolean getDisponible() {
        return disponible;
    };
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    void mostrarInfo(){
        System.out.println("'"+getTitulo()+"' es de "+getAutor()+".");
    };
    public void registrarPrestamo(){
        System.out.println("Prestamo refisrado.");
    };
    public void prestar(){
        this.disponible = false;
    };
    public void devolver(){
        this.disponible = true;
    }
}
