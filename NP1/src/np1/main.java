package np1;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		
		Consulta cons = new Consulta();
		
		try {
			cons.gravaConsulta("Carlos", "YRD", true, "28/09/2016 02:08");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
