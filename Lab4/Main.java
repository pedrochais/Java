import java.util.ArrayList;
public class Main{
    public static void main(String args[]){
        ArrayList<Funcionario> funcionarios = new ArrayList<>(); //instanciei o lista para aceitar apenas objetos da classe Funcionario

        //através do conceito de herança as classes Gerente, Assistente e Vendedor herdarão atributos e métodos de Funcionario
        Gerente gerente = new Gerente("Carl", "001", 3000.0f); //instanciei o objeto gerente passando parâmetros para o método construtor
        Assistente assistente = new Assistente("Andrew", "101", 2000.0f); //instanciei o objeto assistente passando parâmetros para o método construtor
        Vendedor vendedor = new Vendedor("Jack", "201", 1500.0f, 100.0f); //instanciei o objeto vendedor passando parâmetros para o método construtor, observe que passei uma parâmetro a mais, ao contrário das outras duas intâncias.

        //como gerente, assistente e vendedor são extensões da classe abstrata Funcionario, é possível adicioná-los na lista que aceita apenas objetos da classe Funcionario
        funcionarios.add(gerente);
        funcionarios.add(assistente);
        funcionarios.add(vendedor);

        double total = 0;
        //System.out.println("Folha salarial");
        for(int i = 0; i < funcionarios.size(); i++){
            /*
            if(funcionarios.get(i) instanceof Gerente){
                System.out.println("CHECK");
            } else {
                System.out.println("NCHECK");
            }
            */
            System.out.println("\nNome: "+funcionarios.get(i).getNome()+"\n∟ Salário: R$ "+funcionarios.get(i).calculaSalario());
            total += funcionarios.get(i).getSalario();
        }
        System.out.println("\nTotal: R$ "+total);
    }
}