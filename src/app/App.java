package app;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Classe principal que inicia a aplicação e exibe a interface (menus e caixas de diálogo).
 * @author Artur Saraiva Rabelo (asr.engsoft@gmail.com)
 * @version 1.5.3
 * @since 2025-11-02
 */

public class App {
    
    public static void main(String[] args) throws Exception {
        
        //Look and Feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) { 
            System.err.println("Não foi possível carregar o Look and Feel Nimbus."); 
        }

        GerenciarAlunos minhaTurma = new GerenciarAlunos();
        minhaTurma.cadastrarAluno("João Quinzé Oliveira", new Data(10, 10, 2001), Sexo.M, 654321, "Informática", "2", 8.5);
        minhaTurma.cadastrarAluno("Maria Samara Saraiva", new Data(10, 10, 2006), Sexo.M, 952056, "Informática", "2", 6.5);
        minhaTurma.cadastrarAluno("Joana Martins Rabelo", new Data(10, 10, 1997), Sexo.F, 623109, "Informática", "2", 3.5);
        minhaTurma.cadastrarAluno("Katia Santos Martins", new Data(10, 10, 2001), Sexo.M, 654321, "Informática", "2", 8.5);
        iniciar(minhaTurma);

    }    

    //Função para iniciar o programa
    public static void iniciar(GerenciarAlunos minhaTurma) {

        boolean continuar = true;
        String mensagem = "";
        String nome, curso, periodo, situacao, mediaInput;
        Sexo sexo;
        double media;
        Data dataNascimento;
        int idade, matricula;
        String sn[] = {"Sim", "Nao"};
        int snOption;
        Aluno aluno;
        String sexoOP[] = {"Masculino", "Feminino", "Cancelar"};

        while(continuar){
            String opcoes[] = {"Gerenciar alunos da turma", "Relatórios da turma",  "Sair"};
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "<html><h3>Escolha uma opção para continuar:</h3></html>", "Sistema de Gerenciamento de Alunos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[2]);
        
            switch (opcaoSelecionada) {
                case 0: //Gerenciar Alunos
                    String opcoesB[] = {"Cadastrar aluno", "Buscar aluno", "Listar alunos", "Remover aluno", "Atualizar aluno", "Voltar"};
                    int opcaoSelecionadaB = JOptionPane.showOptionDialog(null,"<html><h4>Gerenciamento de alunos</h4></html>", "Sistema de Gerenciamento de Alunos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesB, opcoesB[5]);
                    switch (opcaoSelecionadaB) {
                        case 0: //Cadastrar Aluno (ok)
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
                                if(nome == null) {
                                    break;
                                } else if (nome.equals("") | contemNumeros(nome) ) {
                                    JOptionPane.showMessageDialog(null, "<html>Nome inválido!<br>A operação foi cancelada.</html>");
                                    break;
                                }
                                dataNascimento = DataBox.showDataBox();
                                if(dataNascimento == null){
                                    break;
                                }
                                int sexoSelected = (JOptionPane.showOptionDialog(null, "Qual o sexo do aluno(a)?", "Sistema de Gerenciamento de Alunos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sexoOP, sexoOP[2]));
                                if(sexoSelected == 2 | sexoSelected == -1){
                                    break;
                                }
                                sexo = Sexo.converterParaSexo(sexoSelected);
                                curso = JOptionPane.showInputDialog("Qual o curso do aluno(a)?");
                                if(curso == null) {
                                    break;
                                } else if (curso.equals("") | contemNumeros(curso) ) {
                                    JOptionPane.showMessageDialog(null, "<html>Nome inválido!<br>A operação foi cancelada.</html>");
                                    break;
                                }
                                periodo = JOptionPane.showInputDialog("<html>Qual o período do aluno(a)?<br>(Número de semestres desde que ingressou)</html>");

                                mediaInput = JOptionPane.showInputDialog("Qual a média acadêmica do aluno(a)?");
                                if (mediaInput == null || mediaInput.equals("") || mediaInput.equals("-1")) {
                                    break; 
                                }
                                try {
                                    mediaInput = mediaInput.replace(',', '.'); 
                                    media = Double.parseDouble(mediaInput);
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "<html>Média inválida!<br>A operação foi cancelada.</html>");
                                    break;
                                }
                                try{
                                    minhaTurma.cadastrarAluno(nome, dataNascimento, sexo, GerenciarAlunos.generateMatricula(), curso, periodo, media);
                                    JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
                                } catch(Exception e){
                                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno!");
                                }
                            }
                            break;
                        case 1: //Buscar Aluno (ok)
                            if(minhaTurma.getId() == 0){
                                JOptionPane.showMessageDialog(null, "Turma vazia!");
                            }else{
                                try{
                                    matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite a matricula do aluno(a) que deseja buscar:"));
                                    aluno = minhaTurma.buscarAluno(matricula);
                                    if(aluno == null){
                                        continue;
                                    }
                                    mensagem = "<html>" + aluno.toString() + "</html>";
                                    JOptionPane.showMessageDialog(null, mensagem);
                                } catch(NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Matricula invalida!");
                                }
                            }
                            break;

                        case 2: //Listar Alunos (ok)
                            if(minhaTurma.getId() == 0){
                                JOptionPane.showMessageDialog(null, "Turma vazia!");
                            }else{
                                minhaTurma.listarAlunos();
                            }
                            break;

                        case 3: //Remover Aluno (ok)
                            if(minhaTurma.getId() == 0){
                                JOptionPane.showMessageDialog(null, "Turma vazia!");
                            }else{
                                String matriculaInput = (JOptionPane.showInputDialog("Digite a matricula do aluno(a) que deseja remover:"));
                                if(matriculaInput == null){
                                    continue;
                                }
                                try{
                                    matricula = Integer.parseInt(matriculaInput);
                                    aluno = minhaTurma.buscarAluno(matricula);
                                    if(aluno == null){
                                        continue;
                                    }
                                    minhaTurma.removerAluno(aluno);
                                    if(aluno.getSexo() == Sexo.M){
                                        mensagem = "<html>O Aluno:<br><br>" + aluno.toString() + "<br<br>Foi removido com sucesso!</html>";
                                    }else if(aluno.getSexo() == Sexo.F){
                                        mensagem = "<html>A Aluna:<br><br>" + aluno.toString() + "<br<br>Foi removida com sucesso!</html>";
                                    }
                                    JOptionPane.showMessageDialog(null, mensagem);
                                } catch(NumberFormatException | NullPointerException e) {
                                    JOptionPane.showMessageDialog(null, "Matricula invalida!");
                                }
                            }
                            break;
                        case 4: //Atualizar Aluno (ok)
                            if(minhaTurma.getId() == 0){
                                JOptionPane.showMessageDialog(null, "Turma vazia!");
                            }else{
                                try{
                                    matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite a matricula do aluno(a) que deseja modificar:"));
                                    aluno = minhaTurma.buscarAluno(matricula);
                                    if(aluno == null){
                                        continue;
                                    }
                                    boolean atualizar = true;
                                    while(atualizar){
                                        mensagem = "<html>Aluno:<br><br>" + aluno.toString() + "<br><br>Qual informação deseja modificar?</html>";
                                        int atualizarOption = JOptionPane.showOptionDialog(null, mensagem, "Sistema de Gerenciamento de Alunos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Nome", "Data de Nascimento", "Sexo", "Curso", "Período", "Média Acadêmica", "Sair"}, "Sair");
                                        switch(atualizarOption){
                                            case 0: //Nome
                                            nome =(JOptionPane.showInputDialog("Digite o novo nome:"));
                                            if(nome == null) {
                                                break;
                                            } else if (nome.equals("") | contemNumeros(nome) ) {
                                                JOptionPane.showMessageDialog(null, "<html>Nome inválido!<br>A operação foi cancelada.</html>");
                                                break;
                                            }
                                            aluno.setNome(nome);
                                                break;
                                            case 1: //Data de Nascimento
                                                dataNascimento = (DataBox.showDataBox());
                                                if(dataNascimento == null){
                                                    break;
                                                }
                                                aluno.setDataNascimento(dataNascimento);
                                                break;
                                            case 2: //Sexo
                                                int sexoSelected = (JOptionPane.showOptionDialog(null, "Qual o sexo do aluno(a)?", "Sistema de Gerenciamento de Alunos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sexoOP, sexoOP[2]));
                                                if(sexoSelected == 0){
                                                    aluno.setSexo(Sexo.M);
                                                }else if(sexoSelected == 1){
                                                    aluno.setSexo(Sexo.F);
                                                } else if(sexoSelected == 2 | sexoSelected == -1){
                                                    break;
                                                }
                                                break;
                                            case 3: //Curso
                                                curso = (JOptionPane.showInputDialog("Digite o novo curso:"));
                                                if(curso == null) {
                                                    break;
                                                } else if (curso.equals("") | contemNumeros(curso) ) {
                                                    JOptionPane.showMessageDialog(null, "<html>Nome inválido!<br>A operação foi cancelada.</html>");
                                                    break;
                                                }
                                                aluno.setCurso(curso);
                                                break;
                                            case 4: //Período
                                                aluno.setPeriodo(JOptionPane.showInputDialog("Digite o novo período:"));
                                                break;
                                            case 5: //Média Acadêmica
                                                mediaInput = JOptionPane.showInputDialog("Qual a média acadêmica do aluno(a)?");
                                                if (mediaInput == null || mediaInput.equals("") || mediaInput.equals("-1")) {
                                                    break; 
                                                }
                                                try {
                                                    mediaInput = mediaInput.replace(',', '.'); 
                                                    media = Double.parseDouble(mediaInput);
                                                } catch (NumberFormatException e) {
                                                    JOptionPane.showMessageDialog(null, "<html>Média inválida!<br>A operação foi cancelada.</html>");
                                                    break;
                                                }
                                                aluno.setMedia(media);
                                                break;
                                            case 6: //Sair
                                                atualizar = false;
                                                break;
                                        }
                                    }
                                } catch(NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Matricula invalida!");
                                }
                            }
                            break;
                        default:
                            continue;
                    }
                    break;
                case 1: //Relatórios
                    String opcoesA[] = {"", "", "Voltar"};
                    int opcaoSelecionadaA = JOptionPane.showOptionDialog(null,"<html><h4>Informações sobre a turma</h4></html>", "Sistema de Gerenciamento de Alunos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesA, opcoesA[2]);
                    
                case 2: //Sair 
                    continuar = false;
                    break;
                default:
                    continuar = false;
                    break;
            }
        }
    }

    public static boolean contemNumeros(String texto) {
    if (texto == null) {
        return false;
    }
    for (char c : texto.toCharArray()) {
        if (Character.isDigit(c)) {
            return true; 
        }
    }
    return false;
}
}