import dataStructure.WordFrequence;
import org.testng.annotations.Test;

public class WordFrequenceTest {


    @Test
    void frequenceTest() {
    //    WordFrequence wordFrequence = new WordFrequence("/Users/burcuakkaya/Desktop/romeo.txt");
    //    wordFrequence.calculateMostFrequence();

    //    WordFrequence wordFrequence2 = new WordFrequence("/Users/burcuakkaya/Desktop/lotsOfWords.txt");
    //    wordFrequence2.calculateMostFrequence();

        WordFrequence wordFrequence = new WordFrequence("/Users/burcuakkaya/Downloads/likeit.txt");
        wordFrequence.calculateMostFrequence();

    }
}
