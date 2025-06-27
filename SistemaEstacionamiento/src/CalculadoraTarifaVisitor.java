public class CalculadoraTarifaVisitor implements VehiculoVisitor{
    private double totalAutosMas6Asientos = 0;
    private double totalCamionesMenos2Toneladas = 0;
    private double totalGeneral = 0;

    @Override
    public void visit(Auto auto) {
        double tarifa = auto.calcularTarifa();
        totalGeneral += tarifa;
        if (auto.getCantidadAsientos() > 6) {
            totalAutosMas6Asientos += tarifa;
        }
    }

    @Override
    public void visit(Moto moto) {
        double tarifa = moto.calcularTarifa();
        totalGeneral += tarifa;
    }

    @Override
    public void visit(Camion camion) {
        double tarifa = camion.calcularTarifa();
        totalGeneral += tarifa;
        if (camion.getToneladas() < 2.0) {
            totalCamionesMenos2Toneladas += tarifa;
        }
    }

    public double getTotalAutosMas6Asientos() { return totalAutosMas6Asientos; }
    public double getTotalCamionesMenos2Toneladas() { return totalCamionesMenos2Toneladas; }
    public double getTotalGeneral() { return totalGeneral; }
}
