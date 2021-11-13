import java.util.ArrayList;

public class Prateleira {
    ArrayList<Livro> livros;
    ArrayList<Revista> revistas;
    ArrayList<Video> videos;

    public Prateleira(){
        livros = new ArrayList<>();
        revistas = new ArrayList<>();
        videos = new ArrayList<>();
    }

    public void addLivro(Livro livro){
        livros.add(livro);
    }

    public void addRevista(Revista revista){
        revistas.add(revista);
    }

    public void addVideo(Video video){
        videos.add(video);
    }

    public Livro buscarLivro(int id){
        Livro livro = livros.get(id);
        return livro;
    }

    public Revista buscarRevista(int id){
        Revista revista = revistas.get(id);
        return revista;
    }

    public Video buscarVideo(int id){
        Video video = videos.get(id);
        return video;
    }

    public ArrayList<Livro> listaLivros(){
        return livros;
    }

    public ArrayList<Revista> listaRevistas(){
        return revistas;
    }

    public ArrayList<Video> listaVideos(){
        return videos;
    }
}
