package pessoa;

import java.util.ArrayList;

import atividade.Atividade;
import entidades.*;

public class Aluno extends Pessoa{
    private ArrayList<Atividade> atividades;
    private boolean matriculado_local;
    private boolean matriculado_global;
    private boolean frequencia;
    private float nota;

    public Aluno(int codigo, String nome, String email, String cpf) {
        super(codigo, nome, email, cpf);
        this.matriculado_local = false;
        this.matriculado_global = false;
        atividades = new ArrayList<>();
        nota = 0;
    }

    public String getNome(){
        return this.nome;
    }

    public boolean getMatriculadoL(){
        return this.matriculado_local;
    }

    public boolean getMatriculadoG(){
        return this.matriculado_global;
    }

    public boolean getFrequencia(){
        return this.frequencia;
    }

    public float getNota(){
        return this.nota;
    }

    public ArrayList<Atividade> getAtividades(){
        return this.atividades;
    }

    public void setMatriculadoL(boolean matriculado){
        this.matriculado_local = matriculado;
    }

    public void setMatriculadoG(boolean matriculado){
        this.matriculado_global = matriculado;
    }

    public void setFrequencia(boolean frequencia){
        this.frequencia = frequencia;
    }

    public void setNota(float nota){
        this.nota = nota;
    }

    public void addAtividade(Atividade atividade){
        boolean existe = false;

        for(int i = 0; i < atividades.size(); i++){
            if(atividade == atividades.get(i)){
                existe = true;
            }
        }

        if(existe == true){
            atividades.remove(atividade);
            //System.out.println("[Atividade retirada]");
        }else{
            atividades.add(atividade);
            //System.out.println("[Atividade atribuída]");
        }
    }

    public void alternarFrequencia(){
        if(this.frequencia) frequencia = false;
        else frequencia = true;
    }

    public void calcularNotas(){
        float soma = 0;

        for(int i = 0; i < atividades.size(); i++){
            soma += atividades.get(i).getNota();
        }

        this.nota = soma/atividades.size();
    }
    
    @Override
    public String toString(){
        calcularNotas();
        return "\n ╥[Aluno]\n ╠ Codigo: "+codigo+"\n ╠ Nome: "+nome+"\n ╠ Email: "+email+"\n ╠ Média de notas: "+nota+"\n ╚ CPF: "+cpf+"";
    }
}
