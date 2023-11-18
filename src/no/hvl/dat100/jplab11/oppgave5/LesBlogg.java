package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import no.hvl.dat100.jplab11.oppgave2.*;

import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class LesBlogg {
//	 leser inn bloggen fra en fil på formatet som i oppgave 4 og returnerer en samling (blogg) 
//	med de Innlegg-objekt som er lest inn. Metoden skal håndtere eventuelle unntak ifm. filer 
//	vha. try-catch. Det kan antas innholdet i filen er på korrekt format. Testen TestLesBlogg
//	vil forsøke å lese inn filen bloggkorrekt.dat.
	
//	 Start med å lese inn første linje og opprett en blogg med det antall innlegg som står 
//	 angitt i første linje av filen. Les inn et innlegg om gangen og hver gang et innlegg 
//	 leses inn, finn ut om det er en tekst-innlegg eller et bilde-innlegg. Dette bestemmer 
//	 da hva som evt. skal leses videre
	
	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		Blogg nysamling = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(mappe+filnavn))){
			String line = br.readLine();
			
			if (line != null) { // leser første linje i filen og lager en ny blogg
				int nrInnlegg = Integer.parseInt(line.trim());
				nysamling = new Blogg(nrInnlegg);
			}
			
			do { // leser resten av filen 
				if (line.trim().equals(TEKST)) {
					int id = Integer.parseInt(br.readLine().trim());
	                String bruker = br.readLine().trim();
	                String dato = br.readLine().trim();
	                int likes = Integer.parseInt(br.readLine().trim());
	                String tekst = br.readLine().trim();
	          
	                nysamling.leggTil(new Tekst(id, bruker, dato, likes, tekst));
				} 
				else if (line.trim().equals(BILDE)) {
					 int id = Integer.parseInt(br.readLine().trim());
	                String bruker = br.readLine().trim();
	                String dato = br.readLine().trim();
	                int likes = Integer.parseInt(br.readLine().trim());
	                String tekst = br.readLine().trim();
	                String url = br.readLine().trim();
	                
	                nysamling.leggTil(new Bilde(id, bruker, dato, likes, tekst, url));
				}
			} while ((line != null));
			
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	return nysamling;	

	}
}
