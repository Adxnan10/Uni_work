**King Fahd University of Petroleum & Minerals**

**College of Computer Science and Engineering**

**Information and Computer Science Department**

**ICS 202 – Data Structures**

# Recursion

**Objectives**

The objective of this lab is to design, and implement recursive programs.

**Outcomes**

After completing this Lab, students are expected to:

• Design recursive solutions.

• Implement recursive methods.

**Lab Exercises**

1.  Given an array of strings, write a recursive method that finds and prints the string of (a) minimum length and (b) another recursive method that finds the string of maximum length.

    Your methods should have signature as follows:

2.  public static String findSmallest(String[] array, int index)
3.  public static String findLongest(String[] array, int index)

    For example, if the array is

    String[] fruits = {"Apple", "Mango", "Banana", "Orange", "Peach", "Lime", "Watermelon"};

    then findSmallest method will return “Lime”, while findLongest will return “Watermelon”.

    Also write a main method to test your methods.

4.  Write a recursive method GCD(*n*, *m*) that returns the greatest common divisor of two integers *n* and *m* according to the following:

GCD(*n*, *m*) = *n*, if *m* = 0

= GCD(*m*, *n* mod *m*) otherwise

Test Case: System.out.println(gcd(45, 25)); should return 5.

1.  Write a recursive method putCommas(int x) that puts commas after every 3 digits in an integer “x” starting from the units place. The method is public static String putCommas(int x)

    For example, putCommas(1234567) returns 1,234,567.

    Test: System.out.println(putCommas("987631000")); should print 987,631,000

2.  Write a recursive method findPalindrome(String word) that finds whether the contents of a string form a palindrome. The algorithm is as follows:
    1.  Base Case: If the string is empty or has one element, return true.
    2.  Recursive Case: If the first and the last character have the same contents, apply findPalindrome on a new, shorter string without the first and the last character of the original string; if the first and the last character are not the same, return false.

        System.out.println(isPalindrome("level")); should print true

        System.out.println(isPalindrome("lever")); should print false
