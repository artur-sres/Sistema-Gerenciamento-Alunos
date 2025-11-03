package app;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class TesteDataComboBox {

    // (Supondo a mesma classe Data da opção 1)

    public static void main(String[] args) {
        
        // 1. Criar os JComboBoxes
        JComboBox<Integer> comboDia = new JComboBox<>();
        JComboBox<Integer> comboMes = new JComboBox<>();
        JComboBox<Integer> comboAno = new JComboBox<>();

        // 2. Popular os JComboBoxes com valores
        for (int i = 1; i <= 31; i++) {
            comboDia.addItem(i);
        }
        for (int i = 1; i <= 12; i++) {
            comboMes.addItem(i);
        }
        // Ex: popular anos de 1990 até 2030
        for (int i = 1990; i <= 2030; i++) {
            comboAno.addItem(i);
        }

        // 3. Criar o painel que vai conter os 3 combos
        JPanel painelInputs = new JPanel();
        painelInputs.add(new JLabel("Dia:"));
        painelInputs.add(comboDia);
        painelInputs.add(new JLabel("Mês:"));
        painelInputs.add(comboMes);
        painelInputs.add(new JLabel("Ano:"));
        painelInputs.add(comboAno);

        // 4. Exibir o JOptionPane com o painel customizado
        int resultado = JOptionPane.showConfirmDialog(
            null, 
            painelInputs, 
            "Selecione a Data de Nascimento", 
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        // 5. Verificar se o usuário clicou em OK
        if (resultado == JOptionPane.OK_OPTION) {
            int dia = (Integer) comboDia.getSelectedItem();
            int mes = (Integer) comboMes.getSelectedItem();
            int ano = (Integer) comboAno.getSelectedItem();

            // data = new Data(dia, mes, ano);
            
            System.out.println("Data selecionada: " + dia + "/" + mes + "/" + ano);
            // System.out.println("Objeto Data formatado: " + data.getDataFormatada());

        } else {
            System.out.println("Seleção de data cancelada.");
        }
    }
}

