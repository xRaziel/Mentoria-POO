import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sistema {

    private static Sistema sistema;

    private ArrayList<Vehiculo> vehiculos;

    private Sistema() {
        vehiculos = new ArrayList<>();
    }

    public static Sistema getInstance() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }

    public void cargarDatos(String vehiculosTxt, String tiempos) {
        try{
            BufferedReader reader = new BufferedReader(new java.io.FileReader(vehiculosTxt));
            String linea;
            while((linea = reader.readLine()) != null){
                Vehiculo v = VehiculoFactory.crearVehiculo(linea);
                if (v != null) {
                    this.vehiculos.add(v);
                }
            }
        }catch (Exception e){
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }

        try{
            BufferedReader reader = new BufferedReader(new java.io.FileReader(tiempos));
            String linea;
            while((linea = reader.readLine()) != null){
                String[] partes = linea.split(",");
                String patente = partes[0].trim();
                int tiempoEstacionado = Integer.parseInt(partes[1].trim());

                for (Vehiculo vehiculo : vehiculos) {
                    if (vehiculo.getPatente().equals(patente)) {
                        vehiculo.agregarTiempo(tiempoEstacionado);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResultadosTotales obtenerTotales(){
        CalculadoraTarifaVisitor calculadora = new CalculadoraTarifaVisitor();

        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.accept(calculadora);
        }

        return new ResultadosTotales(
                calculadora.getTotalAutosMas6Asientos(),
                calculadora.getTotalCamionesMenos2Toneladas(),
                calculadora.getTotalGeneral()
        );
    }

    public ResultadoPatentes obtenerPatentesConMasLetras() {
        BuscadorPatenteVisitor buscador = new BuscadorPatenteVisitor();

        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.accept(buscador);
        }

        return new ResultadoPatentes(buscador.getMaxLetras(), buscador.getPatentesMaxLetras());
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void calcularTotales() {
        ResultadosTotales resultado = obtenerTotales();
        System.out.println("=== TOTALES DE DINERO RECAUDADO ===");
        System.out.printf("Autos con más de 6 asientos: $%.2f%n", resultado.getTotalAutosMas6Asientos());
        System.out.printf("Camiones que soportan menos de 2 toneladas: $%.2f%n", resultado.getTotalCamionesMenos2Toneladas());
        System.out.printf("Total general: $%.2f%n", resultado.getTotalGeneral());
    }

    public void encontrarPatentesConMasLetras() {
        ResultadoPatentes resultado = obtenerPatentesConMasLetras();
        System.out.println("\n=== PATENTES CON MÁS LETRAS ===");
        System.out.println("Número máximo de letras: " + resultado.getMaxLetras());
        System.out.println("Patentes:");
        for (String patente : resultado.getPatentes()) {
            System.out.println("- " + patente);
        }
    }

    public void listarVehiculos() {
        System.out.println("\n=== LISTADO DE VEHÍCULOS ===");
        System.out.println("Patente\t\tDueño\t\t\tMinutos");
        System.out.println("------------------------------------------------");

        for (Vehiculo vehiculo : vehiculos) {
            System.out.printf("%-10s\t%-20s\t%d%n",
                    vehiculo.getPatente(),
                    vehiculo.getNombreDueño(),
                    vehiculo.getTiempoEstacionado());
        }
    }

}
