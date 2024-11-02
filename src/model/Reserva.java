package model;

public class Reserva {
	
	private String nombreBanda;
	private int horaDesde;
	private int horaHasta;
	private double monto;
	
	public Reserva(String nombreBanda, int horaDesde, int horaHasta, double monto) {
		this.nombreBanda = nombreBanda;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
		this.monto =  monto;
	}

	
	
	
	public String getNombreBanda() {
		return nombreBanda;
	}
	public int getHoraDesde() {
		return horaDesde;
	}
	public int getHoraHasta() {
		return horaHasta;
	}
	public double getMonto() {
		return monto;
	}
	public int getCantidadHoras() {
		return horaHasta - horaDesde;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombreBanda +"\n");
		sb.append("de: " + horaDesde + " a " + horaHasta + "\n");
		sb.append(monto+ "\n-------------");
		return sb.toString();
	}
	
}
