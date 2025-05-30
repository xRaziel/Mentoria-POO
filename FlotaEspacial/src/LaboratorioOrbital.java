public class LaboratorioOrbital extends Nave{

    private int cantExperimentos;

    public LaboratorioOrbital(String codigo, int anioServicio, double potenciaMotor, double blindaje, String estadoOperacional, int cantExperimentos) {
        super(codigo, anioServicio, potenciaMotor, blindaje, estadoOperacional);
        this.cantExperimentos = cantExperimentos;
    }

    @Override
    public void accept(NaveVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getTipoNave() {
        return "Laboratorio Orbital";
    }

    @Override
    public boolean necesitaMantenimiento() {
        return this.anioServicio > 12 || cantExperimentos < 3;
    }

    public int getCantExperimentos() {
        return cantExperimentos;
    }

    public void setCantExperimentos(int cantExperimentos) {
        this.cantExperimentos = cantExperimentos;
    }
}
