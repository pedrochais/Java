package sistema;
import java.util.Scanner;

import atividade.*;
import entidades.*;
import pessoa.*;

public class Menu {
    private Scanner input = new Scanner(System.in);
    // 0
    public int principal(){
        int operacao;
        operacao = menu("/MENU", new String[] {"Cadastro", "Consultar", "Gerenciar", "Relatórios"}, false);

        return operacao;
    }

    // 1
    public int cadastro(){
        int operacao;
        operacao = menu("/MENU/CADASTRO", new String[] {"Pessoa", "Entidade", "Atividade"}, true);

        return operacao;
    }

    // 1.1
    public int cadastroPessoa(){
        int operacao;
        operacao = menu("/MENU/CADASTRO/PESSOA", new String[] {"Aluno", "Docente"}, true);

        return operacao;
    }

    // 1.1.1
    public void cadastroAluno(Sistema sistema){

        System.out.println("/MENU/CADASTRO/PESSOA/ALUNO");
        System.out.print("╥ Nome: ");
        String nome = input.nextLine();
        System.out.print("╠ Email: ");
        String email = input.nextLine();
        System.out.print("╚ CPF: ");
        String CPF = input.nextLine();

        Aluno aluno = new Aluno(sistema.alunos.size(), nome, email, CPF);
        sistema.addAluno(aluno);

    }

    // 1.1.2
    public void cadastroDocente(Sistema sistema){
        if(sistema.turmas.size() > 0){
            while(true){
                System.out.println("/MENU/CADASTRO/PESSOA/DOCENTE");
                System.out.print("╥ Nome: ");
                String nome = input.nextLine();
                System.out.print("╠ Email: ");
                String email = input.nextLine();
                System.out.print("╠ CPF: ");
                String CPF = input.nextLine();
                System.out.print("╚ Categoria: ");
                String categoria = input.nextLine();
                
                int turma = menu("Turmas", sistema.listaSemIDTurma(sistema.turmas), false);

                if(turma > 0 && turma <= sistema.turmas.size()){
                    sistema.addDocente(new Docente(sistema.docentes.size(), nome, email, CPF, categoria, sistema.turmas.get(turma-1)));
                    break;
                }else{
                    System.out.println("[Insira uma opção válida]");
                }
            }
        }else{
            System.out.println("[Deve haver pelo menos uma turma para vincular o docente]");
        }
        
    }

    // 1.2
    public int cadastroEntidade(){
        int operacao;
        operacao = menu("/MENU/CADASTRO/ENTIDADE", new String[] {"Curso", "Disciplina", "Turma"}, true);

        return operacao;
    }

    // 1.2.1
    public void cadastroCurso(Sistema sistema){
        System.out.println("/MENU/CADASTRO/ENTIDADE/CURSO");
        System.out.print("╥ Nome: ");
        String nome = input.nextLine();

        sistema.addCurso(new Curso(sistema.cursos.size(), nome));
    }

    // 1.2.2
    public void cadastroDisciplina(Sistema sistema){
        if(sistema.cursos.size() > 0){
            while(true){
                System.out.println("/MENU/CADASTRO/ENTIDADE/DISCIPLINA");
                System.out.print("╥ Nome: ");
                String nome = input.nextLine();
                System.out.print("╚ CH: ");
                String CH = input.nextLine();

                int curso = menu("Cursos", sistema.listaNomesCursos(sistema.cursos), false);

                if(curso > 0 && curso <= sistema.cursos.size()){
                    sistema.addDisciplina(new Disciplina(sistema.disciplinas.size(), nome, CH, sistema.cursos.get(curso-1)));
                    break;
                }else{
                    System.out.println("[Insira uma opção válida]");
                }
            }
            
        }else{
            System.out.println("[Deve haver pelo menos um curso para cadastrar uma disciplina]");
        }
        
    }

    // 1.2.3
    public void cadastroTurma(Sistema sistema){
        if(sistema.disciplinas.size() > 0){
            while(true){
                System.out.println("/MENU/CADASTRO/ENTIDADE/TURMA");
                System.out.print("╥ Semestre: ");
                String semestre = input.nextLine();

                int disciplina = menu("Disciplinas", sistema.listaNomesDisciplinas(sistema.disciplinas), false);
                
                if(disciplina > 0 && disciplina <= sistema.disciplinas.size()){
                    sistema.addTurma(new Turma(sistema.turmas.size(), semestre, sistema.disciplinas.get(disciplina-1)));
                    break;
                }else{
                    System.out.println("[Insira uma opção válida]");
                }
            }
        }else{
            System.out.println("[Deve haver pelo menos uma disciplina para cadastrar uma turma]");
        }
        
    }

