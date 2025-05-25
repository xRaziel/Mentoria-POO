import java.util.HashMap;
import java.util.Map;

public class ContadorHemisferioVisitor implements DinosaurioVisitor{

    private Map<String, Map<String,Integer>> contadorHemisferio; // {region -> {especie -> cantidad}}

    public ContadorHemisferioVisitor(){
        contadorHemisferio = new HashMap<>();
        contadorHemisferio.put("Norte", new HashMap<>());
        contadorHemisferio.put("Sur", new HashMap<>());
    }

    private void incrementarContador(String especie, String region){
        contadorHemisferio.get(region).put(especie,
                contadorHemisferio.get(region).getOrDefault(especie, 0) + 1);
    }

    @Override
    public void visit(Triceratops triceratops) {
        incrementarContador("Triceratops", triceratops.getRegion());
    }

    @Override
    public void visit(Brachiosaurus brachiosaurus) {
        incrementarContador("Brachiosaurus", brachiosaurus.getRegion());
    }

    @Override
    public void visit(Velociraptor velociraptor) {
        incrementarContador("Velociraptor", velociraptor.getRegion());
    }

    @Override
    public void visit(Tiranosaurio tiranosaurio) {
        incrementarContador("Tiranosaurio", tiranosaurio.getRegion());
    }

    public Map<String, Map<String, Integer>> getContadorHemisferio() {
        return contadorHemisferio;
    }
}
