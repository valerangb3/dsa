package chapter3;

public class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
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

    public void bubbleSort() {
        int lastIndex = a.length - 1;
        for (int outer = lastIndex; outer > 0; outer--) {
            for (int inner = 0; inner < outer; inner++) {
                if (a[inner] > a[inner + 1]) {
                    swap(inner, inner + 1);
                }
            }
        }
    }

    public void bubbleSortWitTwoPointers() {
        int lastIndex = nElems - 1;
        for (int outer = lastIndex, leftPointer = 0; outer > leftPointer; outer--, leftPointer++) {
            int inner = leftPointer;
            boolean moveBack = false;
            while (inner >= leftPointer) {
                if (moveBack) {
                    if (inner == leftPointer) {
                        break;
                    }
                    if (a[inner - 1] > a[inner]) {
                        swap(inner - 1, inner);
                    }
                    inner--;
                } else {
                    if (a[inner] > a[inner + 1]) {
                        swap(inner, inner + 1);
                    }
                    inner++;
                }
                if (inner == outer) {
                    moveBack = true;
                    inner--;
                }
            }
        }
    }

    private void swap(int from, int to) {
        long tmp = a[from];
        a[from] = a[to];
        a[to] = tmp;
    }
}
