public class FreqAnalysis {
    private String encryptedText;
    private String plainText;
    private String[][] freqMatrixOfText;

    public void setEncryptedText(String encryptedText) {
        this.encryptedText = encryptedText;
    }
    
    public String getEncryptedText() {
        return encryptedText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText.toLowerCase();
    }

    public String getPlainText() {
        return plainText;
    }

    public void decrypt() {
        System.out.println("So we take the encrypted text and see each letter and how many they have appeared.");
        plainText = encryptedText;
        createFreqMatrixOfText();
        System.out.println("And we replace the most frequent letters with the most common letters in the english language.");
        plainText = plainText.replace(freqMatrixOfText[0][0], "e");
        plainText = plainText.replace(freqMatrixOfText[1][0], "t");
        plainText = plainText.replace(freqMatrixOfText[2][0], "a");
        System.out.println("Output is: " + plainText);
        System.out.println("So we continue on that path until the plain text is clear, if the text is still encrypted you may go back and try diffrent combinations...");
        
    }

    public void createFreqMatrixOfText() {
        String uniqueCharacters = "";
        for(int i = 0; i < encryptedText.length(); i++) {
            String character = "" + encryptedText.charAt(i);
            if (!uniqueCharacters.contains(character))
                uniqueCharacters = uniqueCharacters.concat(character);
        }
        freqMatrixOfText = new String[uniqueCharacters.length()][2];
        for(int i = 0; i < uniqueCharacters.length(); i++) {
            freqMatrixOfText[i][0] = "" + uniqueCharacters.charAt(i);
            int count = 0;
            for(int j = 0; j<encryptedText.length(); j++) {
                if (uniqueCharacters.charAt(i) == encryptedText.charAt(j))
                    count++;
            }
            freqMatrixOfText[i][1] = "" + count;
        }
        sortFreqMatrixOfText(uniqueCharacters.length());

    }

    public void sortFreqMatrixOfText(int lengthOfFreqMatrix) {
        String[] temp;
        for(int i = 0; i < lengthOfFreqMatrix - 1; i++) {
            for (int j = i + 1; j < lengthOfFreqMatrix; j++) {
                if (Integer.parseInt(freqMatrixOfText[j][1]) > Integer.parseInt(freqMatrixOfText[i][1])) {
                    temp = freqMatrixOfText[i];
                    freqMatrixOfText[i] = freqMatrixOfText[j];
                    freqMatrixOfText[j] = temp;
                }
            }
        }
        display();
    }

    public void display() {
        try {
            int i = 0;
            while(true) {
                System.out.println("-------");
                System.out.println("|"+ freqMatrixOfText[i][0] +"|-|"+ freqMatrixOfText[i++][1] +"|");
            }
        }catch(Exception e){}
    }
}
