public class DinosaurioFactory {

    public static Dinosaurio crearDinosaurio(String linea){
        String [] partes = linea.split(",");

        String id = partes[0];
        String especie = partes[1];
        double peso = Double.parseDouble(partes[2]);
        double altura = Double.parseDouble(partes[3]);
        double velocidad = Double.parseDouble(partes[4]);
        String region = partes[5];
        String caracteristica = partes[6];

        switch(especie){
            case "Tiranosaurio":
                return new Tiranosaurio(id, peso, altura, velocidad, region, Integer.parseInt(caracteristica));
            case "Triceratops":
                return new Triceratops(id, peso, altura, velocidad, region, caracteristica.toUpperCase());
            case "Velociraptor":
                return new Velociraptor(id, peso, altura, velocidad, region, Double.parseDouble(caracteristica));
            case "Brachiosaurus":
                return new Brachiosaurus(id, peso, altura, velocidad, region, Double.parseDouble(caracteristica));
            default:
                throw new IllegalArgumentException("Especie de dinosaurio no reconocida: " + especie);
        }
    }
}
