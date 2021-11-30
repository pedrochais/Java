package atividade;

import java.util.ArrayList;

public abstract class Atividade {
    protected String assunto;
    protected String data;
    protected float nota;
    protected boolean status;

    public Atividade(String assunto, String data){
        this.assunto = assunto;
        this.data = data;
        this.status = false;
    }

    public void mudarStatus(){
        if(this.status == true){
            this.status = false;
        } else {
            this.status = true;
        }
    }

    public boolean getStatus(){
        return this.status;
    }

    public float getNota(){
        return this.nota;
    }

    public String getAssunto(){
        return this.assunto;
    }

    public String getData(){
        return this.data;
    }

    public void setNota(float nota){
        this.nota = nota;
    }

    public void setStatus(boolean status){
        this.status = status;
    }
}
