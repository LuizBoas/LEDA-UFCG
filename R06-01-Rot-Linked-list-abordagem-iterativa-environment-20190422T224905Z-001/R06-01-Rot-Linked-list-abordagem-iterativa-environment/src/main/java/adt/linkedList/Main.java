package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Main {
    protected LinkedList<Integer> lista1;


    @Before
    public void main() {
        lista1 = new SingleLinkedListImpl<>();

        lista1.insert(3);
        lista1.insert(2);
        lista1.insert(1);
        lista1.insert(1);

    }

    @Test
    public void tests() {
        Assert.assertEquals(0, lista1.indexOf(3));
        Assert.assertEquals(1, lista1.indexOf(2));
        Assert.assertEquals(3, lista1.lastIndexOf(1));
        lista1.inverte();
        Assert.assertArrayEquals(new Integer[] { 1, 1, 2, 3 }, lista1.toArray());
        lista1.removerIndex(2);
        Assert.assertArrayEquals(new Integer[] { 1, 1, 3 }, lista1.toArray());


    }




}
