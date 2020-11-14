package it.unibas.mastermind.modello;

public class Risposta {
	
	private int palliniNeri;
	private int palliniBianchi;

	public Risposta(int palliniNeri, int palliniBianchi){
		this.palliniNeri = palliniNeri;
		this.palliniBianchi = palliniBianchi;
	}

	public int getPalliniNeri(){
		return this.palliniNeri;
	}

	public int getPalliniBianchi(){
		return this.palliniBianchi;
	}

	public String prova(){
		return "prova";
	}

}