 public class MonoSub{
    private String plainText;
	private String encryptedText;
    private int key;
    public String encrypt() {
        encryptedText = "";
        for (int i = 0; i < plainText.length(); i++) {
            char letter = plainText.charAt(i);
            char encryptedLetter = moveLetter(letter, key,true);
            encryptedText += encryptedLetter;
        }        
        return encryptedText;
    }
        
        
    public String decrypt() {
            plainText = "";
            for (int i = 0; i < encryptedText.length(); i++) {
                char letter = encryptedText.charAt(i);
                char decryptedLetter = moveLetter(letter, key,false);
                plainText += decryptedLetter;
            }
            return plainText;
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
