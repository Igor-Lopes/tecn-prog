package np1;

import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Lembrete extends TimerTask {

    private String nomePaciente;
    private String nomeMedico;
    private String horario;

    public Lembrete(String paciente, String medico, String horaMinuto) {
        this.nomePaciente = paciente;
        this.nomeMedico = medico;
        this.horario = horaMinuto;
    }

    @Override
    public void run() {

        String msg = "Hoje, o paciente " + this.nomePaciente + " tem consulta com Dr(a). " + this.nomeMedico + " às " + horario;

        JOptionPane.showMessageDialog(null, msg);
        System.out.println(msg);
    }
}
