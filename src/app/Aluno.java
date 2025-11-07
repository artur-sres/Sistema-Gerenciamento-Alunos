package app;
import static app.Data.calcularIdade;

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

