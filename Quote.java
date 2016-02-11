
package quotes;

import org.junit.Test;

//se arduino è staccato puo' essere omessa
/*import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException; 

/**
 *
 * @author RoXy
 * 
 * 
 */



public class Quote {
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws FileNotFoundException, IOException {// throws  UnsupportedEncodingException, InterruptedException, SerialPortException  {
        //int numero;
      // String[] port = SerialPortList.getPortNames();
       //String porta = Arrays.toString(port);
        
        AzioniTest st  = new AzioniTest();
        st.testAzioni();
           
        // se Arduino è staccato possiamo omettere questo pezzo
      /*  System.out.println("La porta usata da Arduino è la seguente");
        SerialPort serialPort = new SerialPort("/dev/tty.usbmodem1421");
            System.out.println(porta);
              System.out.println("connect To Arduino");
              serialPort.openPort();//Open serial port
           serialPort.setParams(9600, 8, 1, 0);//Set params.
           serialPort.closePort();
           System.out.println("disconnect To Arduino");
           */
      
       System.out.println("\n Sul file scritto da scheda Arduino è presente questo contenuto:\n");
       BufferedReader reader = new BufferedReader(new FileReader("/Volumes/SDA1/QUOTA.TXT"));
        String line = reader.readLine();
        while(line!=null) {
            System.out.println(line);
            line = reader.readLine();
      
     
    }
    }
}

            
            
            
            

    



