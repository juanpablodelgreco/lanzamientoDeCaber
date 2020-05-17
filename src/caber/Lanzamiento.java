package caber;

public class Lanzamiento {
	private double angulo;
	private double distancia;

	public Lanzamiento(double angulo, double distancia) {
		this.angulo = angulo;
		this.distancia = distancia;
	}

	public double obtenerDistanciaValida() {
		if (angulo >= -30 && angulo <= 30)
			return distancia;
		else if (angulo < 90 && angulo > -90)
				return distancia * 0.8;
			else return 0;
	}

	public boolean isDescalificado() {
		if(angulo>90 || angulo<-90)
			return true;
		else return false;
	}
	
}
