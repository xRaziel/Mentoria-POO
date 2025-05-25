// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstancia();
        sistema.cargarDatos("fauna.txt");
        sistema.analizarDatos();
    }
}