public class Cliente {
    private String nombre;
    private String apellido;
    private int dni;
    private String direccion;
    private int telefono;

    Cliente(String nombre, String apellido, int dni, String direccion, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public int getDni() {
        return dni;
    }
    public String getDireccion() {
        return direccion;
    }
    public int getTelefono() {
        return telefono;
    }
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
