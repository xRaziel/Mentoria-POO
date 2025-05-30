public class CazadorAsteroides extends Nave{
    private int cantTaladros;

    public CazadorAsteroides(String codigo, int anioServicio, double potenciaMotor, double blindaje, String estadoOperacional, int cantTaladros) {
        super(codigo, anioServicio, potenciaMotor, blindaje, estadoOperacional);
        this.cantTaladros = cantTaladros;
    }

    @Override
    public void accept(NaveVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getTipoNave() {
        return "Cazador de Asteroides";
    }

    @Override
    public boolean necesitaMantenimiento() {
        return this.anioServicio > 15 || this.blindaje < 60;
    }

    public int getCantTaladros() {
        return cantTaladros;
    }

    public void setCantTaladros(int cantTaladros) {
        this.cantTaladros = cantTaladros;
    }
}
