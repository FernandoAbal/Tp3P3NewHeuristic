package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.ComparadorPorMonto;
import model.NegocioSala;
import model.PsbleSolucion;
import model.Solver;
import visual.VentanaPrincipal;

public class Controller {
	private VentanaPrincipal interfazUsuario;
	private NegocioSala salaDeEnsayo;
	
	
	public Controller() {
		interfazUsuario = new VentanaPrincipal();
		salaDeEnsayo = new NegocioSala();
		salaDeEnsayo.setearReservasDePrueba();
		
		inicializarFuncionalidadInterfaz();
		
	}


	private void inicializarFuncionalidadInterfaz() {
		
		interfazUsuario.getButtonSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazUsuario.getFrame().dispose();
			}
		});
		
		interfazUsuario.getButtonCrearReserva().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				salaDeEnsayo.registrarReserva(
						interfazUsuario.getTextNombre().getText(),
						interfazUsuario.getBoxHoraDesde().getSelectedIndex(),
						interfazUsuario.getBoxHoraHasta().getSelectedIndex(),
						Integer.parseInt(interfazUsuario.getTextMontoReserva().getText()));
			}
		});
		/*interfazUsuario.getBoxMes().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarBoxDias();
			}
		});*/
		
		interfazUsuario.getBoxHoraDesde().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarBoxHasta();
			}
		});
		interfazUsuario.getButtonPrintReservas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Solver solver = new Solver(salaDeEnsayo.getInstance(), new ComparadorPorMonto());
				PsbleSolucion solucion = solver.resolver();
				System.out.println("Cantidad de Reservas: " + solucion.getCardinal());
		        System.out.println("Monto Total: " + solucion.getMonto());
		        System.out.println("Horas Reservadas: " + solucion.getHorasReservadas());
		        JOptionPane.showInternalMessageDialog(null, "Cantidad de Reservas: " + solucion.getCardinal() +
		        		"\n" + "Monto Total: " + solucion.getMonto() + "\n" + "Horas Reservadas: " + solucion.getHorasReservadas());

			}
		});
		
		cargarBoxes();
	}

	
	private void actualizarBoxHasta() {
		interfazUsuario.getBoxHoraHasta().removeAllItems();
		for(int i = (int) interfazUsuario.getBoxHoraDesde().getSelectedItem() + 1; i <= 24; i++ ) {
			interfazUsuario.getBoxHoraHasta().addItem(i);
		}
	}
	
	/*private void actualizarBoxDias() {
		interfazUsuario.getBoxDia().removeAllItems();
		for (int i = 1; i < getDiasSegunMes(interfazUsuario.getBoxMes())+1; i++) {
			interfazUsuario.getBoxDia().addItem(i);		
		}
	}*/
	
	/*private void cargarBoxMes() {
		interfazUsuario.getBoxMes().addItem("ENERO");
		interfazUsuario.getBoxMes().addItem("FEBRERO");
		interfazUsuario.getBoxMes().addItem("MARZO");
		interfazUsuario.getBoxMes().addItem("ABRIL");
		interfazUsuario.getBoxMes().addItem("MAYO");
		interfazUsuario.getBoxMes().addItem("JUNIO");
		interfazUsuario.getBoxMes().addItem("JULIO");
		interfazUsuario.getBoxMes().addItem("AGOSTO");
		interfazUsuario.getBoxMes().addItem("SEPTIEMBRE");
		interfazUsuario.getBoxMes().addItem("OCTUBRE");
		interfazUsuario.getBoxMes().addItem("NOVIEMBRE");
		interfazUsuario.getBoxMes().addItem("DICIEMBRE");
	}*/
	
	/*private int getDiasSegunMes(JComboBox<String> boxMes) {
		switch(boxMes.getSelectedItem().toString()) {
		case "ENERO": return 31;
		case "FEBRERO": return 29;
		case "MARZO": return 31;
		case "ABRIL": return 30;
		case "MAYO": return 31;
		case "JUNIO": return 30;
		case "JULIO": return 31;
		case "AGOSTO": return 31;
		case "SEPTIEMBRE": return 30;
		case "OCTUBRE": return 31;
		case "NOVIEMBRE": return 30;
		case "DICIEMBRE": return 31;
		default: return 0;
		}
	}*/
	
	private void cargarBoxDesdeHasta() {
		for(int i = 00; i < 24; i++) {
			interfazUsuario.getBoxHoraDesde().addItem(i);
			interfazUsuario.getBoxHoraHasta().addItem(i);
		}
		
	}
	private void cargarBoxes() {
		//cargarBoxMes();
		cargarBoxDesdeHasta();
	}
	
}