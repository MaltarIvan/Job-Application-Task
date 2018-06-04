import java.util.Scanner;

/**
 * Created by Maltar on 4.6.2018..
 */
public class Main {
    public static void main(String args[]) {
        int T;
        Scanner scanner = new Scanner(System.in);
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
            int N;
            while (true) {
                try {
                    System.out.print("Enter number of sensors: ");
                    N = Integer.parseInt(scanner.next());
                    if (N >= 2 && N <= 500) {
                        break;
                    } else {
                        System.out.println("Wrong input!");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Wrong input!");
                }
            }
            int[] A = new int[N];
            boolean inputCorrect = false;
            while (!inputCorrect) {
                System.out.println("Enter sensors frequencies:");
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
                        if (element >= 1 && element <= 1000000000) {
                            A[k] = Integer.parseInt(line[k]);
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
                System.out.print("Entered sensors frequencies: ");
                for (int m : A) {
                    System.out.print(m + " ");
                }
                System.out.println();
            }
            System.out.println("Result: " + doMagic(A));
        }
    }

    private static int doMagic(int[] A) {
        int length = A.length;
        int minimalLcm = lcm(A[0], A[1]);
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int a = A[i];
                int b = A[j];
                int lcm = lcm(A[i], A[j]);
                if (lcm < minimalLcm) {
                    minimalLcm = lcm;
                }
            }
        }
        return minimalLcm;
    }

    private static int gcd(int a, int b) {
        if (a == 0 || b == 0) return 0;
        if (a == b) return a;
        if (a > b) return gcd(a-b, b);
        return gcd(a, b-a);
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
