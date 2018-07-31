/*
 * Currency Exchange to Bar Graph
 * Reads the input file and gets the currency codes
 * creates the exchange URL and gets the exchange rate
 * and creates a bar graph for all the currencies in the input file
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartUtilities;

public class CurrencyExchange {
	private static final int IO_EXCEPTION = 1;
	private static final int MALFORMED_URL = 2;
	private static final int FILE_NOT_FOUND = 3;

	public static void main(String[] args) {
		
			DefaultCategoryDataset barChartDataset = new DefaultCategoryDataset();   //creating the data set
			Scanner in = null;
			try {
				in = new Scanner(new File("currencies.txt"));
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found Exception Error");
				System.exit(FILE_NOT_FOUND);
			}
	        while (in.hasNextLine()) {
	            String currencyCode = getCurrency(in);
	            System.out.println(currencyCode);   //testing to make sure it's reading the file properly
	            
	    		String currencyUrl = getUrlString(currencyCode);
	    		System.out.println(currencyUrl);   //testing to make sure it creates the proper URL
	    		
	    		double exchnageRateDub = 0.0;
				try {
					exchnageRateDub = getExchangeRate(currencyUrl);
				} catch (MalformedURLException e) {
					System.out.println("Malformed URL Exception Error");
					System.exit(MALFORMED_URL);
				} catch (IOException e) {
					System.out.println("IO Exception Error");
					System.exit(IO_EXCEPTION);
				}
	   			barChartDataset.addValue(exchnageRateDub,  "ER", currencyCode);   //adds each currency exchange bar to the data set
		        in.close();
		        
		        //creating the bar chart
		        JFreeChart barChartObject = ChartFactory.createBarChart(
		                "Currency Exchange Rate (USD Base)", "Currency Code", "Exchnage Rate (USD Base)", barChartDataset, PlotOrientation.VERTICAL, 
		                false,  // Include legend.
		                false,  // Include tool tips.
		                false); // Include URLs.               
		                          
		             // Write the bar chart to a picture file               
		             int imageWidth = 640;
		             int imageHeight = 480;                
		             File barChart = new File("currencyexchange.png");              
		             try {
						ChartUtilities.saveChartAsPNG(
						     barChart, barChartObject, imageWidth, imageHeight);
					} catch (IOException e) {
						System.out.println("IO Exception Error");
						System.exit(IO_EXCEPTION);
					} 
	        }
	}

	//gets the exchange rate for each currency type from the input file
	public static double getExchangeRate(String currencyUrl) throws IOException, MalformedURLException {
		Scanner s = new Scanner((new URL(currencyUrl)).openStream( ));
		String jsonStr = s.nextLine();
		int len = jsonStr.length();
		String exchangeRateStr = jsonStr.substring(49, len-2);
		System.out.println(exchangeRateStr);   //testing to make sure it's getting the correct exchange rate
		s.close();
		double exchnageRateDub = Double.parseDouble(exchangeRateStr);
		return exchnageRateDub;
	}

	//creates the currency exchange URL
	public static String getUrlString(String currencyCode) {
		return "https://api.fixer.io/latest?base=USD&symbols=" + currencyCode;	}

	//reads the currencies.txt file to get the currency codes to convert
	public static String getCurrency(Scanner in) {
		return in.nextLine( );
	}
	
}
