public class Gerente extends Funcionario{ // para herdar atributos e métodos da classe Funcionario

    //método construtor para atribuir valores aos atributos que estão como protected na classe pai (Funcionario)
    public Gerente(String nome, String matricula, double salario_base){
        super(nome, matricula, salario_base);
    }
    
    @Override //aqui eu sobreponho o método calculaSalario que está na classe abstrata Funcionario
    public double calculaSalario(){
        this.salario = 2*this.salario_base;
        return this.salario;
    }
}
