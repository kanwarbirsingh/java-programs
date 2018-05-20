
/*import java.util.Iterator;
import java.util.NoSuchElementException;
public class UnorderedListTester 
{
	// stats on test cases run 
	private int passes = 0;
	private int failures = 0;
	private int total = 0;
	// elements added to the lists 
	private int A = new Integer(1);
	private int B = new Integer(2);
	private int C = new Integer(3);
	private int D = new Integer(4);
	private int E = new Integer(5);
	// which class running tests on 
	private enum ListType { Good, Bad };
	// results of a given test
	private enum Results{ EmptyCollection, True, ElementNotFound, NoException, False, Fail };
	// stores which class running tests on 
	private ListType listType; 
	// which method performed in the change scenario
	private enum Methods{constructor, addToFront, addToRear, addAfter, removeFirst, removeLast, remove};
	public static void main(String[] args) 
	{
		//to avoid every method being static
		UnorderedListTester tester = new UnorderedListTester();
		if(args[0].length() != 1)
		{
			return;
		}
		if(args[0].equals("-g"))
		{
			tester.runTests(ListType.Good);
		}
		else if(args[0].equals("-b"))
		{
			tester.runTests(ListType.Bad); 
		}
	}
	private UnorderedList<Integer> newList(Methods changeMethod, int length, Integer ... elements) 
	{
		UnorderedList<Integer> newList; 
		// determine which list to create
		switch(listType)
		{
		case Good:
				newList = new GoodUnorderedList<Integer>();
				break;
		case Bad:
				newList = new BadUnorderedList<Integer>();
				break;
		default:
				newList = null;
		}
		// replicate state of list before change
		// first size elements are in the list before the change
		for(int i = 0; i < length; i++)
		{
			newList.addToRear(elements[i]);
		}	
		// apply change to the list
		// constructor just creates list, doesn't change it
		if(changeMethod != Methods.constructor)
		{
			applyChange(newList, changeMethod, elements);
		}
		
		return newList;
	}
	@SuppressWarnings("incomplete-switch")
	private void applyChange(UnorderedList<Integer> list, Methods changeMethod,  Integer ... elements)
	{
		switch(changeMethod)
		{
		case addToFront:
			list.addToFront(elements[elements.length-1]);
			break;
		case addToRear:
			list.addToRear(elements[elements.length-1]);
			break;
		case addAfter:
			list.addAfter(elements[elements.length-2], elements[elements.length-1]);
			break;
		case removeFirst:
			list.removeFirst();
			break;
		case removeLast:
			list.removeLast();
			break;
		case remove:
			list.remove(elements[elements.length-1]);
			break;				
		}
	}
	private void printTest(String testDesc, boolean result) 
	{
		// update number of tests run
		total++;
		if (result) 
		{
			passes++;  // update number of tests passed
		} 
		else 
		{
			failures++; // update number of tests failed 
		}
		// print the results of the test 
		System.out.printf("%-46s\t%s\n", testDesc, (result ? "   PASS" : "***FAIL***"));
	}
	private void printFinalSummary() 
	{
		System.out.printf("\nTotal Tests: %d,  Passed: %d,  Failed: %d\n", total, passes, failures);
	}
	private void runTests(ListType type) 
	{
		listType = type;
		noList_constructorTests();
		emptyList_addToFrontTests();
		emptyList_addToRearTests();
		oneElementList_removeFirstTests();
		oneElementList_addToFrontTests();
		oneElementList_addToRearTests();
		twoElementList_removeSecondElementTests();
		twoElementList_addToFrontTests();
		twoElementList_addToRearTests();
		twoElementList_addAfterFirstElementTests();
		twoElementList_addAfterSecondElementTests();
		threeElementList_removeFirstTests();
		threeElementList_removeLastTests();
		threeElementList_removeFirstElementTests();
		printFinalSummary();
	}
	
	// Scenario 1 - no list -> constructor -> []
	private void noList_constructorTests()
	{
		// run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("noList_constructor_testAddToFront_A", testAddToFront(newList(Methods.constructor, 0), A, Results.NoException));
		printTest("noList_constructor_testAddToRear_A", testAddToRear(newList(Methods.constructor, 0), A, Results.NoException));
		printTest("noList_constructor_testAddAfter_B_A", testAddAfter(newList(Methods.constructor, 0), B, A, Results.ElementNotFound));
		printTest("noList_constructor_testRemoveFirst", testRemoveFirst(newList(Methods.constructor, 0), Results.EmptyCollection));
		printTest("noList_constructor_testRemoveLast", testRemoveLast(newList(Methods.constructor, 0), Results.EmptyCollection));
		printTest("noList_constructor_testRemove_A", testRemove(newList(Methods.constructor, 0), A, Results.ElementNotFound));
		printTest("noList_constructor_testFirst", testFirst(newList(Methods.constructor, 0), Results.EmptyCollection));
		printTest("noList_constructor_testLast", testLast(newList(Methods.constructor, 0), Results.EmptyCollection));
		printTest("noList_constructor_testContains_A", testContains(newList(Methods.constructor, 0), A, Results.False));
		printTest("noList_constructor_testIsEmpty", testIsEmpty(newList(Methods.constructor, 0), Results.True));
		printTest("noList_constructor_testSize", testSize(newList(Methods.constructor, 0), 0));
		printTest("noList_constructor_testIterator", testIterator(newList(Methods.constructor, 0), Results.NoException));
		printTest("noList_constructor_testToString", testToString(newList(Methods.constructor, 0), Results.NoException));
	}
	
	// Scenario 2 - [] -> addToFront(A) -> [A]
	private void emptyList_addToFrontTests()
	{
		// run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("emptyList_addToFront_testAddToFront_C", testAddToFront(newList(Methods.addToFront, 0, A), C, Results.NoException));
		printTest("emptyList_addToFront_testAddToRear_C", testAddToRear(newList(Methods.addToFront, 0, A), C, Results.NoException));
		printTest("emptyList_addToFront_testAddAfter_C_A", testAddAfter(newList(Methods.addToFront, 0, A), C, A, Results.NoException));
		printTest("emptyList_addToFront_testAddAfter_C_B", testAddAfter(newList(Methods.addToFront, 0, A), C, B, Results.ElementNotFound));
		printTest("emptyList_addToFront_testRemoveFirst", testRemoveFirst(newList(Methods.addToFront, 0, A), Results.NoException));
		printTest("emptyList_addToFront_testRemoveLast", testRemoveLast(newList(Methods.addToFront, 0, A), Results.NoException));
		printTest("emptyList_addToFront_testRemove_A", testRemove(newList(Methods.addToFront, 0, A), A, Results.NoException));
		printTest("emptyList_addToFront_testRemove_B", testRemove(newList(Methods.addToFront, 0, A), B, Results.ElementNotFound));
		printTest("emptyList_addToFront_testFirst", testFirst(newList(Methods.addToFront, 0, A), Results.NoException));
		printTest("emptyList_addToFront_testLast", testLast(newList(Methods.addToFront, 0, A), Results.NoException));
		printTest("emptyList_addToFront_testContains_A", testContains(newList(Methods.addToFront, 0, A), A, Results.True));
		printTest("emptyList_addToFront_testContains_B", testContains(newList(Methods.addToFront, 0, A), B, Results.False));
		printTest("emptyList_addToFront_testIsEmpty", testIsEmpty(newList(Methods.addToFront, 0, A), Results.False));
		printTest("emptyList_addToFront_testSize", testSize(newList(Methods.addToFront, 0, A), 1));
		printTest("emptyList_addToFront_testIterator", testIterator(newList(Methods.addToFront, 0, A), Results.NoException));
		printTest("emptyList_addToFront_testToString", testToString(newList(Methods.addToFront, 0, A), Results.NoException));
	}
	
	// Scenario 3 - [] -> addToRear(A) -> [A]
	private void emptyList_addToRearTests()
	{
		//run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("emptyList_addToRear_testAddToFront_C", testAddToFront(newList(Methods.addToRear, 0, A), C, Results.NoException));
		printTest("emptyList_addToRear_testAddToRear_C", testAddToRear(newList(Methods.addToRear, 0, A), C, Results.NoException));
		printTest("emptyList_addToRear_testAddAfter_C_A", testAddAfter(newList(Methods.addToRear, 0, A), C, A, Results.NoException));
		printTest("emptyList_addToRear_testAddAfter_C_B", testAddAfter(newList(Methods.addToRear, 0, A), C, B, Results.ElementNotFound));
		printTest("emptyList_addToRear_testRemoveFirst", testRemoveFirst(newList(Methods.addToRear, 0, A), Results.NoException));
		printTest("emptyList_addToRear_testRemoveLast", testRemoveLast(newList(Methods.addToRear, 0, A), Results.NoException));
		printTest("emptyList_addToRear_testRemove_A", testRemove(newList(Methods.addToRear, 0, A), A, Results.NoException));
		printTest("emptyList_addToRear_testRemove_B", testRemove(newList(Methods.addToRear, 0, A), B, Results.ElementNotFound));
		printTest("emptyList_addToRear_testFirst", testFirst(newList(Methods.addToRear, 0, A), Results.NoException));
		printTest("emptyList_addToRear_testLast", testLast(newList(Methods.addToRear, 0, A), Results.NoException));
		printTest("emptyList_addToRear_testContains_A", testContains(newList(Methods.addToRear, 0, A), A, Results.True));
		printTest("emptyList_addToRear_testContains_B", testContains(newList(Methods.addToRear, 0, A), B, Results.False));
		printTest("emptyList_addToRear_testIsEmpty", testIsEmpty(newList(Methods.addToRear, 0, A), Results.False));
		printTest("emptyList_addToRear_testSize", testSize(newList(Methods.addToRear, 0, A), 1));
		printTest("emptyList_addToRear_testIterator", testIterator(newList(Methods.addToRear, 0, A), Results.NoException));
		printTest("emptyList_addToRear_testToString", testToString(newList(Methods.addToRear, 0, A), Results.NoException));
	}
	
	// Scenario 4 - [A] -> removeFirst -> []
	private void oneElementList_removeFirstTests()
	{
		//run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("oneElementList_removeFirst_testRemoveFirst", testRemoveFirst(newList(Methods.removeFirst, 1, A), Results.EmptyCollection));
		printTest("oneElementList_removeFirst_testRemoveLast", testRemoveLast(newList(Methods.removeFirst, 1, A), Results.EmptyCollection));
		printTest("oneElementList_removeFirst_testAddToFront_C", testAddToFront(newList(Methods.removeFirst, 1, A), C, Results.EmptyCollection));
		printTest("oneElementList_removeFirst_testAddToRear_C", testAddToRear(newList(Methods.removeFirst, 1, A), C, Results.EmptyCollection));
		printTest("oneElementList_removeFirst_testRemove_A", testRemove(newList(Methods.removeFirst, 1, A), A, Results.ElementNotFound));
		printTest("oneElementList_removeFirst_testRemove_B", testRemove(newList(Methods.removeFirst, 1, A), B, Results.ElementNotFound));
		printTest("oneElementList_removeFirst_testRemove_C", testRemove(newList(Methods.removeFirst, 1, A), C, Results.ElementNotFound));
		printTest("oneElementList_removeFirst_testFirst", testFirst(newList(Methods.removeFirst, 1, A), Results.EmptyCollection));
		printTest("oneElementList_removeFirst_testLast", testLast(newList(Methods.removeFirst, 1, A), Results.EmptyCollection));
		printTest("oneElementList_removeFirst_testContains_A", testContains(newList(Methods.removeFirst, 1, A), A, Results.False));
		printTest("oneElementList_removeFirst_testContains_B", testContains(newList(Methods.removeFirst, 1, A), B, Results.False));
		printTest("oneElementList_removeFirst_testIsEmpty", testIsEmpty(newList(Methods.removeFirst, 1, A), Results.True));
		printTest("oneElementList_removeFirst_testSize", testSize(newList(Methods.removeFirst, 1, A), 0));
		printTest("oneElementList_removeFirst_testIterator", testIterator(newList(Methods.removeFirst, 1, A), Results.NoException));
		printTest("oneElementList_removeFirst_testToString", testToString(newList(Methods.removeFirst, 1, A), Results.NoException));
	}
	
	// Scenario 5 - [A] -> removeLast -> []
	private void oneElementList_removeLastTests()
	{
	}
	
	// Scenario 6 - [A] -> remove(A) -> []
	private void oneElementList_removeElementTests()
	{	
	}
	
	// Scenario 7 - [A] -> addToFront(B) -> [B, A]
	private void oneElementList_addToFrontTests()
	{
		
		//run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("oneElementList_addToFront_testRemoveFirst", testRemoveFirst(newList(Methods.addToFront, 1, A, B), Results.NoException));
		printTest("oneElementList_addToFront_testRemoveLast", testRemoveLast(newList(Methods.addToFront, 1, A, B), Results.NoException));
		printTest("oneElementList_addToFront_testaddToFront_C", testAddToFront(newList(Methods.addToFront, 1, A, B ), C, Results.NoException));
		printTest("oneElementList_addToFront_testaddToRear_C", testAddToRear(newList(Methods.addToFront, 1, A, B), C, Results.NoException));
		printTest("oneElementList_addToFront_testRemove_A", testRemove(newList(Methods.addToFront, 1, A, B), A, Results.NoException));
		printTest("oneElementList_addToFront_testRemove_B", testRemove(newList(Methods.addToFront, 1, A, B), B, Results.NoException));
		printTest("oneElementList_addToFront_testRemove_C", testRemove(newList(Methods.addToFront, 1, A, B), C, Results.ElementNotFound));
		printTest("oneElementList_addToFront_testFirst", testFirst(newList(Methods.addToFront, 1, A, B), Results.NoException));
		printTest("oneElementList_addToFront_testLast", testLast(newList(Methods.addToFront, 1, A, B), Results.NoException));
		printTest("oneElementList_addToFront_testContains_A", testContains(newList(Methods.addToFront, 1, A, B), A, Results.True));
		printTest("oneElementList_addToFront_testContains_B", testContains(newList(Methods.addToFront, 1, A, B), B, Results.True));
		printTest("oneElementList_addToFront_testIsEmpty", testIsEmpty(newList(Methods.addToFront, 1, A, B), Results.False));
		printTest("oneElementList_addToFront_testSize", testSize(newList(Methods.addToFront, 1, A, B), 2));
		printTest("oneElementList_addToFront_testIterator", testIterator(newList(Methods.addToFront, 1, A, B), Results.NoException));
		printTest("oneElementList_addToFront_testToString", testToString(newList(Methods.addToFront, 1, A, B), Results.NoException));
	}
	
	// Scenario 8 - [A] -> addToRear(B) -> [A, B]
	private void oneElementList_addToRearTests()
	{
		//run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("oneElementList_addToRear_testRemoveFirst", testRemoveFirst(newList(Methods.addToRear, 1, A, B), Results.NoException));
		printTest("oneElementList_addToRear_testRemoveLast", testRemoveLast(newList(Methods.addToRear, 1, A, B), Results.NoException));
		printTest("oneElementList_addToRear_testaddToFront_C", testAddToFront(newList(Methods.addToRear, 1, A, B), C, Results.NoException));
		printTest("oneElementList_addToRear_testaddToRear_C", testAddToRear(newList(Methods.addToRear, 1, A, B), C, Results.NoException));
		printTest("oneElementList_addToRear_testRemove_A", testRemove(newList(Methods.addToRear, 1, A, B), A, Results.NoException));
		printTest("oneElementList_addToRear_testRemove_B", testRemove(newList(Methods.addToRear, 1, A, B), B, Results.NoException));
		printTest("oneElementList_addToFront_testRemove_C", testRemove(newList(Methods.addToRear, 1, A, B), C, Results.ElementNotFound));
		printTest("oneElementList_addToRear_testFirst", testFirst(newList(Methods.addToRear, 1, A, B), Results.NoException));
		printTest("oneElementList_addToRear_testLast", testLast(newList(Methods.addToRear, 1, A, B), Results.NoException));
		printTest("oneElementList_addToRear_testContains_A", testContains(newList(Methods.addToRear, 1, A, B), A, Results.True));
		printTest("oneElementList_addToRear_testContains_B", testContains(newList(Methods.addToRear, 1, A, B), B, Results.True));
		printTest("oneElementList_addToRear_testIsEmpty", testIsEmpty(newList(Methods.addToRear, 1, A, B), Results.False));
		printTest("oneElementList_addToRear_testSize", testSize(newList(Methods.addToRear, 1, A, B), 2));
		printTest("oneElementList_addToRear_testIterator", testIterator(newList(Methods.addToRear, 1, A, B), Results.NoException));
		printTest("oneElementList_addToRear_testToString", testToString(newList(Methods.addToRear, 1, A, B), Results.NoException));
	}
	
	// Scenario 9 - [A] -> addAfter(B, A) -> [A, B]
	private void oneElementList_addAfterElementTests()
	{
	}
	
	// Scenario 10 - [A, B] -> removeFirst -> [B]
	private void twoElementList_removeFirstTests()
	{	
	}
	
	// Scenario 11 - [A, B] -> removeLast -> [A]
	private void twoElementList_removeLastTests()
	{
	}
	
	// Scenario 12 - [A, B] -> remove(A) -> [B]
	private void twoElementList_removeFirstElementTests()
	{
	}
	
	// Scenario 13 - [A, B] -> remove(B) -> [A]
	private void twoElementList_removeSecondElementTests()
	{
		//run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("twoElementList_removeSecondElement_testRemoveFirst", testRemoveFirst(newList(Methods.remove, 2, A, B), Results.NoException));
		printTest("twoElementList_removeSecondElement_testRemoveLast", testRemoveLast(newList(Methods.remove, 2, A, B), Results.NoException));
		printTest("twoElementList_removeSecondElement_testaddToFront_C", testAddToFront(newList(Methods.remove, 2, A, B), C, Results.NoException));
		printTest("twoElementList_removeSecondElement_testaddToRear_C", testAddToRear(newList(Methods.remove, 2, A, B), C, Results.NoException));
		printTest("twoElementList_removeSecondElement_testRemove_A", testRemove(newList(Methods.remove, 2, A, B), A, Results.NoException));
		printTest("twoElementList_removeSecondElement_testRemove_B", testRemove(newList(Methods.remove, 2, A, B), B, Results.ElementNotFound));
		printTest("twoElementList_removeSecondElement_testRemove_C", testRemove(newList(Methods.remove, 2, A, B), C, Results.ElementNotFound));
		printTest("twoElementList_removeSecondElement_testFirst", testFirst(newList(Methods.remove, 2, A, B), Results.NoException));
		printTest("twoElementList_removeSecondElement_testLast", testLast(newList(Methods.remove, 2, A, B), Results.NoException));
		printTest("twoElementList_removeSecondElement_testContains_A", testContains(newList(Methods.remove, 2, A, B), A, Results.True));
		printTest("twoElementList_removeSecondElement_testContains_B", testContains(newList(Methods.remove, 2, A, B), B, Results.False));
		printTest("twoElementList_removeSecondElement_testIsEmpty", testIsEmpty(newList(Methods.remove, 2, A, B), Results.False));
		printTest("twoElementList_removeSecondElement_testSize", testSize(newList(Methods.remove, 2, A, B), 1));
		printTest("twoElementList_removeSecondElement_testIterator", testIterator(newList(Methods.remove, 2, A, B), Results.NoException));
		printTest("twoElementList_removeSecondElement_testToString", testToString(newList(Methods.remove, 2, A, B), Results.NoException));
	}
	
	// Scenario 14 - [A, B] -> addToFront(C) -> [A, B, C]
	private void twoElementList_addToFrontTests()
	{
		//run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("twoElementList_addToFront_testRemoveFirst", testRemoveFirst(newList(Methods.addToFront, 2, A, B, C), Results.NoException));
		printTest("twoElementList_addToFront_testRemoveLast", testRemoveLast(newList(Methods.addToFront, 2, A, B, C), Results.NoException));
		printTest("twoElementList_addToFront_testaddToFront_D", testAddToFront(newList(Methods.addToFront, 2, A, B, C), D, Results.NoException));
		printTest("twoElementList_addToFront_testaddToRear_D", testAddToRear(newList(Methods.addToFront, 2, A, B, C), D, Results.NoException));
		printTest("twoElementList_addToFront_testRemove_A", testRemove(newList(Methods.addToFront, 2, A, B, C), A, Results.NoException));
		printTest("twoElementList_addToFront_testRemove_B", testRemove(newList(Methods.addToFront, 2, A, B, C), B, Results.NoException));
		printTest("twoElementList_addToFront_testRemove_C", testRemove(newList(Methods.addToFront, 2, A, B, C), C, Results.NoException));
		printTest("twoElementList_addToFront_testFirst", testFirst(newList(Methods.addToFront, 2, A, B, C), Results.NoException));
		printTest("twoElementList_addToFront_testLast", testLast(newList(Methods.addToFront, 2, A, B, C), Results.NoException));
		printTest("twoElementList_addToFront_testContains_A", testContains(newList(Methods.addToFront, 2, A, B, C), A, Results.True));
		printTest("twoElementList_addToFront_testContains_B", testContains(newList(Methods.addToFront, 2, A, B, C), B, Results.True));
		printTest("twoElementList_addToFront_testIsEmpty", testIsEmpty(newList(Methods.addToFront, 2, A, B, C), Results.False));
		printTest("twoElementList_addToFront_testSize", testSize(newList(Methods.addToFront, 2, A, B, C), 3));
		printTest("twoElementList_addToFront_testIterator", testIterator(newList(Methods.addToFront, 2, A, B, C), Results.NoException));
		printTest("twoElementList_addToFront_testToString", testToString(newList(Methods.addToFront, 2, A, B, C), Results.NoException));
	}
	
	// Scenario 15 - [A, B] -> addToRear -> [A, B, C]
	private void twoElementList_addToRearTests()
	{
		//run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("twoElementList_addToRear_testRemoveFirst", testRemoveFirst(newList(Methods.addToRear, 2, A, B, C), Results.NoException));
		printTest("twoElementList_addToRear_testRemoveLast", testRemoveLast(newList(Methods.addToRear, 2, A, B, C), Results.NoException));
		printTest("twoElementList_addToRear_testaddToFront_D", testAddToFront(newList(Methods.addToRear, 2, A, B, C), D, Results.NoException));
		printTest("twoElementList_addToRear_testaddToRear_D", testAddToRear(newList(Methods.addToRear, 2, A, B, C), D, Results.NoException));
		printTest("twoElementList_addToRear_testRemove_A", testRemove(newList(Methods.addToRear, 2, A, B, C), A, Results.NoException));
		printTest("twoElementList_addToRear_testRemove_B", testRemove(newList(Methods.addToRear, 2, A, B, C), B, Results.NoException));
		printTest("twoElementList_addToRear_testRemove_C", testRemove(newList(Methods.addToRear, 2, A, B, C), C, Results.NoException));
		printTest("twoElementList_addToRear_testFirst", testFirst(newList(Methods.addToRear, 2, A, B, C), Results.NoException));
		printTest("twoElementList_addToRear_testLast", testLast(newList(Methods.addToRear, 2, A, B, C), Results.NoException));
		printTest("twoElementList_addToRear_testContains_A", testContains(newList(Methods.addToRear, 2, A, B, C), A, Results.True));
		printTest("twoElementList_addToRear_testContains_B", testContains(newList(Methods.addToRear, 2, A, B, C), B, Results.True));
		printTest("twoElementList_addToRear_testIsEmpty", testIsEmpty(newList(Methods.addToRear, 2, A, B, C), Results.False));
		printTest("twoElementList_addToRear_testSize", testSize(newList(Methods.addToRear, 2, A, B, C), 3));
		printTest("twoElementList_addToRear_testIterator", testIterator(newList(Methods.addToRear, 2, A, B, C), Results.NoException));
		printTest("twoElementList_addToRear_testToString", testToString(newList(Methods.addToRear, 2, A, B, C), Results.NoException));
	}
	
	// Scenario 16 - [A, B] -> addAfter(C, A) -> [A, C, B]
	private void twoElementList_addAfterFirstElementTests()
	{
		//run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("twoElementList_addAfterFirstElement_testRemoveFirst", testRemoveFirst(newList(Methods.addAfter, 2, B, C, A), Results.NoException));
		printTest("twoElementList_addAfterFirstElement_testRemoveLast", testRemoveLast(newList(Methods.addAfter, 2, B, C, A), Results.NoException));
		printTest("twoElementList_addAfterFirstElement_testaddToFront_D", testAddToFront(newList(Methods.addAfter, 2, B, C, A), D, Results.NoException));
		printTest("twoElementList_addAfterFirstElement_testaddToRear_D", testAddToRear(newList(Methods.addAfter, 2, B, C, A), D, Results.NoException));
		printTest("twoElementList_addAfterFirstElement_testRemove_A", testRemove(newList(Methods.addAfter, 2, B, C, A), A, Results.NoException));
		printTest("twoElementList_addAfterFirstElement_testRemove_B", testRemove(newList(Methods.addAfter, 2, B, C, A), B, Results.NoException));
		printTest("twoElementList_addAfterFirstElement_testRemove_C", testRemove(newList(Methods.addAfter, 2, B, C, A), C, Results.NoException));
		printTest("twoElementList_addAfterFirstElement_testFirst", testFirst(newList(Methods.addAfter, 2, B, C, A), Results.NoException));
		printTest("twoElementList_addAfterFirstElement_testLast", testLast(newList(Methods.addAfter, 2, B, C, A), Results.NoException));
		printTest("twoElementList_addAfterFirstElement_testContains_A", testContains(newList(Methods.addAfter, 2, B, C, A), A, Results.True));
		printTest("twoElementList_addAfterFirstElement_testContains_B", testContains(newList(Methods.addAfter, 2, B, C, A), B, Results.True));
		printTest("twoElementList_addAfterFirstElement_testIsEmpty", testIsEmpty(newList(Methods.addAfter, 2, B, C, A), Results.False));
		printTest("twoElementList_addAfterFirstElement_testSize", testSize(newList(Methods.addAfter, 2, B, C, A), 3));
		printTest("twoElementList_addAfterFirstElement_testIterator", testIterator(newList(Methods.addAfter, 2, B, C, A), Results.NoException));
		printTest("twoElementList_addAfterFirstElement_testToString", testToString(newList(Methods.addAfter, 2, B, C, A), Results.NoException));
	}
	
	// Scenario 17 - [A, B] -> addAfter(C, B) -> [A, B, C]
	private void twoElementList_addAfterSecondElementTests()
	{
		//run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("twoElementList_addAfterSecondElement_testRemoveFirst", testRemoveFirst(newList(Methods.addAfter, 2, A, C, B), Results.NoException));
		printTest("twoElementList_addAfterSecondElement_testRemoveLast", testRemoveLast(newList(Methods.addAfter, 2, A, C, B), Results.NoException));
		printTest("twoElementList_addAfterSecondElement_testaddToFront_D", testAddToFront(newList(Methods.addAfter, 2, A, C, B), D, Results.NoException));
		printTest("twoElementList_addAfterSecondElement_testaddToRear_D", testAddToRear(newList(Methods.addAfter, 2, A, C, B), D, Results.NoException));
		printTest("twoElementList_addAfterSecondElement_testRemove_A", testRemove(newList(Methods.addAfter, 2, A, C, B), A, Results.NoException));
		printTest("twoElementList_addAfterSecondElement_testRemove_B", testRemove(newList(Methods.addAfter, 2, A, C, B), B, Results.NoException));
		printTest("twoElementList_addAfterSecondElement_testRemove_C", testRemove(newList(Methods.addAfter, 2, A, C, B), C, Results.NoException));
		printTest("twoElementList_addAfterSecondElement_testFirst", testFirst(newList(Methods.addAfter, 2, A, C, B), Results.NoException));
		printTest("twoElementList_addAfterSecondElement_testLast", testLast(newList(Methods.addAfter, 2, A, C, B), Results.NoException));
		printTest("twoElementList_addAfterSecondElement_testContains_A", testContains(newList(Methods.addAfter, 2, A, C, B), A, Results.True));
		printTest("twoElementList_addAfterSecondElement_testContains_B", testContains(newList(Methods.addAfter, 2, A, C, B), B, Results.True));
		printTest("twoElementList_addAfterSecondElement_testIsEmpty", testIsEmpty(newList(Methods.addAfter, 2, A, C, B), Results.False));
		printTest("twoElementList_addAfterSecondElement_testSize", testSize(newList(Methods.addAfter, 2, A, C, B), 3));
		printTest("twoElementList_addAfterSecondElement_testIterator", testIterator(newList(Methods.addAfter, 2, A, C, B), Results.NoException));
		printTest("twoElementList_addAfterSecondElement_testToString", testToString(newList(Methods.addAfter, 2, A, C, B), Results.NoException));

	}
	
	// Scenario 18 - [A, B, C] -> removeFirst -> [B, C]
	private void threeElementList_removeFirstTests()
	{
		//run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("threeElementList_removeFirst_testRemoveFirst", testRemoveFirst(newList(Methods.removeFirst, 3, A, B, C), Results.NoException));
		printTest("threeElementList_removeFirst_testRemoveLast", testRemoveLast(newList(Methods.removeFirst, 3, A, B, C), Results.NoException));
		printTest("threeElementList_removeFirst_testaddToFront_D", testAddToFront(newList(Methods.removeFirst, 3, A, B, C), D, Results.NoException));
		printTest("threeElementList_removeFirst_testaddToRear_D", testAddToRear(newList(Methods.removeFirst, 3, A, B, C), D, Results.NoException));
		printTest("threeElementList_removeFirst_testRemove_A", testRemove(newList(Methods.removeFirst, 3, A, B, C), A, Results.ElementNotFound));
		printTest("threeElementList_removeFirst_testRemove_B", testRemove(newList(Methods.removeFirst, 3, A, B, C), B, Results.NoException));
		printTest("threeElementList_removeFirst_testRemove_C", testRemove(newList(Methods.removeFirst, 3, A, B, C), C, Results.NoException));
		printTest("threeElementList_removeFirst_testFirst", testFirst(newList(Methods.removeFirst, 3, A, B, C), Results.NoException));
		printTest("threeElementList_removeFirst_testLast", testLast(newList(Methods.removeFirst, 3, A, B, C), Results.NoException));
		printTest("threeElementList_removeFirst_testContains_A", testContains(newList(Methods.removeFirst, 3, A, B, C), A, Results.False));
		printTest("threeElementList_removeFirst_testContains_B", testContains(newList(Methods.removeFirst, 3, A, B, C), B, Results.True));
		printTest("threeElementList_removeFirst_testIsEmpty", testIsEmpty(newList(Methods.removeFirst, 3, A, B, C), Results.False));
		printTest("threeElementList_removeFirst_testSize", testSize(newList(Methods.removeFirst, 3, A, B, C), 2));
		printTest("threeElementList_removeFirst_testIterator", testIterator(newList(Methods.removeFirst, 3, A, B, C), Results.NoException));
		printTest("threeElementList_removeFirst_testToString", testToString(newList(Methods.removeFirst, 3, A, B, C), Results.NoException));
	}
	
	// Scenario 19 - [A, B, C] -> removeLast -> [A, B]
	private void threeElementList_removeLastTests()
	{
		//run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("threeElementList_removeLast_testRemoveFirst", testRemoveFirst(newList(Methods.removeLast, 3, A, B, C), Results.NoException));
		printTest("threeElementList_removeLast_testRemoveLast", testRemoveLast(newList(Methods.removeLast, 3, A, B, C), Results.NoException));
		printTest("threeElementList_removeLast_testaddToFront_D", testAddToFront(newList(Methods.removeLast, 3, A, B, C), D, Results.NoException));
		printTest("threeElementList_removeLast_testaddToRear_D", testAddToRear(newList(Methods.removeLast, 3, A, B, C), D, Results.NoException));
		printTest("threeElementList_removeLast_testRemove_A", testRemove(newList(Methods.removeLast, 3, A, B, C), A, Results.NoException));
		printTest("threeElementList_removeLast_testRemove_B", testRemove(newList(Methods.removeLast, 3, A, B, C), B, Results.NoException));
		printTest("threeElementList_removeLast_testRemove_C", testRemove(newList(Methods.removeLast, 3, A, B, C), C, Results.ElementNotFound));
		printTest("threeElementList_removeLast_testFirst", testFirst(newList(Methods.removeLast, 3, A, B, C), Results.NoException));
		printTest("threeElementList_removeLast_testLast", testLast(newList(Methods.removeLast, 3, A, B, C), Results.NoException));
		printTest("threeElementList_removeLast_testContains_A", testContains(newList(Methods.removeLast, 3, A, B, C), A, Results.True));
		printTest("threeElementList_removeLast_testContains_B", testContains(newList(Methods.removeLast, 3, A, B, C), B, Results.True));
		printTest("threeElementList_removeLast_testIsEmpty", testIsEmpty(newList(Methods.removeLast, 3, A, B, C), Results.False));
		printTest("threeElementList_removeLast_testSize", testSize(newList(Methods.removeLast, 3, A, B, C), 2));
		printTest("threeElementList_removeLast_testIterator", testIterator(newList(Methods.removeLast, 3, A, B, C), Results.NoException));
		printTest("threeElementList_removeLast_testToString", testToString(newList(Methods.removeLast, 3, A, B, C), Results.NoException));
	}
	
	// Scenario 20 - [A, B, C] -> remove(A) -> [B, C]
	private void threeElementList_removeFirstElementTests()
	{
		//run tests - description of test case, method testing, list tested, arguments to method tested, expected result
		printTest("threeElementList_removeFirst_testRemoveFirst", testRemoveFirst(newList(Methods.remove, 3, B, C, A), Results.NoException));
		printTest("threeElementList_removeFirst_testRemoveLast", testRemoveLast(newList(Methods.remove, 3, B, C, A), Results.NoException));
		printTest("threeElementList_removeFirst_testaddToFront_D", testAddToFront(newList(Methods.remove, 3, B, C, A), D, Results.NoException));
		printTest("threeElementList_removeFirst_testaddToRear_D", testAddToRear(newList(Methods.remove, 3, B, C, A), D, Results.NoException));
		printTest("threeElementList_removeFirst_testRemove_A", testRemove(newList(Methods.remove, 3, B, C, A), A, Results.ElementNotFound));
		printTest("threeElementList_removeFirst_testRemove_B", testRemove(newList(Methods.remove, 3, B, C, A), B, Results.NoException));
		printTest("threeElementList_removeFirst_testRemove_C", testRemove(newList(Methods.remove, 3, B, C, A), C, Results.NoException));
		printTest("threeElementList_removeFirst_testFirst", testFirst(newList(Methods.remove, 3, B, C, A), Results.NoException));
		printTest("threeElementList_removeFirst_testLast", testLast(newList(Methods.remove, 3, B, C, A), Results.NoException));
		printTest("threeElementList_removeFirst_testContains_A", testContains(newList(Methods.remove, 3, B, C, A), A, Results.False));
		printTest("threeElementList_removeFirst_testContains_B", testContains(newList(Methods.remove, 3, B, C, A), B, Results.True));
		printTest("threeElementList_removeFirst_testIsEmpty", testIsEmpty(newList(Methods.remove, 3, B, C, A), Results.False));
		printTest("threeElementList_removeFirst_testSize", testSize(newList(Methods.remove, 3, B, C, A), 2));
		printTest("threeElementList_removeFirst_testIterator", testIterator(newList(Methods.remove, 3, B, C, A), Results.NoException));
		printTest("threeElementList_removeFirst_testToString", testToString(newList(Methods.remove, 3, B, C, A), Results.NoException));
	}
	
	// Scenario 21 - [A, B, C] -> remove(B) -> [A, C]
	private void threeElementList_removeSecondElementTests()
	{
	}
	
	// Scenario 22 - [A, B, C] -> remove(C) -> [A, B]
	private void threeElementList_removeThirdElementTests()
	{
	}
	private boolean testAddToFront(UnorderedList<Integer> list, Integer i, Results expectedResult) 
	{
		Results result; 
		try 
		{
			list.addToFront(i);
			result = Results.NoException;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "newList_testAddToFront", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult; 
	}
	private boolean testAddToRear(UnorderedList<Integer> list, Integer i, Results expectedResult) 
	{
		Results result;
		try 
		{
			list.addToRear(i);
			result = Results.NoException;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "newList_testAddToRear", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult;
	}
	private boolean testAddAfter(UnorderedList<Integer> list, Integer i, Integer j, Results expectedResult) 
	{
		Results result;
		try 
		{
			list.addAfter(i, j);
			result = Results.NoException;
		} 
		catch (ElementNotFoundException e) 
		{
			result = Results.ElementNotFound;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s expected %s, caught %s\n", "newList_testAddAfter", "ElementNotFoundException", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult; 
	}
	private boolean testRemoveFirst(UnorderedList<Integer> list, Results expectedResult) 
	{
		Results result; 
		try 
		{
			list.removeFirst();
			result = Results.NoException;
		} 
		catch (EmptyCollectionException e) 
		{
			result = Results.EmptyCollection;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s expected %s, caught %s\n", "newList_testRemoveFirst", "EmptyCollectionException", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult;
	}
	private boolean testRemoveLast(UnorderedList<Integer> list, Results expectedResult) 
	{
		Results result;
		try 
		{
			list.removeLast();
			result = Results.NoException;
		} 
		catch (EmptyCollectionException e) 
		{
			result = Results.EmptyCollection;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s expected %s, caught %s\n", "newList_testRemoveLast", "EmptyCollectionException", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult;
	}
	private boolean testRemove(UnorderedList<Integer> list, Integer i, Results expectedResult) 
	{
		Results result;
		try 
		{
			list.remove(i);
			result = Results.NoException;
		} 
		catch (ElementNotFoundException e) 
		{
			result = Results.ElementNotFound;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s expected %s, caught %s\n", "newList_testRemoveElement", "ElementNotFoundException", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult;
	}
	private boolean testFirst(UnorderedList<Integer> list, Results expectedResult) 
	{
		Results result;
		try 
		{
			list.first();
			result = Results.NoException;
		} 
		catch (EmptyCollectionException e) 
		{
			result = Results.EmptyCollection;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s expected %s, caught %s\n", "newList_testFirst", "EmptyCollectionException", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult;
	}
	private boolean testLast(UnorderedList<Integer> list, Results expectedResult) 
	{
		Results result;
		try 
		{
			list.last();
			result = Results.NoException;
		} 
		catch (EmptyCollectionException e) 
		{
			result = Results.EmptyCollection;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s expected %s, caught %s\n", "newList_testLast", "EmptyCollectionException", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult;
	}
	private boolean testContains(UnorderedList<Integer> list, Integer i, Results expectedResult) 
	{
		Results result;
		try 
		{
			if(list.contains(i))
			{
				result = Results.True;
			}
			else
			{
				result = Results.False;
			}
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "newList_testContains", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult;
	}
	private boolean testIsEmpty(UnorderedList<Integer> list, Results expectedResult) 
	{
		Results result;
		try 
		{
			if(list.isEmpty())
			{
				result = Results.True;
			}
			else
			{
				result = Results.False;
			}
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "newList_testIsEmpty", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult;
	}
	private boolean testSize(UnorderedList<Integer> list, int expectedSize) 
	{
		try 
		{
			return (list.size() == expectedSize);
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "newList_testSize", e.toString());
			return false;
		}
	}
	private boolean testIterator(UnorderedList<Integer> list, Results expectedResult) 
	{
		Results result; 
		try 
		{
			Iterator<Integer> it = list.iterator();
			result = Results.NoException;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "newList_testIterator", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult;
	}
	private boolean testIteratorHasNext(UnorderedList<Integer> list, Results expectedResult) 
	{
		Results result;
		try 
		{
			Iterator<Integer> it = list.iterator();
			if(it.hasNext())
			{
				result = Results.True;
			}
			else
			{
				result = Results.False;
			}
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "newList_testIterator", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult;
	}
	private boolean testIteratorNext(UnorderedList<Integer> list, Results expectedResult) 
	{
		Results result;
		try 
		{
			Iterator<Integer> it = list.iterator();
			it.next();
			result = Results.NoException;
		} 
		catch (NoSuchElementException e) 
		{
			result = Results.ElementNotFound;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "newList_testIterator", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult;
	}
	private boolean testToString(UnorderedList<Integer> list, Results expectedResult) 
	{
		Results result;
		try 
		{
			String str = list.toString();
			System.out.println("toString() output: " + str);
			if (str.length() == 0) 
			{
				result = Results.Fail;
			}
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar)
							|| (lastChar >= 'a' && lastChar <= 'f'))) 
			{
				result = Results.Fail; //looks like default toString()
			}
			else
			{
				result = Results.NoException;
			}
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "newList_testToString", e.toString());
			result = Results.Fail;
		}
		return result == expectedResult;
	}
}
*/
	
