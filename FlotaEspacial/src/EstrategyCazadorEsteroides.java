public class EstrategyCazadorEsteroides implements EstrategyRentabilidad{

    @Override
    public double calcularRentabilidad(Nave nave) {
        CazadorAsteroides cazador = (CazadorAsteroides) nave;
        return (cazador.getCantTaladros() * cazador.getPotenciaMotor() * cazador.getBlindaje())
                / (cazador.getAnioServicio() * 10.0);
    }
}
