package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;



public class Solver {
	
	private InstanciaReservas _instancia;
	private Comparator<Reserva> _comparator;
	
	
	public Solver(InstanciaReservas instancia, Comparator<Reserva> comparator) {
		_instancia = instancia;
		_comparator = comparator;
	}
	
	public PsbleSolucion resolver() {
	    PsbleSolucion ret = new PsbleSolucion();
	    List<Reserva> reservas = objetosOrdenados();

	    for (Reserva reserva : reservas) {
	        boolean acum = true;
	        for (int k = reserva.getHoraDesde(); k < reserva.getHoraHasta(); k++) {
	            if (!ret.getHoraEstaDisponible(k)) {
	                acum = false;
	                break;
	            }
	        }
	        if (acum) {
	            ret.agregar(reserva);
	        }
	    }
	    return ret;
	}

	
	private List<Reserva> objetosOrdenados() {
		List<Reserva> ret = _instancia.getObjetos();
		Collections.sort(ret, _comparator);
		Collections.reverse(ret);
		
		return ret;
	}
/*
	public static void marcarHorarios(ArrayList<String> horarios, Reserva reserva) {
		if(horarioEstaLibre(horarios, reserva) && !horarios.contains(reserva.getNombreBanda())) {
			for(int i = reserva.getHoraDesde(); i< reserva.getHoraHasta(); i++) {
				horarios.remove(i);
				horarios.add(i, reserva.getNombreBanda());
			}
		}
		else {
			throw new RuntimeException("no esta libre el horario para reservar");
		}
	}
	
	public static boolean horarioEstaLibre(ArrayList<String> horarios, Reserva reserva) {
		boolean flag = true;
		for(int i = reserva.getHoraDesde(); i< reserva.getHoraHasta()-1; i++){
			flag &= horarios.get(i) == "-";
		}
		return flag;
	}
	
	public static ArrayList<String> setearHorario() {
		ArrayList<String> horario = new ArrayList<String>();
		for(int i = 0; i < 24; i++ ) {
			horario.add("-");
		}
		return horario;
	}
	


	public static void crearSolucion(HashMap<String, Reserva> listaReservas){
		Set<String> bandaRegistradasEnSolucion = new HashSet<String>();	
		String[] horarios = new String[24];
		Random rand = new Random();
		
	
	
	}*/
	
	


}
