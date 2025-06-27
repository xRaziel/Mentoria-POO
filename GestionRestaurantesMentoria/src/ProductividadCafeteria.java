public class ProductividadCafeteria implements ProductividadStrategy{

    @Override
    public double calcularProductividad(Restaurante restaurante) {
        CafeteriaGourmet cafeteria = (CafeteriaGourmet) restaurante;
        return (cafeteria.getMaquinasCafe() * cafeteria.getRatingClientes() * 75.0) /
                (cafeteria.getAñosOperacion() + cafeteria.getNumeroEmpleados());
    }
}
