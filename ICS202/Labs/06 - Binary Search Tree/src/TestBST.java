
public class TestBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<Integer> bst = new BST<Integer>();
		bst.insert(8);
		bst.insert(4);
		bst.insert(9);
		bst.insert(2);
		bst.insert(7);
		
		System.out.print("For the following bst: [ ");
		bst.breadthFirst();
		System.out.println("]");
		System.out.println("The number of nodes is " + bst.count());
		System.out.println("'4' is leaf? " + bst.isLeaf(4));
		System.out.println("'7' is leaf? " + bst.isLeaf(7));
		System.out.println("number of leaves is " + bst.countLeaves());
		System.out.println("Height is " + bst.height());
		System.out.println("The various traversals are >>");
		System.out.print("Preorder ");
		bst.preorder();
		System.out.print("\nInorder ");
		bst.inorder();
		System.out.print("\nPostorder ");
		bst.postorder();
		System.out.print("\nBreadth first ");
		bst.breadthFirst();
		
			
	}

}
