public class Vigenere {
	private String plainText;
	private String encryptedText;
	private String key;
	public String encrypt() {
		encryptedText = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int keyIndex = 0;
		for (int i = 0; i < plainText.length(); i++) {
			char Letter = plainText.charAt(i);
			if (Character.isLetter(Letter)) {
				int letterindex = find(Letter);
				int keywordindex = find(key.charAt(keyIndex));
				int newIndex = (letterindex + keywordindex) % 26;
				char encryptedLetter = alphabet.charAt(newIndex);
				encryptedText += encryptedLetter;
				keyIndex = (keyIndex + 1) % key.length();
			} else {
				encryptedText += Letter;
			}
		}

		return encryptedText;
	}
	public String decrypt() {
		plainText = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int keyIndex = 0;
		for (int i = 0; i < encryptedText.length(); i++) {
			char letter = encryptedText.charAt(i);
			if (Character.isLetter(letter)) {
				int letterindex = find(letter);
				int keywordindex = find(key.charAt(keyIndex));
				int newIndex = (letterindex - keywordindex + 26) % 26;
				char decryptedLetter = alphabet.charAt(newIndex);
				plainText += decryptedLetter;
				keyIndex = (keyIndex + 1) % key.length();
			} else {
				plainText += letter;
			}
		}
		return plainText;
	}
	
	private int find(char letter) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		return alphabet.indexOf(letter);
	}
	}
