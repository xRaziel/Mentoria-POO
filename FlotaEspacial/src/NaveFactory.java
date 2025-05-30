public class NaveFactory {

    public static Nave crearNave(String linea){
        String [] datos = linea.split(",");

        String codigo = datos[0];
        String tipo = datos[1];
        int anioServicio = Integer.parseInt(datos[2]);
        double potenciaMotor = Double.parseDouble(datos[3]);
        double blindaje = Double.parseDouble(datos[4]);
        String estadoOperacional = datos[5];

        switch (tipo){
            case "Cazador de Asteroides":
                int cantTaladros = Integer.parseInt(datos[6]);
                return new CazadorAsteroides(codigo, anioServicio, potenciaMotor, blindaje, estadoOperacional, cantTaladros);
            case "Nave de Pasajeros":
                int cantPasajeros = Integer.parseInt(datos[6]);
                return new NavePasajeros(codigo, anioServicio, potenciaMotor, blindaje, estadoOperacional, cantPasajeros);
            case "Laboratorio Orbital":
                int cantExperimentos = Integer.parseInt(datos[6]);
                return new LaboratorioOrbital(codigo, anioServicio, potenciaMotor, blindaje, estadoOperacional, cantExperimentos);
            case "Nave de Guerra":
                double potenciaArmamento = Double.parseDouble(datos[6]);
                return new NaveGuerra(codigo, anioServicio, potenciaMotor, blindaje, estadoOperacional, potenciaArmamento);
            default:
                throw new IllegalArgumentException("Tipo de nave desconocido: " + tipo);
        }
    }
}
