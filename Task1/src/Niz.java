/**
 * Created by Maltar on 3.6.2018..
 */
public class Niz {
    private int[] data;
    private int N;

    public Niz() {
    }

    public Niz(int[] data) {
        this.data = data;
        this.N = data.length;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int prefiksNiza(int i) {
        if (i < 0 || i > N) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += data[j];
        }
        return sum;
    }

    public int sufiksNiza(int i) {
        if (i < 0 || i > N) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (int j = i - 1; j < N; j++) {
            sum += data[j];
        }
        return sum;
    }
}
