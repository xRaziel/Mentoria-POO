public class Camion extends Vehiculo{
    private double pesoSoportado;

    public Camion(String rutDueño, String nombreDueño, String patente, String modelo, double pesoSoportado) {
        super(rutDueño, nombreDueño, patente, modelo);
        this.pesoSoportado = pesoSoportado;
    }

    public double getPesoSoportado() {
        return pesoSoportado;
    }

    public double getToneladas() {
        return pesoSoportado / 1000.0;
    }

    @Override
    public double calcularTarifa() {
        double toneladas = getToneladas();
        if (toneladas >= 2.0) {
            return (30.0 * tiempoEstacionado * toneladas) / 3.0;
        } else {
            return (28.0 * tiempoEstacionado * toneladas) / 4.0;
        }
    }

    @Override
    public void accept(VehiculoVisitor visitor) {
        visitor.visit(this);
    }
}
