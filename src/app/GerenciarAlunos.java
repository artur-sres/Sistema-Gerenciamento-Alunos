package app;
public class GerenciarAlunos {
    private Aluno turma[];
    private int id;

    //Construtor
    public GerenciarAlunos() {
        turma = new Aluno[5];
    }

    public Aluno[] getTurma() {
        return turma;
    }
    public int getId() {
        return id;
    }

    public void setTurma(Aluno[] turma) {
        this.turma = turma;
    }

    public void cadastrarAluno(String nome, Data dataNascimento, int idade, Sexo sexo, String matricula, String curso, String periodo, double media){
        Aluno aluno = new Aluno(nome, dataNascimento, idade, sexo, matricula, curso, periodo, media);
        turma[id] = aluno;
        id++;
    }

    public String GerenciarAlunos listarAlunos(){
        String mensagem = "";
        for(int i = 0; i < id; i++) {
            mensagem += turma[i].toString(turma[i]) + "\n\n";
        }
        return mensagem;
    }
}
