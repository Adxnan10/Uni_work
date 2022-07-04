// Adnan Alshehri 
// 201947730
public class Quiz02_st201947730 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<Integer> bst = new BST<Integer>(); 
		bst.insert(8);
		bst.insert(9);
		bst.insert(4);
		bst.insert(2);
		bst.insert(7);
		bst.breadthFirst();
	
		System.out.println("\nThe shallowest node is " + bst.shallowestLeaf());
		System.out.println("The deepest node is " + bst.deepestLeaf());
	}

}
