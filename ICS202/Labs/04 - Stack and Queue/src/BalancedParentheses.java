import java.util.Scanner;
public class BalancedParentheses {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your expression: ");
		String expression = input.nextLine();
		System.out.println("Entered Expression is " + expression);
		LabStack<String> evaluator = new LabStack<String>();
		try {
			for (int i = 0, n = expression.length(); i < n; i++)
			{
				char current = expression.charAt(i);
				if (current == '(' || current == '[' || current == '{') 
					evaluator.push(expression.charAt(i) + "");
				else if (current == ')' || current == ']' || current == '}')
					if (current == ')'  && evaluator.topEl().equals("(") ) 
							evaluator.pop();
					else if (current == ']' && evaluator.topEl().equals("[" )) 
						evaluator.pop();
					else if (current == '}'  && evaluator.topEl().equals("{" ))
						evaluator.pop();
					else {
						System.out.println("Expression is inbalanced");
						System.exit(1);
					}
			}
			if (evaluator.isEmpty())
				System.out.println("The Expression is balanced!");
			else 
				System.out.print("The Expression is inbalanced");
		} catch(Exception e) {
			System.out.print("The Expression is inbalanced");
		}
	}
	
	String isBalanced() {
		return "";
	}
}



