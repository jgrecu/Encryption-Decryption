package encryptdecrypt;

public class EncryptDecryptShift implements EncryptDecrypt {
    private final String str = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String encryptText(String input, int key) {
        final StringBuilder sb = new StringBuilder();
        char letter;
        for (int i = 0; i < input.length(); i++) {
            letter = input.charAt(i);
            if (Character.isLetter(letter)) {
                boolean isUpper = Character.isUpperCase(letter);
                if (isUpper) {
                    letter = Character.toLowerCase(letter);
                }
                int indexLetter = (str.indexOf(letter) + key) % 26;
                char finalChar = isUpper ? Character.toUpperCase(str.charAt(indexLetter)) : str.charAt(indexLetter);
                sb.append(finalChar);
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    @Override
    public String decryptText(String input, int key) {
        final StringBuilder sb = new StringBuilder();
        char letter;
        for (int i = 0; i < input.length(); i++) {
            letter = input.charAt(i);
            if (Character.isLetter(letter)) {
                boolean isUpper = Character.isUpperCase(letter);
                if (isUpper) {
                    letter = Character.toLowerCase(letter);
                }
                int indexLetter = (str.indexOf(letter) - key) % 26;
                if (indexLetter < 0) {
                    indexLetter = 26 + indexLetter;
                }
                char finalChar = isUpper ? Character.toUpperCase(str.charAt(indexLetter)) : str.charAt(indexLetter);
                sb.append(finalChar);
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }
}
