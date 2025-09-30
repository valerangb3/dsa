package chapter3;

public class ArrayInsert {
    private long[] a;
    private int nElems;

    public ArrayInsert(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems++] = value;
    }

    public void display() {
        int size = a.length;
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i + 1 < size) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]\n");
    }

    public void insertSort() {
        for (int outer = 1; outer < a.length; outer++) {
            int inner = outer;
            long temp = a[outer];
            while (inner > 0 && a[inner - 1] > temp) {
                a[inner] = a[inner - 1];
                inner--;
            }
            a[inner] = temp;
        }
    }

    public float median() {
        int medianPosition = nElems / 2;
        if (nElems % 2 == 0) {
            return ((float) a[medianPosition] + (float) a[medianPosition - 1]) / 2;
        }
        return (float) a[medianPosition];
    }
}
