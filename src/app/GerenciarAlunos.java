package app;

/**
 * Gerencia operações sobre a turma de alunos (cadastrar, buscar, listar, remover e atualizar).
 * @author Artur Saraiva Rabelo (asr.engsoft@gmail.com)
 * @since 2025-11-02
 */

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

    public String listarAlunos() {
        String listados = "<html>";
        for(int i = 0; i < this.id; i++) {
            if(this.turma[i] != null) {
                listados += this.turma[i].toString() + "<br><br>";   
            }
        }
        listados += "</html>";
        return listados;
    }

    public Aluno buscarAluno(int matricula) {
        Aluno busca;
        if(matricula < 100000 || matricula > 999999) {
            throw new IllegalArgumentException("Matrícula inválida!");
        }
        for(int i = 0; i < this.id; i++) {
            if(this.turma[i].getMatricula() == matricula) {
                busca = this.turma[i];
                return busca;
            }
        }
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

    public String mediaTurma() {
        double soma = 0.0;
        for (int i = 0; i < this.id; i++) {
            soma += this.turma[i].getMedia();
        }
        double mediaTurma = soma / this.id;
        if(mediaTurma > 7) {
            return String.format("%.2f", mediaTurma) +" - <font color=\"green\">" + "A turnma esta na media</font>";
        } else if (mediaTurma < 7 && mediaTurma > 6) {
            return String.format("%.2f", mediaTurma) +" - <font color=\"orange\">" + "A turma esta a baixo da media</font>";
        } else {
            return String.format("%.2f", mediaTurma) +" - <font color=\"red\">" + "A turma esta muito abaixo da media</font>";
        }
    }

    public int contarAlunosPorSituacao(String situacao) {
        int contador = 0;
        for (int i = 0; i < this.id; i++) {
            if (this.turma[i].getSituacao().equals(situacao)) {
                contador++;
            }
        }
        return contador;
    }

    public String listarAlunosPorSituacao(String situacao) {
        String listados = "<html>";
        for (int i = 0; i < this.id; i++) {
            if (this.turma[i].getSituacao().equals(situacao)) {
                listados += this.turma[i].toString() + "<br><br>";
            }
        }
        listados += "</html>";
        return listados;
    }
}
    

