import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalisisFinancieroVisitor implements RestauranteVisitor{

    private Map<String, Integer> contadorEstados = new HashMap<>();
    private  Map <String, Double> ratingsEstados = new HashMap<>();
    private Map<String, Double> promedioEstados = new HashMap<>();
    private Map<String, Integer> tiposDeficientes = new HashMap<>();

    public AnalisisFinancieroVisitor() {
        String [] estados = {"Excelente", "Bueno", "Regular", "Deficiente"};
        for (String estado : estados) {
            contadorEstados.put(estado, 0);
            ratingsEstados.put(estado, 0.0);
            promedioEstados.put(estado, 0.0);
        }

        tiposDeficientes.put("Pizzeria", 0);
        tiposDeficientes.put("SushiBar", 0);
        tiposDeficientes.put("AsadorCarnes", 0);
        tiposDeficientes.put("CafeteriaGourmet", 0);
    }

    @Override
    public void visit(Pizzeria pizzeria) {
        procesarRestaurante(pizzeria);
    }

    @Override
    public void visit(SushiBar sushiBar) {
        procesarRestaurante(sushiBar);
    }

    @Override
    public void visit(AsadorCarnes asador) {
        procesarRestaurante(asador);
    }

    @Override
    public void visit(CafeteriaGourmet cafeteria) {
        procesarRestaurante(cafeteria);
    }

    private void procesarRestaurante(Restaurante restaurante){
        String estado = restaurante.getEstadoFinanciero();
        double rating = restaurante.getRatingClientes();

        // Contar el estado financiero
        contadorEstados.put(estado, contadorEstados.get(estado) + 1);

        // Agregar el rating al estado correspondiente
        ratingsEstados.put(estado, ratingsEstados.get(estado) + rating);

        // Verificar si es deficiente
        if (estado.equals("Deficiente")) {
            String tipo = restaurante.getTipo();
            tiposDeficientes.put(tipo, tiposDeficientes.get(tipo) + 1);
        }
    }

    public void imprimirResultados(){
        System.out.println("Análisis Financiero de Restaurantes:");
        System.out.println("Contador de Estados Financieros:");
        for (String estado: contadorEstados.keySet()) {
            System.out.println(estado + ": " + contadorEstados.get(estado));
        }
        System.out.println("\nPromedio de Ratings por Estado Financiero:");
        for (String estado: ratingsEstados.keySet()) {
            double totalRatings = ratingsEstados.get(estado);
            int contador = contadorEstados.get(estado);
            double promedio = contador > 0 ? totalRatings / contador : 0.0;
            if( promedio > 0) {
                promedioEstados.put(estado, promedio);
            }else {
                promedioEstados.put(estado, 0.0);
            }
            System.out.println(estado + ": " + promedio);
        }

        System.out.println("\nTipos de Restaurantes Deficientes:");
        String tipoMasDeficiente = "";
        int maxDeficientes = 0;
        for (String tipo : tiposDeficientes.keySet()) {
            if (tiposDeficientes.get(tipo) > maxDeficientes) {
                maxDeficientes = tiposDeficientes.get(tipo);
                tipoMasDeficiente = tipo;
            }
        }
        System.out.println("Tipo con más restaurantes deficientes: " + tipoMasDeficiente + " (" + maxDeficientes + ")");
    }
}
