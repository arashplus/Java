/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;
/**
 * @author Arash Seyedi
 * @since 2017-04-01
 */
public class fileRead { 

    /**
     *@throws IOException to handle a possible IOException (and possibly other exceptions) either with a try-catch block
     */
    public static void searchDIC() throws IOException{
        fileWrite fw = new fileWrite();
        List <String> dictinaryList = new ArrayList<String>();
        String Str,data;
        int position = 0,flag =0;
        String[] arr = new String [100000010];
       
        
        File file = new File(ClassLoader.getSystemResource("srcDB/dic.txt").getFile());
        FileReader reader = new FileReader(file);
        BufferedReader in = new BufferedReader(reader);
        //BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
        while((Str = in.readLine()) != null){
               dictinaryList.add(Str);
               
           }
           String[] stringArr = dictinaryList.toArray(new String[0]);
           
       /*Parsing Sentence from the input document*/
       System.out.println("Documentation\n######+++++####+++++######");
       String input = fileWRead();
       //String temp=null;
       int i,j;
       
       String[] SplitText = input.split("\\s+");
       publicVariables.globalNW=SplitText.length;
       //System.out.println("Number of Word : "+SplitText.length);
       for(String text :SplitText){
       text = text.replaceAll("[^\\w]", "");
       //text = text.toLowerCase();
       //This one printing all the reading words from doc.
       //System.out.println(text);
       
        /*Parsing from the dictionary*/ 
        for(i=0;i<stringArr.length;i++)
        {
          data = stringArr[i].toLowerCase();
          //data = stringArr[i];
          String[] words = data.split("\\|");
          position = words.length;
          for (j = 0; j < position-1; j++) 
          {
              if (text.toLowerCase().equals(words[j])) {
                   //This one printing all the translating words from doc.
                  //System.out.println(words[position-1]);
                  if(flag == 0)
                  {
                   fw.fileWriter(words[position-1]);
                   flag=1;  
                  }
                }
              
           } 
          
        }
        
        flag=0;
       }
    
    }
    
