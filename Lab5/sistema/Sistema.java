package sistema;
import java.util.ArrayList;

import entidades.*;
import pessoa.*;
import atividade.*;

public class Sistema {
    public ArrayList<Aluno> alunos;
    public ArrayList<Docente> docentes;
    public ArrayList<Curso> cursos;
    public ArrayList<Disciplina> disciplinas;
    public ArrayList<Turma> turmas;
    public ArrayList<Exercicio> exercicios;
    public ArrayList<Prova> provas;

    public Sistema(){
        alunos = new ArrayList<>();
        docentes = new ArrayList<>();
        cursos = new ArrayList<>();
        disciplinas = new ArrayList<>();
        turmas = new ArrayList<>();
        exercicios = new ArrayList<>();
        provas = new ArrayList<>();
    }

    public void addAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public void addDocente(Docente docente){
        this.docentes.add(docente);
    }

    public void addCurso(Curso curso){
        this.cursos.add(curso);
    }

    public void addDisciplina(Disciplina disciplina){
        this.disciplinas.add(disciplina);
    }

    public void addTurma(Turma turma){
        this.turmas.add(turma);
    }

    public void addExercicio(Exercicio exercicio){
        this.exercicios.add(exercicio);
    }

    public void addProva(Prova prova){
        this.provas.add(prova);
    }
    
    public String[] listaNomesAlunos(ArrayList<Aluno> alunos){
        String nomes[] = new String[alunos.size()];

        for(int i = 0; i < alunos.size(); i++){
            nomes[i] = alunos.get(i).getNome();
        }

        return nomes;
    }

    public String[] listaNomesDocentes(ArrayList<Docente> docentes){
        String nomes[] = new String[docentes.size()];

        for(int i = 0; i < docentes.size(); i++){
            nomes[i] = docentes.get(i).getNome();
        }

        return nomes;
    }

    public String[] listaNomesCursos(ArrayList<Curso> cursos){
        String nomes[] = new String[cursos.size()];

        for(int i = 0; i < cursos.size(); i++){
            nomes[i] = cursos.get(i).getNome();
        }

        return nomes;
    }

    public String[] listaNomesDisciplinas(ArrayList<Disciplina> disciplinas){
        String nomes[] = new String[disciplinas.size()];

        for(int i = 0; i < disciplinas.size(); i++){
            nomes[i] = disciplinas.get(i).getNome();
        }

        return nomes;
    }

    public String[] listaSemIDTurma(ArrayList<Turma> turmas){
        String semID[] = new String[turmas.size()];

        for(int i = 0; i < turmas.size(); i++){
            semID[i] = turmas.get(i).getSemID();
        }

        return semID;
    }

    public String[] listaAssuntoExercicio(ArrayList<Exercicio> exercicios){
        String assuntos[] = new String[exercicios.size()];

        for(int i = 0; i < exercicios.size(); i++){
            assuntos[i] = exercicios.get(i).getAssunto();
        }

        return assuntos;
    }

    public String[] listaAssuntoProva(ArrayList<Prova> provas){
        String nomes[] = new String[provas.size()];

        for(int i = 0; i < provas.size(); i++){
            nomes[i] = provas.get(i).getAssunto();
        }

        return nomes;
    }

    public String[] listaStatusAssuntoExercicio(Turma turma, ArrayList<Exercicio> exercicios){
        String status_assunto[] = new String[exercicios.size()];
        String status;
        boolean existe;

        for(int i = 0; i < exercicios.size(); i++){
            existe = false;
            for(int j = 0; j < turma.getAtividades().size(); j++){
                if(turma.getAtividades().get(j) == exercicios.get(i)){
                    existe = true;
                }
            }
            exercicios.get(i).setStatus(existe);
        }

        for(int i = 0; i < exercicios.size(); i++){
            if(exercicios.get(i).getStatus()) status = "atribuído";
            else status = "não atribuído";

            status_assunto[i] = "["+status+"] "+exercicios.get(i).getAssunto();
        }

        return status_assunto;
    }

    public String[] listaStatusAssuntoProva(Turma turma, ArrayList<Prova> provas){
        String status_assunto[] = new String[provas.size()];
        String status;
        boolean existe;

        for(int i = 0; i < provas.size(); i++){
            existe = false;
            for(int j = 0; j < turma.getAtividades().size(); j++){
                if(turma.getAtividades().get(j) == provas.get(i)){
                    existe = true;
                }
            }
            provas.get(i).setStatus(existe);
        }

        for(int i = 0; i < provas.size(); i++){
            if(provas.get(i).getStatus()) status = "atribuído";
            else status = "não atribuído";

            status_assunto[i] = "["+status+"] "+provas.get(i).getAssunto();
        }

        return status_assunto;
    }

    public String[] listaMatriculaNomeAluno(Turma turma, ArrayList<Aluno> alunos){
        String status_assunto[] = new String[alunos.size()];
        String status;
        boolean existe;

        for(int i = 0; i < alunos.size(); i++){
            existe = false;
            for(int j = 0; j < turma.getAlunos().size(); j++){
                if(turma.getAlunos().get(j) == alunos.get(i)){
                    existe = true;
                }
            }
            alunos.get(i).setMatriculadoL(existe);
        }

        for(int i = 0; i < alunos.size(); i++){
            if(alunos.get(i).getMatriculadoL()) status = "matriculado";
            else status = "não matriculado";

            status_assunto[i] = "["+status+"] "+alunos.get(i).getNome();
        }

        return status_assunto;
    }
   
    public String[] listaFrequenciaNomeAluno(ArrayList<Aluno> alunos){
        String status_assunto[] = new String[alunos.size()];
        String status;

        for(int i = 0; i < alunos.size(); i++){
            if(alunos.get(i).getFrequencia()) status = "presente";
            else status = "falta";

            status_assunto[i] = "["+status+"] "+alunos.get(i).getNome();
        }

        return status_assunto;
    }

    public String[] listaNotaNomeAluno(ArrayList<Aluno> alunos){
        String nota_assunto[] = new String[alunos.size()];
        String nota;

        for(int i = 0; i < alunos.size(); i++){
            alunos.get(i).calcularNotas();
            nota_assunto[i] = "[nota média: "+alunos.get(i).getNota()+"] "+alunos.get(i).getNome();
        }

        return nota_assunto;
    }

    public String[] listaAssuntoAtividade(ArrayList<Atividade> atividades){
        String assuntos[] = new String[atividades.size()];

        for(int i = 0; i < atividades.size(); i++){
            if(atividades.get(i) instanceof Exercicio) assuntos[i] = "[exercício] "+atividades.get(i).getAssunto();
            if(atividades.get(i) instanceof Prova) assuntos[i] = "[prova] "+atividades.get(i).getAssunto();
        }

        return assuntos;
    }

}
