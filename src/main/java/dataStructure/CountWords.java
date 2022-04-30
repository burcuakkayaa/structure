package dataStructure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;


public class CountWords {
    
 

    public void countWords(String path) throws IOException {
      
        String sentences = new String(Files.readAllBytes(Paths.get(path)));
        sentences = sentences.replaceAll("[^a-zA-Z ]", ""); //removed all punctuations
        String[] words = sentences.split("\\s+"); //split as white spaces


        String[] mostOfCommonWords = { "the", "of", "and", "to", "a", 
        "in", "for", "is", "on", "that", "by", "this","with", "i", "you", "it", "not", "or", "be", "are"};
        int[] count = new int[mostOfCommonWords.length];

        
    
         for(String word : words) {
             word = word.toLowerCase();

            for(int k=0; k< mostOfCommonWords.length ; k++) {
                if(mostOfCommonWords[k].equals(word))
                    count[k] += 1;
 
            }
    
         }

         for(int k=0; k<mostOfCommonWords.length ; k++)
          System.out.println(mostOfCommonWords[k] + "\t"  + count[k]);
    }

    public void findMostReputationWord(String path) throws IOException {
        
        String sentences = new String(Files.readAllBytes(Paths.get(path)));
        sentences = sentences.replaceAll("[^a-zA-Z ]", ""); //removed all punctuations
        String[] words = sentences.split("\\s+"); //split as white spaces
       
        HashMap<String , Integer> map = new HashMap<String,Integer>();
        int countValue;

        for(int k=0 ; k < words.length ; k++) {

            words[k] = words[k].toLowerCase();

            if(!map.containsKey(words[k]))
               map.put(words[k], 0);
            else {
                countValue = map.get(words[k]);
                map.put(words[k], countValue+1);
            }


           
        }

        System.out.println(map);

    }
}
