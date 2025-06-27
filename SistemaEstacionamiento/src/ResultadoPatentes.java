public class ResultadoPatentes {

    private int maxLetras;
    private java.util.List<String> patentes;

    public ResultadoPatentes(int maxLetras, java.util.List<String> patentes) {
        this.maxLetras = maxLetras;
        this.patentes = new java.util.ArrayList<>(patentes);
    }

    public int getMaxLetras() { return maxLetras; }
    public java.util.List<String> getPatentes() { return patentes; }
}
