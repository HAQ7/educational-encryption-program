import java.util.Scanner;

public class Keyed extends Cipher {
	private int[] key = new int[4];
	private int digitsInKey = 0;
	private int numOfElements;

	public Keyed(String name) {
		super(name);
	}

	public boolean exist(int digit) {
		for (int i = 0; i < key.length; i++) {
			if (key[i] == digit)
				return true;
		} return false;
	}

	public void add(int digit, Scanner in) {
		while (exist(digit) || (digit > 4 || digit < 1)) {
			System.out.print("please enter a number from 1 to 4 that you have not entered before: ");
			digit = in.nextInt();
		}
		key[digitsInKey++] = digit;
	}

	public void encrypt() {
		encryptedText = "";
		String textWithoutSpace = plainText.replace(" ", "");

		while (textWithoutSpace.length() % 4 != 0) {
			textWithoutSpace = textWithoutSpace.concat("z");
		}

		String[] splittedPlainText = split(textWithoutSpace);
		for (int i = 0; i < splittedPlainText.length; i++) {
			char[] tempArray = splittedPlainText[i].toCharArray();
			int j = 0;
			while (j != 2) {
				char temp = tempArray[key[j] - 1];
				tempArray[key[j] - 1] = tempArray[j];
				tempArray[j] = temp;
				j++;
			}
			splittedPlainText[i] = "" + tempArray[0] + tempArray[1] + tempArray[2] + tempArray[3];
		}
		for (int i = 0; i < splittedPlainText.length; i++)
			encryptedText = encryptedText.concat(splittedPlainText[i]);
		 // ERWHREEAUNYOZZOW  (for Testing)
	}

	public String[] split(String textWithoutSpace) {
		int div = textWithoutSpace.length() / 4;
//		int size = div;
//		if (plainText.length() % 4 != 0)
//			size = div + 1;
//		String[] array = new String[size]; 
		String[] array = new String[div];
		int count = 0;
		numOfElements = 0;

//		while (count != textWithoutSpace.length() - (plainText.length() - (div * 4))) {

		while (count < textWithoutSpace.length()) {
			count = count + 4;

			array[numOfElements++] = textWithoutSpace.substring(count - 4, count);

//			while (plainText.substring(count).length() != 4) {
//				textWithoutSpace = textWithoutSpace.concat("z");
//			}

//			array[numOfElements] = textWithoutSpace.substring(count);
//			return array;
		}
		return array;
	}

}
