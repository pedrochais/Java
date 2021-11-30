package atividade;

public class Exercicio extends Atividade{

    public Exercicio(String assunto, String data) {
        super(assunto, data);
    }

    @Override
    public String toString(){
        return "\n ╥[Exercicio]\n ╠ Assunto: "+assunto+"\n ╚ Data: "+data;
    }
}
