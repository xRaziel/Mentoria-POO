import java.util.ArrayList;
import java.util.List;

public class BuscadorPatenteVisitor implements VehiculoVisitor{

    private int maxLetras;
    private List<String> patentesMaxLetras  = new ArrayList<>();

    @Override
    public void visit(Auto auto) {
        procesarPatente(auto.getPatente());
    }

    @Override
    public void visit(Camion camion) {
        procesarPatente(camion.getPatente());
    }

    @Override
    public void visit(Moto moto) {
        procesarPatente(moto.getPatente());
    }

    private void procesarPatente(String patente) {
        int letras = contarLetras(patente);
        if (letras > maxLetras) {
            maxLetras = letras;
            patentesMaxLetras.clear();
            patentesMaxLetras.add(patente);
        } else if (letras == maxLetras) {
            patentesMaxLetras.add(patente);
        }
    }

    private int contarLetras(String patente) {
        int count = 0;
        for (char c : patente.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }
    public List<String> getPatentesMaxLetras() {
        return patentesMaxLetras;
    }
    public int getMaxLetras() {
        return maxLetras;
    }


}
