import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // Cargar datos en ambos sistemas
        Sistema sistema = Sistema.getInstance();
        sistema.cargarDatos("vehiculos.txt","estacionamiento.txt");

        // Mostrar interfaz gráfica
        new EstacionamientoGUI(sistema);
    }
}