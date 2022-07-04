
public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] fruits = {"Apple", "Mango", "Banana", "Orange", "Peach", "Lime", "Watermelon"};
		System.out.println("findSmallest: " + findSmallest(fruits, fruits.length - 1));
		System.out.println("findLongest: " + findLongest(fruits, fruits.length - 1));
		System.out.println("GCD of 45, 25 => " + GCD(45, 25));
		System.out.println("1234567 => " + putCommas(1234567));
		System.out.println("is level a Palindrome? " + isPalindrome("level"));
		System.out.println("is lever a Palindrome? " + isPalindrome("level"));

	}
	public static String findSmallest(String[] array, int index) {
			if (index == 0) {
				return array[0];
			} else {
				String called = findSmallest(array, index - 1);
				return array[index].length() < called.length()? array[index]: called;
			}
		}
	public static String findLongest(String[] array, int index) {
			if (index == 0) {
				return array[0];
			} else {
				String called = findLongest(array, index - 1);
				return array[index].length() > called.length()? array[index]: called;
			}
		}
	public static int GCD(int n, int m) {
		if (m == 0) 
			return n;
		else 
			return GCD(m, n % m);
	}
	public static String putCommas(int x) {
			return putCommas(x + ""); 
	}
	public static String putCommas(String x) {
		if (x.length() < 4)
			return x;

		else
			return putCommas(x.substring(0, x.length() - 3)) + "," + x.substring(x.length() - 3, x.length());
	}
	public static boolean isPalindrome(String word)  {
		if (word.length() <= 1) {
			return true;
		} else if (word.charAt(0) == word.charAt(word.length() - 1)) {
			return isPalindrome(word.substring(1, word.length() - 1));
		} else {
			return false;
		}
	}
}
