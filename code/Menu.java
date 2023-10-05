import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class Menu {
    public static String textValidate(String text, Scanner in) {
        boolean isItAllowed = true;
            if (text.isEmpty()) {
                isItAllowed = false;
            }
           if (isItAllowed) {
                for (int i = 0; i < text.length(); i++) {
                    if (!Character.isLetter(text.charAt(i))) {
                        isItAllowed = false;
                        break;
                    }
                }
           }
        while (!isItAllowed) {
            System.out.print("Please enter text with letters only: ");
            text = in.nextLine();
            isItAllowed = true;
             if (text.isEmpty()) {
                isItAllowed = false;
            }
           if (isItAllowed) {
                for (int i = 0; i < text.length(); i++) {
                    if (!Character.isLetter(text.charAt(i))) {
                        isItAllowed = false;
                        break;
                    }
                }
           }
        } 
        return text;
    }

    public static String createCipher(CipherList list, Cipher cipher, String name, String tempText, Scanner in) {
        if (!tempText.isEmpty())
        cipher.setPlainText(tempText);
        else {
            System.out.print("Enter the text to be Encrypted: ");
            cipher.setPlainText(textValidate(in.nextLine(),in));
        } 
        cipher.encrypt();
        tempText = cipher.getEncryptedText();
        list.saveChoice(cipher,in);
        return tempText;
    }
    public static void decChoice(CipherList list, Scanner in) {
        int decChoice;
            do {
                
                decChoice = in.nextInt();
                in.nextLine();
                String name = "";
                if (decChoice != 4) {
                    System.out.print("Enter a name for the cipher: ");
                    name = in.nextLine();
                }
                if (decChoice == 1) {
                    MonoSub monoSubCipher = new MonoSub(name);
                    System.out.println("In Monoalphabetic Substitution, the key is the number of shifts that will ocour to each letter.");
                    System.out.print("Enter the key to start the process: ");
                    int key;
                     try {
                        key = in.nextInt();
                    } catch (Exception e) {
                        System.out.println("since you did not enter an intger 3 was chosen as a default...");
                        key = 3;
                    }      
                    in.nextLine();
                    monoSubCipher.setKey(key);
                    System.out.print("Enter the text to be decrypted: ");
                    monoSubCipher.setEncryptedText(textValidate(in.nextLine(),in));
                    monoSubCipher.decrypt();
                    list.saveChoice(monoSubCipher, in);
                } else if (decChoice == 2) {
                    Playfair playfairCipher = new Playfair(name);
                    System.out.println("In playfair, a matrix that consist of all the letters will be used to encrypt. \n" +
                    "We will take 2 letters each time if the 2 letters are in the same row each letter will be moved 1 cell to the right. \n" +
                    "If the 2 letters are in the same column we will move each letter 1 cell down \n" +
                    "If neither of them are togther then the first will be moved to the sec's column, and the sec will be moved to the first's col");
                    System.out.println("The matrix fill process will start now, keep in mind that in one of the cells you need to enter ij togther.");
                    System.out.println("You will also need to enter all of the letters in the english language.");
                    for(int i = 0; i<25; i++) {
                        System.out.print("Enter a letter: ");
                        while(!playfairCipher.add(textValidate(in.nextLine(),in)));
                    }
                    System.out.print("Enter the text to be decrypted: ");
                    playfairCipher.setEncryptedText(textValidate(in.nextLine(),in));
                    playfairCipher.decrypt();
                    System.out.println(playfairCipher.getPlainText());
                    list.saveChoice(playfairCipher, in);
                } else if (decChoice == 3) {
                    Vigenere vigenereCipher = new Vigenere(name);
                    System.out.println("In Vigenere, the concept of polyalphabetic is used here, where we use a String as a key.");
                    System.out.print("Enter the key to start the process: ");
                    vigenereCipher.setKey(textValidate(in.nextLine(),in));
                    System.out.print("Enter the text to be decrypted: ");
                    vigenereCipher.setEncryptedText(textValidate(in.nextLine(),in));
                    vigenereCipher.decrypt();
                    System.out.println(vigenereCipher.getPlainText());
                    list.saveChoice(vigenereCipher, in);
                    
                } else if (decChoice == 4) {
                    FreqAnalysis freqAnalysis = new FreqAnalysis();
                    System.out.println("In Frequency Analysis, since we dont know the key, we will have to use the frequency of the letters in the sentence and compare them to their frequency in the english language");
                    System.out.print("Enter the text to be decrypted: ");
                    freqAnalysis.setEncryptedText(textValidate(in.nextLine(),in));
                    freqAnalysis.decrypt();
                }
                
                
            } while ((decChoice > 4 || decChoice < 1 ));
        }
        
        public static void encChoice(CipherList list, Scanner in, boolean calledFromSaved, String savedText) {
            boolean hasEncrypted = false;
            int encChoice;
            int againChoice = 0;
            String tempText = "";
            String name = "";
            do {
                if (calledFromSaved) {
                    hasEncrypted = true;
                    encChoice = 10;
                    tempText = savedText;
                    calledFromSaved = false;
                } else {
                    displayCipherOptions(1, list);
                    encChoice = in.nextInt();
                    in.nextLine();
                    if (encChoice != 6) {
                        System.out.print("Enter a name for the cipher: ");
                        name = in.nextLine();
                    }
                }
                if (encChoice == 1) {
                    MonoSub monoSubCipher = new MonoSub(name);
                    System.out.println("In Monoalphabetic Substitution, the key is the number of shifts that will ocour to each letter.");
                    System.out.print("Enter the key to start the process: ");
                    int key;
                     try {
                        key = in.nextInt();
                    } catch (Exception e) {
                        System.out.println("since you did not enter an intger 3 was chosen as a default...");
                        key = 3;
                    }             
                    in.nextLine();
                    monoSubCipher.setKey(key);
                    tempText = createCipher(list, monoSubCipher, name, tempText, in);
                    hasEncrypted = true;
                } else if (encChoice == 2) {
                    Playfair playfairCipher = new Playfair(name);
                    System.out.println("In playfair, a matrix that consist of all the letters will be used to encrypt. \n" +
                    "We will take 2 letters each time if the 2 letters are in the same row each letter will be moved 1 cell to the right. \n" +
                    "If the 2 letters are in the same column we will move each letter 1 cell down \n" +
                    "If neither of them are togther then the first will be moved to the sec's column, and the sec will be moved to the first's col");
                    System.out.println("The matrix fill process will start now, keep in mind that in one of the cells you need to enter ij togther.");
                    System.out.println("You will also need to enter all of the letters in the english language.");
                    for(int i = 0; i<25; i++) {
                        System.out.print("Enter a letter: ");
                        while(!playfairCipher.add(textValidate(in.nextLine(),in)));
                    }
                    tempText = createCipher(list, playfairCipher, name, tempText, in);
                    hasEncrypted = true;
                } else if (encChoice == 3) {
                    Vigenere vigenereCipher = new Vigenere(name);
                    System.out.println("In Vigenere, the concept of polyalphabetic is used here, where we use a String as a key.");
                    System.out.print("Enter the key to start the process: ");
                    vigenereCipher.setKey(textValidate(in.nextLine(),in));
                    tempText = createCipher(list, vigenereCipher, name, tempText, in);
                    hasEncrypted = true;
                } else if (encChoice == 4) {
                    Keyed keyedCipher = new Keyed(name);
                    System.out.println("In Keyed, each 4 letters in the sentence will be split into a group and using your key they will be permute with each other..");
                    System.out.print("now please enter the 4 numbers from 1 to 4 while not entering the same number again: ");
                    for(int i = 0; i<4; i++) {
                        keyedCipher.add(in.nextInt(), in);
                    }
                    in.nextLine();
                    tempText = createCipher(list, keyedCipher, name, tempText, in);
                    hasEncrypted = true;
                } else if (encChoice == 5) {
                    System.out.println("DES takes a 16 hexadecimal numbers to genarate the keys.");
                    Boolean isItAllowed;
                    System.out.print("Enter the key of 16 hexadecimal numbers (without space) to start the process: ");
                    String key;
                    do {
                        key = in.nextLine();
                        isItAllowed = true;
                        for (int i = 0; i < key.length(); i++) {
                            if ("qwrtyuiopsghjklzxvnm `!@#$%^&*()_+{}\\|;:'\'\",<.>/?".contains("" + key.charAt(i)) || key.length() != 16) {
                                isItAllowed = false;
                                System.out.print("please 16 hexadecimal numbers enter again without space: ");
                                break;
                            }
                        }
                    } while(!isItAllowed);
                    System.out.print("Enter the text of 16 hexadecimal numbers (without space) that you want to be encrypted: ");
                    if (!(tempText.length() > 0)) {
                        do {
                        tempText = in.nextLine();
                        isItAllowed = true;
                        for (int i = 0; i < key.length(); i++) {
                            if ("qwrtyuiopsghjklzxvnm `!@#$%^&*()_+{}\\|;:'\'\",<.>/?".contains("" + tempText.charAt(i)) || key.length() != 16) {
                                isItAllowed = false;
                                System.out.print("please 16 hexadecimal numbers enter again without space: ");
                                break;
                            }
                        }
                    } while(!isItAllowed);
                    }
                    DES desCipher = new DES(name, key);
                    tempText = createCipher(list, desCipher, name, tempText, in);
                    hasEncrypted = true;
                } else if (encChoice == 6 && !list.isEmpty()) {
                     int choice;
                    do {
                        System.out.println("Choose the cipher");
                        System.out.println("-------------------------------------");
                        list.display();
                        System.out.println("-------------------------------------");
                        System.out.print("Enter here: ");
                        choice = in.nextInt();
                        in.nextLine();
                    } while(!list.isChoiceAval(choice));
                    Cipher savedCipher = list.getCipher(choice);
                    if (tempText.length() > 0) {
                        savedCipher.setPlainText(tempText);
                    }else {
                        System.out.print("Enter the text to be Encrypted: ");
                        savedCipher.setPlainText(textValidate(in.nextLine(),in));
                    }
                    savedCipher.encrypt();
                    tempText = savedCipher.getEncryptedText();
                    System.out.println(tempText);
                    hasEncrypted = true;
                    
                }
                if (hasEncrypted) {
                    do {
                        System.out.println("Would you like to encrypt it again ?");
                        System.out.println("-------------------------------------");
                        System.out.println("1- Yes");
                        System.out.println("2- No");
                        System.out.println("-------------------------------------");
                        System.out.print("Enter here: ");
                        againChoice = in.nextInt();          
                    } while (againChoice > 2 || againChoice < 1);
                }

            } while (((encChoice > 6 && encChoice != 10 )|| encChoice < 1 ) || againChoice == 1);
    }
    public static void displayCipherOptions(int mainChoice, CipherList list) {
        
        System.out.println("Please select an option");
        System.out.println("-------------------------------------");
        System.out.println("1- Monoalphabetic Substitution");
        System.out.println("2- Playfair");
        System.out.println("3- Vigenere");
        if (mainChoice == 1) {
            System.out.println("4- Keyed Transposition");
            System.out.println("5- DES");
            if (!list.isEmpty()) {
                   System.out.println("6- Saved Encryption method");
               }
        }
        if (mainChoice == 2) {
            System.out.println("4- Frequency Analysis");
        }
        System.out.println("-------------------------------------");

        System.out.print("Enter here: ");
    }

    public static void main(String[] args) {
        CipherList list = new CipherList();
        list.getFile();
        Scanner in = new Scanner (System.in);
        System.out.println("Welcome to the Educational Encryption Program.");
        int mainChoice;
        do {
            System.out.println("Please select an option");
            System.out.println("-------------------------------------");
            System.out.println("1- Encrypt");
            System.out.println("2- Decrypt");
            if (!list.isEmpty()) {
                System.out.println("3- Saved Encryption method");
            }
            System.out.println((!list.isEmpty() ? "4" : "3") +"- Exit");
            System.out.println("-------------------------------------");
            System.out.print("Enter here: ");


            mainChoice = in.nextInt();

            if (mainChoice == 1) {
               encChoice(list, in, false, "");
            }
            else if (mainChoice == 2) {
                displayCipherOptions(mainChoice, list);
                decChoice(list, in);
            }

            else if (mainChoice == 3 && !list.isEmpty()) {
                int saveChoice = 0;
                do {
                    System.out.println("Would you like to ");
                    System.out.println("-------------------------------------");
                    System.out.println("1- Use a saved Encryption method");
                    System.out.println("2- Remove a saved Encryption method");
                    System.out.println("-------------------------------------");
                    System.out.print("Enter here: ");
                    
                    saveChoice = in.nextInt();
                    int choice;
                    do {
                        System.out.println("Choose the cipher");
                        System.out.println("-------------------------------------");
                        list.display();
                        System.out.println("-------------------------------------");
                        System.out.print("Enter here: ");
                        choice = in.nextInt();
                    } while(!list.isChoiceAval(choice));
                    Cipher savedCipher = list.getCipher(choice);
                    if (saveChoice == 1) {
                        if (savedCipher instanceof MonoSub || savedCipher instanceof Playfair || savedCipher instanceof Vigenere) {
                            int encDecChoice;
                            do {
                                System.out.println("Please select an option");
                                System.out.println("-------------------------------------");
                                System.out.println("1- Encrypt");
                                System.out.println("2- Decrypt");
                                System.out.println("-------------------------------------");
                                System.out.print("Enter here: ");
                                encDecChoice = in.nextInt();
                                in.nextLine();
                            } while (encDecChoice > 2 || encDecChoice < 1);
                            if (encDecChoice == 1) {
                                System.out.print("Enter the text to be Encrypted: ");
                                savedCipher.setPlainText(textValidate(in.nextLine(),in));
                                savedCipher.encrypt();
                                String tempText = savedCipher.getEncryptedText();
                                System.out.println(tempText);
                                encChoice(list, in, true, tempText);
                            } else if (encDecChoice == 2) {
                                System.out.print("Enter the text to be decrypted: ");
                                savedCipher.setEncryptedText(textValidate(in.nextLine(),in));
                                savedCipher.decrypt();
                                System.out.println(savedCipher.getPlainText());
                            }

                        }
                        else if (list.getCipher(choice) instanceof Keyed) {
                            System.out.print("Enter the text to be Encrypted: ");
                            savedCipher.setPlainText(textValidate(in.nextLine(),in));
                            savedCipher.encrypt();
                            String tempText = savedCipher.getEncryptedText();
                            System.out.println(tempText);
                            encChoice(list, in, true, tempText);
                        }
                        else if (list.getCipher(choice) instanceof DES) {
                            String tempText;
                            Boolean isItAllowed;
                            in.nextLine();
                            System.out.print("Enter the text of 16 hexadecimal numbers (without space) that you want to be encrypted: ");
                            do {
                                tempText = in.nextLine();
                                isItAllowed = true;
                                for (int i = 0; i < tempText.length(); i++) {
                                    if ("qwrtyuiopsghjklzxvnm `!@#$%^&*()_+{}\\|;:'\'\",<.>/?".contains("" + tempText.charAt(i)) || tempText.length() != 16) {
                                    isItAllowed = false;
                                    System.out.print("please 16 hexadecimal numbers enter again without space: ");
                                    break;
                                    }
                                }
                            } while(!isItAllowed);
                            savedCipher.setPlainText(tempText);
                            savedCipher.encrypt();
                            encChoice(list, in, true, tempText);
                        }
                    } else if (saveChoice == 2) {
                        list.remove(choice);
                    }
                } while (saveChoice > 2 || saveChoice < 1);
                
            }

            else if (mainChoice == 3 && list.isEmpty()) {
                break;
            }

            else if (mainChoice == 4 && !list.isEmpty()) {
                break;
            }

        } while (true);
        list.saveFile();
        in.close();
    }
}
