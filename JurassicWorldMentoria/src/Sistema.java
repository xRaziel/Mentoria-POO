import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private static Sistema instancia;

    private List<Dinosaurio> dinosaurios;

    private Sistema() {
        dinosaurios = new ArrayList<>();
    }

    public static Sistema getInstancia(){
        if(instancia == null){
            instancia = new Sistema();
        }
        return instancia;
    }

    public void cargarDatos(String archivo){
        try{
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while((linea = br.readLine()) != null){
                Dinosaurio dinosaurio = DinosaurioFactory.crearDinosaurio(linea);
                dinosaurios.add(dinosaurio);
            }
        }catch (IOException e){
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    public void analizarDatos(){
        ContadorHemisferioVisitor contadorHemisferioVisitor = new ContadorHemisferioVisitor();
        ExtremoVisitor extremoVisitor = new ExtremoVisitor();
        MejorAdaptadoVisitor mejorAdaptadoVisitor = new MejorAdaptadoVisitor();

        for(Dinosaurio dinosaurio : dinosaurios){
            dinosaurio.accept(contadorHemisferioVisitor);
            dinosaurio.accept(extremoVisitor);
            dinosaurio.accept(mejorAdaptadoVisitor);
        }
        imprimirResultados(contadorHemisferioVisitor, extremoVisitor, mejorAdaptadoVisitor);
    }

    public void imprimirResultados(ContadorHemisferioVisitor contadorHemisferioVisitor, ExtremoVisitor extremoVisitor, MejorAdaptadoVisitor mejorAdaptadoVisitor){
        System.out.println("En el hemisferio norte hay:");
        for(String especie : contadorHemisferioVisitor.getContadorHemisferio().get("Norte").keySet()){
            System.out.println("Especie: " + especie + " Cantidad: " + contadorHemisferioVisitor.getContadorHemisferio().get("Norte").get(especie));
        }
        System.out.println("En el hemisferio sur hay:");
        for(String especie : contadorHemisferioVisitor.getContadorHemisferio().get("Sur").keySet()){
            System.out.println("Especie: " + especie + " Cantidad: " + contadorHemisferioVisitor.getContadorHemisferio().get("Sur").get(especie));
        }

        System.out.println("El dinosaurio con mayor peso es: " + extremoVisitor.getMasPesado().getId() + " con un peso de: " + extremoVisitor.getMasPesado().getPeso());
        System.out.println("El dinosaurio con mayor altura es: " + extremoVisitor.getMasAlto().getId() + " con una altura de: " + extremoVisitor.getMasAlto().getAltura());
        System.out.println("El dinosaurio con mayor velocidad es: " + extremoVisitor.getMasVeloz().getId() + " con una velocidad de: " + extremoVisitor.getMasVeloz().getVelocidad());

        System.out.println("El dinosaurio con mejor tasa de adaptacion es: " + mejorAdaptadoVisitor.getMejorAdaptado().getId() + " con una tasa de adaptacion de: " + mejorAdaptadoVisitor.getMejorTasaAdaptacion());

    }
}
