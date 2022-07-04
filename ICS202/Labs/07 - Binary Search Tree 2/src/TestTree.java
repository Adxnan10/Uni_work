public class TestTree {
	public static void main(String[] args) {
		BST<String> tree = new BST<String>();
		tree.insert("D");
		tree.insert("B");
		tree.insert("A");
		tree.insert("C");
		tree.insert("F");
		tree.insert("H");

		//Likewise test all other methods.
		System.out.println("Path for 'A'>> " + tree.getPath("A"));
		System.out.println("Path for 'Q'>> " + tree.getPath("Q"));
		System.out.println("Right Leaf Count>> " + tree.getRightLeafCount());
		System.out.println("Elements between 'A' and 'D'>> " + tree.rangeCounter("A", "D"));
	}
}
