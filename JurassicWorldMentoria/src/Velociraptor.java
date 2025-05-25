public class Velociraptor extends Dinosaurio{

    private double distancia;

    public Velociraptor(String id, double peso, double altura, double velocidad, String region, double distancia) {
        super(id, peso, altura, velocidad, region);
        this.distancia = distancia;
    }

    @Override
    public double calcularTasaAdaptacion() {
        return this.distancia/this.velocidad;
    }

    @Override
    public void accept(DinosaurioVisitor visitor) {
        visitor.visit(this);
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}
