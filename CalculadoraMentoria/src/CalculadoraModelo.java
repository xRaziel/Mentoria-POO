public class CalculadoraModelo {
    private double numero1;

    private double numero2;

    private double resultado;

    private String operador;

    private boolean nuevaOperacion;

    public CalculadoraModelo(){
        this.reset();
    }

    public void reset(){
        this.numero1 = 0.0;
        this.numero2 = 0.0;
        this.resultado = 0.0;
        this.operador = "";
        this.nuevaOperacion = true;
    }

    public double calcular(){
        switch (operador){
            case "+":
                resultado = numero1 + numero2;
                break;
            case "-":
                resultado = numero1 - numero2;
                break;
            case "*":
                resultado = numero1 * numero2;
                break;
            case "/":
                if(this.numero2 != 0){
                    resultado = numero1 / numero2;
                } else{
                    throw new ArithmeticException("No se puede dividir por cero.");
                }
                break;
            default:
                resultado = this.numero2;
        }
        return resultado;
    }

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public boolean isNuevaOperacion() {
        return nuevaOperacion;
    }

    public void setNuevaOperacion(boolean nuevaOperacion) {
        this.nuevaOperacion = nuevaOperacion;
    }
}
