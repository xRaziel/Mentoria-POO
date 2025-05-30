import java.util.ArrayList;
import java.util.List;

public class RankingVisitor implements NaveVisitor{

    private List<Nave> naves = new ArrayList<>();

    @Override
    public void visit(NavePasajeros nave) {
        naves.add(nave);
    }

    @Override
    public void visit(NaveGuerra nave) {
        naves.add(nave);
    }

    @Override
    public void visit(CazadorAsteroides cazador) {
        naves.add(cazador);
    }

    @Override
    public void visit(LaboratorioOrbital laboratorio) {
        naves.add(laboratorio);
    }

    public List<Nave> getTop3MayorPotencia() {
        List<Nave> copia = new ArrayList<>(naves);

        copia.sort((a, b) -> Double.compare(b.getPotenciaMotor(), a.getPotenciaMotor()));

        List<Nave> top3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            top3.add(copia.get(i));
        }

        return top3;
    }

    public List<Nave> getTop3MejorBlindaje(){
        List<Nave> copia = new ArrayList<>(naves);

        copia.sort((a, b) -> Double.compare(b.getBlindaje(), a.getBlindaje()));

        List<Nave> top3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            top3.add(copia.get(i));
        }

        return top3;
    }

    public Nave getNaveMasAntigua() {
        if (naves.isEmpty()) {
            return null;
        }

        Nave masAntigua = naves.get(0);
        for (Nave nave : naves) {
            if (nave.getAnioServicio() > masAntigua.getAnioServicio()) {
                masAntigua = nave;
            }
        }
        return masAntigua;
    }

    public Nave getNaveMasNueva(){
        if (naves.isEmpty()) {
            return null;
        }

        Nave masNueva = naves.get(0);
        for (Nave nave : naves) {
            if (nave.getAnioServicio() < masNueva.getAnioServicio()) {
                masNueva = nave;
            }
        }
        return masNueva;
    }
}
