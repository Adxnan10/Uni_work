//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class CSLL<T> {
    protected CLLNode<T> firstElement, tail;
    public CSLL() {
        tail = null;
    }
    public boolean isEmpty() {
        return tail == null;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new CLLNode<T>(el, firstElement);
            tail = tail.next;
        }
        else firstElement = tail = new CLLNode<T>(el);
    }
    public void printAll() {
    	if (!isEmpty()) {
	        for(CLLNode<T> tmp = firstElement; tmp != tail; tmp = tmp.next) {
	        	System.out.println(tmp.info);
	        } 
	        System.out.println(tail.info);
    	}
    }
}
