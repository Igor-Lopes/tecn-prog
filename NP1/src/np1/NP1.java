/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np1;

import java.io.IOException;

/**
 *
 * @author Igor Lopes
 */
public class NP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Consulta cons = new Consulta();

        try {
            cons.gravaConsulta("Carlos", "Igor", true, "28/09/2016 02:08");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
