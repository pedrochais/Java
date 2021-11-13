import java.util.Scanner;

public class Main{  
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); 
        
        //CADASTRO DOS LIVROS, REVISTAS E VIDEOS
        Prateleira prateleira = new Prateleira();
        
        Livro livro_1 = new Livro(1, "Livro 1", 250);
        Livro livro_2 = new Livro(2, "Livro 2", 250);
        Revista revista_1 = new Revista(1, "Revista 1", 1);
        Revista revista_2 = new Revista(2, "Revista 2", 1);
        Video video_1 = new Video(1, "Vídeo 1", 20);
        Video video_2 = new Video(2, "Vídeo 2", 20);

        prateleira.addLivro(livro_1);
        prateleira.addLivro(livro_2);
        prateleira.addRevista(revista_1);
        prateleira.addRevista(revista_2);
        prateleira.addVideo(video_1);
        prateleira.addVideo(video_2);

        System.out.print("Cadastro de usuário\nNome: ");
        String nome = input.nextLine();
        Usuario usuario = new Usuario(nome);

        
        int operacao_1 = -1;
        int operacao_2 = -1;
        int id;
        while(operacao_1 != 0){ //MENU 1
            System.out.print("\n+ MENU +\n1. Emprestar\n2. Devolver\n0. Sair\n~ ");
            operacao_1 = input.nextInt();
            
            switch(operacao_1){ 
                case 1:
                    operacao_2 = -1;
                    while(operacao_2 != 0){ //MENU 2
                        System.out.print("\n+ EMPRESTAR +\n1. Livro\n2. Revista\n3. Vídeo\n0. Menu principal\n~ ");
                        operacao_2 = input.nextInt();
                        
                        switch(operacao_2){   
                            case 1:
                                System.out.print("\n- Lista de livros -\n1. Livro 1\n2. Livro 2\n~ ");
                                id = input.nextInt();

                                Livro livro = prateleira.buscarLivro(id-1);
                                usuario.emprestar(livro);
                                break;
                            case 2:
                                System.out.print("\n- Lista de revistas -\n1. Revista 1\n2. Revista 2\n~ ");
                                id = input.nextInt();

                                Revista revista = prateleira.buscarRevista(id-1);
                                usuario.emprestar(revista);
                                break;
                            case 3:
                                System.out.print("\n- Lista de vídeos -\n1. Vídeo 1\n2. Vídeo 2\n~ ");
                                id = input.nextInt();

                                Video video = prateleira.buscarVideo(id-1);
                                usuario.emprestar(video);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("[Digite um comando válido]\n");
                                break;
                        }
                    }
                    break;
                case 2:
                    operacao_2 = -1;
                    while(operacao_2 != 0){ //MENU 3
                        System.out.print("\n+ DEVOLVER +\n1. Livro\n2. Revista\n3. Vídeo\n0. Menu principal\n~ ");

                        operacao_2 = input.nextInt();
                        switch(operacao_2){   
                            case 1:
                                System.out.print("\n- Lista de livros -\n1. Livro 1\n2. Livro 2\n~ ");
                                id = input.nextInt();

                                Livro livro = prateleira.buscarLivro(id-1);
                                usuario.devolver(livro);
                                break;
                            case 2:
                                System.out.print("\n- Lista de revistas -\n1. Revista 1\n2. Revista 2\n~ ");
                                id = input.nextInt();

                                Revista revista = prateleira.buscarRevista(id-1);
                                usuario.devolver(revista);
                                break;
                            case 3:
                                System.out.print("\n- Lista de vídeos -\n1. Vídeo 1\n2. Vídeo 2\n~ ");
                                id = input.nextInt();

                                Video video = prateleira.buscarVideo(id-1);
                                usuario.devolver(video);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("[Digite um comando válido]\n");
                                break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("[Programa finalizado]\n");
                    break;
                default:
                    System.out.println("[Digite um comando válido]\n");
            }
        }
    }
}