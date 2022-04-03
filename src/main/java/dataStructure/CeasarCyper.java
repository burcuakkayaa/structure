package dataStructure;


public class CeasarCyper {

    private String alphabet;
    private String shiftedAlphabet;
    private int[] count;

    public CeasarCyper(int key) {

        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        count = new int[26]; 
    }
    

    public String encrypt(String input) {

        StringBuilder sb = new StringBuilder(input);

        for(int i=0; i < sb.length() ; i++){
            char current = sb.charAt(i);

            Boolean flag = false;
            if(Character.isLowerCase(current)) {
                current =  Character.toUpperCase(current);
                flag = true;
            }


            int index = alphabet.indexOf(current);

            if(index != -1) {
                current = shiftedAlphabet.charAt(index);

                if(flag.equals(true)) {
                    current = Character.toLowerCase(current);
                    flag = false;
                }

                sb.setCharAt(i, current);
            }
        } 

        return sb.toString();


    }


    public String deCrypt(String message) {

        
        int commonIndex = alphabet.indexOf('O');
        int[] frequence = countletters(message);
        int maxIndex = maxIndex(frequence);
        int dkey = maxIndex - commonIndex;

        if(dkey < commonIndex) 
        dkey = count.length - (commonIndex - maxIndex);

        CeasarCyper ceasarCyper = new CeasarCyper(26-dkey);
        
        System.out.println(ceasarCyper.encrypt(message));
        return ceasarCyper.encrypt(message) ;

    }

    private int maxIndex(int[] frequence) {

        int maxIndex=0;
        int maxLetterIndex=0;
        for(int i=0; i< frequence.length ; i++) {
        
            System.out.println(alphabet.charAt(i) + "\t"  +  frequence[i]);
            if(frequence[i] > maxIndex) {
                maxIndex = frequence[i];
                maxLetterIndex = i;
            }
               
        }
        return maxLetterIndex;


    }

    private int[] countletters(String message) {

        for(int i=0; i < message.length() ; i++) {
            char ch = Character.toUpperCase(message.charAt(i));
            int index = alphabet.indexOf(ch);
            if(index != -1) 
            count[index] += 1;

        }

        return count;
    }
}
