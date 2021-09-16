package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        String text = "we found a treasure!";
        Encrypt encrypt = new Encrypt();
        String encryptedText = encrypt.encryptText(text);
        System.out.println(encryptedText);
    }
}
