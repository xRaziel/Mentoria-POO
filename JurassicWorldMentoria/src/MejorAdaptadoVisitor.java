public class MejorAdaptadoVisitor implements DinosaurioVisitor{

    private Dinosaurio mejorAdaptado;

    private double mejorTasaAdaptacion = -1;

    private void evaluarAdaptacion(Dinosaurio d){
        double tasaAdaptacion = d.calcularTasaAdaptacion();
        if(tasaAdaptacion > mejorTasaAdaptacion){
            mejorTasaAdaptacion = tasaAdaptacion;
            mejorAdaptado = d;
        }
    }

    @Override
    public void visit(Triceratops triceratops) {
        evaluarAdaptacion(triceratops);
    }

    @Override
    public void visit(Velociraptor velociraptor) {
        evaluarAdaptacion(velociraptor);
    }

    @Override
    public void visit(Tiranosaurio tiranosaurio) {
        evaluarAdaptacion(tiranosaurio);
    }

    @Override
    public void visit(Brachiosaurus brachiosaurus) {
        evaluarAdaptacion(brachiosaurus);
    }

    public Dinosaurio getMejorAdaptado() {
        return mejorAdaptado;
    }

    public double getMejorTasaAdaptacion() {
        return mejorTasaAdaptacion;
    }
}
