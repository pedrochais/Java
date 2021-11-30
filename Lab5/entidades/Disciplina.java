package entidades;

public class Disciplina {
    private Curso curso;
    private int codigo;
    private String nome;
    private String CH;

    public Disciplina(int codigo, String nome, String CH, Curso curso){
        this.codigo = codigo;
        this.nome = nome;
        this.curso = curso;
        this.CH = CH;
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString(){
        return "\n ╥[Disciplina]\n ╠ Codigo: "+codigo+"\n ╠ Nome: "+nome+"\n ╠ CH: "+CH+"\n ╚ Curso: "+curso.getNome();
    }
}
