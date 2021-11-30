package entidades;
import java.util.ArrayList;

import atividade.Atividade;
import pessoa.Aluno;
import sistema.Sistema;

public class Turma {
    private Sistema sistema;
    private ArrayList<Aluno> alunos;
    private ArrayList<Atividade> atividades;
    private Disciplina disciplina;
    private String semestre;
    private int codigo;

    public Turma(int codigo, String semestre, Disciplina disciplina){
        sistema = new Sistema();
        alunos = new ArrayList<>();
        atividades = new ArrayList<>();
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.codigo = codigo;
    }

    public void addAluno(Aluno aluno){
        boolean existe = false;

        for(int i = 0; i < alunos.size(); i++){
            if(aluno == alunos.get(i)){
                existe = true;
            }
        }

        if(existe == true){
            alunos.remove(aluno);
            //System.out.println("[Aluno retirada]");
        }else{
            alunos.add(aluno);
            //System.out.println("[Aluno inserido]");
        }
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

    public String getSemID(){
        return this.semestre + " | " + this.codigo;
    }

    public int getID(){
        return codigo;
    }

    public ArrayList<Atividade> getAtividades(){
        return this.atividades;
    }

    public ArrayList<Aluno> getAlunos(){
        return this.alunos;
    }

    @Override
    public String toString(){
        String nome = "";

        for(int i = 0; i < alunos.size(); i++){
            nome += "["+(i+1)+"] "+sistema.listaNomesAlunos(alunos)[i]+"\n";
        }

        return "\n ╥[Turma]\n ╠ Codigo: "+codigo+"\n ╠ Semestre: "+semestre+"\n ╚ Disciplina: "+disciplina.getNome();
    }
}
