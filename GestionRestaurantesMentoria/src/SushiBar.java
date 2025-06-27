public class SushiBar extends Restaurante{

    private int chefsEspecializados;

    public SushiBar(String codigo, int añosOperacion, int numeroEmpleados,
                    double ratingClientes, String estadoFinanciero, int chefsEspecializados) {
        super(codigo, añosOperacion, numeroEmpleados, ratingClientes, estadoFinanciero);
        this.chefsEspecializados = chefsEspecializados;
    }

    @Override
    public String getTipo() { return "SushiBar"; }

    @Override
    public int getCaracteristicaEspecial() { return chefsEspecializados; }

    public int getChefsEspecializados() { return chefsEspecializados; }

    @Override
    public void accept(RestauranteVisitor visitor) {
        visitor.visit(this);
    }
}
