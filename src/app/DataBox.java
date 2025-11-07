package app;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class DataBox{
    public static Data showDataBox(){
        JComboBox<Integer> comboDia = new JComboBox<>();
        JComboBox<Integer> comboMes = new JComboBox<>();
        JComboBox<Integer> comboAno = new JComboBox<>();

        for (int i = 1; i <= 31; i++) {
            comboDia.addItem(i);
        }
        for (int i = 1; i <= 12; i++) {
            comboMes.addItem(i);
        }
        for (int i = 1990; i <= 2025; i++) {
            comboAno.addItem(i);
        }

        JPanel painelInputs = new JPanel();
        painelInputs.add(new JLabel("Dia:"));
        painelInputs.add(comboDia);
        painelInputs.add(new JLabel("Mês:"));
        painelInputs.add(comboMes);
        painelInputs.add(new JLabel("Ano:"));
        painelInputs.add(comboAno);

        int resultado = JOptionPane.showConfirmDialog(
        null, 
        painelInputs, 
        "Selecione a Data de Nascimento", 
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE
        );

        if (resultado == JOptionPane.OK_OPTION) {
            int dia = (Integer) comboDia.getSelectedItem();
            int mes = (Integer) comboMes.getSelectedItem();
            int ano = (Integer) comboAno.getSelectedItem();
    
            return new Data(dia, mes, ano);    
        }
        return null;
    }
}