public class NavePasajeros extends Nave{

    private int cantPasajeros;

    public NavePasajeros(String codigo, int anioServicio, double potenciaMotor, double blindaje, String estadoOperacional, int cantPasajeros) {
        super(codigo, anioServicio, potenciaMotor, blindaje, estadoOperacional);
        this.cantPasajeros = cantPasajeros;
    }

    @Override
    public void accept(NaveVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getTipoNave() {
        return "Nave de Pasajeros";
    }

    @Override
    public boolean necesitaMantenimiento() {
        return this.anioServicio > 10 || this.blindaje < 70 || this.potenciaMotor < 500;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }
}
