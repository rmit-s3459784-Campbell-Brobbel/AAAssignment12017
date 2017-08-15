import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>{
        // changes made s3243720
        // Go to make changes soon
        protected Node mHead;
        protected int mLength;

   // define the head and the length of the linkedlist
public LinkedListMultiset(){
        // Implement me!
        // end of LinkedListMultiset()
        mHead=null;
        mLength=0;
        }
public void add(T item){
        // Create a new node object with intial head and length
        Node newNode=new Node((String)item);
        if(mHead==null)
        mHead=newNode;
        else{
        Node currentNode=mHead;
        Node parentNode=null;
        while(currentNode!=null){
        if(currentNode.getValue().
        equals(newNode.getValue())){
        currentNode.addCounter();
        return;
        }
        parentNode=currentNode;
        currentNode=currentNode.getNext();
        }
        parentNode.setNext(newNode);
        }
        mLength++;
}

public int search(T item){
        Node currentNode = mHead;

        while(currentNode!=null){
        if(currentNode.getValue().equals((String)item)){
        return currentNode.getCounter();
        }
        currentNode=currentNode.getNext();
        }

        return 0;
        }

public void removeOne(T item){
        Node currentNode=mHead;
        Node lastNode=null;

        while(currentNode!=null){
        if(currentNode.getValue().equals((String)item)){
        currentNode.minusCounter();
        if(currentNode.getCounter()==0){
        if(currentNode==mHead)
        mHead=currentNode.getNext();
        else lastNode.setNext
        (currentNode.getNext());
        mLength--;
        }
        return;
        }
        lastNode=currentNode;
        currentNode=currentNode.getNext();
        }
        }
public void removeAll(T item){
            Node currentNode=mHead;
            Node lastNode=null;

            while(currentNode!=null){
            if(currentNode.getValue().equals((String)item)){
            if(currentNode==mHead)
            mHead=currentNode.getNext();
            else lastNode.setNext(currentNode.getNext());
            mLength--;
            return;
            }
            lastNode=currentNode;
            currentNode=currentNode.getNext();
            }
            }

public void print(PrintStream out){
        Node currentNode=mHead;

        while(currentNode!=null){
        out.printf("%s | %d\n",currentNode.getValue()
        ,currentNode.getCounter());
        currentNode=currentNode.getNext();
        }
        }
// creating and inner private class to Node
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