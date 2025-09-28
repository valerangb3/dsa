package chapter2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {


    public static void executeOrderArray() {
        OrdArray ordArray = new OrdArray(5);
        ordArray.insert(2);
        ordArray.display();
        ordArray.insert(1);
        ordArray.insert(7);
        ordArray.insert(14);
        ordArray.insert(15);
        ordArray.display();
        ordArray.delete(14);
        ordArray.insert(33);
        ordArray.display();

        int searchValue = 33;
        if (ordArray.find(searchValue) != ordArray.size()) {
            System.out.println("Нашлось " + searchValue + "  в массиве рыба моей мечты!");
        } else {
            System.out.println("Значение " + searchValue + " не нашлось в массиве");
        }
    }

    public static void executeHighArray() {
        HighArray ar = new HighArray(7);
        ar.insert(2);
        ar.insert(1);
        ar.insert(55);

        //ar.delete(1);

        ar.insert(55);

        //ar.display();

        ar.insert(99);

        //ar.delete(55);

        ar.insert(55);
        //ar.display();

        /*long max = ar.getMax();

        if (max == -1) {
            System.out.println("Массив пустой");
        } else {
            System.out.println("max = " + max);
        }

        ar.removeMax();*/


        ar.insert(1000);
        ar.display();
        ar.noDups().display();
        HighArray na = new HighArray(7);
        na.noDups().display();
        /*ar.display();

        ar.removeMax();
        ar.display();

        ar.delete(65);
        ar.delete(3);
        ar.display();
        ar.removeMax();
        ar.display();*/
        long [] sortData = new long[ar.getNumElements()];
        for (int i = ar.getNumElements() - 1; i >= 0; i--) {
            sortData[i] = ar.removeMax();
        }
        for (int i = 0; i < sortData.length; i++) {
            System.out.print(sortData[i] + " ");
        }
    }

    public static void main(String[] args) {
        //executeHighArray();
        //executeOrderArray();


    }
}