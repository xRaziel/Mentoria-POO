import java.util.HashMap;
import java.util.Map;

public class CalculadoraRentabilidad {

    private Map<String,EstrategyRentabilidad> estrategias;

    public CalculadoraRentabilidad() {
        estrategias = new HashMap<>();
        estrategias.put("Cazador de Asteroides", new EstrategyCazadorEsteroides());
        estrategias.put("Laboratorio Orbital", new EstrategiaLaboratorioOrbital());
        estrategias.put("Nave de Guerra", new EstrategiaNaveGuerra());
        estrategias.put("Nave de Pasajeros", new EstrategiaNavePasajeros());
    }

    public double calcularRentabilidad(Nave nave) {
        EstrategyRentabilidad estrategia = estrategias.get(nave.getTipoNave());
        if (estrategia != null) {
            return estrategia.calcularRentabilidad(nave);
        } else {
            throw new IllegalArgumentException("Estrategia no encontrada para la nave: " + nave.getClass().getSimpleName());
        }
    }
}
