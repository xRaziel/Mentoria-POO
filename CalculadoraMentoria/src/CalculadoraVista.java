import javax.swing.*;
import java.awt.*;

public class CalculadoraVista extends JFrame {
    private JTextField pantalla;
    private JButton[] botonesNumeros;
    private JButton[] botonesOperadores;
    private JButton botonIgual, botonClear, botonDelete, botonPunto;

    public CalculadoraVista(){
        this.configurarVentana();
        this.inicializarComponentes();
        this.configurarLayout();
    }

    private void configurarVentana(){
        setTitle("Calculadora Mentoria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,600);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicializarComponentes(){
        // Inicializar pantalla
        pantalla = new JTextField();
        pantalla.setFont(new Font("Arial",Font.BOLD,24));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setText("0");
        pantalla.setBackground(Color.WHITE);
        pantalla.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Inicializar botones numéricos
        botonesNumeros = new JButton[10];
        for(int i = 0; i < 10; i++){
            botonesNumeros[i] = this.crearBotonNumerico(String.valueOf(i));
        }

        // Inicializar botones de operadores
        botonesOperadores = new JButton[4];
        botonesOperadores[0] = this.crearBotonOperador("+");
        botonesOperadores[1] = this.crearBotonOperador("-");
        botonesOperadores[2] = this.crearBotonOperador("*");
        botonesOperadores[3] = this.crearBotonOperador("/");

        // Inicializar botones adicionales
        botonIgual = this.crearBotonOperador("=");
        botonPunto = this.crearBotonNumerico(".");
        botonClear = this.crearBotonAdicional("C");
        botonDelete = this.crearBotonAdicional("DEL");
    }

    private JButton crearBotonNumerico(String texto){
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial",Font.BOLD,20));
        boton.setFocusable(false);
        boton.setBackground(new Color(240,240,240));
        return boton;
    }

    private JButton crearBotonOperador(String texto){
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial",Font.BOLD,20));
        boton.setFocusable(false);
        boton.setBackground(new Color(255,165,0));
        boton.setForeground(Color.WHITE);
        return boton;
    }

    private JButton crearBotonAdicional(String texto){
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial",Font.BOLD,20));
        boton.setFocusable(false);
        boton.setBackground(new Color(255,100,100));
        boton.setForeground(Color.WHITE);
        return boton;
    }

    private void configurarLayout(){
        setLayout(new BorderLayout());

        //Panel de pantalla
        JPanel panelPantalla = new JPanel(new BorderLayout());
        panelPantalla.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelPantalla.add(pantalla);

        //Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5,4,5,5));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //Agregar botones al panel
        this.agregarBotonesNumericos(panelBotones);

        add(panelPantalla, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
    }

    private void agregarBotonesNumericos(JPanel panel){

        //Primera fila
        panel.add(botonClear);
        panel.add(botonDelete);
        panel.add(botonesOperadores[3]);
        panel.add(botonesOperadores[2]);

        //Segunda fila
        panel.add(botonesNumeros[7]);
        panel.add(botonesNumeros[8]);
        panel.add(botonesNumeros[9]);
        panel.add(botonesOperadores[1]);

        //Tercera fila
        panel.add(botonesNumeros[4]);
        panel.add(botonesNumeros[5]);
        panel.add(botonesNumeros[6]);
        panel.add(botonesOperadores[0]);

        //Cuarta fila
        panel.add(botonesNumeros[1]);
        panel.add(botonesNumeros[2]);
        panel.add(botonesNumeros[3]);
        panel.add(botonIgual);

        //Quinta fila
        panel.add(botonesNumeros[0]);
        panel.add(new JLabel()); //Espacio vacio
        panel.add(botonPunto);
        panel.add(new JLabel()); //Espacio vacio

    }

    public JTextField getPantalla() {
        return pantalla;
    }

    public void setPantalla(JTextField pantalla) {
        this.pantalla = pantalla;
    }

    public JButton[] getBotonesNumeros() {
        return botonesNumeros;
    }

    public void setBotonesNumeros(JButton[] botonesNumeros) {
        this.botonesNumeros = botonesNumeros;
    }

    public JButton[] getBotonesOperadores() {
        return botonesOperadores;
    }

    public void setBotonesOperadores(JButton[] botonesOperadores) {
        this.botonesOperadores = botonesOperadores;
    }

    public JButton getBotonIgual() {
        return botonIgual;
    }

    public void setBotonIgual(JButton botonIgual) {
        this.botonIgual = botonIgual;
    }

    public JButton getBotonClear() {
        return botonClear;
    }

    public void setBotonClear(JButton botonClear) {
        this.botonClear = botonClear;
    }

    public JButton getBotonDelete() {
        return botonDelete;
    }

    public void setBotonDelete(JButton botonDelete) {
        this.botonDelete = botonDelete;
    }

    public JButton getBotonPunto() {
        return botonPunto;
    }

    public void setBotonPunto(JButton botonPunto) {
        this.botonPunto = botonPunto;
    }
}
