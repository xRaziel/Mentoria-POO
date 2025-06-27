public class Pizzeria extends Restaurante{
    private int hornosOperativos;

    public Pizzeria(String codigo, int añosOperacion, int numeroEmpleados,
                    double ratingClientes, String estadoFinanciero, int hornosOperativos) {
        super(codigo, añosOperacion, numeroEmpleados, ratingClientes, estadoFinanciero);
        this.hornosOperativos = hornosOperativos;
    }

    @Override
    public String getTipo() { return "Pizzeria"; }

    @Override
    public int getCaracteristicaEspecial() { return hornosOperativos; }

    public int getHornosOperativos() { return hornosOperativos; }

    @Override
    public void accept(RestauranteVisitor visitor) {
        visitor.visit(this);
    }
}
