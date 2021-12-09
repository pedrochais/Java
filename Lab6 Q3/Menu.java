import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    
    public int inicio(){
        return menu("", "GERENCIADOR", new String[] {"Listar equipamentos", "Adicionar equipamentos", "Remover equipamentos"}, false);
    }

    public int gerenciarImpressora(Impressora impressora){
        int opcao = menu("", "IMPRESSORA", new String[] {"Imprimir", "Ligar", "Desligar"}, true);

        if(opcao == 0) return 0;
        else if(opcao == 1) impressora.imprimir();
        else if(opcao == 2) impressora.ligar();
        else if(opcao == 3) impressora.desligar();
        return 0;
    }

    public int gerenciarLuminaria(Luminaria luminaria){
        int opcao = menu("", "LUMINARIA", new String[] {"Quebrar", "Ligar", "Desligar"}, true);

        if(opcao == 0) return 0;
        else if(opcao == 1) luminaria.quebrar();
        else if(opcao == 2) luminaria.ligar();
        else if(opcao == 3) luminaria.desligar();
        return 0;
    }

    public int gerenciarNotebook(Notebook notebook){
        int opcao = menu("", "NOTEBOOK", new String[] {"Teclar", "Ligar", "Desligar"}, true);

        if(opcao == 0) return 0;
        else if(opcao == 1) notebook.teclar();
        else if(opcao == 2) notebook.ligar();
        else if(opcao == 3) notebook.desligar();
        return 0;
    }

    public int gerenciarTelevisao(Televisao televisao){
        int opcao = menu("", "TELEVISAO", new String[] {"Assistir", "Ligar", "Desligar"}, true);

        if(opcao == 0) return 0;
        else if(opcao == 1) televisao.assistir();
        else if(opcao == 2) televisao.ligar();
        else if(opcao == 3) televisao.desligar();
        return 0;
    }

    public int gerenciarVentilador(Ventilador ventilador){
        int opcao = menu("", "VENTILADOR", new String[] {"Botar pra girar", "Ligar", "Desligar"}, true);

        if(opcao == 0) return 0;
        else if(opcao == 1) ventilador.botarPraGirar();
        else if(opcao == 2) ventilador.ligar();
        else if(opcao == 3) ventilador.desligar();
        return 0;
    }

    public int gerenciarXbox(Xbox xbox){
        int opcao = menu("", "XBOX", new String[] {"Jogar", "Ligar", "Desligar"}, true);

        if(opcao == 0) return 0;
        else if(opcao == 1) xbox.jogar();
        else if(opcao == 2) xbox.ligar();
        else if(opcao == 3) xbox.desligar();
        return 0;
    }

    public int listarEquipamentos(Gerenciador gerenciador, String [] lista){
        return menu("", "EQUIPAMENTOS", lista, true);
    }

    public void adicionarEquipamentos(Gerenciador gerenciador){
        int opcao = menu("", "ADICIONAR", new String[] {"Impressora", "Luminaria", "Notebook", "Televisao", "Ventilador", "Xbox"}, true);


        if(opcao == 1) gerenciador.addEquipamento(new Impressora());
        else if(opcao == 2) gerenciador.addEquipamento(new Luminaria());
        else if(opcao == 3) gerenciador.addEquipamento(new Notebook());
        else if(opcao == 4) gerenciador.addEquipamento(new Televisao());
        else if(opcao == 5) gerenciador.addEquipamento(new Ventilador());
        else if(opcao == 6) gerenciador.addEquipamento(new Xbox());
    }

    public void removerEquipamentos(Gerenciador gerenciador, String [] lista){
        int opcao = menu("", "REMOVER", lista, true);

        gerenciador.getEquipamentos().remove(gerenciador.getEquipamentos().get(opcao-1));
        System.out.println("[Equipamento removido]");
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
