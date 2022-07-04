
import java.util.Scanner;

public class reverseStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner k = new Scanner(System.in);
		System.out.println("Enter your input: ");
		String[] input = k.nextLine().split(" ");
		LabStack<String> s = new LabStack<String>();
		for (int i = 0, n = input.length; i < n; i++)
			s.push(input[i]);
		System.out.println("Now The Stack is >> " + s);
		LabQueue<String> q = new LabQueue<String>();
		for (int i = 0, n = s.pool.size(); i < n; i++)
			q.enqueue(s.pop());
		for (int i = 0, n = q.pool.size(); i < n; i++)
			s.push(q.dequeue());
		System.out.print("After reverse the  stack is >> " + s);
	
			
//		System.out.println("The reversed string is: ");
//		while(!s.isEmpty()) {
//			System.out.print(s.pop());
//		
//	}

	}
}
