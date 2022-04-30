import java.io.IOException;

import org.testng.annotations.Test;

import dataStructure.CountWords;

public class CountWordTest {

    @Test
    void countTest() throws IOException {
        CountWords countWords = new CountWords();
       // countWords.countWords("/Users/burcuakkaya/Desktop/romeo.txt");
        countWords.findMostReputationWord("/Users/burcuakkaya/Desktop/lotsOfWords.txt");
      

    }
    
}
