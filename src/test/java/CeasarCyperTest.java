import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import dataStructure.CeasarCyper;

public class CeasarCyperTest {
    
    
    @Test
    public void Test() {
 
        CeasarCyper ceasarCyper = new CeasarCyper(23);
        String input = "Programming can be fun, so can cryptography; however they should not be combined";
        
        System.out.println(ceasarCyper.encrypt(input));

        ceasarCyper.deCrypt("Moldoxjjfkd zxk yb crk, pl zxk zovmqldoxmev; eltbsbo qebv pelria klq yb zljyfkba");
    } 



    @Test
    void testEncryptTwoKeys(){
        String input = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        CeasarCyper ceasarCyper1 = new CeasarCyper(4);
        String encryptedKey1= ceasarCyper1.encrypt(input);
        
        CeasarCyper ceasarCyper2 = new CeasarCyper(7);
        String encryptedKey2 = ceasarCyper2.encrypt(input); 

      
        CeasarCyper ceasarCyper = new CeasarCyper();
        String decrypted = ceasarCyper.encryptTwoKeys(encryptedKey1 , encryptedKey2, input);
        System.out.println (decrypted);
        
        
        }

        @Test
        public void readFileAndDecrypt() throws IOException {

            String sentences = new String(Files.readAllBytes(Paths.get("/Users/burcuakkaya/Downloads/mysteryTwoKeysPractice.txt")));
           // sentences = sentences.replaceAll("[^a-zA-Z ]", ""); //removed all punctuations
          
            CeasarCyper ceasarCyper = new CeasarCyper(18);
            System.out.println(ceasarCyper.encrypt(sentences));
            
            
        }
}
