import java.util.*;

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
                if (T >= 1 && T <= 5) {
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
            int Q = 0;
            boolean inputCorrect = false;
            while (!inputCorrect) {
                System.out.println("Enter number of cats and number of desired lengths");
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
                    Q = Integer.parseInt(line[1]);
                    if ((N >= 1 && N <= 100000) && (Q >= 1 && Q <= 100000)) {
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
            ArrayList<Cat> cats = new ArrayList<>();
            inputCorrect = false;
            while (!inputCorrect) {
                System.out.println("Enter lengths:");
                scanner = new Scanner(System.in);
                String[] line = new String[0];
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().split(" ");
                }
                if (line.length != N) {
                    System.out.println("Wrong number of lengths entered!");
                    continue;
                }
                for (int j = 0; j < N; j++) {
                    try {
                        int length = Integer.parseInt(line[j]);
                        if (length >= 1 && length <= 1000000000) {
                            cats.add(new Cat(length));
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
            for (int j = 0; j < Q; j++) {
                int K;
                scanner = new Scanner(System.in);
                while (true) {
                    System.out.print("Enter " + (j + 1) + ". " + "desired length: ");
                    String scann = scanner.next();
                    try {
                        K = Integer.parseInt(scann);
                        if (K >= 1 && K <= 1000000000) {
                            break;
                        } else {
                            System.out.println("Wrong input!");
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Wrong number format!");
                    }
                }
                System.out.println("Result: " + doMagic(new ArrayList<>(cats), K));
            }
        }
    }

    private static int doMagic(ArrayList<Cat> cats, int K) {
        int result = 0;
        for (int i = 0; i < cats.size(); i++) {
            Cat currentCat = cats.get(i);
            if (currentCat.getLength() >= K) {
                result++;
                cats.remove(currentCat);
                i--;
            }
        }
        Collections.sort(cats);
        return result + catFeast(cats, K);
    }

    private static int catFeast(ArrayList<Cat> cats, int K) {
        if (cats.size() == 1) {
            return cats.get(0).getLength() >= K ? 1 : 0;
        }

        Cat longestCat = cats.get(cats.size() - 1);
        for (int i = 0; i < cats.size() - 1; i++) {
            Cat currentCat = cats.get(i);
            longestCat.setLength(longestCat.getLength() + 1);
            cats.remove(currentCat);
            if (longestCat.getLength() >= K) {
                break;
            }
        }
        if (longestCat.getLength() >= K) {
            cats.remove(longestCat);
            return 1 + catFeast(cats, K);
        } else {
            return 0;
        }
    }
}
