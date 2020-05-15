package caber;

import java.util.ArrayList;
import java.util.List;

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

	}

	public void cargarLanzadores() {

	}

	public void grabarResultados() {

	}
}
