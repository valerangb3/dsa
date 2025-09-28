package chapter2;

import java.util.Collections;

public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    private int getMaxIndex() {
        int i = 0;
        long max = a[i];
        if (i + 1 == nElems) {
            return i;
        }
        int k = i;
        while (nElems != i) {
            if (a[i] > max) {
                max = a[i];
                k = i;
            }
            i++;
        }
        return k;
    }

    private void shiftItems(int whichPosition) {
        for (int k = whichPosition; k < nElems; k++) {
            if (nElems > (k + 1)) {
                a[k] = a[k + 1];
            }
        }
        nElems--;
    }

    public HighArray noDups() {
        for (int i = 0; i < nElems; i++) {
            long candidate = a[i];
            for (int j = i + 1; j < nElems; j++) {
                if (a[j] == candidate) {
                    shiftItems(j);
                }
            }
        }
        return this;
    }

    public int getNumElements() {
        return nElems;
    }

    public long getMax() {
        if (nElems == 0) {
            return -1;
        }
        int maxIndex = getMaxIndex();
        return a[maxIndex];
    }

    public long removeMax() {
        if (nElems == 0) {
            return -1;
        }
        int maxIndex = getMaxIndex();
        long maxElement = a[maxIndex];
        shiftItems(maxIndex);
        return maxElement;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int i;
        for (i = 0; i < a.length; i++) {
            if (value == a[i]) {
                break;
            }
        }
        if (i == nElems) {
            return false;
        } else {
            shiftItems(i);
            return true;
        }
    }

    public boolean find(long value) {
        int i;
        boolean isFind = false;
        for (i = 0; i < nElems; i++) {
            if (value == a[i]) {
                isFind = true;
                break;
            }
        }
        return i != nElems;
    }

    public void display() {
        if (nElems > 0) {
            for (int i = 0; i < nElems; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println("");
        }
    }
}
