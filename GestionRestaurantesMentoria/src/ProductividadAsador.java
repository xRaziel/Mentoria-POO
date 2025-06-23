public class ProductividadAsador implements ProductividadStrategy{

    @Override
    public double calcularProductividad(Restaurante restaurante) {
        AsadorCarnes asador = (AsadorCarnes) restaurante;
        return (asador.getParrillasPremium() * asador.getRatingClientes() * asador.getNumeroEmpleados() * 1.2) /
                (asador.getAñosOperacion() * asador.getAñosOperacion());
    }
}
