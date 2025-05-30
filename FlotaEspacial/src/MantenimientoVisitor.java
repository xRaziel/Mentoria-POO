import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MantenimientoVisitor implements NaveVisitor{

    private List<Nave> navesMantenimiento = new ArrayList<>();
    private Map<String,List<Nave>> navesMantenimientoPorTipo = new HashMap<>();


    @Override
    public void visit(CazadorAsteroides cazador) {
        evaluarMantenimiento(cazador);
    }

    @Override
    public void visit(LaboratorioOrbital laboratorio) {
        evaluarMantenimiento(laboratorio);
    }

    @Override
    public void visit(NaveGuerra nave) {
        evaluarMantenimiento(nave);
    }

    @Override
    public void visit(NavePasajeros nave) {
        evaluarMantenimiento(nave);
    }

    private void evaluarMantenimiento(Nave nave) {
        if (!nave.necesitaMantenimiento()) {
            return;
        }

        navesMantenimiento.add(nave);

        String tipo = nave.getTipoNave();
        List<Nave> listaPorTipo = navesMantenimientoPorTipo.get(tipo);

        if (listaPorTipo == null) {
            listaPorTipo = new ArrayList<>();
            navesMantenimientoPorTipo.put(tipo, listaPorTipo);
        }

        listaPorTipo.add(nave);
    }

    public List<Nave> getNavesMantenimiento() {
        return navesMantenimiento;
    }

    public Map<String, List<Nave>> getNavesMantenimientoPorTipo() {
        return navesMantenimientoPorTipo;
    }
}
