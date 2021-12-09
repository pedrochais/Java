package sistema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import entidades.Trabalho;
import usuario.*;

public class Database {
    java.util.Date data = new Date();
    ArrayList<Usuario> usuarios;
    ArrayList<Pesquisador> pesquisadores;
    ArrayList<Aluno> alunos;
    ArrayList<Convidado> convidados;
    ArrayList<Trabalho> trabalhos;
    String logs;

    public Database(){
        this.usuarios = new ArrayList<>();
        this.pesquisadores = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.convidados = new ArrayList<>();
        this.trabalhos = new ArrayList<>();
        this.logs = "---------------- LOGS ----------------\n";
    }

    public void addUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public void addPesquisador(Pesquisador pesquisador){
        this.pesquisadores.add(pesquisador);
    }

    public void addAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public void addConvidados(Convidado convidado){
        this.convidados.add(convidado);
    }

    public ArrayList<Usuario> getUsuarios(){
        return this.usuarios;
    }

    public ArrayList<Pesquisador> getPesquisadores(){
        return this.pesquisadores;
    }

    public ArrayList<Aluno> getAlunos(){
        return this.alunos;
    }

    public ArrayList<Convidado> getConvidados(){
        return this.convidados;
    }

    public ArrayList<Trabalho> getTrabalhos(){
        return this.trabalhos;
    }

    public int getIDAtualPesquisadores(){
        return this.pesquisadores.size();
    }

    public int getIDAtualAlunos(){
        return this.alunos.size();
    }

    public int getIDAtualConvidados(){
        return this.convidados.size();
    }

    public String getLogs(){
        return this.logs;
    }

    public void updateLogs(String new_log){
        DateTimeFormatter formatacao_data_hora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        String data = formatacao_data_hora.format(LocalDateTime.now());
        logs += "["+data+"]: "+new_log+"\n";
    }

    public void processarCadastro(Usuario usuario){
        boolean encontrado = false;

        for(int i = 0; i < usuarios.size(); i++){
            if(usuario.getNome().equals(usuarios.get(i).getNome())){
                encontrado = true;
            }
        }
        
        if(encontrado){
            System.out.println("[Já existe alguém com este nome de usuário]");
        }else{
            this.usuarios.add(usuario);
            if(usuario instanceof Pesquisador) this.pesquisadores.add((Pesquisador)usuario);
            else if(usuario instanceof Aluno) this.alunos.add((Aluno)usuario);
            else if(usuario instanceof Convidado) this.convidados.add((Convidado)usuario);
            System.out.println("[Cadastro concluído]");
        }
    }

    public boolean processarLogin(Sistema sistema, String nome, String senha, String tipo){
        boolean encontrado = false;
        int index = -1;

        if(tipo.equals("pesquisador")){
            for(int i = 0; i < pesquisadores.size(); i++){
                if(nome.equals(pesquisadores.get(i).getNome()) && senha.equals(pesquisadores.get(i).getSenha())){
                    encontrado = true;
                    index = i;
                    break;
                }
            }
        }else if(tipo.equals("aluno")){
            for(int i = 0; i < alunos.size(); i++){
                if(nome.equals(alunos.get(i).getNome()) && senha.equals(alunos.get(i).getSenha())){
                    encontrado = true;
                    index = i;
                    break;
                }
            }
        }else if(tipo.equals("convidado")){
            for(int i = 0; i < convidados.size(); i++){
                if(nome.equals(convidados.get(i).getNome()) && senha.equals(convidados.get(i).getSenha())){
                    encontrado = true;
                    index = i;
                    break;
                }
            }
        }
        
        if(encontrado){
            if(tipo.equals("pesquisador")){
                sistema.setUsuarioAtual(pesquisadores.get(index));
            }else if(tipo.equals("aluno")){
                sistema.setUsuarioAtual(alunos.get(index));
            }else if(tipo.equals("convidado")){
                sistema.setUsuarioAtual(convidados.get(index));
            }
            return true;
        } 
        else{
            System.out.println("[Usuário/senha inválido(s)]");
            return false;
        }
    }

    public boolean processarModificacao(int index, String nome, String senha){
        boolean encontrado = false;

        for(int i = 0; i < usuarios.size(); i++){
            if(nome.equals(usuarios.get(i).getNome())){
                encontrado = true;
                break;
            }
        }

        if(encontrado) System.out.println("[Alguém com este nome de usuário já existe]");
        else{
            usuarios.get(index).setNome(nome);
            usuarios.get(index).setSenha(senha);
            System.out.println("[Dados modificados]");
        }

        return encontrado;
    }

    public void cadastrarTrabalho(String tipo, String titulo, String autores, String ano, String local_publicacao){
        this.trabalhos.add(new Trabalho(tipo, titulo, autores, ano, local_publicacao));
    }
}
