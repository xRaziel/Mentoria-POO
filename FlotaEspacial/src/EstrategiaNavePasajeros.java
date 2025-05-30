public class EstrategiaNavePasajeros implements EstrategyRentabilidad {

    @Override
    public double calcularRentabilidad(Nave nave) {
        NavePasajeros navePasajeros = (NavePasajeros) nave;
        double factorBlindaje = navePasajeros.getBlindaje() > 80 ? 1.0 : 0.7;

        return (navePasajeros.getCantPasajeros() * navePasajeros.getPotenciaMotor() * factorBlindaje)
                / navePasajeros.getAnioServicio();
    }
}
