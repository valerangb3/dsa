package chapter3.obj;

public class ArrayInOb {
    private Person[] personList;
    private int nElems;

    public ArrayInOb(int mSize) {
        personList = new Person[mSize];
        nElems = 0;
    }

    public void insert(String lastName, String firstName, int age) {
        personList[nElems++] = new Person(
                lastName = lastName,
                firstName = firstName,
                age = age
        );
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            personList[i].displayPerson();
            System.out.println();
        }
    }

    public void insertSort() {
        for (int outer = 1; outer < nElems; outer++) {
            int inner = outer;
            Person temp = personList[outer];
            while (inner > 0 && personList[inner - 1].getLast().compareTo(temp.getLast()) > 0) {
                personList[inner] = personList[inner - 1];
                inner--;
            }
            personList[inner] = temp;
        }
    }
}
