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

        GerenciarAlunos turma = new GerenciarAlunos();
        turma.cadastrarAluno("João", new Data(10, 10, 2000), 20, Sexo.M, "123456", "Informática", "2", 8.5);
        turma.cadastrarAluno("Maria", new Data(10, 10, 2000), 20, Sexo.M, "123456", "Informática", "2", 8.5);
        iniciar();

    }    

    //Função para iniciar o programa
    public static void iniciar() {
        boolean continuar = true;
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
                            
                            break;
                        case 1: //Buscar Aluno

                            break;
                        case 2: //Listar Alunos
                            if(turma.id == 0){
                                JOptionPane.showMessageDialog(null, "Turma vazia!");
                            }else{
                                String mensagem = ;
                                
                                    
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
                    break;
                    
                case 2: //Sair
                    System.exit(0);
                    break;
        
                default:
                    continuar = false;
                    break;
            }
        }
    }
}
