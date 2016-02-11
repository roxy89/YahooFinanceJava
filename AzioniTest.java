
package quotes;

import quotes.AzioniDaPrendere;
import quotes.Azioni;
import org.junit.Test;

public class AzioniTest { 
	
	@Test
	public void testAzioni() { 
		
		Azioni google = AzioniDaPrendere.getAzioni("GOOG");
		System.out.println("Prezzo: " + google.getPrice());
		System.out.println("Volume: " + google.getVolume()); 
		System.out.println("Prezzo Utile P/E: " + google.getPe());
		System.out.println("Utili EPS: " + google.getEps());
		System.out.println("Anno più Basso: " + google.getWeek52low());
		System.out.println("Anno più Alto: " + google.getWeek52high());
		System.out.println("Giorno più Basso: " + google.getDaylow());
		System.out.println("Giorno più Alto: " + google.getDayhigh());
		System.out.println("50 giorni nelle classifiche: " + google.getMovingav50day());
		System.out.println("Valore di Mercato: " + google.getMarketcap());
		System.out.println("Il nome completo è: " + google.getName());
		System.out.println("La moneta è: " + google.getCurrency());
		System.out.println("Il rapporto breve è: " + google.getShortRatio());
		System.out.println("La chiusura del giorno precedente era: " + google.getPreviousClose());
		System.out.println("L'open di oggi è: " + google.getOpen());
		System.out.println("Il fondo di investimento è " + google.getExchange());
		
	} 
        
        
    
}