    /**
     *
     * @throws IOException to handle a possible IOException (and possibly other exceptions) either with a try-catch block
     */
    public static void lsearchDIC() throws IOException{
        fileWrite fw = new fileWrite();
        List <String> dictinaryList = new ArrayList<String>();
        String Str,data,line,ldata;
        int position = 0,flag =1,lposition = 0,lflag =0;
        boolean inflag=false;
        String[] arr = new String [100000010];
        File file = new File(ClassLoader.getSystemResource("srcDB/dic.txt").getFile());
        FileReader reader = new FileReader(file);
        BufferedReader in = new BufferedReader(reader);
        //BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
        while((Str = in.readLine()) != null){
               dictinaryList.add(Str);
               
           }
           String[] stringArr = dictinaryList.toArray(new String[0]);
        
       /*Parsing Sentence from the input document*/
       System.out.println("Documentation Line by Line\n######+++++####+++++######");
       //String input = fileRead();
       String temp=null;
       int i,j,z,k;
       List<String> list = filelineRead();
       String[] SplitLine=list.toArray(new String[0]);
       int lsize=SplitLine.length;
       int dsize=stringArr.length;
       //String[] stringArr = list.toArray(new String[0]);
        //String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
        String specialCharacters = "[" + "-/@#!*$%^&.'_+={}()"+ "]+" ;
        for ( i = 0; i < lsize; i++) {
            temp=SplitLine[i].toString();
            
            if (temp.matches(("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))) {
                            if(lflag == 0)
                            {
                             fw.fileLineWriter(temp);
                             lflag=1;  
                            }
                        }
            
            
            String[] templine=temp.split("\\s+");
            //publicVariables.globalNWL=templine.length;
            //System.out.println("Number of Word in Line : "+templine.length);
            for(int y=0; y < templine.length; y++){
                inflag=false;
                //flag=0;
                String ltext = templine[y];
                
                if (ltext.matches(specialCharacters)) {
                    // It has at least one of them
                    ltext = ltext.replaceAll("[^\\W]", "");
                }
                else 
                    ltext = ltext.replaceAll("[^\\w]", "");
             /*Parsing from the dictionary*/ 
                int count=0;
                for(z=0;z<dsize;z++)
                {
                  count++;
                  ldata = stringArr[z].toLowerCase();
                  String[] word = ldata.split("\\|");
                  lposition = word.length;
                  //String Sword=word.toString();
                  //Sword=Sword.toLowerCase();

                    for (j = 0; j < lposition-1; j++) 
                    {
                        if (ltext.toLowerCase().equals(word[j])) {
                             //This one printing all the translating words from doc.
                            //System.out.println(words[position-1]);
                            //if(lflag == 0)
                            //{
                             fw.fileLineWriter(word[lposition-1]);
                             //lflag=1;
                             inflag=true;
                             z=dsize;
                            //}
                          }
                     } 
                }
                if ((count==dsize)&&inflag!=true) {
                    if (lflag==0) {
                        fw.fileLineWriter(ltext);
                    }
                    else
                        lflag=1;
                    //inflag=true;
                }
            }
            fw.fileLineWriter("\n");
            lflag=0;
        }
    }
    
    /**
     *
     * @return byteArray this function is for read text file and return word by word as String Array
     */
    public static String fileWRead() throws IOException{
        String filedirectory = null;
        Path myFile = null;
        //String line;
        byte[] byteArray = null;
        try {
                switch(publicVariables.globalDocN){
                        case 1: filedirectory="srcDB/docs_100.txt";
                        break;
                        case 2: filedirectory="srcDB/docs_500.txt";
                        break;
                        case 3: filedirectory="srcDB/docs_1000.txt";
                        break;
                        case 4: filedirectory="srcDB/docs_5000.txt";
                        break;
                        case 5: filedirectory="srcDB/docs_10000.txt";
                        break;
                        default: filedirectory="srcDB/docs.txt";
                        break;
                    }
			myFile = Paths.get(ClassLoader.getSystemResource(filedirectory).toURI());
        } catch (URISyntaxException ex) {
            Logger.getLogger(fileRead.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        boolean myFileExists = Files.exists(myFile,new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
        //System.out.println(myFileExists);
        if(!myFileExists){
            System.out.println("Sorry.! your file does not exists.!");
        }
        else
        {
            byteArray = Files.readAllBytes(myFile);
      }
        return new String(byteArray);
    }

    /**
     *
     * @return list this function is for read text file line by line and return as List
     */
    public static List filelineRead(){
        //Path myFile = null;
        String line;
        String filedirectory = null;
        byte[] byteArray = null;
        String str;
        List<String> list = new ArrayList<String>();
        try {
                switch(publicVariables.globalDocN){
                    case 1: filedirectory="srcDB/docs_100.txt";
                    break;
                    case 2: filedirectory="srcDB/docs_500.txt";
                    break;
                    case 3: filedirectory="srcDB/docs_1000.txt";
                    break;
                    case 4: filedirectory="srcDB/docs_5000.txt";
                    break;
                    case 5: filedirectory="srcDB/docs_10000.txt";
                    break;
                    default: filedirectory="srcDB/docs.txt";
                    break;
                }
			File file = new File(ClassLoader.getSystemResource(filedirectory).getFile());
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
                        
                        while ((str = bufferedReader.readLine()) != null) {
                            list.add(str);
                        }
                        String[] stringArr = list.toArray(new String[0]);
                        //System.out.println("Line read in list"+" "+Arrays.toString(stringArr));                                                             
                        
                        
                        /*
                            I'm not sure now, but the code below should remove
                        */
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			//System.out.println("Contents of file:");
			//System.out.println(stringBuffer.toString());
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
        return list;
    }
}
