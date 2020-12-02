package com.fortlift.dataStructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueTest {

    @Test
    void isEmpty() {
        var queue = new Queue();
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    void enqueue_defaultSizeIsFive_throwsExceptionOnSix() throws Exception {
        var queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        Assertions.assertThrows(Exception.class, () -> queue.enqueue(6));
    }

    @Test
    void enqueue_setSize_throwsExceptionOnOverflow() throws Exception {
        var queue = new Queue(1);
        queue.enqueue(1);
        Assertions.assertThrows(Exception.class, () -> queue.enqueue(2));
    }

    @Test
    void enqueue_dequeue_allValuesReturnedAsExpected() throws Exception {
        var queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        Assertions.assertEquals(1, queue.dequeue());
        Assertions.assertEquals(2, queue.dequeue());
        Assertions.assertEquals(3, queue.dequeue());
        Assertions.assertEquals(4, queue.dequeue());
        Assertions.assertEquals(5, queue.dequeue());
    }

    @Test
    void enqueue_dequeue_enqueue_noErrorsThrown() throws Exception {
        var queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
    }

    @Test
    void dequeue_beyondItems_throwsException() throws Exception {
        var queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        Assertions.assertThrows(Exception.class, queue::dequeue);
    }

}