    // 1.3
    public int cadastroAtividade(){
        int operacao;
        operacao = menu("/MENU/CADASTRO/ATIVIDADE", new String[] {"Exercicio", "Prova"}, true);

        return operacao;
    }

    // 1.3.1
    public void cadastroExercicio(Sistema sistema){
        System.out.println("/MENU/CADASTRO/ATIVIDADE/EXERCICIO");

        System.out.print("╥ Assunto: ");
        String assunto = input.nextLine();
        System.out.print("╚ Data: ");
        String data = input.nextLine();

        Exercicio exercicio = new Exercicio(assunto, data);
        sistema.addExercicio(exercicio);
    }

    //1.3.2
    public void cadastroProva(Sistema sistema){
        System.out.println("/MENU/CADASTRO/ATIVIDADE/PROVA");

        System.out.print("╥ Assunto: ");
        String assunto = input.nextLine();
        System.out.print("╠ Data: ");
        String data = input.nextLine();
        System.out.print("╚ Bimestre: ");
        String bimestre = input.nextLine();

        Prova prova = new Prova(assunto, data, bimestre);
        sistema.addProva(prova);
    }

    // 2
    public int consultar(){
        int operacao;
        operacao = menu("/MENU/CONSULTAR", new String[] {"Pessoa", "Entidade", "Atividade"}, true);

        return operacao;
    }

    // 2.1
    public int consultarPessoa(){
        int operacao;
        operacao = menu("/MENU/CONSULTAR/PESSOA", new String[] {"Aluno", "Docente"}, true);

        return operacao;
    }

    // 2.1.1
    public int consultarAluno(Sistema sistema){
        
        if(sistema.alunos.size() > 0){
            String nomes[] = sistema.listaNomesAlunos(sistema.alunos);

            int operacao;
            operacao = menu("/MENU/CONSULTAR/PESSOA/ALUNO", nomes, true);

            if(operacao == 0) return 0;
            else if(operacao > 0 && operacao <= sistema.alunos.size()){
                System.out.println(sistema.alunos.get(operacao-1));
            }else{
                System.out.println("[Insira uma opção válida]");
            }
            
            return operacao;
        }else{
            System.out.println("[Não há nenhum aluno cadastrado]");
            return -1;
        }
    }

    // 2.1.2
    public int consultarDocente(Sistema sistema){
        if(sistema.docentes.size() > 0){
            String nomes[] = sistema.listaNomesDocentes(sistema.docentes);

            int operacao;
            operacao = menu("/MENU/CONSULTAR/PESSOA/ALUNO", nomes, true);

            if(operacao == 0) return 0;
            else if(operacao > 0 && operacao <= sistema.docentes.size()){
                System.out.println(sistema.docentes.get(operacao-1));
            }else{
                System.out.println("[Insira uma opção válida]");
            }
            

            return operacao;
        }else{
            System.out.println("[Não há nenhum docente cadastrado]");
            return -1;
        }
    }

    // 2.2
    public int consultarEntidade(){
        int operacao;
        operacao = menu("/MENU/CONSULTAR/ENTIDADE", new String[] {"Curso", "Disciplina", "Turma"}, true);

        return operacao;
    }

    // 2.2.1
    public int consultarCurso(Sistema sistema){
        if(sistema.cursos.size() > 0){
            String nomes[] = sistema.listaNomesCursos(sistema.cursos);

            int operacao;
            operacao = menu("/MENU/CONSULTAR/ENTIDADE/CURSO", nomes, true);

            if(operacao == 0) return 0;
            else if(operacao > 0 && operacao <= sistema.cursos.size()){
                System.out.println(sistema.cursos.get(operacao-1));
            }else{
                System.out.println("[Insira uma opção válida]");
            }
            
            return operacao;
        }else{
            System.out.println("[Não há nenhum curso cadastrado]");
            return -1;
        }
    }

    // 2.2.2
    public int consultarDisciplina(Sistema sistema){
        if(sistema.disciplinas.size() > 0){
            String nomes[] = sistema.listaNomesDisciplinas(sistema.disciplinas);

            int operacao;
            operacao = menu("/MENU/CONSULTAR/ENTIDADE/DISCIPLINA", nomes, true);

            if(operacao == 0) return 0;
            else if(operacao > 0 && operacao <= sistema.disciplinas.size()){
                System.out.println(sistema.disciplinas.get(operacao-1));
            }else{
                System.out.println("[Insira uma opção válida]");
            }

            return operacao;
        }else{
            System.out.println("[Não há nenhuma disciplina cadastrada]");
            return -1;
        }
    }

