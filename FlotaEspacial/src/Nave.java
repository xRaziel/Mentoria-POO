public abstract class Nave {

    protected String codigo;
    protected int anioServicio;
    protected double potenciaMotor;
    protected double blindaje;
    protected String estadoOperacional;

    public Nave(String codigo, int anioServicio, double potenciaMotor, double blindaje, String estadoOperacional) {
        this.codigo = codigo;
        this.anioServicio = anioServicio;
        this.potenciaMotor = potenciaMotor;
        this.blindaje = blindaje;
        this.estadoOperacional = estadoOperacional;
    }

    public abstract void accept(NaveVisitor visitor);

    public abstract String getTipoNave();

    public abstract boolean necesitaMantenimiento();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getAnioServicio() {
        return anioServicio;
    }

    public void setAnioServicio(int anioServicio) {
        this.anioServicio = anioServicio;
    }

    public double getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(double potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public double getBlindaje() {
        return blindaje;
    }

    public void setBlindaje(double blindaje) {
        this.blindaje = blindaje;
    }

    public String getEstadoOperacional() {
        return estadoOperacional;
    }

    public void setEstadoOperacional(String estadoOperacional) {
        this.estadoOperacional = estadoOperacional;
    }
}
