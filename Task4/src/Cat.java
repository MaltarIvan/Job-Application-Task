/**
 * Created by Maltar on 4.6.2018..
 */
public class Cat implements Comparable {
    private int length;

    public Cat(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int compareTo(Object o) {
        // if (o instanceof Cat) throw new IllegalArgumentException("Argument must be instance of class Cat!");
        int compareLength = ((Cat) o).getLength();
        return this.getLength() - compareLength;
    }
}
