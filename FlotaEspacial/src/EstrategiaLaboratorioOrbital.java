public class EstrategiaLaboratorioOrbital implements EstrategyRentabilidad {

    @Override
    public double calcularRentabilidad(Nave nave) {
        LaboratorioOrbital laboratorio = (LaboratorioOrbital) nave;
        return (laboratorio.getCantExperimentos() * laboratorio.getPotenciaMotor() * 50.0)
                / (laboratorio.getAnioServicio() + laboratorio.getCantExperimentos());
    }
}
