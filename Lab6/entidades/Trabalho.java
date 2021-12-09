package entidades;
public class Trabalho {
    /*
    Um aluno de pesquisa precisa ler muitos trabalhos científicos, e durante essa leitura fazer uma série de anotações dos trabalhos. Organização nesse processo é fundamental. Implemente um programa onde o aluno de pesquisa possa informar dados dos trabalhos científicos e em seguida possa fazer anotações sobre o trabalho. Um trabalho científico pode ser um Artigo de Revista, Artigo de Congresso, Tese, Dissertação ou TCC. Todos têm título, um ou mais autores, ano, local de publicação. O artigo de revista ainda tem um ISSN. O Artigo de Congresso ainda tem um ISBN. Tese, dissertação e TCC além do ISBN também tem o curso realizado.


    Cada trabalho deste pode conter 1 ou mais anotações, texto livre.
    Seu programa deve permitir:
    a)   Fazer todos os cadastros
    b)   Criar anotações sobre os trabalhos
    c)   Consultar por qualquer texto livre em anotações ou título do trabalho
    */
    private String tipo;
    private String titulo;
    private String autores;
    private String ano;
    private String local_publicacao;
    private String anotacoes;
    private int contador_anotacoes;

    public Trabalho(String tipo, String titulo, String autores, String ano, String local_publicacao){
        this.tipo = tipo;
        this.titulo = titulo.toUpperCase(); //char char1UpperCase = Character.toUpperCase(char1);
        this.autores = autores;
        this.ano = ano;
        this.local_publicacao = local_publicacao;
        this.anotacoes = "\""+this.titulo+"\"\n";
        this.contador_anotacoes = 1;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAnotacoes(){
        return this.anotacoes;
    }

    public void addAnotacoes(String nova_anotacao){
        this.anotacoes += this.contador_anotacoes+". "+nova_anotacao+"\n";
        this.contador_anotacoes++;
    }
}
