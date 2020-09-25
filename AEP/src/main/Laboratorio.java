package main;

public class Laboratorio {
	private int numLab;
	private boolean reservada;
	private int capacidade;
	
	public Laboratorio(int numLab, int capacidade) {
		this.numLab = numLab;
		this.capacidade = capacidade;
	}
	
	public int getNumLab() {
		return this.numLab;
	}
	
	public int getCapacidade() {
		return this.capacidade;
	}
}
