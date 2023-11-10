package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg{

	private int nesteledig; //angir antall Innlegg-objekt som er lagret i tabellen og dermed neste ledige posisjon i tabellen
	private Innlegg[] innleggtabell; // er en referanse tabell av Innlegg-objekt.
	
	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
		
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}	
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
//		returnerer indeks (posisjon) i tabellen for et innlegg i samlingen med 
//		samme id som parameteren innlegg (om en slik finnes) og -1 ellers. 
//		Bruk erLik-metoden for Innlegg-objekt i implementasjonen
		
		int posisjon = 0;
		boolean funnet = false; 
		
		while (posisjon < nesteledig && !funnet ) {
			if (innleggtabell[posisjon].erLik(innlegg) == true) {
				funnet = true;
				return posisjon;
			} else {
				posisjon++;
			}
		}
		return -1;
}

	public boolean finnes(Innlegg innlegg) {
//		 returnerer true om der finnes et innlegg i samlingen med samme id som innlegget gitt ved parameteren innlegg.
		
		boolean funnet = false;
		int posisjon = 0;
		
		while (posisjon < nesteledig && !funnet) {
			if (innlegg.getId() == innleggtabell[posisjon].getId()) {
				funnet = true;
			} else {
				posisjon++;
			}
		}
		
		return funnet;
		
	}

	public boolean ledigPlass() {
//		returnerer true om der er ledig plass i samlingen og false ellers.
		
		if (nesteledig < innleggtabell.length) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean leggTil(Innlegg innlegg) {
//		legger innlegg inn i tabellen. Dersom der ikke finnes et innlegg i tabellen med 
//		samme id som innlegg skal metoden legge til innlegget på neste ledige plass i 
//		tabellen. Ellers skal ikke metoden legge inn innlegg i tabellen. Metoden skal 
//		returnere true om innlegget blev lagt til og false ellers.
		
		if (finnes(innlegg) == false) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		} else {
			return false;
		}		
}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
	    sb.append(nesteledig).append("\n");

	    for (int i = 0; i < nesteledig; i++) {
	        if (innleggtabell[i] instanceof Tekst) {
	            sb.append(((Tekst) innleggtabell[i]).toString());
	        } else if (innleggtabell[i] instanceof Bilde) {
	            sb.append(((Bilde) innleggtabell[i]).toString());
	        }
	    }

	    return sb.toString();
		
//	    Versjon 2 (uten Stringbuilder):
//	     String txt = nesteledig + "\n";
//
//	    for (int i = 0; i < nesteledig; i++) {
//	        if (innleggtabell[i] instanceof Tekst) {
//	            txt += ((Tekst) innleggtabell[i]).toString();
//	        } else if (innleggtabell[i] instanceof Bilde) {
//	            txt += ((Bilde) innleggtabell[i]).toString();
//	        }
//	    }
//
//	    return txt;
//	}     
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}