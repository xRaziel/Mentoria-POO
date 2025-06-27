public class Factory {

    public static Restaurante crearRestaurante(String linea){
        String[] partes = linea.split(",");
        String codigo = partes[0];
        String tipo = partes[1];
        int añosOperacion = Integer.parseInt(partes[2]);
        int numeroEmpleados = Integer.parseInt(partes[3]);
        double ratingClientes = Double.parseDouble(partes[4]);
        String estadoFinanciero = partes[5];

        switch (tipo) {
            case "CafeteriaGourmet":
                int maquinasCafe = Integer.parseInt(partes[6].trim());
                return new CafeteriaGourmet(codigo, añosOperacion, numeroEmpleados, ratingClientes, estadoFinanciero, maquinasCafe);
            case "AsadorCarnes":
                int parrillasPremium = Integer.parseInt(partes[6].trim());
                return new AsadorCarnes(codigo, añosOperacion, numeroEmpleados, ratingClientes, estadoFinanciero, parrillasPremium);
            case "Pizzeria":
                int hornos = Integer.parseInt(partes[6].trim());
                return new Pizzeria(codigo, añosOperacion, numeroEmpleados, ratingClientes, estadoFinanciero, hornos);
            case "SushiBar":
                int mesas = Integer.parseInt(partes[6].trim());
                return new SushiBar(codigo, añosOperacion, numeroEmpleados, ratingClientes, estadoFinanciero, mesas);
            default:
                throw new IllegalArgumentException("Tipo de restaurante desconocido: " + tipo);
        }
    }
}
