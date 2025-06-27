public class ResultadosTotales {

    private double totalAutosMas6Asientos;
    private double totalCamionesMenos2Toneladas;
    private double totalGeneral;

    public ResultadosTotales(double totalAutosMas6Asientos, double totalCamionesMenos2Toneladas, double totalGeneral) {
        this.totalAutosMas6Asientos = totalAutosMas6Asientos;
        this.totalCamionesMenos2Toneladas = totalCamionesMenos2Toneladas;
        this.totalGeneral = totalGeneral;
    }

    public double getTotalAutosMas6Asientos() { return totalAutosMas6Asientos; }
    public double getTotalCamionesMenos2Toneladas() { return totalCamionesMenos2Toneladas; }
    public double getTotalGeneral() { return totalGeneral; }
}
