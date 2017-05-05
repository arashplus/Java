/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileIO;


import java.io.IOException;
import java.net.URISyntaxException;
//import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Arash Seyedi
 * @since 2017-04-01
 */
public class fileWrite {

    /**
     *<p>Method fileWriter() is creating and writing translated words in a text file</p>
     * @param data this is variable contains the final output after translating text
     * @throws IOException to handle a possible IOException (and possibly other exceptions) either with a try-catch block
     */
    public static void fileWriter(String data) throws IOException{
        Path myFile = null;
        try {
            myFile = Paths.get(ClassLoader.getSystemResource("srcDB/Resualt.txt").toURI());
        } catch (URISyntaxException ex) {
            Logger.getLogger(fileRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean myFileExists = Files.exists(myFile,new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
        
        if(!myFileExists){
            System.out.println("Sorry.! your file does not exists.!");
        }
        else
        {
            //System.out.println("Writing in File...done!");
            data = data+" ";
            Files.write(myFile, data.getBytes(),StandardOpenOption.APPEND);
           // Files.write(myFile, data.getBytes(), StandardCharsets.UTF_8,StandardOpenOption.APPEND);
            
      }
    }

    /**
     *<p>Method fileLineWriter() is creating and writing translated words line by line in a text file</p>
     * @param ldata this is variable contains the final output after translating text
     * @throws IOException to handle a possible IOException (and possibly other exceptions) either with a try-catch block
     */
    public static void fileLineWriter(String ldata) throws IOException{
        Path myFile = null;
        try {
            myFile = Paths.get(ClassLoader.getSystemResource("srcDB/LResualt.txt").toURI());
        } catch (URISyntaxException ex) {
            Logger.getLogger(fileRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean myFileExists = Files.exists(myFile,new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
        
        if(!myFileExists){
            System.out.println("Sorry.! your file does not exists.!");
        }
        else
        {
            //System.out.println("Writing in File...done!");
            ldata = ldata+" ";
            Files.write(myFile, ldata.getBytes(),StandardOpenOption.APPEND);
           // Files.write(myFile, data.getBytes(), StandardCharsets.UTF_8,StandardOpenOption.APPEND);
            
      }
    }
}
