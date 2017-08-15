import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by campbellbrobbel on 15/8/17.
 */
public class SortedLinkedListMultisetTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void addNodeTest() {

        SortedLinkedListMultiset<String> multiset = new SortedLinkedListMultiset<String>();

        multiset.add("Apple");
        multiset.add("Balt");
        multiset.add("Carrot");
        multiset.add("Banana");

        if (multiset.headNode != null) {
            LinkedListNode node = multiset.headNode;

            while (node.getNextNode() != null) {
                System.out.println(node.getValue());
                if (node.getNextNode() != null) {
                    assertTrue(node.getValue().compareTo(node.getNextNode().getValue()) < 0);
                }
                node = node.getNextNode();


            }
        }


    }

    @Test
    public void testSearch() {

        SortedLinkedListMultiset<String> multiset = new SortedLinkedListMultiset<String>();
        System.out.println("Step 1");
        multiset.add("shoe");
        System.out.println("Step 2");
        multiset.add("shoe");
        System.out.println("Step 3");
        multiset.add("foot");
        System.out.println("Step 4");
        multiset.add("shoe");
        System.out.println("Step 5");
        multiset.add("cream");
        System.out.println("Step 6");
        multiset.removeAll("shoe");
        System.out.println("Step 7");
        System.out.println(multiset.search("shoe"));
        System.out.println("Step 8");
        multiset.add("shoe");
        System.out.println("Step 9");
        multiset.add("foot");
        System.out.println("Step 10");
        multiset.removeAll("foot");
        System.out.println("Step 11");
        multiset.removeAll("foot");
        System.out.println("Step 12");
        multiset.removeOne("foot");






        multiset.removeOne("fortune");
        multiset.printAllNodesFrom(multiset.headNode, null);


    }
}