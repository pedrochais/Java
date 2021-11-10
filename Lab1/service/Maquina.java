package service;

import java.util.ArrayList;
import entity.Ticket;

public class Maquina {
    private ArrayList<Ticket> emissoes;

    public Maquina(){
        emissoes = new ArrayList<>();
    }

    public Ticket emitir(float valor){
        Ticket ticket = new Ticket(emissoes.size(), valor);
        emissoes.add(ticket);

        System.out.println("[Ticket de número " + emissoes.size() + " emitido]");

        return ticket;
    }

    public void pagar(int numero){
        for(int i = 0; i < emissoes.size(); i++){
            if(emissoes.get(i).getNumero() == numero){
                emissoes.get(i).changeStatus();
            }
        }
    }
    
    public float saldo(){
        float temp = 0;
        for(int i = 0; i < emissoes.size(); i++){
            temp += emissoes.get(i).getValor();
        }
        return temp;
    }

    public void status(int numero){
        for(int i = 0; i < emissoes.size(); i++){
            if(emissoes.get(i).getNumero() == numero){
                boolean status = emissoes.get(i).getStatus();
                if(status) System.out.println("[Ticket de número " + numero + " - Pago]");
                else System.out.println("[Ticket de número " + numero + " - Não pago]");
            }
        }
    }
}
