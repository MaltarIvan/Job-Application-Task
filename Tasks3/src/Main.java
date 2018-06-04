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
            int N = 0;
            int M = 0;
            int[] cookieMasses;
            boolean inputCorrect = false;
            while (!inputCorrect) {
                System.out.println("Enter number of cookies and desired cookie mass:");
                scanner = new Scanner(System.in);
                String[] line = new String[0];
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().split(" ");
                }
                if (line.length != 2) {
                    System.out.println("Wrong input!");
                    continue;
                }
                try {
                    N = Integer.parseInt(line[0]);
                    M = Integer.parseInt(line[1]);
                    if ((N >= 1 && N <= 20) && (M >= 1 && M <= 1000)) {
                        inputCorrect = true;
                    } else {
                        System.out.println("Wrong input!");
                        inputCorrect = false;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Wrong number format!");
                    inputCorrect = false;
                    continue;
                }
            }
            cookieMasses = new int[N];

            scanner = new Scanner(System.in);
            for (int k = 0; k < N; k++) {
                while (true) {
                    System.out.print("Enter mass of cookie number " + (k + 1) + ": ");
                    try {
                        int mass = Integer.parseInt(scanner.next());
                        if (mass >= 1 && mass <= 1000) {
                            cookieMasses[k] = Integer.parseInt(scanner.next());
                        }else {
                            System.out.println("Wrong input!");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("Wrong input!");
                        continue;
                    }
                }
            }
            if (inputCorrect) {
                System.out.print("Entered elements: ");
                for (int m : cookieMasses) {
                    System.out.print(m + " ");
                }
                System.out.println();
            }
            System.out.println(doMagic(cookieMasses, M) ? "Yes" : "No");
        }
    }

    private static boolean doMagic(int[] cookieMasses, int desiredMass) {
        return isSubsetSum(cookieMasses, cookieMasses.length, desiredMass);
    }

    private static boolean isSubsetSum(int[] set, int n, int sum) {
        if (sum == 0) return true;
        if (n == 0 && sum != 0) return false;

        if (set[n-1] > sum) return isSubsetSum(set, n-1, sum);

        return isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum-set[n-1]);
    }
}
