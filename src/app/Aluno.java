package app;
import static app.Data.calcularIdade;

/**
 * Representa um aluno com dados pessoais e acadêmicos (nome, matrícula, média, situação etc.).
 * @author Artur Saraiva Rabelo (asr.engsoft@gmail.com)
 * @version 1.0
 * @since 2025-11-02
 */

public class Aluno {
    //Atributos pessoais
    String nome;
    Data dataNascimento;
    int idade;
    Sexo sexo;
    //Atributos academicos
    int matricula;
    String curso;
    String periodo;
    double media;
    String situacao;

    //Construtor
    public Aluno(String nome, Data dataNascimento, Sexo sexo, int matricula, String curso, String periodo, double media) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.idade = calcularIdade(dataNascimento);
        this.sexo = sexo;
        this.matricula = matricula;
        this.curso = curso;
        this.periodo = periodo;
        this.media = media;
        
        if(media >= 7) {
            this.situacao = "Aprovado";
        } else if (media >= 4) {
            this.situacao = "Final";
        } else {
            this.situacao = "Reprovado";
        }
    }

    //Getters
    public String getNome() {
        return this.nome;
    }
    public int getMatricula() {
        return this.matricula;
    }
    public String getCurso() {
        return this.curso;
    }
    public String getPeriodo() {
        return this.periodo;
    }
    public double getMedia() {
        return this.media;
    }
    public String getSituacao() {
        return this.situacao;
    }
    public Sexo getSexo() {
        return this.sexo;
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public void setMedia(double media) {
        this.media = media;
        if(media >= 7) {
            setSituacao("Aprovado");
        } else if (media >= 4) {
            setSituacao("Final");
        } else {
            setSituacao("Reprovado");
        }



    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }



    public String coloredSituacao(String situacao){
        if(this.situacao == "Aprovado") {
            return "<font color=\"green\">" + situacao + "</font>";
        } else if (this.situacao == "Final") {
            return "<font color=\"orange\">" + situacao + "</font>";
        } else {
            return "<font color=\"red\">" + situacao + "</font>";
        }

    }

    public String toString(){
        String mensagem = "(" + this.matricula + ") " + this.nome
                        + "<br>Data de Nascimento: " + this.dataNascimento.getDataFormatada() 
                        + "<br>Sexo: " + this.sexo
                        + "<br>Curso: " + this.curso
                        + "<br>Média: " + this.media + " - " + coloredSituacao(this.situacao);
        return mensagem;
    }
}

