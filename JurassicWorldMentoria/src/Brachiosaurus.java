public class Brachiosaurus extends Dinosaurio{

    private double largoCuello;

    public Brachiosaurus(String id, double peso, double altura, double velocidad, String region, double largoCuello) {
        super(id, peso, altura, velocidad, region);
        this.largoCuello = largoCuello;
    }

    @Override
    public double calcularTasaAdaptacion() {
        return (this.altura-this.largoCuello)*this.peso;
    }

    @Override
    public void accept(DinosaurioVisitor visitor) {
        visitor.visit(this);
    }

    public double getLargoCuello() {
        return largoCuello;
    }

    public void setLargoCuello(double largoCuello) {
        this.largoCuello = largoCuello;
    }
}
