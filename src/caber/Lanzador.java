package caber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lanzador implements Comparable<Lanzador>{
	private int id;
	private double distTotalRecorrida;
	private double consistencia;
	private boolean descalificado;


	public Lanzador(int id,double distTotalRecorrida, double consistencia, boolean descalificado) {
		//lanzamientos = new ArrayList<Lanzamiento>();
		this.id = id;
		this.distTotalRecorrida = distTotalRecorrida;
		this.consistencia = consistencia;
		this.descalificado = descalificado;
	}

	public boolean getDescalificado() {
		return this.descalificado;
	}

	public int compareConsistencia(Lanzador l) {
		return (int)this.consistencia - (int)l.consistencia;
	}

	public double getDistTotalRecorrida() {
		return distTotalRecorrida;
	}
	
	public double getConsistencia() {
		return consistencia;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Lanzador [id=" + id + ", distTotalRecorrida=" + distTotalRecorrida + ", consistencia=" + consistencia
				+ ", descalificado=" + descalificado + "]";
	}

	@Override
	public int compareTo(Lanzador obj) {
		return (int)obj.distTotalRecorrida - (int)this.distTotalRecorrida;
	}
	
	public static class Comparators {
		
		public static Comparator<Lanzador> CONSISTENCIA = new Comparator<Lanzador>() {
			@Override
			public int compare(Lanzador l1, Lanzador l2) {
				return (int) l1.getConsistencia() - (int) l2.getConsistencia();
			}
		};
	}
}
