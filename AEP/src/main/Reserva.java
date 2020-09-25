package main;

public class Reserva {
	private String data;
	private Laboratorio labReservada;
	private boolean statusReserva;
	
	public Reserva(String data, Laboratorio labReservada, boolean statusReserva) {
		this.data = data;
		this.labReservada = labReservada;
		this.statusReserva = statusReserva;
	}
	
	public String getDataReserva() {
		return this.data;
	}
	
	public int getReservaCapacidade() {
		return this.labReservada.getCapacidade();
	}
	
	public int getReservaNumLab() {
		return this.labReservada.getNumLab();
	}
	
	public boolean getStatusReserva() {
		return this.statusReserva;
	}
	
	public void setStatusReserva(boolean statusReserva) {
		this.statusReserva = statusReserva;
	}
}
