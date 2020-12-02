package com.fortlift.dataStructures;

import org.junit.jupiter.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class ArrayListTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    void add_get() throws Exception {
        var list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(3, list.get(2));
    }

    @Test
    void get_negativeIndex_throwsException() {
        var list = new ArrayList<Integer>();
        Assertions.assertThrows(Exception.class, () -> list.get(-1));
    }

    @Test
    void get_OutOfIndex_throwsException() {
        var list = new ArrayList<Integer>();
        Assertions.assertThrows(Exception.class, () -> list.get(1));
    }

    @Test
    void remove() throws Exception {
        var list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        Assertions.assertEquals(2, list.get(0));
    }
}