    // 2.2.3
    public int consultarTurma(Sistema sistema){
        if(sistema.turmas.size() > 0){
            String nomes[] = sistema.listaSemIDTurma(sistema.turmas);

            int operacao;
            operacao = menu("/MENU/CONSULTAR/ENTIDADE/TURMA", nomes, true);

            if(operacao == 0) return 0;
            else if(operacao > 0 && operacao <= sistema.turmas.size()){
                System.out.println(sistema.turmas.get(operacao-1));
            }else{
                System.out.println("[Insira uma opção válida]");
            }
            
            return operacao;
        }else{
            System.out.println("[Não há nenhuma turma cadastrada]");
            return -1;
        }
    }

    // 2.3
    public int consultarAtividade(){
        int operacao;
        operacao = menu("/MENU/CONSULTAR/ATIVIDADE", new String[] {"Exercicio", "Prova"}, true);

        return operacao;
    }

    // 2.3.1
    public int consultarExercicio(Sistema sistema){
        if(sistema.exercicios.size() > 0){
            String nomes[] = sistema.listaAssuntoExercicio(sistema.exercicios);

            int operacao;
            operacao = menu("/MENU/CONSULTAR/ATIVIDADE/EXERCICIOS", nomes, true);

            if(operacao == 0) return 0;
            else if(operacao > 0 && operacao <= sistema.exercicios.size()){
                System.out.println(sistema.exercicios.get(operacao-1));
            }else{
                System.out.println("[Insira uma opção válida]");
            }

            return operacao;
        }else{
            System.out.println("[Não há nenhum exercício cadastrado]");
            return -1;
        }
    }

    // 2.3.2
    public int consultarProva(Sistema sistema){
        if(sistema.provas.size() > 0){
            String nomes[] = sistema.listaAssuntoProva(sistema.provas);

            int operacao;
            operacao = menu("/MENU/CONSULTAR/ATIVIDADE/PROVAS", nomes, true);

            if(operacao == 0) return 0;
            else if(operacao > 0 && operacao <= sistema.provas.size()){
                System.out.println(sistema.provas.get(operacao-1));
            }else{
                System.out.println("[Insira uma opção válida]");
            }

            return operacao;
        }else{
            System.out.println("[Não há nenhuma prova cadastrada]");
            return -1;
        }
    }

    // 3
    public int gerenciar(){
        int operacao;
        operacao = menu("/MENU/GERENCIAR", new String[] {"Turmas"}, true);

        return operacao;
    }

    // 3.1
    public int gerenciarTurmas(Sistema sistema, int index){
        if(sistema.turmas.size() > 0){
            int operacao;

            operacao = menu("/MENU/GERENCIAR/TURMA_"+ sistema.turmas.get(index).getID(), new String[] {"Matricular alunos", "Atribuir exercícios", "Atribuir provas", "Atribuir notas","Atribuir frequência"}, true);
            
            return operacao;
        }else{
            return 0;
        }
    }

    // 3.1.1
    public int matricularAlunos(Sistema sistema, int index){
        if(sistema.alunos.size() > 0){
            int operacao;

            while(true){
                String status_nome[] = sistema.listaMatriculaNomeAluno(sistema.turmas.get(index), sistema.alunos);
                operacao = menu("/MENU/GERENCIAR/TURMA_"+sistema.turmas.get(index).getID()+"/MATRICULA", status_nome, true); //DECREMENTO EM OPERACAO

                if(operacao == 0) return 0; //OPERACAO É indice do aluno
                else if(operacao > 0 && operacao <= sistema.alunos.size()){
                    boolean matriculado_turma_atual = false;

                    if(sistema.alunos.get(operacao-1).getMatriculadoG() == true){ // verifica se status matriculado de aluno é true
                        
                        for(int i = 0; i < sistema.turmas.get(index).getAlunos().size(); i++){
                            if(sistema.turmas.get(index).getAlunos().get(i) == sistema.alunos.get(operacao-1)){ //checando se o aluno existe na turma
                                matriculado_turma_atual = true;
                                break;
                            }
                        }
                        
                        if(matriculado_turma_atual){
                            /*
                            for(int i = 0; i < sistema.turmas.get(index).getAlunos().get(operacao-1).getAtividades().size(); i++){
                                System.out.println("EXCLUINDO "+sistema.turmas.get(index).getAlunos().get(operacao-1).getAtividades().get(i).getAssunto());
                                
                                sistema.turmas.get(index).getAlunos().get(operacao-1).getAtividades().remove(sistema.turmas.get(index).getAlunos().get(operacao-1).getAtividades().get(i));
                            }
                            */

                            sistema.alunos.get(operacao-1).setMatriculadoG(false);
                            sistema.turmas.get(index).addAluno(sistema.alunos.get(operacao-1));         //tira aluno da turma
                        }else{
                            System.out.println("[O aluno já está matriculado em uma turma]");
                        }

                    } else {
                        sistema.alunos.get(operacao-1).setMatriculadoG(true); //muda para matriculado true
                        sistema.turmas.get(index).addAluno(sistema.alunos.get(operacao-1));         //adiciona aluno na turma
                    }
                }else{
                    System.out.println("[Insira um um índice válido]");
                }
            }
        }else{
            System.out.println("[Não há alunos para matricular]");
            return -1;
        }
    }

