public class ExtremoVisitor implements DinosaurioVisitor{

    private Dinosaurio masPesado;

    private Dinosaurio masAlto;

    private Dinosaurio masVeloz;

    private void actualizarExtremos(Dinosaurio d){
        if(masPesado == null || d.getPeso() > masPesado.getPeso()){
            masPesado = d;
        }
        if(masAlto == null || d.getAltura() > masAlto.getAltura()){
            masAlto = d;
        }
        if(masVeloz == null || d.getVelocidad() > masVeloz.getVelocidad()){
            masVeloz = d;
        }
    }

    @Override
    public void visit(Tiranosaurio tiranosaurio) {
        actualizarExtremos(tiranosaurio);
    }

    @Override
    public void visit(Triceratops triceratops) {
        actualizarExtremos(triceratops);
    }

    @Override
    public void visit(Velociraptor velociraptor) {
        actualizarExtremos(velociraptor);
    }

    @Override
    public void visit(Brachiosaurus brachiosaurus) {
        actualizarExtremos(brachiosaurus);
    }

    public Dinosaurio getMasPesado() {
        return masPesado;
    }

    public Dinosaurio getMasAlto() {
        return masAlto;
    }

    public Dinosaurio getMasVeloz() {
        return masVeloz;
    }
}
