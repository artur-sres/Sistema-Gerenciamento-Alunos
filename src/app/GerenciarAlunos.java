package app;
import javax.swing.JOptionPane;
public class GerenciarAlunos {
    public static final int MAX_ALUNOS = 10;
    public static int matricula = 123456;
    private Aluno turma[];
    private int id;

    //Construtor
    public GerenciarAlunos() {
        turma = new Aluno[MAX_ALUNOS];
    }

    public Aluno[] getTurma() {
        return turma;
    }
    public int getId() {
        return this.id;
    }

    public void setTurma(Aluno[] turma) {
        this.turma = turma;
    }

    public static int generateMatricula(){
        return matricula++;
    }

    public void cadastrarAluno(String nome, Data dataNascimento, Sexo sexo, int matricula, String curso, String periodo, double media){
        Aluno aluno = new Aluno(nome, dataNascimento, sexo, matricula, curso, periodo, media);
        turma[id] = aluno;
        id++;
    }

    public void listarAlunos() {
        String listados = "<html>";
        for(int i = 0; i < this.id; i++) {
            if(this.turma[i] != null) {
                listados += this.turma[i].toString() + "<br><br>";   
            }
        }
        listados += "</html>";
        JOptionPane.showMessageDialog(null, listados);
    }

    public String buscarAluno(int matricula) {
        String busca;
        if(matricula < 100000 || matricula > 999999) {
            JOptionPane.showMessageDialog(null, "Matricula invalida!");
            return null;
        }
        for(int i = 0; i < this.id; i++) {
            if(this.turma[i].getMatricula() == matricula) {
                busca = this.turma[i].toString();
                return busca;
            }
        }
        JOptionPane.showMessageDialog(null, "Aluno nao encontrado!");
        return null;
    }
}
    

