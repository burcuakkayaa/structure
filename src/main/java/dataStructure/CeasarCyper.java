package dataStructure;


public class CeasarCyper {

    private String alphabet;
    private String shiftedAlphabet;

    public CeasarCyper(int key) {

        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
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
}
