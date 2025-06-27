import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private static Sistema sistema;

    private List<Restaurante> restaurantes;

    private Sistema() {
        restaurantes = new ArrayList<>();
    }

    public static Sistema getInstance() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }

    public void cargarDatos(String archivo){
        try{
            BufferedReader reader = new BufferedReader(new java.io.FileReader(archivo));
            String linea;
            while((linea = reader.readLine()) != null){
                Restaurante restaurante = Factory.crearRestaurante(linea);
                if (restaurante != null) {
                    restaurantes.add(restaurante);
                }else{
                    System.out.println("Error al crear el restaurante con la línea: " + linea);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    public void analizarDatos(){
        AnalisisFinancieroVisitor analisis = new AnalisisFinancieroVisitor();
        RankingVisitor ranking = new RankingVisitor();
        ProductividadVisitor productividad = new ProductividadVisitor();

        for (Restaurante restaurante : restaurantes) {
            restaurante.accept(analisis);
            restaurante.accept(ranking);
            restaurante.accept(productividad);
        }

        analisis.imprimirResultados();
        ranking.imprimirResultados();
        productividad.imprimirResultados();
    }
}
