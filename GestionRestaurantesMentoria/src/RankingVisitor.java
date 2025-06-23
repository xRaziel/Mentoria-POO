import java.util.ArrayList;
import java.util.List;

public class RankingVisitor implements RestauranteVisitor{
    private List<Restaurante> ranking = new ArrayList<>();

    @Override
    public void visit(Pizzeria pizzeria) {
        ranking.add(pizzeria);
    }

    @Override
    public void visit(SushiBar sushiBar) {
        ranking.add(sushiBar);
    }

    @Override
    public void visit(AsadorCarnes asador) {
        ranking.add(asador);
    }

    @Override
    public void visit(CafeteriaGourmet cafeteria) {
        ranking.add(cafeteria);
    }

    public void imprimirResultados(){
        List<Restaurante> copia = new ArrayList<>(ranking);

        System.out.println("Top 3 de Restaurantes por Rating de Clientes:");
        copia.sort((a,b) -> Double.compare(b.getRatingClientes(), a.getRatingClientes()));
        for (int i = 0; i < 3; i++) {
            Restaurante restaurante = copia.get(i);
            System.out.println((i + 1) + ". " + restaurante.getCodigo() + " - Rating: " + restaurante.getRatingClientes());
        }

        System.out.println("Top 3 restaurantes con más empleados");
        copia.sort((a, b) -> Integer.compare(b.getNumeroEmpleados(), a.getNumeroEmpleados()));
        for (int i = 0; i < 3; i++) {
            Restaurante restaurante = copia.get(i);
            System.out.println((i + 1) + ". " + restaurante.getCodigo() + " - Empleados: " + restaurante.getNumeroEmpleados());
        }

        System.out.println("Restaurante mas antiguo:");
        copia.sort((a, b) -> Integer.compare(b.getAñosOperacion(), a.getAñosOperacion()));
        Restaurante masAntiguo = copia.get(0);
        System.out.println(masAntiguo.getCodigo() + " - Años de operación: " + masAntiguo.getAñosOperacion());

        System.out.println("Restaurante mas nuevo:");
        copia.sort((a, b) -> Integer.compare(a.getAñosOperacion(), b.getAñosOperacion()));
        Restaurante masNuevo = copia.get(0);
        System.out.println(masNuevo.getCodigo() + " - Años de operación: " + masNuevo.getAñosOperacion());



    }
}
