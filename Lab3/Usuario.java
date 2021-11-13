import java.util.ArrayList;

public class Usuario {
    String nome;
    ArrayList<Livro> livros;
    ArrayList<Revista> revistas;
    ArrayList<Video> videos;

    public Usuario(String nome){
        this.nome = nome;

        livros = new ArrayList<>();
        revistas = new ArrayList<>();
        videos = new ArrayList<>();

        System.out.println("[Usuário '"+nome+"' cadastrado]");
    }

    public void emprestar(Livro livro){
        if(livros.size() == 0){
            livros.add(livro);
            System.out.println("[Livro emprestado]");
        } else {
            boolean emprestado = false;

            for(int i = 0; i < livros.size(); i++){
                if(livro == livros.get(i)){
                    emprestado = true;
                }
            }

            if(emprestado == true){
                System.out.println("[Você já tem este livro]");
            } else {
                livros.add(livro);
                System.out.println("[Livro emprestado]");
            }   
        }
    }

    public void emprestar(Revista revista){
        if(revistas.size() == 0){
            revistas.add(revista);
            System.out.println("[Revista emprestada]");
        } else {
            boolean emprestado = false;
            
            for(int i = 0; i < revistas.size(); i++){
                if(revista == revistas.get(i)){
                    emprestado = true;
                }
            }

            if(emprestado == true){
                System.out.println("[Você já tem esta revista]");
            } else {
                revistas.add(revista);
                System.out.println("[Revista emprestada]");
            }
        }
    }

    public void emprestar(Video video){
        if(videos.size() == 0){
            videos.add(video);
            System.out.println("[Vídeo emprestado]");
        } else {
            boolean emprestado = false;
            
            for(int i = 0; i < videos.size(); i++){
                if(video == videos.get(i)){
                    emprestado = true;
                }
            }

            if(emprestado == true){
                System.out.println("[Você já tem este vídeo]");
            } else {
                videos.add(video);
                System.out.println("[Vídeo emprestado]");
            }
        }
    }

    public void devolver(Livro livro){
        if(livros.size() == 0){
            System.out.println("[Não há livros para devolver]");
        } else {
            boolean possui = false;
            for(int i = 0; i < livros.size(); i++){
                if(livro == livros.get(i)){
                    possui = true;
                }
            }

            if(possui == true){
                livros.remove(livro);
                System.out.println("[Livro devolvido]\n");
            } else {
                System.out.println("[Este livro não está na lista]\n");
            }
        }
    }

    public void devolver(Revista revista){
        if(revistas.size() == 0){
            System.out.println("[Não há revistas para devolver]\n");
        } else {
            boolean possui = false;
            for(int i = 0; i < revistas.size(); i++){
                if(revista == revistas.get(i)){
                    possui = true;
                }
            }

            if(possui == true){
                revistas.remove(revista);
                System.out.println("[Revista devolvida]\n");  
            } else {
                System.out.println("[Esta revista não está na lista]\n");
            }
        }   
    }

    public void devolver(Video video){
        if(videos.size() == 0){
            System.out.println("[Não há vídeos para devolver]");
        } else {
            boolean possui = false;
            for(int i = 0; i < videos.size(); i++){
                if(video == videos.get(i)){
                    possui = true;
                }
            }

            if(possui == true){
                videos.remove(video);
                System.out.println("[Vídeo devolvido]");
            } else {
                System.out.println("[Este vídeo não está na lista]\n");
            }
        }
    }    
}
