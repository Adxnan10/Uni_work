import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestAVL {
	public static void main(String[] args) {
			//Example which works with Left Rotation
         AVLTree<String> t = new AVLTree<String>();
         for(int i = 1; i <= 5; i++)
				t.insertAVL("a" + i);
         System.out.println("Result: ");
		 t.breadthFirst();
		 System.out.println();
		
         System.out.println("Exercise 2");
         AVLTree<Integer> avlTree = new AVLTree<Integer>();
         int[] values = {8, 14, 12, 18, 23, 20, 15, 13, 7, 16};
         for (int i: values)
        	 avlTree.insertAVL(i);
         System.out.println("Result: ");
         avlTree.breadthFirst();
         
         System.out.println("\nEnter Three 3 elements to delete (seperated by a space)"); 
         Scanner input = new Scanner(System.in);
         int[] elements = {input.nextInt(), input.nextInt(), input.nextInt()};
         for (int i: elements)
        	 avlTree.deleteAVL(i);
         System.out.println("AVLTREE after deleting: ");
         avlTree.breadthFirst();
         
         // Exercise 3: read the text file, insert unique words into the AVL tree and print its inorder traversal
         System.out.println("\nExercise 3"); 
         AVLTree<String> avlFromText = new AVLTree<String>();
         File file = new File("sampletextfile.txt");
         try (Scanner inputTxt = new Scanner(file);) {
        	 String[] words = inputTxt.nextLine().split(" ");
        	 for (String word: words)
        		 if (!avlFromText.isInTree(word))
        			 avlFromText.insertAVL(word);
        		 
         }
         catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         System.out.println("Result: ");
         avlFromText.inorder();
	}
}