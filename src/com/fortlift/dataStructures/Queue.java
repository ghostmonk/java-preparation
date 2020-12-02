package com.fortlift.dataStructures;

public class Queue {
    public static final int DEFAULT_SIZE = 5;
    private final Object[] data;
    private int index;

    public Queue() {
        data = new Object[DEFAULT_SIZE];
    }

    public Queue(int size) {
        data = new Object[size];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void enqueue(Object obj) throws Exception {
        System.out.println(data.length);
        if(index == data.length) {
            throw new Exception("Queue is full");
        }
        this.data[index] = obj;
        this.index++;
    }

    public Object dequeue() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is empty");
        }
        Object obj = this.data[0];
        if (this.index - 1 >= 0) System.arraycopy(data, 1, data, 0, this.index - 1);
        this.index--;
        return obj;
    }
}
