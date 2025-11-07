package app;
import javax.swing.JOptionPane;

/**
 * Gerencia operações sobre a turma de alunos (cadastrar, buscar, listar, remover e atualizar).
 * @author Artur Saraiva Rabelo (asr.engsoft@gmail.com)
 * @version 1.0
 * @since 2025-11-02
 */

public class GerenciarAlunos {
    public static final int MAX_ALUNOS = 5;
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

    public Aluno buscarAluno(int matricula) {
        Aluno busca;
        if(matricula < 100000 || matricula > 999999) {
            JOptionPane.showMessageDialog(null, "Matricula invalida!");
            return null;
        }
        for(int i = 0; i < this.id; i++) {
            if(this.turma[i].getMatricula() == matricula) {
                busca = this.turma[i];
                return busca;
            }
        }
        JOptionPane.showMessageDialog(null, "Aluno nao encontrado!");
        return null;
    }

    public void removerAluno(Aluno aluno) {
        if (aluno != null) {
            for (int i = 0; i < this.id; i++) {
                if (this.turma[i].getMatricula() == aluno.getMatricula()) {
                    for (int j = i; j < this.id - 1; j++) {
                        this.turma[j] = this.turma[j + 1];
                    }
                    this.id--;
                    this.turma[this.id] = null;
                    break;
                }
            }
        }
    }
}
    

