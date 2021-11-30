package pessoa;
public abstract class Pessoa{
    protected int codigo;
    protected String nome;
    protected String email;    
    protected String cpf;

    public Pessoa(int codigo, String nome, String email, String cpf){
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    } 
}