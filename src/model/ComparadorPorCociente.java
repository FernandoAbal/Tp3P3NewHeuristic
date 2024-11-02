package model;

import java.util.Comparator;

public class ComparadorPorCociente implements Comparator<Reserva>{

	@Override
	public int compare(Reserva una, Reserva otra) {
		return (int) (una.getMonto()/una.getCantidadHoras() - otra.getMonto()/otra.getCantidadHoras());
	}

}