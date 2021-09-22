package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static final EncoderDecoder encoderDecoder = new EncoderDecoder();
    static final String error = "Error";

    public static void main(String[] args) {

        final HashMap<String, String> argsMap = new HashMap<>();

        try {
            for (int i = 0; i < args.length; i += 2) {
                argsMap.put(args[i], args[i + 1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(error);
            System.exit(1);
        }

        String process = argsMap.getOrDefault("-mode", "enc");
        int key = Integer.parseInt(argsMap.getOrDefault("-key", "0"));
        String inputText = argsMap.getOrDefault("-data", "");
        String algorithm = argsMap.getOrDefault("-alg", "shift");

        if (argsMap.get("-data")  == null && argsMap.get("-in") != null) {
            String inFileName = argsMap.get("-in");
            inputText = readFile(inFileName);
        }

        if (inputText == null) {
            System.exit(1);
        }

        if (argsMap.get("-out") == null) {
            processDataPrint(inputText, key, process, algorithm);
        } else {
            String outFileName = argsMap.get("-out");
            processDataToFile(inputText, key, process, outFileName, algorithm);
        }

    }


    public static void processDataPrint(String inputText, int key, String process, String algorithm) {
        String text = encoderDecoder.processText(inputText, key, process, algorithm);
        System.out.println(text);
    }

    public static String readFile(String filename) {
        if (filename.equals("")) {
            System.out.println(error);
            System.exit(1);
        }
        File file = new File(filename);
        StringBuilder fileContents = new StringBuilder((int)file.length());
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return fileContents.toString();
        } catch (FileNotFoundException e) {
            System.out.println(error);
            return null;
        }
    }

    private static void processDataToFile(String inputText, int key, String process, String outFileName, String algorithm) {
        if (outFileName.equals("")) {
            System.out.println(error);
            System.exit(1);
        }
        String text = encoderDecoder.processText(inputText, key, process, algorithm);
        try (PrintStream out = new PrintStream(new FileOutputStream(outFileName))) {
            out.print(text);
        } catch (FileNotFoundException e) {
            System.out.println(error);
            System.exit(1);
        }
    }
}
