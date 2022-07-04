//****************************  DLL.java  *******************************
//                  generic doubly linked list class

public class DLL<T> {
    private DLLNode<T> head, tail;
    public DLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void setToNull() {
        head = tail = null;
    }
    public T firstEl() {
        if (head != null)
             return head.info;
        else return null;
    }
    public void addToHead(T el) {
        if (head != null) {
             head = new DLLNode<T>(el,head,null);
             head.next.prev = head;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public void addToTail(T el) {
        if (tail != null) {
             tail = new DLLNode<T>(el,null,tail);
             tail.prev.next = tail;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public T deleteFromHead() { 
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             head = head.next;
             head.prev = null;
        }
        return el;
    }
    public T deleteFromTail() {
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             tail = tail.prev;
             tail.next = null;
        }
        return el;
    }
    public void printAll() { 
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
             System.out.print(tmp.info + " ");
        System.out.println();
    }
    // My Methods
    public void printReverse() { 
        for (DLLNode<T> tmp = tail; tmp != null; tmp = tmp.prev)
             System.out.print(tmp.info + " ");
        System.out.println();
    }
    public void delete7() {
    	if (isEmpty()) return;
    	if (head == tail) {
    		setToNull(); // Don't have to get into the loop if there's one element only
    		return;
    	} 
    	int count = 1;
    	DLLNode<T> tmp = head;
    	boolean forward = true;
    	while (count < 7) {
    		count++;
    		// toggle forward if needed
    		if (forward && tmp.next == null)  
    			forward = false;
    		 else if (!forward && tmp.prev == null)
    			 forward = true;
    		// End Of Toggling
    		if (forward) 
    			tmp = tmp.next;
    		else 
    			tmp = tmp.prev;
    	}
    	// Deleting the element; Finally :)
    	if (tmp == head) 
    		deleteFromHead();
    	else if (tmp == tail) 
    		deleteFromTail();
    	else {
    		tmp.prev.next = tmp.next;  
        	tmp.next.prev = tmp.prev; 
    	}
    	
    	
    }
    public void insertAlternate(DLL<T> newList)  {
    	if (this.isEmpty()) {
    		System.out.println("The list is empty. You must have two unempty lists with the same length to combine them alternately.");
    		return;
    	}
    	if (this.length() != newList.length()) {
    		System.out.println("The lists have Different lengths. They must have the same length");
    		return;
    	}
    	DLLNode<T> tmp = head;
    	DLLNode<T> tmpN = newList.head;
    	while (tmpN != null) {
    		tmp.next = new DLLNode<T>(tmpN.info, tmp.next, tmp);
    		tmp = tmp.next;
    		if (tmp.next != null)
    			tmp.next.prev = tmp;
    		else 
    			tail = tmp;
    		tmpN = tmpN.next;
    		tmp = tmp.next;
    	}
    }
    public int length() {
    	if (isEmpty()) return 0;
    	int count = 0;
    	for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
    		count++;
    	return count;
    }
    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp == null)
             return null;
        else return tmp.info;
    }
}