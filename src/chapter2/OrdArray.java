package chapter2;

public class OrdArray {

    private int[] a;

    private int nElems;

    public OrdArray(int max) {
        a = new int[max];
        nElems = 0;
    }

    /**
     * a = []
     * insert(2) -> a = [2]
     * insert(1) -> 2 > 1 => break => i = 0 position to "1"
     * a) then bias elements in a[]
     * b) then insert "1" to a[] in "i = 0" position
     */
    public void insert(int newItem) {
        int searchIndex = find(newItem);
        if (searchIndex != nElems) {
            for (int k = nElems; k > searchIndex; k--) {
                a[k] = a[k - 1];
            }
        }
        a[searchIndex] = newItem;
        nElems++;
    }

    public int size() {
        return nElems;
    }

    protected int removeMin(int[] items, int size) {
        int min = 2147483647;
        int i;
        for (i = 0; i < size; i++) {
            if (min > items[i]) {
                min = items[i];
            }
        }
        if (i != size) {
            for (int k = i; k < size; k++) {
                if (size > (k + 1)) {
                    items[k] = items[k + 1];
                }
            }
        }
        return min;
    }

    protected int[] getArray() {
        return a;
    }

    public OrdArray merge(OrdArray items) {
        int firstSize = nElems;
        int secondSize = items.size();

        OrdArray firstOrdArray = firstSize >= secondSize ? this : items;
        OrdArray secondOrdArray = firstSize <= secondSize ? items : this;

        int[] firstArray = firstOrdArray.getArray().clone();
        int[] secondArray = secondOrdArray.getArray().clone();

        firstSize = firstOrdArray.size();
        secondSize = secondOrdArray.size();

        int newSize = firstOrdArray.size() + secondOrdArray.size();

        OrdArray target = new OrdArray(newSize);

        int[] tmpArray = new int[newSize];

        while (newSize >= 0) {
            int firstValue = removeMin(firstArray, firstSize);
            int secondValue = removeMin(secondArray, secondSize);
            
            newSize--;
        }
        return target;
    }

    public int find(int searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (a[curIn] > searchKey) {
                    upperBound = --curIn;
                } else {
                    lowerBound = ++curIn;
                }
            }
        }
    }

    public boolean delete(int value) {
        int searchIndex = find(value) ;
        if (searchIndex == nElems) {
            return false;
        } else {
            for (int i = searchIndex; i < nElems; i++) {
                if (nElems > (i + 1)) {
                    a[i] = a[i + 1];
                }
            }
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}