    // 3.1.2
    public int atribuirExercicios(Sistema sistema, int index){
        if(sistema.exercicios.size() > 0){
            int operacao;

            while(true){
                String assuntos[] = sistema.listaStatusAssuntoExercicio(sistema.turmas.get(index), sistema.exercicios);
                operacao = menu("/MENU/GERENCIAR/TURMA_"+sistema.turmas.get(index).getID()+"/EXERCICIOS", assuntos, true); //DECREMENTO EM OPERACAO

                if(operacao == 0) return 0;
                else if(operacao > 0 && operacao <= sistema.exercicios.size()){
                    sistema.turmas.get(index).addAtividade(sistema.exercicios.get(operacao-1));
                    for(int i = 0; i < sistema.turmas.get(index).getAlunos().size(); i++){
                        Exercicio clone = new Exercicio(sistema.exercicios.get(operacao-1).getAssunto(), sistema.exercicios.get(operacao-1).getData());
                        sistema.turmas.get(index).getAlunos().get(i).addAtividade(clone);
                    }
                }else{
                    System.out.println("[Insira uma opção válida]");
                }
            }
        }else{
            System.out.println("[Não há exercícios para atribuir]");
            return -1;
        }
    }

    // 3.1.3
    public int atribuirProva(Sistema sistema, int index){
        if(sistema.provas.size() > 0){
            int operacao;

            while(true){
                String assuntos[] = sistema.listaStatusAssuntoProva(sistema.turmas.get(index), sistema.provas);
                operacao = menu("/MENU/GERENCIAR/TURMA_"+sistema.turmas.get(index).getID()+"/PROVAS", assuntos, true); //DECREMENTO EM OPERACAO

                if(operacao == 0) return 0;
                else if(operacao > 0 && operacao <= sistema.provas.size()){
                    sistema.turmas.get(index).addAtividade(sistema.provas.get(operacao-1));
                    for(int i = 0; i < sistema.turmas.get(index).getAlunos().size(); i++){
                        Prova clone = new Prova(sistema.provas.get(operacao-1).getAssunto(), sistema.provas.get(operacao-1).getData(), sistema.provas.get(operacao-1).getBimestre());
                        sistema.turmas.get(index).getAlunos().get(i).addAtividade(clone);
                    }
                }else{
                    System.out.println("[Insira uma opção válida]");
                }
            }
        }else{
            System.out.println("[Não há provas para atribuir]");
            return -1;
        }
    }
    
    // 3.1.4
    public int atribuirNotas(Sistema sistema, int index){
        if(sistema.turmas.get(index).getAlunos().size() > 0){
            if(sistema.turmas.get(index).getAtividades().size() > 0){
                Scanner input = new Scanner(System.in);
                int aluno;

                while(true){
                    String status_nome[] = sistema.listaNomesAlunos(sistema.turmas.get(index).getAlunos());
                    aluno = menu("/MENU/GERENCIAR/TURMA_"+sistema.turmas.get(index).getID()+"/NOTAS", status_nome, true); //DECREMENTO EM OPERACAO

                    if(aluno == 0) return 0;
                    else if(aluno > 0 && aluno <= sistema.turmas.get(index).getAlunos().size()){

                        while(true){
                            String assuntos[] = sistema.listaAssuntoAtividade(sistema.turmas.get(index).getAlunos().get(aluno-1).getAtividades());
                        
                            int atividade = menu("ATIVIDADES", assuntos, true);
                            if(atividade == 0) return 0;
                            else if(atividade > 0 && atividade <= sistema.turmas.get(index).getAtividades().size()){
                                System.out.print(" - Nota: ");
                                float nota = input.nextFloat();
                                input.nextLine();
    
                                sistema.turmas.get(index).getAlunos().get(aluno-1).getAtividades().get(atividade-1).setNota(nota);
                                break;
                            }else{
                                System.out.println("[Insira uma opção válida]");
                            }
                        }
                        
                        
                    }else{
                        System.out.println("[Insira uma opção válida]");
                    }
                }
            }else{
                System.out.println("[Não há atividades para atribuir notas]");
                return -1;
            } 
        }else{
            System.out.println("[Não há alunos para atribuir notas]");
            return -1;
        }
    }
    
