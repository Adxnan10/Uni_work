import java.util.Scanner;

public class postfixEvaluator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your <postfix> expression: ");
		String expression = input.nextLine();	
		String[] trimmedExpression = expression.split(" ");
		LabStack<Integer> evaluator = new LabStack<Integer>();
		for (int i = 0, n = trimmedExpression.length; i < n; i++)
		{
			String current = trimmedExpression[i];
			if (isInteger(current))
				evaluator.push(Integer.parseInt(current));
			else if (current.equals("+")  || current.equals("-")  || current.equals("*") || current.equals("/"))
				if (evaluator.pool.size() < 2) {
					System.out.print("Your postfix expression is invalid");
					System.exit(1);
				}
				else {
					int firstInteger = evaluator.pop();
					int secondInteger = evaluator.pop();
					if (current.equals("+")) {
						 evaluator.push(secondInteger + firstInteger);
						 System.out.println("Currently, the sack is >> " + evaluator);
					}
					else if (current.equals("-")) {
						evaluator.push(secondInteger - firstInteger);
						System.out.println("Currently, the sack is >> " + evaluator);
					}
					else if (current.equals("*")) {
						evaluator.push(secondInteger * firstInteger);
						System.out.println("Currently, the sack is >> " + evaluator);
					}
					else {
							evaluator.push(secondInteger / firstInteger);
							System.out.println("Currently, the sack is >> " + evaluator);
					}
				}
			else {
				System.out.print("Your postfix expression is invalid. You must have only integers and opreators");
				System.exit(1);
			}
		} 
		if (evaluator.pool.size() > 1) 
			System.out.print("Your postfix expression is invalid. The stack have more than one number");
		else 
			System.out.print(expression + " = " + evaluator.pop());
	}
	public static boolean isInteger(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int i = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
