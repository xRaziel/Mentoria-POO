public class EstrategiaNaveGuerra implements EstrategyRentabilidad {

    @Override
    public double calcularRentabilidad(Nave nave) {
        NaveGuerra naveGuerra = (NaveGuerra) nave;
        return (naveGuerra.getPotenciaArmamento() * naveGuerra.getBlindaje() * naveGuerra.getPotenciaMotor())
                / (naveGuerra.getAnioServicio() * naveGuerra.getAnioServicio());
    }
}
