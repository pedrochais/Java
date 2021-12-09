public class Ventilador extends Equipamento{
    public void botarPraGirar(){
        System.out.println("[Ventilador tá girando]");
    }

    @Override
    public void ligar() {
        System.out.println("[Ventilador ligado]");
    }

    @Override
    public void desligar() {
        System.out.println("[Ventilador desligado]");
        
    }
}
