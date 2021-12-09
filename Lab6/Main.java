import java.util.ArrayList;
import java.util.Scanner;

import sistema.*;
import usuario.*;

public class Main{
    public static void main(String args[]){
        Menu menu = new Menu();
        Sistema sistema = new Sistema();
        Database database = new Database();
        Scanner input = new Scanner(System.in);

        /*#############################*/
        boolean menu_inicial = true;
        boolean area_pesquisador = false;
        boolean area_aluno = false;
        boolean area_convidado = false;
        /*#############################*/

        /*#############################*/
        Usuario usuario;
        String nome_usuario;
        String senha_usuario;

        int opcao = -1;
        /*#############################*/

        while(true){
            // MENU INICIAL [INICIO]
            while(menu_inicial == true){
                opcao = menu.menuInicial();

                int tipo_usuario = -1;
                switch(opcao){
                    case 1:
                        String tipo = "";
                        tipo_usuario = menu.escolherTipoUsuario("LOGIN");

                        if(tipo_usuario == 1) tipo = "pesquisador";
                        else if(tipo_usuario == 2) tipo = "aluno";
                        else if(tipo_usuario == 3) tipo = "convidado";

                        System.out.print("[Usuário]: ");
                        nome_usuario = input.nextLine();
                        System.out.print("[Senha]:  ");
                        senha_usuario = input.nextLine();
                        

                        boolean login_autorizado = database.processarLogin(sistema, nome_usuario, senha_usuario, tipo);
                        if(login_autorizado) menu_inicial = false;
                        else break;

                        if(tipo_usuario == 1){
                            area_pesquisador = true;
                            database.updateLogs("Pesquisador "+sistema.getUsuarioAtual().getNome()+" logou.");
                        }else if(tipo_usuario == 2){
                            area_aluno = true;
                            database.updateLogs("Aluno "+sistema.getUsuarioAtual().getNome()+" logou.");
                        } 
                        else if(tipo_usuario == 3){
                            area_convidado = true;
                            database.updateLogs("Convidado "+sistema.getUsuarioAtual().getNome()+" logou.");
                            sistema.registrarHorarioLogin();
                        } 
                    break;

                    case 2:
                        tipo_usuario = menu.escolherTipoUsuario("CADASTRO");

                        System.out.print("[Usuário]: ");
                        nome_usuario = input.nextLine();
                        System.out.print("[Senha]:  ");
                        senha_usuario = input.nextLine();
                        
                        
                        if(tipo_usuario == 1) usuario = new Pesquisador(database.getIDAtualPesquisadores(), nome_usuario, senha_usuario);
                        else if(tipo_usuario == 2) usuario = new Aluno(database.getIDAtualAlunos(), nome_usuario, senha_usuario);
                        else if(tipo_usuario == 3) usuario = new Convidado(database.getIDAtualConvidados(), nome_usuario, senha_usuario);
                        else break;
                        
                        database.processarCadastro(usuario);
                        database.updateLogs("Novo cadastro realizado: "+nome_usuario+".");
                    break;

                    case 0: 
                        menu_inicial = false;
                    break;
                }
            }
            // MENU INICIAL [FIM]

            while(area_pesquisador == true){
                opcao = menu.areaPesquisador();
                switch(opcao){
                    case 1:
                        System.out.println("[Não há nada para mostrar]");
                        for(int i = 0; i < database.getUsuarios().size(); i++){
                            System.out.println(database.getUsuarios().get(i).getNome());
                        }
                    break;
                    
                    case 2:
                        System.out.println(database.getLogs());
                    break;

                    case 3:
                        int tipo_usuario = menu.escolherTipoUsuario("CADASTRO");

                        System.out.print("[Usuário]: ");
                        nome_usuario = input.nextLine();
                        System.out.print("[Senha]:  ");
                        senha_usuario = input.nextLine();
                        
                        if(tipo_usuario == 1) usuario = new Pesquisador(database.getIDAtualPesquisadores(), nome_usuario, senha_usuario);
                        else if(tipo_usuario == 2) usuario = new Aluno(database.getIDAtualAlunos(), nome_usuario, senha_usuario);
                        else if(tipo_usuario == 3) usuario = new Convidado(database.getIDAtualConvidados(), nome_usuario, senha_usuario);
                        else break;
                        
                        database.processarCadastro(usuario);
                        database.updateLogs("Pesquisador "+sistema.getUsuarioAtual().getNome()+" cadastrou um novo usuário: "+nome_usuario+".");
                    break;

                    case 4:
                        menu.modificarUsuario(sistema, database);
                    break;

                    case 5:
                        menu.removerUsuario(sistema, database);
                    break;

                    case 0:
                        area_pesquisador = false;
                        menu_inicial = true;
                        database.updateLogs("Pesquisador "+sistema.getUsuarioAtual().getNome()+" deslogou.");
                    break;
                }
            }

            while(area_aluno == true){
                opcao = menu.areaAluno();
                switch(opcao){
                    case 1:
                        if(database.getTrabalhos().size() > 0){
                            int trabalho = menu.selecionarTrabalho(sistema, database, "SELECIONAR: TRABALHO");

                            System.out.println(database.getTrabalhos().get(trabalho).getTitulo());
                            System.out.println(database.getTrabalhos().get(trabalho).getAnotacoes());
                        }else{
                            System.out.println("[Não há nenhum trabalho cadastrado]");
                        }
                    break;

                    case 2:
                        String tipos[] = {"Artigo de revista", "Artigo de congresso", "Tese", "Dissertação", "TCC"};
                        int tipo = menu.escolherTipoTrabalho();

                        String tipo_trabalho = tipos[tipo-1];
                        System.out.print("[Título]: ");
                        String titulo = input.nextLine();
                        System.out.print("[Autores]: ");
                        String autores = input.nextLine();
                        System.out.print("[Ano]: ");
                        String ano = input.nextLine();
                        System.out.print("[Local de publicação]: ");
                        String local_publicacao = input.nextLine();

                        database.cadastrarTrabalho(tipo_trabalho, titulo, autores, ano, local_publicacao);
                        System.out.println("[Novo trabalho cadastrado]");
                        database.updateLogs(sistema.getUsuarioAtual().getNome()+" cadastrou o trabalho \""+titulo+"\"");
                    break;

                    case 3:
                        if(database.getTrabalhos().size() > 0){
                            int index = -1;
                            boolean encontrado = false;
                            
                            System.out.print("Conteúdo para buscar: ");
                            String conteudo = input.nextLine();
                            
                            for(int i = 0; i < database.getTrabalhos().size(); i++){
                                String anotacoes = database.getTrabalhos().get(i).getAnotacoes();
                                titulo = database.getTrabalhos().get(i).getTitulo();
                                if(anotacoes.toLowerCase().contains(conteudo.toLowerCase()) || titulo.toLowerCase().contains(conteudo.toLowerCase())){
                                    encontrado = true;
                                    index = i;
                                    break;
                                }
                            }
                            if(encontrado) System.out.println("[Trabalho encontrado]\nTrabalho: \""+database.getTrabalhos().get(index).getTitulo()+"\"");
                            else System.out.println("[Não encontrado]");
                        }else{
                            System.out.println("[Não há nenhum trabalho cadastrado]");
                        }
                        
                    break;

                    case 4:
                        if(database.getTrabalhos().size() > 0){
                            int trabalho = menu.selecionarTrabalho(sistema, database, "ADICIONAR: ANOTAÇÃO");
    
                            System.out.println(database.getTrabalhos().get(trabalho).getAnotacoes());
                            System.out.print("Nova anotação: ");
                            String nova_anotacao = input.nextLine();
    
                            database.getTrabalhos().get(trabalho).addAnotacoes(nova_anotacao);
                            database.updateLogs(sistema.getUsuarioAtual().getNome()+" fez uma nova anotação em \""+database.getTrabalhos().get(trabalho).getTitulo()+"\"");
                        }else{
                            System.out.println("[Não há nenhum trabalho cadastrado]");
                        }
                    break;

                    case 0:
                        area_aluno = false;
                        menu_inicial = true;
                        database.updateLogs("Aluno "+sistema.getUsuarioAtual().getNome()+" deslogou.");
                    break;
                }
            }

            while(area_convidado == true){
                opcao = menu.areaConvidado();
                boolean acesso = sistema.checarAcessoTemporario();
                if(!acesso){
                    menu_inicial = true;
                    area_convidado = false;
                    System.out.println("[Sessão expirada]");
                    database.updateLogs("A sessão de "+sistema.getUsuarioAtual().getNome()+" expirou.");
                }
                

                switch(opcao){
                    case 1:
                        System.out.println("[Não há nada para mostrar]");
                    break;

                    case 0:
                        area_convidado = false;
                        menu_inicial = true;
                        database.updateLogs("Convidado "+sistema.getUsuarioAtual().getNome()+" deslogou.");
                    break;
                }
            }
        }   
    }
}