public class Triceratops extends Dinosaurio{

    private String plantaFav;

    public Triceratops(String id, double peso, double altura, double velocidad, String region, String plantaFav) {
        super(id, peso, altura, velocidad, region);
        this.plantaFav = plantaFav;
    }

    @Override
    public double calcularTasaAdaptacion() {
        if(this.plantaFav.equals("HELECHOS")){
            return (this.peso*this.velocidad)/2;
        }
        return (this.peso*this.velocidad)/3;
    }

    @Override
    public void accept(DinosaurioVisitor visitor) {
        visitor.visit(this);
    }

    public String getPlantaFav() {
        return plantaFav;
    }

    public void setPlantaFav(String plantaFav) {
        this.plantaFav = plantaFav;
    }
}
