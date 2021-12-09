import java.util.ArrayList;

public class Gerenciador {
    private ArrayList<Equipamento> equipamentos;

    public Gerenciador(){
        this.equipamentos = new ArrayList<>();
    }

    public ArrayList<Equipamento> getEquipamentos(){
        return this.equipamentos;
    }

    public void addEquipamento(Equipamento equipamento){
        this.equipamentos.add(equipamento);
    }
    /*
    public void removerEquipamento(String nome_classe){
        for(int i = 0; i < this.equipamentos.size(); i++){
            if(nome_classe.equals(this.equipamentos.get(i).getClass().getName())){
                this.equipamentos.remove(this.equipamentos.get(i));
            }
        }
    }
    */
    public String[] listaEquipamentos(){
        String[] equipamentos = new String[this.equipamentos.size()];

        for(int i = 0; i < this.equipamentos.size(); i++){
            equipamentos[i] = this.equipamentos.get(i).getClass().getName();
        }
        return equipamentos;
    }

}
