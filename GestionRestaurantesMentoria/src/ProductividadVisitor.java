import java.util.HashMap;
import java.util.Map;

public class ProductividadVisitor implements RestauranteVisitor{
    private Map<String, Double> productividadPorRestaurante = new HashMap<>();
    private CalcularProductividad calculador = new CalcularProductividad();

    @Override
    public void visit(Pizzeria pizzeria) {
        calculador.setStrategy(new ProductividadPizzeria());
        double productividad = calculador.calcular(pizzeria);
        productividadPorRestaurante.put(pizzeria.getCodigo(), productividad);
    }

    @Override
    public void visit(SushiBar sushiBar) {
        calculador.setStrategy(new ProductividadSushi());
        double productividad = calculador.calcular(sushiBar);
        productividadPorRestaurante.put(sushiBar.getCodigo(), productividad);
    }

    @Override
    public void visit(AsadorCarnes asador) {
        calculador.setStrategy(new ProductividadAsador());
        double productividad = calculador.calcular(asador);
        productividadPorRestaurante.put(asador.getCodigo(), productividad);
    }

    @Override
    public void visit(CafeteriaGourmet cafeteria) {
        calculador.setStrategy(new ProductividadCafeteria());
        double productividad = calculador.calcular(cafeteria);
        productividadPorRestaurante.put(cafeteria.getCodigo(), productividad);
    }

    public void imprimirResultados() {
        System.out.println("El restaurante con mayor productividad es:");
        String mejorRestaurante = "";
        double mejorProductividad = 0;
        for (String codigo : productividadPorRestaurante.keySet()) {
            double productividad = productividadPorRestaurante.get(codigo);
            if (productividad > mejorProductividad) {
                mejorProductividad = productividad;
                mejorRestaurante = codigo;
            }
        }
        if (mejorRestaurante != "") {
            System.out.println(mejorRestaurante + " con una productividad de: " + mejorProductividad);
        } else {
            System.out.println("No se encontraron restaurantes.");
        }
    }
}
