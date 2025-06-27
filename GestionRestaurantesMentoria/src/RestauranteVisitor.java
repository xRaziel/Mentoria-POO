public interface RestauranteVisitor {

    void visit(Pizzeria pizzeria);
    void visit(SushiBar sushiBar);
    void visit(AsadorCarnes asador);
    void visit(CafeteriaGourmet cafeteria);
}
