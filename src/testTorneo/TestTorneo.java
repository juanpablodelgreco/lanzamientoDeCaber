package testTorneo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;



public class TestTorneo {

	@Test
	public void test() {
		File f = new File("./lote_pruebas/Recibido/entrada1.out");
		File fEsperado = new File("./lote_pruebas/Esperado/entrada1.out");
		FileReader fr;
		FileReader frE;
		try {
			fr = new FileReader(f);
			frE = new FileReader(fEsperado);
			BufferedReader br = new BufferedReader(fr);
			BufferedReader brEsperado = new BufferedReader(frE);
			
			String linea;
			String lineaEsperada;
			while((linea = br.readLine()) != null && (lineaEsperada = brEsperado.readLine()) != null) {
				Assert.assertEquals(linea, lineaEsperada);
			}
			
			
			
			brEsperado.close();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
