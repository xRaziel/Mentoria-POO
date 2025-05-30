public interface NaveVisitor {

    void visit(NavePasajeros navePasajeros);
    void visit(NaveGuerra naveGuerra);
    void visit(CazadorAsteroides cazadorAsteroides);
    void visit(LaboratorioOrbital laboratorioOrbital);

}
