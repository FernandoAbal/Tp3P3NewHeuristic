package model;

import java.util.ArrayList;
import java.util.List;


public class InstanciaReservas {
	
	private ArrayList<Reserva> _reservas;
	private int _horas;
	
	
	public InstanciaReservas(int horas) {
		_reservas = new ArrayList<Reserva>();
		_horas = horas;
	}
	
	public void agregar(Reserva reserva) {
		_reservas.add(reserva);
	}

	@SuppressWarnings("unchecked")
	public List<Reserva> getObjetos() {
		return (ArrayList<Reserva>) _reservas.clone();
	}

	public int getHorasEntreAperturaCierre() {
		return _horas;
	}

	public int getTamano() {
		return _reservas.size();
	}

	public Reserva getObjeto(int i) {
		return _reservas.get(i);
	}

}
