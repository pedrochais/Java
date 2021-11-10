package entity;

public class Ticket{
    private int numero;     //número de identificação do ticket
    private float valor;    //preço do ticket
    private boolean pago;   //se está pago ou não

    public Ticket(int numero, float valor){
        this.numero = numero;
        this.valor = valor;
        this.pago = false;
    }

    public void changeStatus(){
        if(this.pago) this.pago = true;
        else this.pago = false;
    }

    public int getNumero(){
        return this.numero;
    }

    public float getValor(){
        return this.valor;
    }

    public boolean getStatus(){
        return this.pago;
    }
}