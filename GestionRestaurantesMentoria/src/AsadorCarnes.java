public class AsadorCarnes extends Restaurante{

    private int parrillasPremium;

    public AsadorCarnes(String codigo, int añosOperacion, int numeroEmpleados,
                        double ratingClientes, String estadoFinanciero, int parrillasPremium) {
        super(codigo, añosOperacion, numeroEmpleados, ratingClientes, estadoFinanciero);
        this.parrillasPremium = parrillasPremium;
    }

    @Override
    public String getTipo() { return "AsadorCarnes"; }

    @Override
    public int getCaracteristicaEspecial() { return parrillasPremium; }

    public int getParrillasPremium() { return parrillasPremium; }

    @Override
    public void accept(RestauranteVisitor visitor) {
        visitor.visit(this);
    }
}
