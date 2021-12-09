public class Notebook extends Equipamento{
    public void teclar(){
        System.out.println("[Teclando]");
    }

    @Override
    public void ligar() {
        System.out.println("[Notebook ligado]");
        
    }

    @Override
    public void desligar() {
        System.out.println("[Notebook desligado]");
        
    }
}
