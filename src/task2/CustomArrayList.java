package task2;

import java.util.Objects;

class Main {
    public static void main(String[] args) {
        CustomArrayList customList = new CustomArrayList();
        customList.add("s");
        customList.add("s");
        customList.add(23);
        customList.get(2);
        customList.remove(2);


    }
}

public class CustomArrayList<E> {
    private Objects[] elements;
    private int capacity = 10;
    private int size = 0;

    public CustomArrayList() {
        elements = new Objects[capacity];
    }

    public CustomArrayList(int capacity) {
        this.capacity = capacity;
    }

    public void add(E element) {
        if (size == elements.length) {
            grow();
        }
     //   elements[size] = element;   /почему выдает ошибку,что за ерунда с этим привидением типов?
        size++;
    }

    /*public void remove(Objects[] o, int i) {
        final int newSize;
        if ((newSize = size - 1) > i) {
            Objects[] removeElements = new Objects[newSize];
            System.arraycopy(removeElements, i + 1, removeElements, i, newSize - i);
            o[size - newSize] = null;
        }
    }*/

    public boolean contains(E element){
        boolean result = false;
        for (int i=0;i<=size;i++){
            if (elements[i].equals(element)){
                result=true;
                break;
            }
        }
        return result;
    }

    public void remove(int index) {
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
            elements[size] = null;
            size--;
        }
    }
    public E get(int index) {
        return (E) elements[index];
    }

    public int size() {
        return size;
    }

    public void grow() {
        Objects[] growElements = new Objects[(int) (capacity * 1.5)];
        System.arraycopy(elements, 0, growElements, 0, size);
        elements = growElements;
    }
}
