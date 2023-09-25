 public class MonoSub extends Cipher{
    private int key;

    public MonoSub(String name) {
        super(name);
    }

    public void encrypt() {
        encryptedText = "";
        for (int i = 0; i < plainText.length(); i++) {
            char letter = plainText.charAt(i);
            char encryptedLetter = moveLetter(letter, key,true);
            encryptedText += encryptedLetter;
        }        
    }
        
        
    public void decrypt() {
            plainText = "";
            for (int i = 0; i < encryptedText.length(); i++) {
                char letter = encryptedText.charAt(i);
                char decryptedLetter = moveLetter(letter, key,false);
                plainText += decryptedLetter;
            }
        }
        
        
    
    
    public static char moveLetter(char letter, int key,boolean check) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
       if (check == true) {
    	   if (letter==' ')
    		   return ' ';
    	   int index = alphabet.indexOf(letter);
           int newIndex = (index + key) % 26;
           
           return alphabet.charAt(newIndex);
       }
       else  {
    	   if (letter==' ')
    		   return ' ';
    	   int index = alphabet.indexOf(letter);
           int newIndex = (index - key);
           
           if (newIndex < 0) {
               newIndex += 26;
           }
           
           return alphabet.charAt(newIndex);
       }
    }
    
}
