package atividade;

public class Prova extends Atividade{
    private String bimestre;

    public Prova(String assunto, String data, String bimestre) {
        super(assunto, data);
        this.bimestre = bimestre;
    }

    public String getBimestre(){
        return this.bimestre;
    }

    @Override
    public String toString(){
        return "\n ╥[Prova]\n ╠ Assunto: "+assunto+"\n ╠ Bimestre: "+bimestre+"\n ╚ Data: "+data;
    }
}