    // 3.1.4
    public int atribuirFrequencia(Sistema sistema, int index){
        if(sistema.turmas.get(index).getAlunos().size() > 0){
            int operacao;

            while(true){
                String status_nome[] = sistema.listaFrequenciaNomeAluno(sistema.turmas.get(index).getAlunos());
                operacao = menu("/MENU/GERENCIAR/TURMA_"+sistema.turmas.get(index).getID()+"/FREQUENCIA", status_nome, true); //DECREMENTO EM OPERACAO

                if(operacao == 0) return 0;
                else if(operacao > 0 && operacao <= sistema.turmas.get(index).getAlunos().size()){
                    sistema.turmas.get(index).getAlunos().get(operacao-1).alternarFrequencia();
                }else{
                    System.out.println("[Insira uma opção válida]");
                }
            }
        }else{
            System.out.println("[Não há alunos para atribuir frequência]");
            return -1;
        }
    }

    // 4
    public int relatorios(){
        int operacao;
        operacao = menu("/MENU/RELATORIOS", new String[] {"Turmas"}, true);

        return operacao;
    }

    // 4.1
    public int relatoriosTurma(Sistema sistema, int index){
        if(sistema.turmas.size() > 0){
            int operacao;

            operacao = menu("/MENU/RELATORIO/TURMA_"+ sistema.turmas.get(index).getID(), new String[] {"Relatório de frequência", "Relatório de notas"}, true);

            return operacao;
        }else{
            return 0;
        }
    }

    // 4.1.1
    public int relatorioFrequencia(Sistema sistema, int index){
        if(sistema.turmas.get(index).getAlunos().size() > 0){
            int operacao;

            while(true){
                String status_nome[] = sistema.listaFrequenciaNomeAluno(sistema.turmas.get(index).getAlunos());
                operacao = menu("/MENU/RELATORIO/TURMA_"+sistema.turmas.get(index).getID()+"/FREQUENCIA", status_nome, true); //DECREMENTO EM OPERACAO
                if(operacao == 0) return 0;
            }
        }else{
            System.out.println("[Não há alunos para gerar relatório]");
            return -1;
        }
    }

    // 4.1.2
    public int relatorioNotas(Sistema sistema, int index){
        if(sistema.turmas.get(index).getAlunos().size() > 0){
            int operacao;

            while(true){
                String status_nome[] = sistema.listaNotaNomeAluno(sistema.turmas.get(index).getAlunos());
                operacao = menu("/MENU/RELATORIO/TURMA_"+sistema.turmas.get(index).getID()+"/NOTAS", status_nome, true); //DECREMENTO EM OPERACAO
                if(operacao == 0) return 0;
            }
        }else{
            System.out.println("[Não há alunos para gerar relatório]");
            return -1;
        }
    }
    
    //SELECIONAR TURMA
    public int selecionarTurma(Sistema sistema){
        if(sistema.turmas.size() > 0){
            int turma;
            String semID[] = sistema.listaSemIDTurma(sistema.turmas);

            while(true){
                turma = menu("SELECIONAR TURMA", semID, true);

                if(turma == 0) return 0;
                else if(turma < 0 || turma > sistema.turmas.size()){
                    System.out.println("[Não é uma turma válida]");
                }else{
                    return turma;
                }
            }
                
        }else{
            System.out.println("[Não há nenhuma turma cadastrada]");
            return 0;
        }    
    }

    private int menu(String titulo, String[] opcoes, boolean voltar){
        Scanner input = new Scanner(System.in); 
        
        int operacao = -1;
        while(true){
            System.out.println("\n========================");
            System.out.println("\n"+titulo+"\n");
            for(int i = 0; i < opcoes.length; i++){
                if(i == 0){
                    System.out.println("╥["+(i+1)+"] " + opcoes[i]);
                    continue;
                }
                if(i == opcoes.length-1){
                    System.out.println("╚["+(i+1)+"] " + opcoes[i]);
                    continue;
                }
                System.out.println("╠["+(i+1)+"] " + opcoes[i]);
            }
            if(voltar == true) System.out.println("\n༝ [0] Voltar");
            System.out.print("» ");
            operacao = input.nextInt();
            
            for(int i = 0; i < opcoes.length; i++){
                if(operacao == i+1) return operacao;
                if(voltar == true) return operacao;
            }
        }
    }

    private void clear(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
