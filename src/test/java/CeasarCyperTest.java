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
}
