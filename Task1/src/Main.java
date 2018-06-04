import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by Maltar on 3.6.2018..
 */
public class Main {
    public static void main(String args[]) {
        int T;
        int N;
        Niz A;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ulaz:");
        while (true) {
            System.out.println("Enter tests number:");
            String scann = scanner.next();
            try {
                T = Integer.parseInt(scann);
                if (T >= 1 && T <= 10) {
                    break;
                } else {
                    System.out.println("Wrong input!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Wrong number format!");
            }
        }
        for (int i = 0; i < T; i++) {
            while (true) {
                System.out.println("Enter elements number:");
                String scann = scanner.next();
                try {
                    N = Integer.parseInt(scann);
                    if (N >= 1) {
                        break;
                    } else {
                        System.out.println("Wrong input!");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Wrong number format!");
                }
            }
            A = new Niz(new int[N]);
            boolean inputCorrect = false;
            while (!inputCorrect) {
                System.out.println("Enter elements:");
                scanner = new Scanner(System.in);
                String[] line = new String[0];
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().split(" ");
                }
                if (line.length != N) {
                    System.out.println("Wrong number of elements entered!");
                    continue;
                }
                for (int k = 0; k < N; k++) {
                    try {
                        int element = Integer.parseInt(line[k]);
                        if (element > 0 && element <= 100000) {
                            A.getData()[k] = Integer.parseInt(line[k]);
                            inputCorrect = true;
                        } else {
                            System.out.println("Wrong input!");
                            inputCorrect = false;
                            break;
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Wrong number format!");
                        inputCorrect = false;
                        break;
                    }
                }
            }
            if (inputCorrect) {
                System.out.print("Entered elements: ");
                for (int m : A.getData()) {
                    System.out.print(m + " ");
                }
                System.out.println();
            }
            System.out.println("Result: " + doMagic(A));
        }
    }

    public static int doMagic(Niz A) {
        int min = A.prefiksNiza(1) + A.sufiksNiza(1);
        int minIndex = 1;
        for (int j = 2; j <= A.getN(); j ++) {
            int sum = A.prefiksNiza(j) + A.sufiksNiza(j);
            if (sum <  min) {
                min = sum;
                minIndex = j;
            }
        }
        return minIndex;
    }
}
