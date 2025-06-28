import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;

public class EstacionamientoGUI extends JFrame {

    private JTextArea resultadosArea;
    private Sistema sistema;

    public EstacionamientoGUI(Sistema sistema) {
        this.sistema = sistema;
        inicializarGUI();
        mostrarBienvenida();
    }

    private void inicializarGUI() {
        setTitle("Sistema de Gestión de Estacionamiento UCN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de botones
        JPanel panelBotones = crearPanelBotones();
        add(panelBotones, BorderLayout.NORTH);

        // Área de texto principal
        resultadosArea = new JTextArea(25, 80);
        resultadosArea.setFont(new Font("Courier New", Font.PLAIN, 12));
        resultadosArea.setEditable(false);
        resultadosArea.setBackground(Color.WHITE);

        JScrollPane scrollResultados = new JScrollPane(resultadosArea);
        scrollResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));

        add(scrollResultados, BorderLayout.CENTER);

        setSize(900, 750);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Opciones"));
        panel.setBackground(new Color(240, 240, 240));

        // Botón para mostrar totales de dinero
        JButton btnTotales = new JButton("💰 Mostrar Totales");
        btnTotales.setFont(new Font("Arial", Font.BOLD, 12));
        btnTotales.setBackground(new Color(76, 175, 80));
        btnTotales.setForeground(Color.BLACK);
        btnTotales.addActionListener(e -> mostrarTotales());

        // Botón para mostrar patentes con más letras
        JButton btnPatentes = new JButton("🔤 Patentes con más letras");
        btnPatentes.setFont(new Font("Arial", Font.BOLD, 12));
        btnPatentes.setBackground(new Color(135, 206, 250));
        btnPatentes.setForeground(Color.BLACK);
        btnPatentes.addActionListener(e -> mostrarPatentesConMasLetras());

        // Botón para listar vehículos
        JButton btnListar = new JButton("🚗 Listar Vehículos");
        btnListar.setFont(new Font("Arial", Font.BOLD, 12));
        btnListar.setBackground(new Color(255, 193, 7));
        btnListar.setForeground(Color.BLACK);
        btnListar.addActionListener(e -> mostrarListadoVehiculos());

        // Botón para mostrar todos los resultados
        JButton btnTodos = new JButton("📊 Mostrar Todo");
        btnTodos.setFont(new Font("Arial", Font.BOLD, 12));
        btnTodos.setBackground(new Color(220, 120, 240));
        btnTodos.setForeground(Color.BLACK);
        btnTodos.addActionListener(e -> mostrarTodosLosResultados());

        // Botón para limpiar
        JButton btnLimpiar = new JButton("🗑️ Limpiar");
        btnLimpiar.setFont(new Font("Arial", Font.BOLD, 12));
        btnLimpiar.setBackground(new Color(255, 87, 87));
        btnLimpiar.setForeground(Color.BLACK);
        btnLimpiar.addActionListener(e -> limpiarResultados());

        panel.add(btnTotales);
        panel.add(btnPatentes);
        panel.add(btnListar);
        panel.add(btnTodos);
        panel.add(btnLimpiar);

