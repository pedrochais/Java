public class Livro {
    int id;
    String nome;
    int paginas;

    public Livro(int id, String nome, int paginas){
        this.id = id;
        this.nome = nome;
        this.paginas = paginas;
    }

    public int getID(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public int getPaginas(){
        return this.paginas;
    }

    @Override
    public String toString(){
        return "Livro : [ID: "+id+", Nome: "+nome+", Páginas: "+paginas+"]";
    }
}
