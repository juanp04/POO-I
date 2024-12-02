public abstract class Habitacion {
    private int cantPersonas;
    private int precioPorDia;
    private String codigo;
    private boolean disponibilidad;
    private Persona propietario;

    Habitacion(int cantPersonas, int precioPorDia, String codigo){
        setCantPersonas(cantPersonas);
        setPrecioPorDia(precioPorDia);
        setCodigo(codigo);
        setDisponibilidad(true);
        setPropietario(null);
    }
    //Getters
    public int getCantPersonas() {
        return cantPersonas;
    }
    public int getPrecioPorDia() {
        return precioPorDia;
    }
    public String getCodigo() {
        return codigo;
    }
    public boolean getDisponibilidad() {
        return disponibilidad;
    }
    public Persona getPropietario() {
        return propietario;
    }
    public String getInfoPropietario(){
        if(getDisponibilidad()){
            return "DISPONIBLE";
        }else{
            return propietario.getApellido() + ", " + propietario.getNombre();
        }
    }
    //Setters
    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
    public void setPrecioPorDia(int precioPorDia) {
        this.precioPorDia = precioPorDia;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    //Metodos
    public void calcularMonto(int diasAlquilados){
        if(propietario.getEdad()>=65 && propietario.getGenero().equals("FEMENINO") || propietario.getEdad()>=70 && propietario.getGenero().equals("MASCULINO")){
            System.out.println("El monto a pagar es de $" + getPrecioPorDia()*diasAlquilados*0.75);
        }else{
            System.out.println("El monto a pagar es de $" + getPrecioPorDia()*diasAlquilados);
        }
    }
}
