package covidvis;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;
/**
 *  SinglyLinkedListTest will test all of the methods in 
 *  SinglyLinkedList to make sure that they run and 
 *  perform as expected
 *
 * @author  Noah Coyle noahcoyle11
 * @version 10/23/2020
 */
public class SinglyLinkedListTest extends TestCase {
    
    private SinglyLinkedList<String> smallListA;
    private SinglyLinkedList<String> smallListB;
    private SinglyLinkedList<String> emptyListA;
    private SinglyLinkedList<String> emptyListB;
    private SinglyLinkedList<String> bigListA;
    private SinglyLinkedList<String> bigListB;
    private String nullObject;
    private SinglyLinkedList<String> list;


    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp() {
        smallListA = new SinglyLinkedList<String>();
        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");
        
        smallListB = new SinglyLinkedList<String>();
        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");
        
        emptyListA = new SinglyLinkedList<String>();
        emptyListB = new SinglyLinkedList<String>();

        bigListA = new SinglyLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListA.add("sport" + i);
        }

        bigListB = new SinglyLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        nullObject = null;
        list = new SinglyLinkedList<String>();
    }
    
    /**
     * Tests
     */
    public void testSize() {
        assertEquals(3, this.smallListA.size());
    }
    
    /**
     * Tests
     */
    public void testAdd() {
        this.smallListA.add("jumping");
        assertEquals("jumping", this.smallListA.get(3));
    }
    
    /**
     * Tests
     */
    public void testAddEmpty() {
        this.smallListA.clear();
        this.smallListA.add("jumping");
        assertEquals("jumping", this.smallListA.get(0));
    }
    
    /**
     * tests throwing a exception when adding
     */
    public void testAddIndexException() {
        Exception thrown = null;
        try {
            this.smallListA.add(0, null);
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }
    
    /**
     * tests throwing a exception when adding
     */
    public void testAddIndexException2() {
        Exception thrown = null;
        try {
            this.smallListA.add(-1, "soccer");
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * tests throwing a exception when adding
     */
    public void testAddIndexException3() {
        Exception thrown = null;
        try {
            this.smallListA.add(10, "soccer");
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * tests throwing a exception when adding
     */
    public void testAddException() {
        Exception thrown = null;
        try {
            this.smallListA.add(null);
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }
    
    /**
     * Tests
     */
    public void testAddIndex() {
        this.smallListA.add(2, "jumping");
        assertEquals("jumping", this.smallListA.get(2));
        assertEquals(4, this.smallListA.size());
    }
    
    /**
     * Tests
     */
    public void testAddIndexEmpty() {
        this.smallListA.clear();
        this.smallListA.add(0, "jumping");
        assertEquals("jumping", this.smallListA.get(0));
    }
    
    /**
     * Tests
     */
    public void testAddIndexZero() {
        this.smallListA.add(0, "jumping");
        assertEquals("jumping", this.smallListA.get(0));
    }
    
    /**
     * Tests
     */
    public void testIsEmptyTrue() {
        this.smallListA.clear();
        assertEquals(true, this.smallListA.isEmpty());
    }
    
    /**
     * Tests
     */
    public void testIsEmptyFalse() {
        assertEquals(false, this.smallListA.isEmpty());
    }
    
    /**
     * Tests
     */
    public void testRemove() {
        this.smallListA.remove("swimming");
        assertEquals("{soccer, gymnastics}", this.smallListA.toString());
    }
    
    /**
     * Tests
     */
    public void testRemoveFalse() {
        this.smallListA.clear();
        assertEquals(false, this.smallListA.remove("swimming"));
    }
    
    /**
     * Tests
     */
    public void testRemoveTwoAndNull() {
        this.smallListA.clear();
        this.smallListA.add("Basketball");
        this.smallListA.add("Tennis");
        assertEquals(false, this.smallListA.remove("Baseball"));
    }
    
    /**
     * Tests
     */
    public void testRemoveAndAdd() {
        this.smallListA.add("rope jumping");
        this.smallListA.remove("rope jumping");
        this.smallListA.add("jump roping");
        assertEquals(4, this.smallListA.size());
        assertEquals("{soccer, swimming, gymnastics, jump roping}"
            , this.smallListA.toString());
    }
    
    /**
     * Tests
     */
    public void testRemoveFirst() {
        this.smallListA.remove("soccer");
        assertEquals("{swimming, gymnastics}", this.smallListA.toString());
    }
    
    /**
     * Tests
     */
    public void testRemoveLast() {
        this.smallListA.remove("gymnastics");
        assertEquals("{soccer, swimming}", this.smallListA.toString());
    }
    
    /**
     * Tests
     */
    public void testRemoveIndexFirst() {
        this.smallListA.remove(0);
        assertEquals("{swimming, gymnastics}", this.smallListA.toString());
    }
    
    /**
     * Tests
     */
    public void testRemoveIndexOnly() {
        this.smallListA.clear();
        this.smallListA.add("Basketball");
        this.smallListA.remove(0);
        assertEquals("{}", this.smallListA.toString());
    }
    
    /**
     * Tests
     */
    public void testRemoveIndex() {
        this.smallListA.remove(1);
        assertEquals("{soccer, gymnastics}", this.smallListA.toString());
    }
    
    /**
     * Tests
     */
    public void testRemoveIndexLast() {
        this.smallListA.remove(2);
        assertEquals("{soccer, swimming}", this.smallListA.toString());
    }
    
    /**
     * tests throwing a exception when adding
     */
    public void testRemoveIndexException() {
        Exception thrown = null;
        try {
            this.smallListA.remove(-1);
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * tests throwing a exception when adding
     */
    public void testRemoveIndexException2() {
        Exception thrown = null;
        try {
            this.smallListA.remove(10);
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * tests throwing a exception when adding
     */
    public void testRemoveIndexException3() {
        Exception thrown = null;
        try {
            this.smallListA.clear();
            this.smallListA.remove(10);
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests
     */
    public void testGet() {
        assertEquals("soccer", this.smallListA.get(0));
        assertEquals("swimming", this.smallListA.get(1));
        assertEquals("gymnastics", this.smallListA.get(2));
    }
    
    /**
     * tests throwing a exception when adding
     */
    public void testGetIndexException() {
        Exception thrown = null;
        try {
            this.smallListA.clear();
            this.smallListA.get(0);
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests
     */
    public void testContainsTrue() {
        assertEquals(true, this.smallListA.contains("swimming"));
    }
    
    /**
     * Tests
     */
    public void testContainsFalse() {
        assertEquals(false, this.smallListA.contains("basketball"));
    }
    
    /**
     * Tests
     */
    public void testContainsNull() {
        this.smallListA.clear();
        assertEquals(false, this.smallListA.contains(null));
    }
    
    /**
     * Tests
     */
    public void testClear() {
        this.smallListA.clear();
        assertEquals(0, this.smallListA.size());
    }
    
    /**
     * Tests
     */
    public void testClearEmpty() {
        this.smallListA.clear();
        this.smallListA.clear();
        assertEquals(0, this.smallListA.size());
    }
    
    /**
     * Tests
     */
    public void testLastIndexOf() {
        assertEquals(1, this.smallListA.lastIndexOf("swimming"));
        this.smallListA.add("swimming");
        assertEquals(3, this.smallListA.lastIndexOf("swimming"));
    }
    
    /**
     * Tests
     */
    public void testToString() {
        assertEquals("{soccer, swimming, gymnastics}"
            , this.smallListA.toString());
    }
    
    /**
     * Tests
     */
    public void testToStringEmpty() {
        this.smallListA.clear();
        assertEquals("{}", this.smallListA.toString());
    }
    
    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));
        smallListA.remove("rope jumping");
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList() {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        assertEquals(bigListA, bigListB);
    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {
        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));
    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {
        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));
    }
    
    /**
     * Tests iterator has next
     */
    public void testIteratorHasNextTrue() {
        this.list.add("A");
        this.list.add("B");
        Iterator<String> iter = this.list.iterator();
        assertEquals(true, iter.hasNext());
    }
    
    /**
     * Tests iterator has next
     */
    public void testIteratorHasNextFalse() {
        Iterator<String> iter = this.list.iterator();
        assertEquals(false, iter.hasNext());
    }
    
    /**
     * Tests iterator has next
     */
    public void testIteratorHasNextNull() {
        this.list.add("A");
        this.list.add("B");
        Iterator<String> iter = this.list.iterator();
        assertEquals(true, iter.hasNext());
        iter.next();
        assertEquals(true, iter.hasNext());
        iter.next();
        assertEquals(false, iter.hasNext());
    }
    
    /**
     * Tests iterator next
     */
    public void testIteratorNext() {
        this.list.add("A");
        this.list.add("B");
        Iterator<String> iter = this.list.iterator();
        assertEquals("A", iter.next());
    }
    
    /**
     * Tests iterator next exception
     */
    public void testIteratorNextException() {
        Exception thrown = null;
        try {
            Iterator<String> iter = this.list.iterator();
            iter.next();
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NoSuchElementException);
    }
    
    /**
     * Tests iterator remove
     */
    public void testIteratorRemove() {
        this.list.add("A");
        this.list.add("B");
        Iterator<String> iter = this.list.iterator();
        iter.next();
        iter.remove();
        assertEquals("B", iter.next());
    }
    
    /**
     * Tests iterator remove exception
     */
    public void testIteratorRemoveException() {
        Exception thrown = null;
        try {
            Iterator<String> iter = this.list.iterator();
            iter.remove();
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalStateException);
    }
}