package testeoCaber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.Assert;
import org.junit.Test;

import caber.Torneo;

import java.util.Scanner;

public class TestsCaber {
	@Test
	public void testCasoBase() throws FileNotFoundException {
		// Verifica que el programa realiza el ejemplo del enunciado correctamente.
		Torneo t = new Torneo("CasoBase");
		t.jugarTorneo();

		Scanner esperado = new Scanner(new File("./lote_pruebas/Esperado/CasoBase.out"));
		String esp = esperado.useDelimiter("\\A").next();

		Scanner recibido = new Scanner(new File("./lote_pruebas/Recibido/CasoBase.out"));
		String rec = recibido.useDelimiter("\\A").next();
		Assert.assertEquals(esp, rec);

		esperado.close();
		recibido.close();
	}

	@Test
	public void testLanzamientoDescalificado() throws FileNotFoundException {

		// Verifica que el programa no sume los lanzamientos descalificados.
		Torneo t = new Torneo("LanzamientoDescalificado");
		t.jugarTorneo();

		Scanner esperado = new Scanner(new File("./lote_pruebas/Esperado/LanzamientoDescalificado.out"));
		String esp = esperado.useDelimiter("\\A").next();

		Scanner recibido = new Scanner(new File("./lote_pruebas/Recibido/LanzamientoDescalificado.out"));
		String rec = recibido.useDelimiter("\\A").next();
		Assert.assertEquals(esp, rec);

		esperado.close();
		recibido.close();

	}

	@Test
	public void testMaximoPodio() throws FileNotFoundException {
		// Verifica que el programa solo muestre 3 ganadores.
		Torneo t = new Torneo("MaximoPodio");
		t.jugarTorneo();

		Scanner esperado = new Scanner(new File("./lote_pruebas/Esperado/MaximoPodio.out"));
		String esp = esperado.useDelimiter("\\A").next();

		Scanner recibido = new Scanner(new File("./lote_pruebas/Recibido/MaximoPodio.out"));
		String rec = recibido.useDelimiter("\\A").next();

		Assert.assertEquals(esp, rec);

		esperado.close();
		recibido.close();

	}

	@Test
	public void testTodosDescalificados() throws FileNotFoundException {
		// Demuestra que el programa muestre que no hay ganadores si están todos
		// descalificados.
		Torneo t = new Torneo("todosDescalificados");
		t.jugarTorneo();

		Scanner esperado = new Scanner(new File("./lote_pruebas/Esperado/todosDescalificados.out"));
		String esp = esperado.useDelimiter("\\A").next();

		Scanner recibido = new Scanner(new File("./lote_pruebas/Recibido/todosDescalificados.out"));
		String rec = recibido.useDelimiter("\\A").next();

		Assert.assertEquals(esp, rec);

		esperado.close();
		recibido.close();

	}

	@Test
	public void testUnGanadorUnDescalificado() throws FileNotFoundException {
		// Demuestra que el programa muestre correctamente cuando hay un ganador en
		// distancia pero no hay ganadores en consistencia porque están descalificados.
		Torneo t = new Torneo("unGanadorUnDescalificado");
		t.jugarTorneo();

		Scanner esperado = new Scanner(new File("./lote_pruebas/Esperado/unGanadorDosDescalificados.out"));
		String esp = esperado.useDelimiter("\\A").next();

		Scanner recibido = new Scanner(new File("./lote_pruebas/Recibido/unGanadorDosDescalificados.out"));
		String rec = recibido.useDelimiter("\\A").next();

		Assert.assertEquals(esp, rec);

		esperado.close();
		recibido.close();

	}
	
	@Test
	public void testCasoFatiga() throws FileNotFoundException {
		//generadorCasoFatiga();
		Torneo t = new Torneo("casoFatiga");
		t.jugarTorneo();
		Scanner esperado = new Scanner(new File("./lote_pruebas/Esperado/casoFatiga.out"));
		String esp = esperado.useDelimiter("\\A").next();

		Scanner recibido = new Scanner(new File("./lote_pruebas/Recibido/casoFatiga.out"));
		String rec = recibido.useDelimiter("\\A").next();
	}
	
	public void generadorCasoFatiga() {
		try {
			PrintWriter pw = new PrintWriter(new File("./lote_pruebas/Input/casoFatiga.in"));
			pw.println(100000);
			double distancia, angulo;
			for (int i = 0; i < 100000; i++) {
				for (int j = 0; j < 3; j++) {
					distancia = (double) (Math.random() * 3) + 1;
					angulo = (double) (Math.random() * 100) + 1;
					pw.println(distancia + " " + angulo);
				}

			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
