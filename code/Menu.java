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
        if (tempText.length() > 0) 
        cipher.setPlainText(tempText);
        else {
            System.out.print("Enter the text to be Encrypted: ");
            cipher.setPlainText(textValidate(in.nextLine(),in));
        } 
        cipher.encrypt();
        tempText = cipher.getEncryptedText();
        System.out.println(tempText);
        list.saveChoice(cipher,in);
        return tempText;
    }
    public static void decChoice(CipherList list, Scanner in) {
        int encChoice;
            do {
                
                encChoice = in.nextInt();
                in.nextLine();
                System.out.print("Enter a name for the cipher: ");
                String name = in.nextLine();
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
                    System.out.print("Enter the text to be decrypted: ");
                    monoSubCipher.setEncryptedText(textValidate(in.nextLine(),in));
                    monoSubCipher.decrypt();
                    System.out.println(monoSubCipher.getPlainText());
                    list.saveChoice(monoSubCipher, in);
                } else if (encChoice == 2) {
                    
                } else if (encChoice == 3) {
                    Vigenere vigenereCipher = new Vigenere(name);
                    System.out.println("In Vigenere, the concept of polyalphabetic is used here, where we use a String as a key.");
                    System.out.print("Enter the key to start the process: ");
                    vigenereCipher.setKey(in.nextLine());
                    System.out.print("Enter the text to be decrypted: ");
                    vigenereCipher.setEncryptedText(textValidate(in.nextLine(),in));
                    vigenereCipher.decrypt();
                    System.out.println(vigenereCipher.getPlainText());
                    list.saveChoice(vigenereCipher, in);
                    
                } else if (encChoice == 4) {
                    
                }
                
                
            } while ((encChoice > 4 || encChoice < 1 ));
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
                    displayCipherOptions(1);
                    encChoice = in.nextInt();
                    in.nextLine();
                    System.out.print("Enter a name for the cipher: ");
                    name = in.nextLine();
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
                    // playfair here
                } else if (encChoice == 3) {
                    Vigenere vigenereCipher = new Vigenere(name);
                    System.out.println("In Vigenere, the concept of polyalphabetic is used here, where we use a String as a key.");
                    System.out.print("Enter the key to start the process: ");
                    vigenereCipher.setKey(in.nextLine());
                    tempText = createCipher(list, vigenereCipher, name, tempText, in);
                    hasEncrypted = true;
                } else if (encChoice == 4) {
                    // keyed here
                } else if (encChoice == 5) {
                    // des here
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

            } while (((encChoice > 5 && encChoice != 10 )|| encChoice < 1 ) || againChoice == 1);
    }
    public static void displayCipherOptions(int mainChoice) {

        System.out.println("Please select an option");
        System.out.println("-------------------------------------");
        System.out.println("1- Monoalphabetic Substitution");
        System.out.println("2- Playfair");
        System.out.println("3- Vigenere");
        if (mainChoice == 1) {
            System.out.println("4- Keyed Transposition");
            System.out.println("5- DES");
        }
        if (mainChoice == 2) {
            System.out.println("4- Frequency Analysis");
        }
        System.out.println("-------------------------------------");

        System.out.print("Enter here: ");
    }

    public static void main(String[] args) {

        Scanner in = new Scanner (System.in);
        CipherList list = new CipherList();
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
            if (mainChoice == 2) {
                displayCipherOptions(mainChoice);
                decChoice(list, in);
            }

            if (mainChoice == 3 && !list.isEmpty()) {
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
                        // else if (list.getCipher(choice) instanceof Keyed || list.getCipher(choice) instanceof DES)
                        //else if (list.getCipher(choice) instanceof Freq)
                    } else if (saveChoice == 2) {
                        list.remove(choice);
                    }
                } while (saveChoice > 2 || saveChoice < 1);
                
            }

            if (mainChoice == 3 && list.isEmpty()) {
                break;
            }

            if (mainChoice == 4 && !list.isEmpty()) {
                break;
            }

        } while (true);
        in.close();
    }
}
