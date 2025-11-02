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
    }
}

