package caber;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Torneo {
	private int cantLanzadores;
	private List<Lanzador> lanzadores;
	private List<Lanzador> podioD;
	private List<Lanzador> podioC;
	private String inputPath;
	private String outputPath;

	public Torneo(String inputPath, String outputPath) {
		lanzadores = new ArrayList<Lanzador>();
		podioD = new ArrayList<Lanzador>();
		podioC = new ArrayList<Lanzador>();
		this.inputPath = inputPath;
		this.outputPath = outputPath;
	}

	public void jugarTorneo() {
		try {
			Scanner sc = new Scanner(new File(inputPath));
			Lanzador lanzador;
			Lanzamiento lanzamiento;
			double distancia = 0;
			double grados = 0;
			boolean descalificado  = false;
			double distanciaTotal= 0, consistencia = 0;
			cantLanzadores = sc.nextInt();
			for (int i = 0; i < cantLanzadores; i++) {
				descalificado = false;
				distanciaTotal = 0;
				consistencia = 0;
				for (int j = 0; j < 3; j++) {
					distancia = sc.nextDouble();
					grados = sc.nextDouble();
					lanzamiento = new Lanzamiento(grados,distancia);
					distanciaTotal += lanzamiento.obtenerDistanciaValida();
					if (lanzamiento.isDescalificado()) {
						descalificado = true;
					}
					consistencia += Math.abs(grados);
				}
				consistencia /= 3;
				lanzador = new Lanzador(distanciaTotal, consistencia, descalificado);
				lanzadores.add(lanzador);
			}
			for(Lanzador l : lanzadores) {
				System.out.println(l);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public void cargarLanzadores() {

	}

	public void grabarResultados() {

	}
}
