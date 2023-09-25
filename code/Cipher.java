public abstract class Cipher {
    private String name;
    protected String plainText;
    protected String encryptedText;

    public Cipher(String name) {
        this.name = name;
        plainText = "";
        encryptedText = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

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

    public abstract void encrypt();
    public abstract void decrypt();
}
