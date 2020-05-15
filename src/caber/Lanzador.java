package caber;

import java.util.ArrayList;
import java.util.List;

public class Lanzador {
	private List<Lanzamiento> lanzamientos;
	private double distTotalRecorrida;
	private double consistencia;
	private boolean descalificado;

	public Lanzador(double distTotalRecorrida, double consistencia, boolean descalificado) {
		lanzamientos = new ArrayList<Lanzamiento>();
		this.distTotalRecorrida = distTotalRecorrida;
		this.consistencia = consistencia;
		this.descalificado = descalificado;
	}

	public boolean getDescalificado() {
		return this.descalificado;
	}

	public int compareDistancia(Lanzador l) {
		return 0;
	}

	public int compareConsistencia(Lanzador l) {
		return 0;
	}

}
