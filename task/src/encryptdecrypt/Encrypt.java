package encryptdecrypt;

public class Encrypt {
    //private final String str = "abcdefghijklmnopqrstuvwxyz";

    public String encryptText(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                char letter = (char) (122 - input.charAt(i) + 97);
                sb.append(letter);
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    public String processText(String inputText, int key, String process) {
        switch (process) {
            case "enc":
                return encryptText(inputText, key);
            case "dec":
                return decryptText(inputText, key);
            default:
                return null;
        }
    }
    public String encryptText(String input, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            char encLetter = (char) (letter + key);
            sb.append(encLetter);
        }
        return sb.toString();
    }

    public String decryptText(String input, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            char decLetter = (char) (letter - key);
            sb.append(decLetter);
        }
        return sb.toString();
    }
}
