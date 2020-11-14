package it.unibas.mastermind.modello;

public class Combinazione {
	
	private int[] cifre = new int[Costanti.NUMERO_CIFRE];

	public Combinazione(){
	}

	public Combinazione(int cifra1, int cifra2, int cifra3, int cifra4){
		this.cifre[0] = cifra1;
		this.cifre[1] = cifra2;
		this.cifre[2] = cifra3;
		this.cifre[3] = cifra4;
	}

	public void setCifra(int pos, int cifra){
		this.cifre[pos] = cifra;
	}

	public int getCifra(int pos){
		return this.cifre[pos];
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Costanti.NUMERO_CIFRE; i++){
			sb.append(cifre[i] + " ");
		}
		return sb.toString();
	}

}