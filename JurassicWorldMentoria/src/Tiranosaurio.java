public class Tiranosaurio extends Dinosaurio{

    private int cicatrices;

    public Tiranosaurio(String id, double peso, double altura, double velocidad, String region, int cicatrices) {
        super(id, peso, altura, velocidad, region);
        this.cicatrices = cicatrices;
    }

    @Override
    public double calcularTasaAdaptacion() {
        return this.peso/(Math.pow(this.altura,this.cicatrices));
    }

    @Override
    public void accept(DinosaurioVisitor visitor) {
        visitor.visit(this);
    }

    public int getCicatrices() {
        return cicatrices;
    }

    public void setCicatrices(int cicatrices) {
        this.cicatrices = cicatrices;
    }
}
