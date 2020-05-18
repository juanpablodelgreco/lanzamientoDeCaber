package caber;

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import java.util.Scanner;

public class TestsCaber {
	@Test
	public void testEntrada1() throws FileNotFoundException {
		// Caso base
		Torneo t = new Torneo("entrada1");
		t.jugarTorneo();

		Scanner esperado = new Scanner(new File("./lote_pruebas/Esperado/entrada1.out"));
		String esp = esperado.useDelimiter("\\A").next();

		Scanner recibido = new Scanner(new File("./lote_pruebas/Recibido/entrada1.out"));
		String rec = recibido.useDelimiter("\\A").next();
		Assert.assertEquals(esp, rec);

		esperado.close();
		recibido.close();
	}

	@Test
	public void testEntrada2() throws FileNotFoundException {

		// Verifica que el programa no sume los lanzamientos descalificados.
		Torneo t = new Torneo("entrada2");
		t.jugarTorneo();

		Scanner esperado = new Scanner(new File("./lote_pruebas/Esperado/entrada2.out"));
		String esp = esperado.useDelimiter("\\A").next();

		Scanner recibido = new Scanner(new File("./lote_pruebas/Recibido/entrada2.out"));
		String rec = recibido.useDelimiter("\\A").next();
		Assert.assertEquals(esp, rec);

		esperado.close();
		recibido.close();

	}

	@Test
	public void testEntrada3() throws FileNotFoundException {
		// Verifica que el programa solo muestre 3 ganadores.
		Torneo t = new Torneo("entrada3");
		t.jugarTorneo();

		Scanner esperado = new Scanner(new File("./lote_pruebas/Esperado/entrada3.out"));
		String esp = esperado.useDelimiter("\\A").next();

		Scanner recibido = new Scanner(new File("./lote_pruebas/Recibido/entrada3.out"));
		String rec = recibido.useDelimiter("\\A").next();

		Assert.assertEquals(esp, rec);

		esperado.close();
		recibido.close();

	}
}
