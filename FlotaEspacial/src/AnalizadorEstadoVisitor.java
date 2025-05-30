import java.util.HashMap;
import java.util.Map;

public class AnalizadorEstadoVisitor implements NaveVisitor{

    private Map<String, Integer> conteoEstados = new HashMap<>();
    private Map<String, Integer> aniosEstados = new HashMap<>();
    private Map<String,Double> promedioAnioEstados = new HashMap<>();
    private Map<String, Integer> tiposNavesCritico = new HashMap<>();

    public AnalizadorEstadoVisitor() {
        String [] estados = {"Óptimo", "Funcional", "Crítico"};
        for (String estado : estados) {
            conteoEstados.put(estado, 0);
            promedioAnioEstados.put(estado, 0.0);
            aniosEstados.put(estado, 0);
        }
        tiposNavesCritico.put("Cazador de Asteroides", 0);
        tiposNavesCritico.put("Laboratorio Orbital", 0);
        tiposNavesCritico.put("Nave de Guerra", 0);
        tiposNavesCritico.put("Nave de Pasajeros", 0);
    }

    @Override
    public void visit(CazadorAsteroides cazador) {
        procesarNave(cazador);
    }

    @Override
    public void visit(LaboratorioOrbital laboratorio) {
        procesarNave(laboratorio);
    }

    @Override
    public void visit(NaveGuerra nave) {
        procesarNave(nave);
    }

    @Override
    public void visit(NavePasajeros nave) {
        procesarNave(nave);
    }

    private void procesarNave(Nave nave) {
        String estado = nave.getEstadoOperacional();
        int anioServicio = nave.getAnioServicio();

        // Actualizar conteo de estados
        conteoEstados.put(estado, conteoEstados.get(estado) + 1);
        // Actualizar años de servicio por estado
        aniosEstados.put(estado, aniosEstados.get(estado) + anioServicio);

        // Contar naves críticas
        if (estado.equals("Crítico")) {
            String tipoNave = nave.getTipoNave();
            tiposNavesCritico.put(tipoNave, tiposNavesCritico.get(tipoNave) + 1);
        }
    }

    public Map<String, Integer> getConteoEstados() {
        return conteoEstados;
    }

    public Map<String, Integer> getAniosEstados() {
        return aniosEstados;
    }

    public Map<String, Double> getPromedioAnioEstados() {
        for (String estado : promedioAnioEstados.keySet()) {
            int totalAnios = aniosEstados.get(estado);
            int totalNaves = conteoEstados.get(estado);
            if (totalNaves > 0) {
                promedioAnioEstados.put(estado, (double) totalAnios / totalNaves);
            } else {
                promedioAnioEstados.put(estado, 0.0);
            }
        }
        return promedioAnioEstados;
    }

    public Map<String, Integer> getTiposNavesCritico() {
        return tiposNavesCritico;
    }

    public String getMasComunCritico() {
        String tipoMasComun = "Ninguno";
        int maxCount = 0;

        for (String tipo : tiposNavesCritico.keySet()) {
            int cantidad = tiposNavesCritico.get(tipo);

            if (cantidad > maxCount) {
                maxCount = cantidad;
                tipoMasComun = tipo;
            }
        }

        return tipoMasComun;
    }


}
