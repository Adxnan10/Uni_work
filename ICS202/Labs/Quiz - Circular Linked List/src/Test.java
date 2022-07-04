
public class Test {

	public static void main(String[] args) {
		CSLL<String> mySLL = new CSLL<String>();
		String[] testElements = {"Mango", "Avocado", "Lime", "Peach", "Apple"};
		for (int i = 0, n = testElements.length; i < n; i++)
			mySLL.addToTail(testElements[i]);
	
	}

}
