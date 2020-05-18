package caber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Torneo {
	private int cantLanzadores;
	private List<Lanzador> lanzadores;
	private List<Lanzador> podioD;
	private List<Lanzador> podioC;
	private String path;

	public Torneo(String path) {
		lanzadores = new ArrayList<Lanzador>();
		podioD = new ArrayList<Lanzador>();
		podioC = new ArrayList<Lanzador>();
		this.path = path;
	}

	public void jugarTorneo() {
		int i;
		cargarLanzadores();
		Collections.sort(lanzadores);
		for (i = 0; i < 3; i++) {
			podioD.add(lanzadores.get(i));
		}
		Collections.sort(lanzadores, Lanzador.Comparators.CONSISTENCIA);
		i = 0;
		while (podioC.size() < 3 && i < lanzadores.size()) {
			if (!lanzadores.get(i).getDescalificado())
				podioC.add(lanzadores.get(i));
			i++;
		}
		grabarResultados();
	}

	public void cargarLanzadores() {
		try {
			Scanner sc = new Scanner(new File("./lote_pruebas/Input/" + path + ".in"));
			Lanzador lanzador;
			Lanzamiento lanzamiento;
			double distancia = 0;
			double grados = 0;
			boolean descalificado = false;
			double distanciaTotal = 0, consistencia = 0;
			cantLanzadores = sc.nextInt();
			for (int i = 0; i < cantLanzadores; i++) {
				descalificado = false;
				distanciaTotal = 0;
				consistencia = 0;
				for (int j = 0; j < 3; j++) {
					distancia = Double.parseDouble(sc.next());
					grados = Double.parseDouble(sc.next());
					lanzamiento = new Lanzamiento(grados, distancia);
					distanciaTotal += lanzamiento.obtenerDistanciaValida();
					if (lanzamiento.isDescalificado()) {
						descalificado = true;
					}
					consistencia += Math.abs(grados);
				}
				consistencia /= 3;
				lanzador = new Lanzador(i + 1, distanciaTotal, consistencia, descalificado);
				lanzadores.add(lanzador);
			}
			sc.close();
			System.out.println(path + ".out " + " generado con exito!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void grabarResultados() {
		try {
			PrintWriter pw = new PrintWriter(new File("./lote_pruebas/Recibido/" + path + ".out"));
			for (Lanzador l : podioC)
				pw.print(l.getId() + " ");
			pw.println();
			for (Lanzador l : podioD)
				pw.print(l.getId() + " ");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
