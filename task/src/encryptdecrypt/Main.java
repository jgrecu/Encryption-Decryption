package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Encrypt encrypt = new Encrypt();
        //String text = "we found a treasure!";
        //String encryptedText = encrypt.encryptText(text);
        String text = sc.nextLine();
        int key = sc.nextInt();
        String encryptedText = encrypt.encryptText(text, key);
        System.out.println(encryptedText);
        sc.close();
    }
}
