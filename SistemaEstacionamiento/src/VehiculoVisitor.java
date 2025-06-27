public interface VehiculoVisitor {

    void visit(Auto auto);
    void visit(Moto moto);
    void visit(Camion camion);
}
