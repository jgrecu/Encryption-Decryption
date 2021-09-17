package encryptdecrypt;

public class EncryptDecrypt {
    private final String str = "abcdefghijklmnopqrstuvwxyz";

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
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            char encLetter = (char) (letter + key);
            sb.append(encLetter);
        }
        return sb.toString();
    }

    public String decryptText(String input, int key) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            char decLetter = (char) (letter - key);
            sb.append(decLetter);
        }
        return sb.toString();
    }

    public String encryptTextShift(String input, int key) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
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

    public String decryptTextShift(String input, int key) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
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
