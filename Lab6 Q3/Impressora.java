public class Impressora extends Equipamento{
    public void imprimir(){
        System.out.println("[A impressora imprimiu algo]");
    }

    @Override
    public void ligar() {
        System.out.println("[Impressora ligada]");
        
    }

    @Override
    public void desligar() {
        System.out.println("[Impressora desligada]");
        
    }
}
