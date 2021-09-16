package encryptdecrypt;

public class Encrypt {
    private final String str = "abcdefghijklmnopqrstuvwxyz";

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

    public String encryptText(String input, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                char letter = input.charAt(i);
                int indexLetter = (str.indexOf(letter) + key) % 26;
                sb.append(str.charAt(indexLetter));
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }
}
