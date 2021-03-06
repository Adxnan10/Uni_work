//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class SLL<T> {
    protected SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }
    public T deleteFromHead() { // delete the head and return its info; 
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
             head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
             head = tail = null;
        else {                  // if more than one node in the list,
             SLLNode<T> tmp;    // find the predecessor of tail;
             for (tmp = head; tmp.next != tail; tmp = tmp.next);
             tail = tmp;        // the predecessor of tail becomes tail;
             tail.next = null;
        }
        return el;
    }
    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                 head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                 head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                 SLLNode<T> pred, tmp;// and el is in a nonhead node;
                 for (pred = head, tmp = head.next;  
                      tmp != null && !tmp.info.equals(el); 
                      pred = pred.next, tmp = tmp.next);
                 if (tmp != null) {   // if el was found;
                     pred.next = tmp.next;
                     if (tmp == tail) // if el is in the last node;
                        tail = pred;
                 }
            }
    }
    
    // My Methods
    public int length() {
    	int len = 0;
    	for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
    		len++;
    	return len;
    }
    public void insertBefore(T newElem, T existingElem) {
    	if(isEmpty()) {
    		System.out.println("The list is empty. Insertion Failed.");	
    	} else if (head == tail) { // one element in the list
    		if (head.info.equals(existingElem)) {
    			tail = head;
    			head = new SLLNode<T>(newElem, head);
    		} else {
    			System.out.println(existingElem + " does not exist. Insertion Failed.");
    		}
    	} else if (head.info.equals(existingElem)) { // If the element is found in the head
			head = new SLLNode<T>(newElem, head);
		} else {
    		SLLNode<T> before = head, tmp = head.next;
    		while (tmp != null && !tmp.info.equals(existingElem)) {
    				before = before.next;
        			tmp = tmp.next;    			
    		}
    		if (tmp == null) {
    			System.out.println(existingElem + " does not exist. Insertion Failed.");
    			return;
    		}
    			before.next = new SLLNode<T>(newElem, tmp);
    	}
    	
    }
    public void insertAfter(T newElem, T existingElem) {
    	if(isEmpty()) {
    		System.out.println("The list is empty. Insertion Failed.");	
    	} else if (head == tail) { // one element in the list
    		if (head.info.equals(existingElem)) {
    			head.next = new SLLNode<T>(newElem);
    			tail = head.next;
    		} else {
    			System.out.println(existingElem + " does not exist. Insertion Failed.");
    		}
		} else {
    		SLLNode<T> tmp = head;
    		
    		while (tmp != null && !tmp.info.equals(existingElem)) {
    			tmp = tmp.next;
    		}
    		if (tmp == null) {
    			System.out.println(existingElem + " does not exist. Insertion Failed.");
    			return;
    		}
    		if (tmp == tail) { // If the element is found in the tail
    			tmp.next = new SLLNode<T>(newElem, null);
    			tail = tmp.next;
    			return;
    		}
    			tmp.next = new SLLNode<T>(newElem, tmp.next);
    	}
    	
    }
    public void deleteBefore(T existingElem) {
    	if (!isEmpty())
            if ((head == tail && existingElem.equals(head.info)) || existingElem.equals(head.info)) { // if there's only one node in the list or if the element is found in head
                 System.out.println("There's No Element before " + existingElem + ". Nothing was deleted.");
             }                 
            else { // if more than one node in the list
            	
            	SLLNode<T> beforeB = null, before = head, tmp = head.next;
        		while (tmp != null && !tmp.info.equals(existingElem)) {
        			beforeB = before;
        			before = before.next;
            		tmp = tmp.next;    			
        		}
        		if (tmp == null) {
        			System.out.println(existingElem + " does not exist. Nothing was deleted.");
        			return;
        		} if (beforeB != null ) { // entered the loop || the element after head != Existing Element
        			beforeB.next = tmp;
        			before = null;
        		} else { // Existing Element == the element after head. So, Delete the head.
        			head = tmp;
        			before = null;
        		}	
            }
    }
    public void deleteAfter(T existingElem) {
    	if (!isEmpty())
            if ((head == tail && existingElem.equals(head.info)) || existingElem.equals(tail.info)) // if there's only one node in the list or if the element is found in tail
                 System.out.println("There's No Element After " + existingElem + ". Nothing was deleted.");
            else {  // if more than one node in the list
            	SLLNode<T> tmp = head;
        		
        		while (tmp != null && !tmp.info.equals(existingElem)) {
        			tmp = tmp.next;
        		}
        		if (tmp == null) {
        			System.out.println(existingElem + " does not exist. Nothing was deleted.");
        			return;
        		}
        		if (tmp.next == tail) {
        			tmp.next = null;
        			tail = tmp;
        		} else {
        			tmp.next = tmp.next.next;
        		}
            }
    	else 
    		System.out.println("The list is empty. Nothing was deleted.");
    }
    public void printAll() {
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info + " ");   
	System.out.println();             
    }
    public boolean isInList(T el) {
        SLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        return tmp != null;
    }
}
