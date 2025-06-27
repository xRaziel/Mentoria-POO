import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraControlador implements ActionListener{

    private CalculadoraModelo modelo;
    private CalculadoraVista vista;

    public CalculadoraControlador(CalculadoraModelo modelo,CalculadoraVista vista){
        this.modelo = modelo;
        this.vista = vista;

        this.agregarListeners();
    }

    private void agregarListeners(){
        //Botones numericos
        for(int i = 0; i < 10; i++){
            vista.getBotonesNumeros()[i].addActionListener(this);
        }

        //Botones operadores
        for(int i = 0; i < 4; i++){
            vista.getBotonesOperadores()[i].addActionListener(this);
        }

        //Botones adicionales
        vista.getBotonIgual().addActionListener(this);
        vista.getBotonClear().addActionListener(this);
        vista.getBotonPunto().addActionListener(this);
        vista.getBotonDelete().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String comando = e.getActionCommand();

        if(this.esNumero(comando)){
            this.manejarNumero(comando);
        }else if(this.esOperador(comando)){
            this.manejarOperador(comando);
        } else{
            this.manejarAccionAdicional(comando);
        }
    }

    private boolean esNumero(String comando){
        try{
            Integer.parseInt(comando);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }

    private void manejarNumero(String numero){
        if(this.modelo.isNuevaOperacion()){
            vista.getPantalla().setText(numero);
            modelo.setNuevaOperacion(false);
        } else{
            String textoActual = vista.getPantalla().getText();
            if(textoActual.equals("0")){
                vista.getPantalla().setText(numero);
            }else{
                vista.getPantalla().setText(textoActual + numero);
            }
        }
    }

    private boolean esOperador(String comando){
        return comando.equals("+") || comando.equals("-") || comando.equals("*") || comando.equals("/");
    }

    private void manejarOperador(String comando){
        double numeroActual = Double.parseDouble(vista.getPantalla().getText());
        modelo.setNumero1(numeroActual);
        modelo.setOperador(comando);
        modelo.setNuevaOperacion(true);
    }

    private void manejarAccionAdicional(String comando){
        switch (comando){
            case "=":
                this.calcular();
                break;
            case "C":
                this.limpiar();
                break;
            case "DEL":
                this.borrarUltimoDigito();
            case ".":
                this.agregarPuntoDecimal();
                break;
        }
    }

    private void calcular(){
        try{
            double numero2 = Double.parseDouble(vista.getPantalla().getText());
            modelo.setNumero2(numero2);

            double resultado = modelo.calcular();

            if(resultado == (long) resultado){
                vista.getPantalla().setText(String.valueOf((long) resultado));
            }else{
                vista.getPantalla().setText(String.valueOf(resultado));
            }
            modelo.setNuevaOperacion(true);
        }catch (ArithmeticException e){
            vista.getPantalla().setText("Error");
            modelo.reset();
        }catch (NumberFormatException e){
            vista.getPantalla().setText("Error");
            modelo.reset();
        }
    }

    private void limpiar(){
        modelo.reset();
        vista.getPantalla().setText("0");
    }

    private void borrarUltimoDigito(){
        String textoActual = vista.getPantalla().getText();
        if(textoActual.length() > 1){
            vista.getPantalla().setText(textoActual.substring(0, textoActual.length() - 1));
        } else {
            vista.getPantalla().setText("0");
        }
    }

    private void agregarPuntoDecimal(){
        String textoActual = vista.getPantalla().getText();
        if (!textoActual.contains(".")) {
            vista.getPantalla().setText(textoActual + ".");
        }
    }

}
