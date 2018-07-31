/*
 * POSTNET Barcode Creator
 * Reads the input file and converts the string ZIP code
 * to a POSTNET barcode and writes it to an output file
 */

import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
 
public class Postnet {
 
    public static void main(String[ ] args) throws FileNotFoundException {
        // Open file containing names with FileChooser dialog
        JFileChooser chooser = new JFileChooser( );
        chooser.showOpenDialog(null);
        File inputFile = chooser.getSelectedFile( );
        Scanner sc = new Scanner(inputFile);
        
        String outputStr = "";   //creates the string that will hold the final output
        while (sc.hasNextLine()) {
          String[ ] feedLine = sc.nextLine().split(",");   //splits the text fields from the input file at each comma
          System.out.println(Arrays.toString(feedLine));   //testing purposes only; to make sure fields were split properly
          
          //creates the final output that will be written to the destination file
          outputStr += feedLine[0] + '\n' + 
        		  feedLine[1] + '\n' + 
        		  feedLine[2] + ' ' + feedLine[3] +  ' ' + feedLine[4] + '\n' + 
        		  getBarCode(feedLine[4]) + "\n\n";
          
        }
        
        PrintWriter pw = new PrintWriter(new File("labels.txt"));   //creates the destination/file to be written to
        //System.out.println(outputStr);   //testing purpose only; to check the format of the output text
        pw.println(outputStr);   //writes the output string to the destination file
        sc.close();
        pw.close();
    }
 
    public static String getBarCode(String zipcode) {
        String[ ] code = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:",
        ":||::", "|:::|", "|::|:", "|:|::"};
        String parsedZip = zipcode.replace("-", "");   //gets rid of the dash in the ZIP code
        String barcode = "";
        int total = 0;
        
        //go through each character (number) of the ZIP code field (feedLine[4])
        for (char c : parsedZip.toCharArray()) {   
          barcode += code[Character.getNumericValue(c)];   //changes the number character to an integer, then gets the code symbol based on the index location
          total += Character.getNumericValue(c);   //adds all the ZIP code numbers for a total to calculate checksum
        }
        int checksum = (10 - total % 10) % 10;
        return '|' + barcode + code[checksum] + '|';
    }
}