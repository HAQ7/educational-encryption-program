// Not complete

public class Keyed {
	private int[] key;
	private int numOfElements;
	
	
	// they should be inherited from class Cipher
	private String plainText;
	private String encryptedText;
    
	
	public Keyed(String name, String plainText) {
		// super constructor
	}
	
	public String encrypt() {
		encryptedText = "";
		String textWithoutSpace = plainText.replace(" ", "");
		String[] splittedPlainText = split(textWithoutSpace);
		for(int i=0; i<splittedPlainText.length; i++) {
			char[] tempArray = splittedPlainText[i].toCharArray();
			int j = 0;
			while(j != 2) {
		/*char*/char temp = tempArray[key[j] - 1]; // variable "temp" is integer and "tempArray" is array of char
				tempArray[key[j] - 1] = tempArray[j];
	            tempArray[j] = temp; // variable "temp" is integer and "tempArray" is array of char
	            j++;
			} 
//			splittedPlainText[i] = ""+tempArray[0] + tempArray[1] + tempArray[2] + tempArray[3] ;
//			splittedPlainText[i] = String(tempArray[0]) + String(tempArray[1]) + String(tempArray[2]) + String(tempArray[3]);
		}
		for(int i=0; i<splittedPlainText.length; i++)
	        encryptedText = encryptedText.concat(splittedPlainText[i]);
//		return encryptedText;
	}
	
	public string[] split(String textWithoutSpace) {
		int div = textWithoutSpace.length() / 4;
		if(plainText.length() % 4 != 0) {
			int size = div + 1; 
			// check the scope of the code below 
			String[] array = new String[size];
			int count = 0;
			numOfElements = 0; // numOfElements variable already initialized in this class
			while(count != textWithoutSpace.length() - (plainText.length() - (div * 4))) {
		        count = count + 4;
		        array[numOfElements++] = textWithoutSpace.substring(count-4, count);
			}
			 while(plainText.substring(count) != 4) { // check this boolean expression
		            textWithoutSpace = textWithoutSpace.concat("z");
		        }
			 array[numOfElements] = textWithoutSpace.substring(count);
			 return array;
		}
	}
	
}
