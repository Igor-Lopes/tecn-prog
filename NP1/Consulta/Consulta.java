/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Consulta {

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public void gravaConsulta(String nomeMedico, String nomePaciente, boolean usaPlano, String agendamento)
            throws IOException {

        File file = new File("Consulta", "consultas.txt");
        FileWriter writer = new FileWriter("Consulta/consultas.txt", true);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        String output = nomeMedico + ";" + nomePaciente + ";" + usaPlano + ";" + agendamento;
        writer.write(output);
        writer.write(System.getProperty("line.separator"));
        writer.close();

        this.agendaConsulta(nomePaciente, nomeMedico, agendamento);
    }

    private void agendaConsulta(String nomePaciente, String nomeMedico, String horario) {

        Timer timer = new Timer();

        TimerTask novoLembrete = new Lembrete(nomePaciente, nomeMedico, horario);

        Date dateTask = new Date();

        try {
            dateTask = this.dateFormat.parse(horario);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateTask);
            cal.set(Calendar.HOUR, 8);
            cal.set(Calendar.MINUTE, 0);
 
            timer.schedule(novoLembrete, cal.getTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
