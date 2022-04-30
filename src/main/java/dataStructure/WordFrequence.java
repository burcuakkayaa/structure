package dataStructure;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WordFrequence {

    private ArrayList<String> wordList;
    private ArrayList<Integer> freq;
    private String sentences;
    private String[] words;

    @SneakyThrows
    public WordFrequence(String filePath){
        wordList = new ArrayList<>();
        freq = new ArrayList<>();

        sentences = new String(Files.readAllBytes(Paths.get(filePath)));
       // sentences = sentences.replaceAll("[^a-zA-Z ]", ""); //removed all punctuations
        words = sentences.split("\\s+"); //split as white spaces
    }

    public void calculateMostFrequence() {

        wordList.clear();
        freq.clear();

        for(int i=0; i< words.length ; i++) {
            String word = words[i].toLowerCase();
            int index = wordList.indexOf(word);
            if(index == -1) {
                wordList.add(word);
                freq.add(1);
            }else {
                int freqInt = freq.get(index);
                freq.set(index,freqInt +1);
            }


        }

        System.out.println("# unique words: "+wordList.size());
        int index = findMax();
        if(index >1)
        System.out.println("The word that occurs most often and its count are:  "+wordList.get(index)+" "+freq.get(index));
    }

    public int findMax() {
        int max = freq.get(0);
        int maxIndex = 1;
        for(int k=0; k < freq.size(); k++){
            if (freq.get(k) > max){
                max = freq.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
}
