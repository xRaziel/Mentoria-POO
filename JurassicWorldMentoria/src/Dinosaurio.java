public abstract class Dinosaurio {

    protected String id;
    protected double peso;
    protected double altura;
    protected double velocidad;
    protected String region;

    public Dinosaurio(String id, double peso, double altura, double velocidad, String region) {
        this.id = id;
        this.peso = peso;
        this.altura = altura;
        this.velocidad = velocidad;
        this.region = region;
    }

    public abstract double calcularTasaAdaptacion();

    public abstract void accept(DinosaurioVisitor visitor);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
