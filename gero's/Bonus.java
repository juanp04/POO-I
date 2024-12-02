public class Bonus {
    private String beneficio;
    private String descp;

    public Bonus(String beneficio, String descp) {
        this.beneficio=beneficio;
        this.descp=descp;
    }

    public String getBonus(){
        return beneficio;
    }
    public String getDescpB(){
        return descp;
    }

    @Override
    public String toString() {
        return beneficio;
    }
}
