package it.unibas.mastermind.test;

import junit.framework.*;
import it.unibas.mastermind.modello.*;

public class TestOperatore extends TestCase{

	private Operatore operatore = new Operatore();
	
	public void testCombinazioneValida(){
		assertTrue(operatore.isValida(new Combinazione(1, 2, 3, 4)));
		assertTrue(operatore.isValida(new Combinazione(4, 5, 6, 1)));
		assertFalse(operatore.isValida(new Combinazione(2, 2, 6, 1)));
		assertFalse(operatore.isValida(new Combinazione(2, 2, 2, 2)));
		assertFalse(operatore.isValida(new Combinazione(2, 1, 6, 1)));
		assertFalse(operatore.isValida(new Combinazione(2, 8, 6, 1)));
		assertFalse(operatore.isValida(new Combinazione(2, 0, 6, 1)));
	}

	public void testGeneraCombinazione(){
		for(int i = 0; i < 1000; i++){
			Combinazione combinazioneGenerata = operatore.genera();
			assertTrue(operatore.isValida(combinazioneGenerata));
		}
	}

	public void testRisposte1(){
		Risposta risposta1 = operatore.valutaTentativo(new Combinazione(1,2,3,4), new Combinazione(5,6,1,2));
		assertEquals(0, risposta1.getPalliniNeri());
		assertEquals(2, risposta1.getPalliniBianchi());
	}

	public void testRisposte2(){
		Risposta risposta2 = operatore.valutaTentativo(new Combinazione(2,4,6,1), new Combinazione(1,6,2,4));
		assertEquals(0, risposta2.getPalliniNeri());
		assertEquals(4, risposta2.getPalliniBianchi());
	}
	
	public void testRisposte3(){
		Risposta risposta3 = operatore.valutaTentativo(new Combinazione(2,4,6,1), new Combinazione(2,1,6,4));
		assertEquals(2, risposta3.getPalliniNeri());
		assertEquals(2, risposta3.getPalliniBianchi());
	}
	
	public void testRisposte4(){
		Risposta risposta4 = operatore.valutaTentativo(new Combinazione(6,2,5,1), new Combinazione(2,3,4,1));
		assertEquals(1, risposta4.getPalliniNeri());
		assertEquals(1, risposta4.getPalliniBianchi());
	}
	
	public void testRisposte5(){
		Risposta risposta5 = operatore.valutaTentativo(new Combinazione(1,2,3,4), new Combinazione(1,2,3,4));
		assertEquals(4, risposta5.getPalliniNeri());
		assertEquals(0, risposta5.getPalliniBianchi());
	}
	
}
