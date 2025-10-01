package chapter3;

import chapter3.obj.ArrayInOb;

import java.util.Random;

public class Main {
    public static void display(int[] items) {
        int size = items.length;
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(items[i]);
            if (i + 1 != size) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]\n");
    }

    public static void selectSort(int[] items) {
        int length = items.length;
        for(int outer = 0; outer < length; outer++) {
            int minIndex = outer;
            for (int inner = outer + 1; inner < length; inner++) {
                if (items[inner] < items[minIndex]) {
                    minIndex = inner;
                }
            }
            int tmp = items[minIndex];
            items[minIndex] = items[outer];
            items[outer] = tmp;
        }
    }

    private static void testSelectSort() {
        int size = 1_000_000;
        ArraySel arraySel = new ArraySel(size);
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            arraySel.insert(rnd.nextInt() * (size - 1));
        }
        long startTime = System.currentTimeMillis();
        //arraySel.display();
        arraySel.sort();
        long endTime = (System.currentTimeMillis() - startTime) / 1_000;
        System.out.println("Вермя выполнения: " + endTime + " сек.");
        //arraySel.display();
    }

    private static void testBubbleSort() {
        int size = 5;
        Random rnd = new Random();
        ArrayBub arrayBub = new ArrayBub(size);
        for (int i = 0; i < size; i++) {
            arrayBub.insert(rnd.nextLong(-255, 255) );
        }
        arrayBub.display();
        long startTime = System.currentTimeMillis();
        //arrayBub.bubbleSort();
        arrayBub.oddEvenSort();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.println("Время выполнения: " + endTime / 1_000 + " сек.");
        arrayBub.display();
    }

    private static void testBubbleSortWithTwoPointers() {
        int size = 100_000;
        Random rnd = new Random();
        ArrayBub arrayBub = new ArrayBub(size);
        for (int i = 0; i < size; i++) {
            arrayBub.insert(rnd.nextLong() * (size - 1));
        }
        /*arrayBub.insert(1);
        arrayBub.insert(-1);
        arrayBub.insert(2);
        arrayBub.insert(0);
        arrayBub.insert(11);
        arrayBub.insert(-2);
        arrayBub.insert(-15);
        arrayBub.insert(22);
        arrayBub.insert(-50);
        arrayBub.insert(5);*/
        //arrayBub.display();
        long startTime = System.currentTimeMillis();
        arrayBub.bubbleSortWitTwoPointers();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.println("Время выполнения: " + endTime / 1_000 + " сек.");
        //arrayBub.display();
    }

    private static void testInsertSort() {
        ArrayInsert arrayIns = new ArrayInsert(15);
        arrayIns.insert(1);
        arrayIns.insert(-1);
        arrayIns.insert(2);
        arrayIns.insert(0);
        arrayIns.insert(11);
        arrayIns.insert(-2);
        arrayIns.insert(-15);
        arrayIns.insert(33);
        arrayIns.insert(-1);
        arrayIns.insert(3);
        arrayIns.insert(1);
        arrayIns.insert(22);
        arrayIns.insert(-50);
        arrayIns.insert(-60);
        arrayIns.insert(30);
        arrayIns.display();
        arrayIns.insertSort();
        arrayIns.display();
        arrayIns.noDups();
        arrayIns.display();
    }

    private static void testArrayInOb() {
        int maxSize = 100;
        ArrayInOb arr = new ArrayInOb(maxSize);

        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Adams", "Henry", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        System.out.println("Before sorting");
        arr.display();
        arr.insertSort();

        System.out.println("After sorting");
        arr.display();
    }

    public static void main(String[] arg) {
        //testArrayInOb();
        //testInsertSort();
        //testSelectSort();
        testBubbleSort();
        //testBubbleSortWithTwoPointers();
        /*int[] someArray = {55, 10, 4, 3, 1, 0, -1, -23, -44, -55};
        display(someArray);
        selectSort(someArray);
        display(someArray);*/
    }
}
