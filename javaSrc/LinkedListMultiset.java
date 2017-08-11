import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
	// changes made s3243720
    // Go to make changes soon
	protected Node mHead;
		protected int mLength
{
	public LinkedListMultiset(){
		// Implement me!
	 // end of LinkedListMultiset()
		 mHead = null;
		 mLength = 0;
		)
	public void add(T item) (
			Node newNode = new Node((String) item);
		if (mHead == null)
		mHead = newNode;
		else {
		Node currNode = mHead;
		Node parentNode = null;
		while (currNode != null) {
		if (currNode.getValue().
		equals(newNode.getValue())) {
		currNode.addCounter();
		return;
		}
		parentNode = currNode;
		currNode = currNode.getNext();
		}
		parentNode.setNext(newNode);
		}
		mLength++;
		}
	
	public int search(T item) {
		Node currNode = mHead;

		while (currNode != null){
		if(currNode.getValue().equals((String)item)){
		return currNode.getCounter();
		}
		currNode=currNode.getNext();
		}

		return 0;
		}

public void removeOne(T item) {
		Node currNode = mHead;
		Node lastNode = null;

		while (currNode != null) {
		if (currNode.getValue().equals((String) item)) {
		currNode.minusCounter();
		if (currNode.getCounter() == 0) {
		if (currNode == mHead)
		mHead = currNode.getNext();
		else
		lastNode.setNext
		(currNode.getNext());
		mLength--;
		}
		return;
		}
		lastNode = currNode;
		currNode = currNode.getNext();
		}
		}
	public void removeAll(T item) {
		Node currNode = mHead;
		Node lastNode = null;

		while (currNode != null) {
		if (currNode.getValue().equals((String) item)) {
		if (currNode == mHead)
		mHead = currNode.getNext();
		else
		lastNode.setNext(currNode.getNext());
		mLength--;
		return;
		}
		lastNode = currNode;
		currNode = currNode.getNext();
		}
		}
	
	public void print(PrintStream out)  Node currNode = mHead;

		while (currNode != null) {
		out.printf("%s | %d\n", currNode.getValue()
		, currNode.getCounter());
		currNode = currNode.getNext();
		}
		}
private class Node {
	protected String mValue;
	protected Node mNext;

	int counter;

	public Node(String value) {
		mValue = value;
		mNext = null;
		counter = 1;
	}

	public void addCounter() {
		counter++;
	}

	public void minusCounter() {
		counter--;
	}

	public int getCounter() {
		return counter;
	}

	public String getValue() {
		return mValue;
	}

	public Node getNext() {
		return mNext;
	}

	public void setValue(String value) {
		mValue = value;
	}

	public void setNext(Node next) {
		mNext = next;
	}
	
} // end of class LinkedListMultiset