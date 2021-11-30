package entidades;
import java.util.ArrayList;

public class Curso {
    private ArrayList<Disciplina> disciplinas;
    private int codigo;
    private String nome;

    public Curso(int codigo, String nome){
        disciplinas = new ArrayList<>();
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString(){
        return "\n ╥[Curso]\n ╠ Codigo: "+codigo+"\n ╚ Nome: "+nome+"";
    }
}
