package com.fortlift.dataStructures;

public class ArrayList<T> {
    private static final int SIZE_FACTOR = 5;
    private Object[] data;
    private int index;
    private int size;

    public ArrayList() {
        this.data = new Object[SIZE_FACTOR];
        this.size = SIZE_FACTOR;
        this.index = 0;
    }

    public void add(T obj) {
        if(this.index == this.size - 1) {
            reallocateSize();
        }
        data[this.index] = obj;
        index++;
    }

    public T get(int i) throws Exception {
        checkBounds(i);
        return (T)data[i];
    }

    public T remove(int i) throws Exception {
        checkBounds(i);
        T output = (T)data[i];
        for(var x = i; i < this.data.length - 1; i++) {
            data[x] = data[x+1];
        }
        this.index--;
        return output;
    }

    private void checkBounds(int i) throws Exception {
        if(i > index - 1) {
            throw new Exception("Provided index is out of range");
        }

        if(i < 0) {
            throw new Exception("Index cannot be a negative number");
        }
    }

    private void reallocateSize() {
        this.size = this.size + SIZE_FACTOR;
        Object[] newData = new Object[this.size];
        System.arraycopy(data, 0, newData, 0, data.length);
        this.data = newData;
    }
}
