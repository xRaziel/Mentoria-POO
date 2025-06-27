import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Configurar Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cargar datos en ambos sistemas
        Sistema sistema = Sistema.getInstance();
        sistema.cargarDatos("vehiculos.txt","estacionamiento.txt");

        // Mostrar interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            new EstacionamientoGUI(sistema);
        });
    }
}