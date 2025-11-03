package app;
import static app.Data.calcularIdade;

public class Aluno {
    //Atributos pessoais
    String nome;
    Data dataNascimento;
    int idade;
    Sexo sexo;
    //Atributos academicos
    String matricula;
    String curso;
    String periodo;
    double media;
    String situacao;

    //Construtor
    public Aluno(String nome, Data dataNascimento, int idade, Sexo sexo, String matricula, String curso, String periodo, double media) {
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
    public String getMatricula() {
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

    public String coloredSituacao(String situacao){
        if(this.situacao == "Aprovado") {
            return "<html>" + "<font color=\"green\">" + situacao + "</font></html>";
        } else if (this.situacao == "Final") {
            return "<html>" + "<font color=\"yellow\">" + situacao + "</font></html>";
        } else {
            return "<html>" + "<font color=\"red\">" + situacao + "</font></html>";
        }

    }

    public String toString(Aluno aluno){
        String mensagem = "(" + this.matricula + ") " + this.nome
                        + "\\nData de Nascimento: " + this.dataNascimento.getDataFormatada() + " - " + this.idade + " anos" + "Sexo: " + this.sexo
                        + "\nCurso: " + this.curso
                        + "\nMédia: " + this.media + "Situação: " + coloredSituacao(this.situacao);
        return mensagem;
    }
}

