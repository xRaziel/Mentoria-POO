public class Auto extends Vehiculo{
    private int cantidadAsientos;

    public Auto(String rutDueño, String nombreDueño, String patente, String modelo, int cantidadAsientos) {
        super(rutDueño, nombreDueño, patente, modelo);
        this.cantidadAsientos = cantidadAsientos;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    @Override
    public double calcularTarifa() {
        return (27.0 * cantidadAsientos * tiempoEstacionado) / 5.0;
    }

    @Override
    public void accept(VehiculoVisitor visitor) {
        visitor.visit(this);
    }
}
