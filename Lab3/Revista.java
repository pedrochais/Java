public class Revista {
    int id;
    String nome;
    int edicao;

    public Revista(int id, String nome, int edicao){
        this.id = id;
        this.nome = nome;
        this.edicao = edicao;
    }

    public int getID(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public int getEdicao(){
        return this.edicao;
    }

    @Override
    public String toString(){
        return "Revista : [ID: "+id+", Nome: "+nome+", Edicao: "+edicao+"]";
    }
}
