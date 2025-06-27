public class Moto extends Vehiculo{
    private int cilindrada;

    public Moto(String rutDueño, String nombreDueño, String patente, String modelo, int cilindrada) {
        super(rutDueño, nombreDueño, patente, modelo);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }
    @Override
    public double calcularTarifa() {
        return 10.0 * cilindrada;
    }

    @Override
    public void accept(VehiculoVisitor visitor) {
        visitor.visit(this);
    }
}
