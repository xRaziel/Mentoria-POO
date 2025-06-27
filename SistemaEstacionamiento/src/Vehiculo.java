public abstract class Vehiculo {
    protected String rutDueño;
    protected String nombreDueño;
    protected String patente;
    protected String modelo;
    protected int tiempoEstacionado;

    public Vehiculo(String rutDueño, String nombreDueño, String patente, String modelo) {
        this.rutDueño = rutDueño;
        this.nombreDueño = nombreDueño;
        this.patente = patente;
        this.modelo = modelo;
        this.tiempoEstacionado = 0; // Inicializar tiempo estacionado a 0
    }

    public void agregarTiempo(int tiempo){
        this.tiempoEstacionado += tiempo;
    }

    public abstract double calcularTarifa();

    public abstract void accept(VehiculoVisitor visitor);

    public int contarLetrasPatente(){
        int contador = 0;
        for (char c : patente.toCharArray()) {
            if (Character.isLetter(c)) {
                contador++;
            }
        }
        return contador;
    }

    public String getRutDueño() {
        return rutDueño;
    }

    public void setRutDueño(String rutDueño) {
        this.rutDueño = rutDueño;
    }

    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTiempoEstacionado() {
        return tiempoEstacionado;
    }

    public void setTiempoEstacionado(int tiempoEstacionado) {
        this.tiempoEstacionado = tiempoEstacionado;
    }
}
