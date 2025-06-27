public class ProductividadPizzeria implements ProductividadStrategy{

    @Override
    public double calcularProductividad(Restaurante restaurante) {
        Pizzeria pizzeria = (Pizzeria) restaurante;
        return (pizzeria.getHornosOperativos() * pizzeria.getRatingClientes() * pizzeria.getNumeroEmpleados()) /
                (pizzeria.getAñosOperacion() * 5.0);
    }
}
