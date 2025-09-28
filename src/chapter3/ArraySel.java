package chapter3;

public class ArraySel {
    private long[] items;
    private int nElems;

    ArraySel(int size) {
        items = new long[size];
        nElems = 0;
    }

    public void display() {
        int size = items.length;
        System.out.print("[ ");
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i]);
            if (i + 1 < size) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]\n");
    }

    public void sort() {
        int minIndex;
        for(int outer = 0; outer < nElems; outer++) {
            minIndex = outer;
            for(int inner = outer + 1; inner < nElems; inner++) {
                if (items[inner] < items[minIndex]) {
                    minIndex = inner;
                }
            }
            swap(outer, minIndex);
        }
    }

    private void swap(int to, int from) {
        long tmpMin = items[from];
        items[from] = items[to];
        items[to] = tmpMin;
    }

    public void insert(int val) {
        items[nElems++] = val;
    }
}
