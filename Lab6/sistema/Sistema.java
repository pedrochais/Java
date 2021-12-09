package sistema;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import usuario.Pesquisador;
import usuario.Usuario;

public class Sistema {
    private Usuario usuario_atual;
    private String horario_login;
    private int tempo_limite;

    public Sistema(){
        this.tempo_limite = 30;
    }

    public Usuario getUsuarioAtual(){
        return this.usuario_atual;
    }

    public void setUsuarioAtual(Usuario usuario){
        this.usuario_atual = usuario;
    }

    public String[] listaUsuarios(Database database){
        String nomes[] = new String[database.getUsuarios().size()];
        for(int i = 0; i < database.getUsuarios().size(); i++){
            if(database.getUsuarios().get(i) instanceof Pesquisador){
                nomes[i] = database.getUsuarios().get(i).getNome()+" [sem permissão para modificar]";
            }else{
                nomes[i] = database.getUsuarios().get(i).getNome();
            }
        }
        return nomes;
    }

    public String[] listaTrabalhos(Database database){
        String titulos[] = new String[database.getTrabalhos().size()];
        for(int i = 0; i < database.getTrabalhos().size(); i++){
            titulos[i] = database.getTrabalhos().get(i).getTitulo();
        }
        return titulos;
    }

    public void registrarHorarioLogin(){
        DateTimeFormatter data_hora_formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.horario_login = data_hora_formatacao.format(LocalDateTime.now());
    }

    public boolean checarAcessoTemporario(){
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        LocalDateTime tempo_1 = LocalDateTime.parse(horario_login, formatacao);
        LocalDateTime tempo_2 = LocalDateTime.parse(formatacao.format(LocalDateTime.now()), formatacao);
        
        long diferencaSeg = Duration.between(tempo_1, tempo_2).getSeconds();
        //long diferencaMin = Duration.between(dt1, dt2).toMinutes();
        if(diferencaSeg < tempo_limite) return true;
        else return false;
    }
    
}
