public class Vigenere extends Cipher {
	private String key;

	public Vigenere(String name) {
		super(name);
	}

	public void setKey(String key) {
		this.key = key.toLowerCase();
	}

	public String getKey() {
		return key;
	}

	public void encrypt() {
		encryptedText = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int keyIndex = 0;
		System.out.println("So we take each letter from the plain text and we get their index from the alphabet and we add it with index of the letter from the key.");
		System.out.println("And we will get a new index which will be the new letter, note that if the sum is more then 26 we will subtract 26 from the final answer.");
		for (int i = 0; i < plainText.length(); i++) {
			char letter = plainText.charAt(i);
			if (Character.isLetter(letter)) {
				int letterindex = find(letter);
				int keywordindex = find(key.charAt(keyIndex));
				int newIndex = (letterindex + keywordindex) % 26;
				char encryptedLetter = alphabet.charAt(newIndex);
				System.out.println("Index of " + letter + " is: " + letterindex + " and we add it with " + keywordindex);
				System.out.println("So new letter is: " + encryptedLetter);
				encryptedText += encryptedLetter;
				keyIndex = (keyIndex + 1) % key.length();
			} else {
				encryptedText += letter;
			}
		}
		System.out.println("-----------------------------------");
		System.out.println("Final output: " + encryptedText);

	}
	public void decrypt() {
		plainText = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int keyIndex = 0;
		System.out.println("So we take each letter from the encrypted text and we get their index from the alphabet and we subtract it with index of the letter from the key and we add 26.");
		System.out.println("And we will get a new index which will be the new letter, note that if the sum is more then 26 we will subtract 26 from the final answer.");
		System.out.println("-----------------------------------");
		for (int i = 0; i < encryptedText.length(); i++) {
			char letter = encryptedText.charAt(i);
			if (Character.isLetter(letter)) {
				int letterindex = find(letter);
				int keywordindex = find(key.charAt(keyIndex));
				int newIndex = (letterindex - keywordindex + 26) % 26;
				char decryptedLetter = alphabet.charAt(newIndex);
				System.out.println("Index of " + letter + " is: " + letterindex + " and we subtract it with " + keywordindex);
				System.out.println("So new letter is: " + decryptedLetter);
				plainText += decryptedLetter;
				keyIndex = (keyIndex + 1) % key.length();
			} else {
				plainText += letter;
			}
		}
		System.out.println("-----------------------------------");
		System.out.println("Final output: " + plainText);
	}
	
	private int find(char letter) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		return alphabet.indexOf(letter);
	}
	}
