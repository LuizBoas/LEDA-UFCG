package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testando {
    LinkedList<Integer> lst;

    @Before
    public void testando(){
        lst = new SingleLinkedListImpl<>();

        lst.insert(2);
        lst.insert(3);
    }

    @Test
    public void tests(){
        Assert.assertEquals(2, lst.size());
        Assert.assertTrue(2 == lst.search(2));
        Assert.assertTrue(3 == lst.search(3));
        Assert.assertNull(lst.search(1));
    }

    @Test
    public void remover(){
        Assert.assertArrayEquals(new Integer[] {2, 3}, lst.toArray());
    }

}
