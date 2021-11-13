public class Video {
    int id;
    String nome;
    int duracao; //em minutos

    public Video(int id, String nome, int duracao){
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
    }

    public int getID(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public int getPaginas(){
        return this.duracao;
    }

    @Override
    public String toString(){
        return "Video : [ID: "+id+", Nome: "+nome+", Duração: "+duracao+"]";
    }
}
