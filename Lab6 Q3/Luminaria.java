public class Luminaria extends Equipamento{
    public void quebrar(){
        System.out.println("[Quebrou a luminária]"); //nao sei o que botar aqui
    }

    @Override
    public void ligar() {
        System.out.println("[Luminaria ligada]");
        
    }

    @Override
    public void desligar() {
        System.out.println("[Luminaria desligada]");
    }
}
