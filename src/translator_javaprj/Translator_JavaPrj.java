/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translator_javaprj;

import java.io.IOException;
import fileIO.fileProcessing;
import fileIO.fileRead;
import fileIO.publicVariables;

/**
 * @author Arash Seyedi
 * @version 0.1
 * @since 2017-04-01
 */

public class Translator_JavaPrj {
   /**
     * *<p>In main() method I'm declaring object for all class from different package<br>
     * and also calling methods and passing data. </p>
     * @throws IOException to handle a possible IOException (and possibly other exceptions) either with a try-catch block
     * @param args default argument
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        DocumentioanTest dt = new DocumentioanTest();
//        dt.DisplayMessage("Hey this is a test.!");
//        System.err.println("Sum of passing interges : "+dt.add(10, 5));
        /*
        *Testing DIctonary data reading.
        */
        
        for (publicVariables.globalDocN=0; publicVariables.globalDocN < 6; publicVariables.globalDocN++) {

            fileRead fr = new fileRead();
            fileProcessing fp = new fileProcessing();

            long startTime = System.currentTimeMillis(); 
            fr.searchDIC();
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Time for translating "+publicVariables.globalNW+" words : "+totalTime);

            publicVariables.tT =  "Time for translating "+publicVariables.globalDocNW[publicVariables.globalDocN]+" words : "+totalTime;
            fp.WriteInTextFile("Time and space complexity analysis for : "+publicVariables.globalDocNW[publicVariables.globalDocN]+" Word");
            fp.WriteInTextFile(publicVariables.tT+"\n");
        }
        for (publicVariables.globalDocN=0; publicVariables.globalDocN < 6; publicVariables.globalDocN++) {

            fileRead fr = new fileRead();
            fileProcessing fp = new fileProcessing();

            long startTime = System.currentTimeMillis(); 
            fr.lsearchDIC();
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            startTime = System.currentTimeMillis(); 
            fr.lsearchDIC();
            endTime   = System.currentTimeMillis();
            totalTime = endTime - startTime;
            System.out.println("Time for translating Line by Line for : "+publicVariables.globalDocNW[publicVariables.globalDocN]+" words : "+totalTime);


            publicVariables.tT =  "Time for translating Line by Line for : "+publicVariables.globalDocNW[publicVariables.globalDocN]+" words : "+totalTime;
            fp.WriteInTextFilelbl("Time and space complexity analysis for : "+publicVariables.globalDocNW[publicVariables.globalDocN]+" Word");
            fp.WriteInTextFilelbl(publicVariables.tT+"\n");
        }
    }
    
}
