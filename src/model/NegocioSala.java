package model;

import java.time.LocalDate;

public class NegocioSala {
	private InstanciaReservas _instancia;
	
	public NegocioSala() {
		_instancia = new InstanciaReservas(24);
	}
	
	public void registrarReserva(String nombreBanda, int horaDesde, int horaHasta, int monto){
		for(Reserva reserv :_instancia.getObjetos()) {
				if (reserv.getNombreBanda() == nombreBanda) {
					throw new RuntimeException("la banda ya se encuentra en la lista de reservas");
			}
		}
			Reserva nuevaReserva = new Reserva(nombreBanda, horaDesde, horaHasta, monto);
			_instancia.agregar(nuevaReserva);
	}
	
	
	public InstanciaReservas getInstance() {
		return _instancia;
	}
	
	
	
	public void setearReservasDePrueba() {
		
		registrarReserva("Tesseract", 7, 10, 16000);
		registrarReserva("Periphery", 8, 12, 20000);
		registrarReserva("Vola", 10, 17, 13000);
		registrarReserva("Tool", 11, 17, 21000);
		registrarReserva("Bring Me The Horizon", 0, 7, 15000);
		registrarReserva("Fit For An autopsy", 13, 17, 17000);
		registrarReserva("Jinjer", 17, 19, 16000);
		registrarReserva("Mudvayne", 15, 22, 13000);
		registrarReserva("Thy Art Is Murder", 20, 23, 11100);
	}

	
	
}
