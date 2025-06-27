public class VehiculoFactory {

    public static Vehiculo crearVehiculo(String linea) {
        String[] partes = linea.split(",");

        String rutDueño = partes[0].trim();
        String nombreDueño = partes[1].trim();
        String patente = partes[2].trim();
        String tipo = partes[3].trim();
        String modelo = partes[4].trim();
        String caracteristicaExtra = partes[5].trim();

        switch (tipo.toLowerCase()) {
            case "auto":
                return new Auto(rutDueño, nombreDueño, patente, modelo,
                        Integer.parseInt(caracteristicaExtra));
            case "camion":
                return new Camion(rutDueño, nombreDueño, patente, modelo,
                        Double.parseDouble(caracteristicaExtra));
            case "moto":
                return new Moto(rutDueño, nombreDueño, patente, modelo,
                        Integer.parseInt(caracteristicaExtra));
            default:
                throw new IllegalArgumentException("Tipo de vehículo no válido: " + tipo);
        }
    }
}
