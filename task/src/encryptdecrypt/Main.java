package encryptdecrypt;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Encrypt encrypt = new Encrypt();
        HashMap<String, String> argsMap = new HashMap<>();

        for (int i = 0; i < args.length; i += 2) {
            argsMap.put(args[i], args[i + 1]);
        }

        String process = argsMap.getOrDefault("-mode", "enc");
        int key = Integer.parseInt(argsMap.getOrDefault("-key", "0"));
        String inputText = argsMap.getOrDefault("-data", "");

        String text = encrypt.processText(inputText, key, process);
        System.out.println(text);
    }
}
