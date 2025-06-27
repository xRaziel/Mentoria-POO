public class CafeteriaGourmet extends Restaurante{

    private int maquinasCafe;

    public CafeteriaGourmet(String codigo, int añosOperacion, int numeroEmpleados,
                            double ratingClientes, String estadoFinanciero, int maquinasCafe) {
        super(codigo, añosOperacion, numeroEmpleados, ratingClientes, estadoFinanciero);
        this.maquinasCafe = maquinasCafe;
    }

    @Override
    public String getTipo() { return "CafeteriaGourmet"; }

    @Override
    public int getCaracteristicaEspecial() { return maquinasCafe; }

    public int getMaquinasCafe() { return maquinasCafe; }

    @Override
    public void accept(RestauranteVisitor visitor) {
        visitor.visit(this);
    }
}
