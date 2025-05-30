public class RentabilidadVisitor implements NaveVisitor{

    private Nave naveMasRentable;
    private double maxRentabilidad = -1;

    private void evaluarRentabilidad(Nave nave, EstrategyRentabilidad estrategia) {
        double rentabilidad = estrategia.calcularRentabilidad(nave);
        if (rentabilidad > maxRentabilidad) {
            maxRentabilidad = rentabilidad;
            naveMasRentable = nave;
        }
    }

    @Override
    public void visit(NavePasajeros nave) {
        evaluarRentabilidad(nave, new EstrategiaNavePasajeros());
    }

    @Override
    public void visit(NaveGuerra nave) {
        evaluarRentabilidad(nave, new EstrategiaNaveGuerra());
    }

    @Override
    public void visit(CazadorAsteroides cazador) {
        evaluarRentabilidad(cazador, new EstrategyCazadorEsteroides());
    }

    @Override
    public void visit(LaboratorioOrbital laboratorio) {
        evaluarRentabilidad(laboratorio, new EstrategiaLaboratorioOrbital());
    }

    public Nave getNaveMasRentable() {
        return naveMasRentable;
    }

    public double getMaxRentabilidad() {
        return maxRentabilidad;
    }

}
