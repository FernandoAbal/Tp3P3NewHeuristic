package model;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SolverTest {

    @Test
    public void porMontoTest() {
        Solver solver = new Solver(ejemplo(), new ComparadorPorMonto());
        PsbleSolucion solucion = solver.resolver();

        System.out.println("Cantidad de Reservas: " + solucion.getCardinal());
        System.out.println("Monto Total: " + solucion.getMonto());
        System.out.println("Horas Reservadas: " + solucion.getHorasReservadas());

        assertEquals(4, solucion.getCardinal()); // Ajusta según las reservas no solapadas
        assertEquals(68000, solucion.getMonto(), 0.01);
    }
    
    @Test
    public void porMontoTest2() {
        Solver solver = new Solver(ejemplo2(), new ComparadorPorMonto());
        PsbleSolucion solucion = solver.resolver();

        System.out.println("Cantidad de Reservas: " + solucion.getCardinal());
        System.out.println("Monto Total: " + solucion.getMonto());
        System.out.println("Horas Reservadas: " + solucion.getHorasReservadas());
        System.out.println("Ensayos aceptados: " + solucion.getEnsayosAceptados());

        assertEquals(3, solucion.getCardinal()); // Ajusta según las reservas no solapadas
        assertEquals(44000, solucion.getMonto(), 0.01);
    }

    private InstanciaReservas ejemplo() {
        InstanciaReservas ret = new InstanciaReservas(24);

        ret.agregar(new Reserva("Tesseract", 7, 10, 16000));
        ret.agregar(new Reserva("Periphery", 8, 12, 20000));
        ret.agregar(new Reserva("Vola", 10, 17, 13000));
        ret.agregar(new Reserva("Tool", 11, 17, 21000));
        ret.agregar(new Reserva("Bring Me The Horizon", 0, 7, 15000));
        ret.agregar(new Reserva("Fit For An autopsy", 13, 17, 17000));
        ret.agregar(new Reserva("Jinjer", 17, 19, 16000));

        return ret;
    }
    
    private InstanciaReservas ejemplo2() {
        InstanciaReservas ret = new InstanciaReservas(24);

        ret.agregar(new Reserva("Ensayo1", 8, 12, 16000));
        ret.agregar(new Reserva("Ensayo2", 12, 15, 14000));
        ret.agregar(new Reserva("Ensayo3", 11, 16, 10000));
        ret.agregar(new Reserva("Ensayo4", 17, 21, 14000));
        ret.agregar(new Reserva("Ensayo5", 7, 11, 14000));


        return ret;
    }
}

