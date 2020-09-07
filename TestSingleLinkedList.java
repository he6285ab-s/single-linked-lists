package test_lists;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import single_linked_lists.SingleLinkedList;

public class TestSingleLinkedList {
	
	SingleLinkedList<Integer> list;

	@BeforeEach
	void setUp() {
		list = new SingleLinkedList<>();
	}
	@AfterEach
	void tearDown(){
		list = null;
	}
	
	
	// ------ isEmpty() -------

	@Test
	void testEmptyWhenEmpty() {
		assertTrue(list.isEmpty(), "List should be empty but it wasn't.");
	}
	
	@Test
	void testEmptyWhenNotEmpty() {
		list.add(10);
		assertFalse(list.isEmpty(), "List shouldn't be empty but it was.");
	}
	
	
	// -------- add(E element), get(int index), size() ----------
	
	@Test
	void testAddAndGetIndex() {
		fillListOneToTen();
		assertEquals(10, list.size(), "List's size should be 10.");
		assertEquals(1, list.get(0), "Item at index 0 should be 1.");
		assertEquals(2, list.get(1), "Item at index 1 should be 2.");
		assertEquals(5, list.get(4), "Item at index 4 should be 5.");

	}
	
	@Test
	void testGetIndexLast() {
		list.add(10);
		assertEquals(10, list.get(0), "Item at index 0 should be 10");
		assertEquals(10, list.get(list.size() - 1), "Last item should be 10.");
		
		list.add(20);
		assertEquals(20, list.get(list.size() - 1), "Last item should be 20.");
		
	}
	

	// -------- set(int index, E element) --------
	
	@Test
	void testSet() {
		list.add(10);
		list.add(30);
		list.set(0, 200);
		list.set(1, 500);
		assertEquals(200, list.get(0), "Item at index 0 should be 200");
		assertEquals(500, list.get(1), "Item at index 1 should be 500");
	}
	
	
	// -------- add(int index, E e) --------
	
	@Test
	void testInsertFirstEmpty() {
		list.add(0, 0);
		assertEquals(0, list.get(0), "Item at index 0 should be 0.");
	}
	
	
	@Test
	void testInsertFirstNotEmpty() {
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(0, 0);
		assertEquals(0, list.get(0), "Item at index 0 should be 0.");
	}
	
	@Test
	void testInsertLast() {
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(3, 0);
		assertEquals(0, list.get(3), "Item at index 3 should be 0.");
	}
	
	
	// -------- remove(int index) --------
	
	@Test
	void testRemoveFirst() {
		fillListOneToTen();
		assertEquals(1, list.remove(0), "Removed item should be 1.");
		assertEquals(2, list.get(0), "Item at index 0 should now be 2.");
		
	}
	
	@Test
	void testRemoveLast() {
		fillListOneToTen();
		assertEquals(10, list.remove(list.size() - 1), "Removed item should be 10.");
		assertEquals(9, list.get(list.size() - 1), "Last item should now be 9.");
		
	}
	
	
	// -------- indexOf(Object o) --------
	@Test
	void testIndexOfItemThatDoesntExist() {
		list.add(10);
		assertEquals(-1, list.indexOf(1), "The index of 1 should be -1, since it doesn't exist.");
	}
	
	
	@Test
	void testIndexOfOnlyItem() {
		list.add(1);
		assertEquals(0, list.indexOf(1), "The index of 1 should be 0");
	}
	
	@Test
	void testIndexOfMiddleItem() {
		fillListOneToTen();
		assertEquals(5, list.indexOf(6), "The index of 6 should be 5.");
	}
	
	@Test
	void testIndexOfLastItem() {
		fillListOneToTen();
		assertEquals(9, list.indexOf(10), "The index of 10 should be 9");
	}
	
	
	
	
	// -------- Helper methods --------
	
	/*
	 * Fills the list with the numbers 1 to 10, ascending order,
	 * to test add, get and set methods.
	 */
	private void fillListOneToTen() {
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
	}
	
	

}
