package dataStructure;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CharactersInPlay {

    private ArrayList<String> names;
    private ArrayList<String> sentences;
    private String[] words;


    @SneakyThrows
    public CharactersInPlay(String filePath) {
        this.names = new ArrayList<>();
        this.sentences = new ArrayList<>();

        FileInputStream fis=new FileInputStream(filePath);
        Scanner sc=new Scanner(fis);


        while(sc.hasNextLine())
        {
            String line = sc.nextLine().replaceAll("[^a-zA-Z ]", "");

            if(!line.isEmpty() && !line.equals(line.toUpperCase()))
            sentences.add(line.trim());


        }
       // System.out.println(sentences.toString());
        sc.close();
    }

    private void collectNames(String name) {
        int index = names.indexOf(name);
        if(index == -1) {
            names.add(name);
        }
    }

    private void findSpecialName() {
        for(String sentence : sentences) {
            words = sentence.split("\\s+");

            if(words[0].equals(words[0].toUpperCase()) && words[1].equals(words[1].toUpperCase()) && words[1].length()>1) {
                String name = words[0] + " " + words[1];
                collectNames(name);
            }else if(words[0].equals(words[0].toUpperCase()) && !words[1].equals(words[1].toUpperCase()) && words[0].length()>1) {
                String name = words[0];
                collectNames(name);
            }

        }

        System.out.println(names.toString());
    }

    public void findAllCharacters() {
       findSpecialName();
       int[] freq = new int[names.size()];

        for(String sentence : sentences) {

            sentence = sentence.toLowerCase();

            for(int k=0 ; k < names.size() ; k++) {
                String name = names.get(k).toLowerCase();
                if(sentence.contains(name)) {
                    freq[k]++;
                }
            }
        }

        int index = findMax(freq);
        if(index > 0)
            System.out.println("The word that occurs most often and its count are:  "+names.get(index)+" "+freq[index]);

        for(int i=0; i< names.size() ; i++)
        System.out.println(names.get(i) + "\t"  + freq[i]);
    }

    private int findMax(int[] freq) {
        int max = freq[0];
        int maxIndex = 1;
        for(int k=0; k < freq.length; k++){
            if (freq[k] > max){
                max = freq[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }
}
