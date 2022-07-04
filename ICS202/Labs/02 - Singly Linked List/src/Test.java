
public class Test {

	public static void main(String[] args) {
		SLL<String> mySLL = new SLL<String>();
		String[] testElements = {"Mango", "Avocado", "Lime", "Peach", "Apple"};
		for (int i = 0, n = testElements.length; i < n; i++)
			mySLL.addToTail(testElements[i]);
		// insertions
		System.out.print("The list now is >> ");
		mySLL.printAll();
		mySLL.insertBefore("Fruits", "Apple");
		System.out.print("after insertBefore the list is >> ");
		mySLL.printAll();
		mySLL.insertAfter("Watermelon", "Lime");
		System.out.print("after insertAfter the list is >> ");
		mySLL.printAll();
		// deletions
		mySLL.deleteBefore("Watermelon");
		System.out.print("after deleteBefore(Waterlemon) the list is >> ");
		mySLL.printAll();
		mySLL.deleteAfter("Watermelon");
		System.out.print("after deleteAfter(Waterlemon) the list is >> ");
		mySLL.printAll();
	}

}
