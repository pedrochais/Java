public class Xbox extends Equipamento{
    public void jogar(){
        System.out.println("[Jogando Red Dead Redemption 2 no Xbox]");
    }

    @Override
    public void ligar() {
        System.out.println("[Xbox ligado]");
        
    }

    @Override
    public void desligar() {
        System.out.println("[Xbox desligado]");
        
    }
}
