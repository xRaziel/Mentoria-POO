public class CalcularProductividad {

    private ProductividadStrategy strategy;

    public void setStrategy(ProductividadStrategy strategy) {
        this.strategy = strategy;
    }

    public double calcular(Restaurante restaurante) {
        if (restaurante == null) {
            throw new IllegalArgumentException("El restaurante no puede ser nulo");
        }
        return strategy.calcularProductividad(restaurante);
    }
}
