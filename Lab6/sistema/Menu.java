package sistema;

import java.util.Scanner;

import usuario.*;

public class Menu {
    Scanner input = new Scanner(System.in);

    public int menuInicial(){
        return menu("", "MENU", new String[] {"Fazer login", "Criar uma conta"}, false);
    }

    public int escolherTipoUsuario(String titulo){
        return menu("", titulo, new String[] {"Pesquisador", "Aluno", "Convidado"}, false);
    }

    public int areaPesquisador(){
        return menu("", "AREA: PESQUISADOR", new String[] {"Acessar dados", "Consultar logs", "Cadastrar usuário", "Modificar usuário", "Remover usuário"}, true);
    }

    public int modificarUsuario(Sistema sistema, Database database){
        int index = menu("", "MODIFICAR USUARIO", sistema.listaUsuarios(database), true);

        if(index == 0) return 0;

        String nome_antigo = database.getUsuarios().get(index-1).getNome();

        input.nextLine();
        System.out.println("Novo nome: ");
        String novo_nome = input.nextLine();
        System.out.println("Nova senha: ");
        String nova_senha = input.nextLine();

        if(database.getUsuarios().get(index-1) instanceof Pesquisador){
            System.out.println("[Você não tem permissão para modificar outro pesquisador]");
            
        }else{
            boolean encontrado = database.processarModificacao(index-1, novo_nome, nova_senha);
            if(!encontrado) database.updateLogs("Pesquisador "+sistema.getUsuarioAtual().getNome()+" modificou os dados de "+nome_antigo+"(atual: "+novo_nome+")");
        }

        return 1;
    }

    public int removerUsuario(Sistema sistema, Database database){
        int index = menu("", "REMOVER USUARIO", sistema.listaUsuarios(database), true);
        
        if(index == 0) return 0;
        if(database.getUsuarios().get(index-1) instanceof Pesquisador){
            System.out.println("[Você não tem permissão para remover outro pesquisador]");
            
        }else{
            database.updateLogs(sistema.getUsuarioAtual().getNome()+" removeu "+database.getUsuarios().get(index-1).getNome()+" do sistema.");
            database.getUsuarios().remove(index-1);
        }
        return 1;
    }

    public int areaAluno(){
        return menu("", "AREA: ALUNO", new String[] {"Acessar dados", "Cadastrar trabalho", "Buscar por conteúdo", "Fazer anotações"}, true);
    }

    public int escolherTipoTrabalho(){ //Artigo de Revista, Artigo de Congresso, Tese, Dissertação ou TCC
        return menu("", "CADASTRO: TRABALHO", new String[] {"Artigo de revista", "Artigo de congresso", "Tese", "Dissertação", "TCC"}, false);
    }

    public int selecionarTrabalho(Sistema sistema, Database database, String titulo){
        return menu("", titulo, sistema.listaTrabalhos(database), true)-1;
    }

    public int areaConvidado(){
        return menu("", "AREA: CONVIDADO", new String[] {"Acessar dados"}, true);
    }

    private int menu(String cabecalho, String titulo, String[] opcoes, boolean voltar){
        
        int operacao = -1;
        while(true){
            System.out.println("\n---------- "+titulo+" ----------");
            if(cabecalho != ""){
                System.out.println(cabecalho);
                System.out.println("--------------------------");
            }
            for(int i = 0; i < opcoes.length; i++){
                System.out.println(" ["+(i+1)+"] " + opcoes[i]);
            }
            if(voltar == true) System.out.println("\n[0] Voltar");
            System.out.print("\n» ");
            operacao = input.nextInt();
            
            for(int i = 0; i < opcoes.length; i++){
                if(operacao == i+1) return operacao;
                if(voltar == true) return operacao;
            }
        }
    }
}
