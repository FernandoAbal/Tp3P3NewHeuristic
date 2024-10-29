package model;

import java.util.Comparator;

public class ComparadorPorMonto implements Comparator<Reserva>{

	@Override
	public int compare(Reserva una, Reserva otra) {
		return (int) (una.getMonto() - otra.getMonto());
	}

}
