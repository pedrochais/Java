public class Main{
    public static void main(String args[]){
        Menu menu = new Menu();
        Gerenciador gerenciador = new Gerenciador();

        int equipamento_index = -1;
        
        while(true){
            int opcao = menu.inicio();
            switch(opcao){
                case 1:
                if(gerenciador.getEquipamentos().size() > 0){
                    equipamento_index = menu.listarEquipamentos(gerenciador, gerenciador.listaEquipamentos());
                    // {"Impressora", "Luminaria", "Notebook", "Televisao", "Ventilador", "Xbox"}
                    if(equipamento_index == 0) break;
                    if(gerenciador.getEquipamentos().get(equipamento_index-1) instanceof Impressora){
                        menu.gerenciarImpressora((Impressora)gerenciador.getEquipamentos().get(equipamento_index-1));
                    }else if(gerenciador.getEquipamentos().get(equipamento_index-1) instanceof Luminaria){
                        menu.gerenciarLuminaria((Luminaria)gerenciador.getEquipamentos().get(equipamento_index-1));
                    }else if(gerenciador.getEquipamentos().get(equipamento_index-1) instanceof Notebook){
                        menu.gerenciarNotebook((Notebook)gerenciador.getEquipamentos().get(equipamento_index-1));
                    }else if(gerenciador.getEquipamentos().get(equipamento_index-1) instanceof Televisao){
                        menu.gerenciarTelevisao((Televisao)gerenciador.getEquipamentos().get(equipamento_index-1));
                    }else if(gerenciador.getEquipamentos().get(equipamento_index-1) instanceof Ventilador){
                        menu.gerenciarVentilador((Ventilador)gerenciador.getEquipamentos().get(equipamento_index-1));
                    }else if(gerenciador.getEquipamentos().get(equipamento_index-1) instanceof Xbox){
                        menu.gerenciarXbox((Xbox)gerenciador.getEquipamentos().get(equipamento_index-1));
                    }
                }    
                break;

                case 2:
                    menu.adicionarEquipamentos(gerenciador);
                break;

                case 3:
                    if(gerenciador.getEquipamentos().size() > 0) menu.removerEquipamentos(gerenciador, gerenciador.listaEquipamentos());
                break;
            }
        }
    }
}