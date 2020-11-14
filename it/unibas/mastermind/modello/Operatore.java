package it.unibas.mastermind.modello;

import org.slf4j.*;
import java.util.*;

public class Operatore {

	private static Logger logger = LoggerFactory.getLogger(Operatore.class);
	private Random random = new Random();

	public Combinazione genera(){
		List<Integer> possibiliValori = this.inizializzaPossibiliValori();
		logger.debug("Possibi valori: " + possibiliValori.toString());
		Combinazione combinazione = new Combinazione();
		for(int i = 0; i < Costanti.NUMERO_CIFRE; i++){
			int posizione = random.nextInt(possibiliValori.size());
			logger.debug("Estraggo il valore in posizione " + posizione);
			int cifra = possibiliValori.get(posizione);
			logger.debug("Cifra estratta " + cifra + " in posizione " + i);
			possibiliValori.remove(posizione);
			combinazione.setCifra(i, cifra);
		}
		return combinazione;
	}

	public boolean isValida(Combinazione combinazione){
		for(int i = 0; i < Costanti.NUMERO_CIFRE; i++){
			int cifra = combinazione.getCifra(i);
			if(cifra < 1 || cifra > Costanti.MAX_NUMERO){
				return false;
			}
			for(int j = i + 1; j < Costanti.NUMERO_CIFRE; j++){
				if(combinazione.getCifra(i) == combinazione.getCifra(j)){
					return false;
				}
			}
		}
		return true;
	}

	private List<Integer> inizializzaPossibiliValori(){
		List<Integer> possibiliValori = new ArrayList<Integer>();
		for(int i = 0; i < Costanti.MAX_NUMERO; i++){
			possibiliValori.add(i + 1);
		}
		return possibiliValori;
	}

	public Risposta valutaTentativo(Combinazione daIndovinare, Combinazione tentata){
		int palliniNeri = calcolaPalliniNeri(daIndovinare, tentata);
		int palliniBianchi = calcolaPalliniBianchi(daIndovinare, tentata);
		return new Risposta(palliniNeri, palliniBianchi);
	}

	private int calcolaPalliniNeri(Combinazione daIndovinare, Combinazione tentata){
		int palliniNeri = 0;
		for(int i = 0; i < Costanti.NUMERO_CIFRE; i++){
			if(daIndovinare.getCifra(i) == tentata.getCifra(i)){
				palliniNeri++;
			}
		}
		return palliniNeri;
	}

	private int calcolaPalliniBianchi(Combinazione daIndovinare, Combinazione tentata){
		int palliniBianchi = 0;
		for(int i = 0; i < Costanti.NUMERO_CIFRE; i++){
			for(int j = 0; j < Costanti.NUMERO_CIFRE; j++){
				if(i != j && daIndovinare.getCifra(i) == tentata.getCifra(j)){
					palliniBianchi++;
				}
			}
		}
		return palliniBianchi;
	}


}