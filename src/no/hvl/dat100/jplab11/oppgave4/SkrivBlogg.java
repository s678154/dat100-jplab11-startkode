package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		// Skriver ut samlingen til fil. Metoden skal returnere true om filen ble skrevet 
		// og skal håndtere eventuelle unntak ifm. fil-håndtering ved å bruke try-catch.
		
		// Bruk toString()-metoden på innlegg-samling
		
		try (PrintWriter writer = new PrintWriter(mappe + filnavn)) {
	          
			writer.println(samling.toString());
	        return true;
	          
	    } catch (FileNotFoundException e) {
	         
	    	System.err.println("Feil ved skriving til fil: " + e.getMessage());
	        return false;
	    }
	}
}
