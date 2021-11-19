public class Vendedor extends Funcionario{ // para herdar atributos e métodos da classe Funcionario
    private double comissao;

    //método construtor para atribuir valores aos atributos que estão como protected na classe pai (Funcionario)
    public Vendedor(String nome, String matricula, double salario_base, double comissao){ //adicionei mais um parâmetro(comissao), particularidade da classe Vendedor
        super(nome, matricula, salario_base);
        this.comissao = comissao;
    }
    
    @Override //aqui eu sobreponho o método calculaSalario que está na classe abstrata Funcionario
    public double calculaSalario(){
        this.salario = this.salario_base + this.comissao;
        return this.salario;
    }
}
