import java.util.Scanner;

/**
 * Created by Maltar on 4.6.2018..
 */
public class Main {
    public static void main(String[] args) {
        int T;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter tests number:");
            String scann = scanner.next();
            try {
                T = Integer.parseInt(scann);
                if (T >= 1 && T <= 1000) {
                    break;
                } else {
                    System.out.println("Wrong input!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Wrong number format!");
            }
        }
        for (int i = 0; i < T; i++) {
            scanner = new Scanner(System.in);
            String input;
            while (true) {
                System.out.println("Enter word: ");
                String scann = scanner.next();
                if (scann.length() >= 1 && scann.length() <= 100) {
                    input  = scann;
                    break;
                } else {
                    System.out.println("Wrong input!");
                }
            }
            System.out.println(doMagic(input) ? "yes" : "no");
        }
    }

    private static boolean doMagic(String input) {
        int length = input.length();
        char[] inputArray = input.toCharArray();
        int[] frequencies = new int[256];

        for (char c : inputArray) {
            frequencies[c]++;
            if (frequencies[c] > 3) {
                return true;
            }
        }

        String nonRepeating = "";
        for (int i = 0; i < length; i++) {
            if (frequencies[inputArray[i]] > 1) {
                nonRepeating += inputArray[i];
            }
        }
        char[] nonRepeatingArray = nonRepeating.toCharArray();

        if (isPalindrome(nonRepeatingArray)) {
            if (nonRepeating.length() % 2 == 1) {
                return nonRepeatingArray[nonRepeating.length() / 2] == nonRepeatingArray[nonRepeating.length() / 2  - 1];
            }
            return false;
        }
        return true;
    }

    private static boolean isPalindrome(char[] input) {
        int length = input.length;
        for (int i = 0; i < length; i++) {
            return input[i] == input[length - i - 1];
        }
        return true;
    }
}
