package app;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
public class App {
    
    public static void main(String[] args) throws Exception {
        
        //Look and Feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) { 
            System.err.println("Não foi possível carregar o Look and Feel Nimbus."); 
        }

        GerenciarAlunos minhaTurma = new GerenciarAlunos();
        minhaTurma.cadastrarAluno("João Quinzé de Azevedo", new Data(10, 10, 2001), Sexo.M, 654321, "Informática", "2", 8.5);
        minhaTurma.cadastrarAluno("Maria Samara Saraiva", new Data(10, 10, 2006), Sexo.M, 952056, "Informática", "2", 6.5);
        minhaTurma.cadastrarAluno("Joana Martins de Oliveira", new Data(10, 10, 1997), Sexo.F, 623109, "Informática", "2", 3.5);
        iniciar(minhaTurma);

    }    

    //Função para iniciar o programa
    public static void iniciar(GerenciarAlunos minhaTurma) {

        boolean continuar = true;
        String mensagem = "";
        String nome, curso, periodo, situacao;
        Sexo sexo;
        double media;
        Data dataNascimento;
        int idade, dia, mes, ano, matricula;
        String sn[] = {"Sim", "Nao"};
        int snOption;

        while(continuar){
            String opcoes[] = {"Ver relatórios sobre a turma", "Gerenciar alunos da turma", "Sair"};
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "<html><h3>Escolha uma opção para continuar:</h3></html>", "Sistema de Gerenciamento de Alunos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[2]);
        
            switch (opcaoSelecionada) {
                case 0: //Relatórios
                String opcoesA[] = {"Listar alunos por nota", "Listar alunos por idade", "Voltar"};
                int opcaoSelecionadaA = JOptionPane.showOptionDialog(null,"<html><h4>Informações sobre a turma</h4></html>", "Sistema de Gerenciamento de Alunos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesA, opcoesA[2]);
                switch (opcaoSelecionadaA) {
                    case 0:
                        break;
                    case 1: 
                        break;
                    case 2:
                        continue;
                    default:
                        continuar = false;
                        break;
                }
                    break;
            
                case 1: //Gerenciar Alunos
                    String opcoesB[] = {"Cadastrar aluno", "Buscar aluno", "Listar alunos", "Excluir aluno", "Atualizar aluno", "Voltar"};
                    int opcaoSelecionadaB = JOptionPane.showOptionDialog(null,"<html><h4>Gerenciamento de alunos</h4></html>", "Sistema de Gerenciamento de Alunos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesB, opcoesB[5]);
                    switch (opcaoSelecionadaB) {
                        case 0: //Cadastrar Aluno
                            if(minhaTurma.getId() == GerenciarAlunos.MAX_ALUNOS){
                                JOptionPane.showMessageDialog(null, "A turma já chegou a sua capacidade maxima!\nNão é possivel cadastrar mais alunos!");
                                break;
                            }
                            mensagem = "<html><h4>Para podermos cadastrar um aluno, precisamos de algumas informações:</h4>"
                                     + "Nome Completo do Aluno(a)<br> Data de Nascimento<br> Sexo<br> Curso<br> Período<br> e Média Acadêmica<br><br>"
                                     + "Após isso, uma matricula será gerada automaticamente e o aluno será cadastrado na turma<br>"
                                     + "Deseja prosseguir?</html>";
                                     
                                     snOption = JOptionPane.showOptionDialog(null, mensagem, "Sistema de Gerenciamento de Alunos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sn, sn[1]);
                                     if(snOption == 0){
                                        nome = JOptionPane.showInputDialog("Digite o nome completo do aluno(a):");
                                        dataNascimento = DataBox.showDataBox();
                                        sexo = Sexo.converterParaSexo(JOptionPane.showOptionDialog(null, "Qual o sexo do aluno(a)?", "Sistema de Gerenciamento de Alunos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Sexo.values(), null));
                                        curso = JOptionPane.showInputDialog("Qual o curso do aluno(a)?");
                                        periodo = JOptionPane.showInputDialog("Qual o período do aluno(a)?");
                                        media = Double.parseDouble(JOptionPane.showInputDialog("Qual a média acadêmica do aluno(a)?"));
                                        minhaTurma.cadastrarAluno(nome, dataNascimento, sexo, GerenciarAlunos.generateMatricula(), curso, periodo, media);
                                        JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
                                     }
                            break;
                        case 1: //Buscar Aluno

                            break;
                        case 2: //Listar Alunos
                            if(minhaTurma.getId() == 0){
                                JOptionPane.showMessageDialog(null, "Turma vazia!");
                            }else{
                                minhaTurma.listarAlunos();
                                }
                            }
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            continue;
                        default:
                            continuar = false;
                            break;     
            }
        }
    }
}
