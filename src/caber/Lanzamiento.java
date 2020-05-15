package caber;

public class Lanzamiento {
	private double angulo;
	private double distancia;
	private boolean descalificado;

	public Lanzamiento(double angulo, double distancia) {
		this.angulo = angulo;
		this.distancia = distancia;
		this.descalificado = false;
	}

	public double obtenerDistanciaValida() {
		return 1;
	}

	public boolean isDescalificado() {
		return this.descalificado;
	}
}
