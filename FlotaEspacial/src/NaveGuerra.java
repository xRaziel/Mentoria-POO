public class NaveGuerra extends Nave{

    private double potenciaArmamento;

    public NaveGuerra(String codigo, int anioServicio, double potenciaMotor, double blindaje, String estadoOperacional, double potenciaArmamento) {
        super(codigo, anioServicio, potenciaMotor, blindaje, estadoOperacional);
        this.potenciaArmamento = potenciaArmamento;
    }

    @Override
    public void accept(NaveVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getTipoNave() {
        return "Nave de Guerra";
    }

    @Override
    public boolean necesitaMantenimiento() {
        return this.blindaje < 80 || this.potenciaMotor < 800;
    }

    public double getPotenciaArmamento() {
        return potenciaArmamento;
    }

    public void setPotenciaArmamento(double potenciaArmamento) {
        this.potenciaArmamento = potenciaArmamento;
    }
}
