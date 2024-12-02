public abstract class Vehiculo{
    private int precioDiario;
    private int cantPersonas;
    private String codigo;
    private boolean disponibilidad;
    private Persona conductor;

    Vehiculo(int precioDiario, int cantPersonas, String codigo){
        setPrecioDiario(precioDiario);
        setCantPersonas(cantPersonas);
        setCodigo(codigo);
        setDisponibilidad(true);
        setConductor(null);
    }

    //Getters
    public int getPrecioDiario() {
        return precioDiario;
    }
    public int getCantPersonas() {
        return cantPersonas;
    }
    public String getCodigo() {
        return codigo;
    }
    public boolean getDisponibilidad() {
        return disponibilidad;
    }
    public Persona getConductor() {
        return conductor;
    }
    public String getEstadoDisponibilidad() {
        if(getDisponibilidad()){
            return "DISPONIBLE";
        }else{
            return getConductor().getApellido() + ", " + getConductor().getNombre();
        }
    }
    //Setters
    public void setPrecioDiario(int precioDiario) {
        this.precioDiario = precioDiario;
    }
    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public void setConductor(Persona conductor) {
        this.conductor = conductor;
    }
    
}