        return panel;
    }

    private void mostrarBienvenida() {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("    SISTEMA DE GESTIÓN DE ESTACIONAMIENTO UCN\n");
        sb.append("========================================\n\n");
        sb.append("¡Bienvenido al Sistema de Gestión de Estacionamiento!\n\n");
        sb.append("Use los botones de arriba para:\n");
        sb.append("• 💰 Ver totales de dinero recaudado\n");
        sb.append("• 🔤 Ver patentes con más letras\n");
        sb.append("• 🚗 Listar todos los vehículos\n");
        sb.append("• 📊 Ver todos los resultados\n");
        sb.append("• 🗑️ Limpiar pantalla\n\n");
        sb.append("Datos cargados: ").append(sistema.getVehiculos().size()).append(" vehículos\n");
        
        resultadosArea.setText(sb.toString());
    }

    private void mostrarResultados(Sistema sistema) {
        StringBuilder sb = new StringBuilder();

        sb.append("========================================\n");
        sb.append("         REPORTE COMPLETO DEL SISTEMA\n");
        sb.append("========================================\n");
        agregarResultadosSistema(sb, sistema);

        resultadosArea.setText(sb.toString());
    }

    private void agregarResultadosSistema(StringBuilder sb, Sistema sistema) {
        ResultadosTotales totales = sistema.obtenerTotales();
        sb.append("\n💰 === TOTALES DE DINERO RECAUDADO ===\n");
        sb.append(String.format("🚗 Autos con más de 6 asientos: $%.2f\n", totales.getTotalAutosMas6Asientos()));
        sb.append(String.format("🚛 Camiones que soportan menos de 2 toneladas: $%.2f\n", totales.getTotalCamionesMenos2Toneladas()));
        sb.append("----------------------------------------\n");
        sb.append(String.format("💵 Total general: $%.2f\n", totales.getTotalGeneral()));

        ResultadoPatentes patentes = sistema.obtenerPatentesConMasLetras();
        sb.append("\n🔤 === PATENTES CON MÁS LETRAS ===\n");
        sb.append("📊 Número máximo de letras: ").append(patentes.getMaxLetras()).append("\n");
        sb.append("📝 Patentes:\n");
        for (String patente : patentes.getPatentes()) {
            sb.append("• ").append(patente).append("\n");
        }

        sb.append("\n🚗 === LISTADO DE VEHÍCULOS ===\n");
        sb.append(String.format("%-12s %-25s %-10s\n", "PATENTE", "DUEÑO", "MINUTOS"));
        sb.append("------------------------------------------------------\n");
        for (Vehiculo vehiculo : sistema.getVehiculos()) {
            sb.append(String.format("%-12s %-25s %-10d\n",
                    vehiculo.getPatente(),
                    vehiculo.getNombreDueño(),
                    vehiculo.getTiempoEstacionado()));
        }
        sb.append("\n📊 Total de vehículos: ").append(sistema.getVehiculos().size());
    }

    private void mostrarTotales() {
        StringBuilder sb = new StringBuilder();
        ResultadosTotales totales = sistema.obtenerTotales();
        
        sb.append("========================================\n");
        sb.append("         TOTALES DE DINERO RECAUDADO\n");
        sb.append("========================================\n\n");
        
        sb.append(String.format("💰 Autos con más de 6 asientos: $%.2f\n", totales.getTotalAutosMas6Asientos()));
        sb.append(String.format("🚛 Camiones que soportan menos de 2 toneladas: $%.2f\n", totales.getTotalCamionesMenos2Toneladas()));
        sb.append("----------------------------------------\n");
        sb.append(String.format("💵 TOTAL GENERAL: $%.2f\n", totales.getTotalGeneral()));
        
        resultadosArea.setText(sb.toString());
    }

    private void mostrarPatentesConMasLetras() {
        StringBuilder sb = new StringBuilder();
        ResultadoPatentes patentes = sistema.obtenerPatentesConMasLetras();
        
        sb.append("========================================\n");
        sb.append("         PATENTES CON MÁS LETRAS\n");
        sb.append("========================================\n\n");
        
        sb.append("🔤 Número máximo de letras: ").append(patentes.getMaxLetras()).append("\n\n");
        sb.append("📝 Patentes encontradas:\n");
        sb.append("------------------------\n");
        
        for (String patente : patentes.getPatentes()) {
            sb.append("• ").append(patente).append("\n");
        }
        
        resultadosArea.setText(sb.toString());
    }

    private void mostrarListadoVehiculos() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("========================================\n");
        sb.append("           LISTADO DE VEHÍCULOS\n");
        sb.append("========================================\n\n");
        
        sb.append(String.format("%-12s %-25s %-10s\n", "PATENTE", "DUEÑO", "MINUTOS"));
        sb.append("------------------------------------------------------\n");
        
        for (Vehiculo vehiculo : sistema.getVehiculos()) {
            sb.append(String.format("%-12s %-25s %-10d\n",
                    vehiculo.getPatente(),
                    vehiculo.getNombreDueño(),
                    vehiculo.getTiempoEstacionado()));
        }
        
        sb.append("\n📊 Total de vehículos: ").append(sistema.getVehiculos().size());
        
        resultadosArea.setText(sb.toString());
    }

    private void mostrarTodosLosResultados() {
        mostrarResultados(sistema);
    }

    private void limpiarResultados() {
        mostrarBienvenida();
    }
}
