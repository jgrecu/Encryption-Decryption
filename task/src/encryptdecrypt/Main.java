package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Encrypt encrypt = new Encrypt();

        String process = sc.nextLine();
        String inputText = sc.nextLine();
        int key = sc.nextInt(); //sc.nextLine();

        String text = encrypt.processText(inputText, key, process);
        System.out.println(text);
        sc.close();
    }
}
