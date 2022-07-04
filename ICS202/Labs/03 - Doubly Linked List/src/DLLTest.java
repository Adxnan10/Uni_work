public class DLLTest {
	public static void main(String[] args) {
		// Testing task 2 
		DLL<Integer> test = new DLL<Integer>();
		for(int i = 0; i < 10; i++)
			test.addToTail((int) (Math.random() * 10));
		System.out.println("=== Deleting 7th element ===");
		System.out.println("The List now is: ");
		test.printAll();
		System.out.println("After deleting 7th element: ");
		test.delete7();
		test.printAll();
		System.out.println("Deleting 3 elements from the tail: ");
		test.deleteFromTail();
		test.deleteFromTail();
		test.deleteFromTail();
		test.printAll();
		System.out.println("After deleting 7th element again (counting in the same direction, then moving reverse), ");
		test.delete7();
		test.printAll();
		System.out.println("After deleting 7th element again (counting in the same direction, then moving reverse),");
		test.delete7();
		test.printAll();
		
		// TESTING task 1 and 3
		DLL<Integer> firstList = new DLL<Integer>();
		DLL<Integer> secondList = new DLL<Integer>();
		for (int i = 0; i < 4; i++) {
			firstList.addToTail(i+1);
			secondList.addToTail(i+6);
		}
		System.out.println("=== Alternating two lists: ===");
		System.out.print("List 1: ");
		firstList.printAll();
		System.out.print("List 2: ");
		secondList.printAll();
		System.out.println("List 1 after inserting the elements of List 2 into List 1 alternately: ");
		firstList.insertAlternate(secondList);
		firstList.printAll();
		System.out.println("=== Printing the elements reversely: ===");
		firstList.printReverse();
		
		DLL<Integer> ss = new DLL<Integer>();
		DLL<Integer> ss2 = new DLL<Integer>();
		for (int i = 0; i < 2; i++) {
			ss.addToTail(i+1);
		}
		ss2.addToTail(1);
		System.out.println("=== Trying to alternate two lists with different lengths: ===");
		System.out.print("List 1: ");
		ss.printAll();
		System.out.print("List 2: ");
		ss2.printAll();
		ss.insertAlternate(ss2);
		
	}
}