public abstract class Pokemon implements Icapturable{
    private String nombre;
    private String tipo;

    Pokemon(String nombre, String tipo){
        setNombre(nombre);
        setTipo(tipo);
    };

    public String getNombre(){return this.nombre;};
    public String getTipo(){return this.tipo;};

    public void setNombre(String nombre){this.nombre = nombre;};
    public void setTipo(String tipo){this.tipo = tipo;};

    public abstract void obtenerDatos();
    public abstract void atacar();

    @Override
    public void capturar(){System.out.println(this.nombre + " fue capturado...");};
}