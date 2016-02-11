
package quotes;



import quotes.Azioni;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import quotes.AzioniDiAiuto;

public class AzioniDaPrendere {  
	
	/*
	* Returns a Stock Object that contains info about a specified stock.
	* @param 	symbol the company's stock symbol
	* @return 	a stock object containing info about the company's stock
	* @see Stock
	*/
	static Azioni getAzioni(String symbol) {  
		String sym = symbol.toUpperCase();
		double price = 0.0;
		int volume = 0;
		double pe = 0.0;
		double eps = 0.0;
		double week52low = 0.0;
		double week52high = 0.0;
		double daylow = 0.0;
		double dayhigh = 0.0;
		double movingav50day = 0.0;
		double marketcap = 0.0;
		String name = "";
		String currency = "";
		double shortRatio = 0.0;
		double open = 0.0;
		double previousClose = 0.0;
		String exchange;
		try { 
			
			// Retrieve CSV File
			URL yahoo = new URL("http://finance.yahoo.com/d/quotes.csv?s="+ symbol + "&f=l1vr2ejkghm3j3nc4s7pox");
			URLConnection connection = yahoo.openConnection(); 
			InputStreamReader is = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(is);  
			
			// Parse CSV Into Array
			String line = br.readLine(); 
			//Only split on commas that aren't in quotes
			String[] azioniinfo = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			
			// Handle Our Data
			AzioniDiAiuto sh = new AzioniDiAiuto();
			
			price = sh.handleDouble(azioniinfo[0]);
			volume = sh.handleInt(azioniinfo[1]);
			pe = sh.handleDouble(azioniinfo[2]);
			eps = sh.handleDouble(azioniinfo[3]);
			week52low = sh.handleDouble(azioniinfo[4]);
			week52high = sh.handleDouble(azioniinfo[5]);
			daylow = sh.handleDouble(azioniinfo[6]);
			dayhigh = sh.handleDouble(azioniinfo[7]);   
			movingav50day = sh.handleDouble(azioniinfo[8]);
			marketcap = sh.handleDouble(azioniinfo[9]);
			name = azioniinfo[10].replace("\"", "");
			currency = azioniinfo[11].replace("\"", "");
			shortRatio = sh.handleDouble(azioniinfo[12]);
			previousClose = sh.handleDouble(azioniinfo[13]);
			open = sh.handleDouble(azioniinfo[14]);
			exchange = azioniinfo[15].replace("\"", "");
			
		} catch (IOException e) {
			Logger log = Logger.getLogger(AzioniDaPrendere.class.getName()); 
			log.log(Level.SEVERE, e.toString(), e);
			return null;
		}
		
		return new Azioni(sym, price, volume, pe, eps, week52low, week52high, daylow, dayhigh, movingav50day, marketcap, name,currency, shortRatio,previousClose,open,exchange);
		
	}
}
