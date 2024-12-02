public abstract class Documento{
    private String titulo;
    private String autor;
    
    public Documento(String titulo, String autor){
        setTitulo(titulo);
        setAutor(autor);
    };

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    abstract void mostrarInfo();
    abstract void registrarPrestamo();
}