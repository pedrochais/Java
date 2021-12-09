public class Televisao extends Equipamento{
    public void assistir(){
        System.out.println("[Assistindo alguma coisa na TV]");
    }

    @Override
    public void ligar() {
        System.out.println("[Televisão ligada]");
        
    }

    @Override
    public void desligar() {
        System.out.println("[Televisão desligada]");
        
    }
}
