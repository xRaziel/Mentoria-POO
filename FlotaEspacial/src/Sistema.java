import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private static Sistema sistema;

    private List<Nave> naves;

    private Sistema() {
        naves = new ArrayList<>();
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
                Nave nave = NaveFactory.crearNave(linea);
                if (nave != null) {
                    naves.add(nave);
                } else {
                    System.out.println("Error al crear la nave con los datos: " + linea);
                }
            }
        }catch(Exception e){
            System.out.println("Error al cargar los datos desde el archivo: " + archivo);
            e.printStackTrace();
        }
    }

    public void analizarDatos(){
        AnalizadorEstadoVisitor analizador = new AnalizadorEstadoVisitor();
        MantenimientoVisitor mantenimiento = new MantenimientoVisitor();
        RankingVisitor ranking = new RankingVisitor();
        RentabilidadVisitor rentabilidad = new RentabilidadVisitor();
        CalculadoraRentabilidad calculadoraRentabilidad = new CalculadoraRentabilidad();

        for(Nave nave : naves) {
            nave.accept(analizador);
            nave.accept(mantenimiento);
            nave.accept(ranking);
            nave.accept(rentabilidad);
        }
        imprimirResultados(analizador, mantenimiento, ranking,rentabilidad, calculadoraRentabilidad);
    }

    public void imprimirResultados(AnalizadorEstadoVisitor analizador,MantenimientoVisitor mantenimiento,RankingVisitor ranking,RentabilidadVisitor rentabilidad,CalculadoraRentabilidad calculadora) {
        System.out.println("Resultados del análisis de naves:");
        System.out.println("Cantidad de naves por estado:");
        for (String estado : analizador.getConteoEstados().keySet()) {
            int cantidad = analizador.getConteoEstados().get(estado);
            System.out.println(estado + ": " + cantidad);
        }

        System.out.println("Promedio de años de servicio por estado:");
        for (String estado : analizador.getPromedioAnioEstados().keySet()) {
            double promedio = analizador.getPromedioAnioEstados().get(estado);
            System.out.println(estado + ": " + promedio);
        }

        System.out.println("Tipo de nave mas comun en estado crítico: " + analizador.getMasComunCritico());
        

        System.out.println("Top 3 naves con mayor potencia de motor:");
        List<Nave> topPotencia = ranking.getTop3MayorPotencia();
        for (Nave nave : topPotencia) {
            System.out.println(nave.getCodigo() + " - Potencia: " + nave.getPotenciaMotor());
        }

        System.out.println("Top 3 naves con mejor blindaje:");
        List<Nave> topBlindaje = ranking.getTop3MejorBlindaje();
        for (Nave nave : topBlindaje) {
            System.out.println(nave.getCodigo() + " - Blindaje: " + nave.getBlindaje());
        }

        System.out.println("Nave mas antigua: "+ ranking.getNaveMasAntigua().getCodigo());
        System.out.println("Nave mas nueva: " + ranking.getNaveMasNueva().getCodigo());

        System.out.println("Rentabilidad de naves:");
        for (Nave nave : naves) {
            try {
                double rentabilidadNave = calculadora.calcularRentabilidad(nave);
                System.out.println(nave.getCodigo() + " - Rentabilidad: " + rentabilidadNave);
            } catch (IllegalArgumentException e) {
                System.out.println("No se pudo calcular la rentabilidad para la nave: " + nave.getCodigo() + " - " + e.getMessage());
            }
        }

        System.out.println("Nave con mayor rentabilidad: "+ rentabilidad.getNaveMasRentable().getCodigo() +
                " - Rentabilidad: " + rentabilidad.getMaxRentabilidad());

        System.out.println("Recomendaciones de mantenimiento por tipo:");
        for (String tipo : mantenimiento.getNavesMantenimientoPorTipo().keySet()) {
            List<Nave> navesTipo = mantenimiento.getNavesMantenimientoPorTipo().get(tipo);
            System.out.println("Tipo: " + tipo + " - Naves: ");
            for (Nave nave : navesTipo) {
                System.out.println("  - " + nave.getCodigo());
            }
        }

    }
}
