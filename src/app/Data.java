package app;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Data {
    private String dataFormatada;
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.dataFormatada = dia + "/" + mes + "/" + ano;
    }

    public String getDataFormatada() {
        return dataFormatada;
    }

    public static int calcularIdade(Data dataNascimento) {
        LocalDate dataAtual = LocalDate.now();
        int diaAtual = dataAtual.getDayOfMonth();
        int mesAtual = dataAtual.getMonthValue();
        int anoAtual = dataAtual.getYear();

        int idade = anoAtual - dataNascimento.ano;
        if (mesAtual < dataNascimento.mes || (mesAtual == dataNascimento.mes && diaAtual < dataNascimento.dia)) {
            idade--;
        }
        return idade;
    }
}


