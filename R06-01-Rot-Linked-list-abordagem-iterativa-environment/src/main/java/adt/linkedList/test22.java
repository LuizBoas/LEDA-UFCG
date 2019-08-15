package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class test22 {
    DoubleLinkedList<Integer> list;

    @Before
    public void main(){
        list = new DoubleLinkedListImpl<>();

        list.insert(3);
        list.insert(4);
        list.insert(2);
    }

    @Test
    public void test(){
        list.inverteDOuble();
        Assert.assertArrayEquals(new Integer[] { 2, 4, 3}, list.toArray());
    }
}
