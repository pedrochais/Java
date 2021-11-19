public abstract class Funcionario { //classe abstrata (uma classe abstrata não pode ser instanciada) que será pai das classes vendedor, gerente e assistente. Essas classes herdarão os atributos e os métodos de Funcionario.
    //através do encapsulamento esses atributos estarão restritos apenas à classe atual e às classes filhas (protected)
    protected String nome;
    protected String matricula;
    protected double salario_base;
    protected double salario;

    //método construtor que é herdado pelas classes filhas(vendedor, gerente, assistente)
    public Funcionario(String nome, String matricula, double salario_base){
        this.nome = nome;
        this.matricula = matricula;
        this.salario_base = salario_base;
    }

    public abstract double calculaSalario(); //método abstrato que todas as classes filhas herdarão

    //abaixo são usados dois getter's para retornar os valores dos atributos nome e salario

    public String getNome(){
        return this.nome;
    }

    public double getSalario(){
        return this.salario;
    }
}
