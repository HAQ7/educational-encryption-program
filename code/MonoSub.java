 public class MonoSub extends Cipher{
    private int key;

    public MonoSub(String name) {
        super(name);
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void encrypt() {
        encryptedText = "";
        for (int i = 0; i < plainText.length(); i++) {
            char character = plainText.charAt(i);
            char encryptedCharacter = moveCharacter(character, key,true);
            System.err.println("-----------------------");
            System.err.println("so we take: " + character + " and it becomes: " + encryptedCharacter);
            encryptedText += encryptedCharacter;
        }
        System.out.println("-----------------------\nFinal output: " + encryptedText);
    }
        
        
    public void decrypt() {
            plainText = "";
            System.out.println("since here we are decrypting, we will shift backwards");
            for (int i = 0; i < encryptedText.length(); i++) {
                char character = encryptedText.charAt(i);
                char decryptedCharacter = moveCharacter(character, key,false);
                System.err.println("-----------------------");
                System.err.println("so we take: " + character + " and it becomes: " + decryptedCharacter);
                plainText += decryptedCharacter;
            }
            System.out.println("-----------------------\nFinal output: " + plainText);
        }
        
        
    
    
    public static char moveCharacter(char character, int key,boolean check) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
       if (check == true) {
    	   if (character==' ')
    		   return ' ';
    	   int index = alphabet.indexOf(character);
           int newIndex = (index + key) % 26;
           
           return alphabet.charAt(newIndex);
       }
       else  {
    	   if (character==' ')
    		   return ' ';
    	   int index = alphabet.indexOf(character);
           int newIndex = (index - key);
           
           if (newIndex < 0) {
               newIndex += 26;
           }
           
           return alphabet.charAt(newIndex);
       }
    }
    
}
