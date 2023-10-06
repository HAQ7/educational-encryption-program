import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class CipherList {
    private int numOfCiphers = 0;
    private Cipher[] arrCiphers = new Cipher[5];

    public void add(Cipher cipher) {
        arrCiphers[numOfCiphers++] = cipher;
    }
    public void saveChoice(Cipher cipher, Scanner in) {
        int saveChoice;
        do {
            System.out.println("Would you like to save it ?");
            System.out.println("-------------------------------------");
            System.out.println("1- Yes");
            System.out.println("2- No");
            System.out.println("-------------------------------------");
            System.out.print("Enter here: ");
            saveChoice = in.nextInt();
            if (saveChoice == 1 && !isFull()) {
                add(cipher);
            } else if (isFull()) {
                System.out.println("the limit of saved ciphers of 5 has been reached, please remove one to add again !");
            }
        } while(saveChoice > 2 || saveChoice < 1);
    }
    public void remove(int index) {
        if(isFull()) {
            numOfCiphers--;
            return;
        }
        index--;
        do {
            arrCiphers[index] = arrCiphers[++index];
        } while(index != numOfCiphers);
        arrCiphers[index] = null;
        numOfCiphers--;
    }
    public void display() {
        for (int i = 0; i < numOfCiphers; i++) {

            System.out.println((i + 1) + "- " + arrCiphers[i].getName());
        }
    }


    public boolean isChoiceAval(int index) {
        if(index > 0 && index < numOfCiphers + 1)
            return true;
        System.out.println("Choose a correct number !");
        return false;
        
    }

    public boolean isEmpty() {
        return numOfCiphers == 0;
    }

    public boolean isFull() {
        return numOfCiphers == 5;
    }

    public Cipher getCipher(int index) {
        return arrCiphers[--index];
    }

    public void getFile() {
        try{
            FileInputStream fis = new FileInputStream("encryptList.encl");
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                while (true) {
                    Cipher newCipher = (Cipher) ois.readObject();
                    if (newCipher != null)
                        add(newCipher);
                    
                }
            } catch (Exception e) {
                
            }
            ois.close();
        }
        catch (IOException e) {  
        }
    }

    public void saveFile() {
        try{

            FileOutputStream fos = new FileOutputStream("encryptList.encl");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i<numOfCiphers; i++) {
                oos.writeObject(arrCiphers[i]);
            }
            oos.close();
        }
        catch (Exception e) {
        }
    }
}
