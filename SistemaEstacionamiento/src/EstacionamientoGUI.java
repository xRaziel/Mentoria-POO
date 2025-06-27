import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;

public class EstacionamientoGUI extends JFrame {

    private JTextArea resultadosArea;

    public EstacionamientoGUI(Sistema sistema) {
        inicializarGUI();
        mostrarResultados(sistema);
    }

    private void inicializarGUI() {
        setTitle("Sistema de Gestión de Estacionamiento UCN - Resultados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área de texto principal
        resultadosArea = new JTextArea(25, 80);
        resultadosArea.setFont(new Font("Courier New", Font.PLAIN, 12));
        resultadosArea.setEditable(false);
        resultadosArea.setBackground(Color.WHITE);

        JScrollPane scrollResultados = new JScrollPane(resultadosArea);
        scrollResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));

        add(scrollResultados, BorderLayout.CENTER);

        setSize(800, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrarResultados(Sistema sistema) {
        StringBuilder sb = new StringBuilder();

        // Sistema Normal
        sb.append("========================================\n");
        sb.append("         SISTEMA NORMAL\n");
        sb.append("========================================\n");
        agregarResultadosSistema(sb, sistema);

        resultadosArea.setText(sb.toString());
    }

    private void agregarResultadosSistema(StringBuilder sb, Sistema sistema) {
        ResultadosTotales totales = sistema.obtenerTotales();
        sb.append("\n=== TOTALES DE DINERO RECAUDADO ===\n");
        sb.append("Autos con más de 6 asientos: ").append(totales.getTotalAutosMas6Asientos()).append("\n");
        sb.append("Camiones que soportan menos de 2 toneladas: ").append(totales.getTotalCamionesMenos2Toneladas()).append("\n");
        sb.append("Total general: ").append(totales.getTotalGeneral()).append("\n");

        ResultadoPatentes patentes = sistema.obtenerPatentesConMasLetras();
        sb.append("\n=== PATENTES CON MÁS LETRAS ===\n");
        sb.append("Número máximo de letras: ").append(patentes.getMaxLetras()).append("\n");
        sb.append("Patentes:\n");
        for (String patente : patentes.getPatentes()) {
            sb.append("- ").append(patente).append("\n");
        }

        sb.append("\n=== LISTADO DE VEHÍCULOS ===\n");
        sb.append("Patente\t\tDueño\t\t\tMinutos\n");
        sb.append("------------------------------------------------\n");
        for (Vehiculo vehiculo : sistema.getVehiculos()) {
            sb.append(String.format("%-10s\t%-20s\t%d\n",
                    vehiculo.getPatente(),
                    vehiculo.getNombreDueño(),
                    vehiculo.getTiempoEstacionado()));
        }
    }
}
