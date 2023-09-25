public class CipherList {
    private int numOfCiphers = 0;
    private Cipher[] arrCiphers = new Cipher[5];

    public void add(Cipher cipher) {
        arrCiphers[numOfCiphers++] = cipher;
    }
    public void remove(int index) {
        index--;
        do {
            arrCiphers[index] = arrCiphers[++index];
        } while(index != numOfCiphers - 1);
        arrCiphers[index] = null;
    }
    public void display() {
        for (int i = 0; i < numOfCiphers; i++) {
            System.out.println((i + 1) + "- " + arrCiphers[i].getName());
        }
    }

    public Cipher getCipher(int index) {
        return arrCiphers[--index];
    }
}
