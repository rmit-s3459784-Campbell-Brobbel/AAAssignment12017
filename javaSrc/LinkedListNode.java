import sun.awt.image.ImageWatched;

/**
 * Created by campbellbrobbel on 14/8/17.
 */
public class LinkedListNode {

    private static int totalNodesInList = 0;
    private String value;
    private LinkedListNode prevNode;
    private LinkedListNode nextNode;
    private int appearancesInList;

    public LinkedListNode(String value) {
        this.value = value;
        this.prevNode = null;
        this.nextNode = null;
        this.appearancesInList = 1;
        totalNodesInList++;
    }
    public LinkedListNode(String value, LinkedListNode prevNode) {
        this.value = value;
        this.prevNode = prevNode;
        this.nextNode = null;
        this.appearancesInList = 1;
        totalNodesInList++;
    }

    public String getValue() {
        return value;
    }

    public LinkedListNode getNextNode() {
        return nextNode;
    }

    public LinkedListNode getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(LinkedListNode prevNode) {
        this.prevNode = prevNode;
    }

    public void addListAppearance() {
        this.appearancesInList++;
    }

    public void removeListAppearance() {
        this.appearancesInList--;
    }

    public int getAppearancesInList() {
        return appearancesInList;
    }

    public void setNextNode(LinkedListNode node) {
        this.nextNode = node;
    }

    public int getTotalNodesInList() {
        return totalNodesInList;
    }
}
