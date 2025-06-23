public class ProductividadSushi implements ProductividadStrategy{

    @Override
    public double calcularProductividad(Restaurante restaurante) {
        SushiBar sushiBar = (SushiBar) restaurante;
        double multiplicador = sushiBar.getRatingClientes() > 4.0 ? 100.0 : 80.0;
        return (sushiBar.getChefsEspecializados() * sushiBar.getRatingClientes() * multiplicador) /
                sushiBar.getAñosOperacion();
    }
}
