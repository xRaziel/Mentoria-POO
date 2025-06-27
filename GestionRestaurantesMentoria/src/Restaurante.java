public abstract class Restaurante {
    protected String codigo;
    protected int añosOperacion;;
    protected int numeroEmpleados;
    protected double ratingClientes;
    protected String estadoFinanciero;

    public Restaurante(String codigo, int añosOperacion, int numeroEmpleados, double ratingClientes, String estadoFinanciero) {
        this.codigo = codigo;
        this.añosOperacion = añosOperacion;
        this.numeroEmpleados = numeroEmpleados;
        this.ratingClientes = ratingClientes;
        this.estadoFinanciero = estadoFinanciero;
    }

    public abstract String getTipo();
    public abstract int getCaracteristicaEspecial();
    public abstract void accept(RestauranteVisitor visitor);

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getAñosOperacion() {
        return añosOperacion;
    }

    public void setAñosOperacion(int añosOperacion) {
        this.añosOperacion = añosOperacion;
    }

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public double getRatingClientes() {
        return ratingClientes;
    }

    public void setRatingClientes(double ratingClientes) {
        this.ratingClientes = ratingClientes;
    }

    public String getEstadoFinanciero() {
        return estadoFinanciero;
    }

    public void setEstadoFinanciero(String estadoFinanciero) {
        this.estadoFinanciero = estadoFinanciero;
    }
}
