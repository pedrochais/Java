package pessoa;

import entidades.Turma;

public class Docente extends Pessoa{
    private String categoria;
    private Turma turma;

    public Docente(int codigo, String nome, String email, String cpf, String categoria, Turma turma) {
        super(codigo, nome, email, cpf);
        this.categoria = categoria;
        this.turma = turma;
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString(){
        return "\n ╥[Docente]\n ╠ Codigo: "+codigo+"\n ╠ Nome: "+nome+"\n ╠ Email: "+email+"\n ╠ CPF: "+cpf+"\n ╠ Categoria: "+categoria+"\n ╚ Turma: "+turma.getSemID();
    }
}
 