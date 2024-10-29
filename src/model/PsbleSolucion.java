package model;

import java.util.ArrayList;

public class PsbleSolucion {

    private ArrayList<Reserva> _reservas;
    private boolean[] _horasReservadas;
    private double _monto;

    public PsbleSolucion() {
        _reservas = new ArrayList<Reserva>();
        _horasReservadas = new boolean[24]; 
        _monto = 0;
    }

    public void agregar(Reserva reserva) {
        _reservas.add(reserva);
        int horaDesde = reserva.getHoraDesde();
        int horaHasta = reserva.getHoraHasta();

        // Marca las horas de la reserva como ocupadas en _horasReservadas
        for (int i = horaDesde; i < horaHasta; i++) {
            _horasReservadas[i] = true;
        }
        _monto += reserva.getMonto();
    }

    public int getCardinal() {
        return _reservas.size();
    }

    public String getHorasReservadas() {
        StringBuilder horas = new StringBuilder();
        for (int i = 0; i < _horasReservadas.length; i++) {
            if (_horasReservadas[i]) {
                horas.append(i).append(", ");
            }
        }
        if (horas.length() > 2) {
            horas.setLength(horas.length() - 2); // Eliminar la última coma y espacio
        }
        return horas.toString();
    }
    
    public String getEnsayosAceptados() {
    	StringBuilder ensayos = new StringBuilder();
    	for (Reserva res : _reservas) {
    		ensayos.append(res.getNombreBanda());
    		ensayos.append(", ");
    	}
    	if (ensayos.length() > 2) {
    		ensayos.setLength(ensayos.length() - 2);
        }
    	return ensayos.toString();
    }

    public boolean getHoraEstaDisponible(int i) {
        return !_horasReservadas[i]; // Cambiamos la lógica para devolver `true` si está disponible
    }

    public double getMonto() {
        return _monto;
    }
}

