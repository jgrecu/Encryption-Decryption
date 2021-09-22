package encryptdecrypt;

public class EncryptDecryptUnicode implements EncryptDecrypt {

    @Override
    public String encryptText(String input, int key) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            char encLetter = (char) (letter + key);
            sb.append(encLetter);
        }
        return sb.toString();
    }

    @Override
    public String decryptText(String input, int key) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            char decLetter = (char) (letter - key);
            sb.append(decLetter);
        }
        return sb.toString();
    }
}
