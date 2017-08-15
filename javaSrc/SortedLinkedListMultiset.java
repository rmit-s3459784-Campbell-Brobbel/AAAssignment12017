import java.io.PrintStream;
import java.util.*;

public class SortedLinkedListMultiset<T> extends Multiset<T>
{
	protected LinkedListNode headNode;

	public SortedLinkedListMultiset() {
		// Implement me
		headNode = null;
	} // end of SortedLinkedListMultiset()

	private LinkedListNode getLastNode() {

		if (headNode == null) {
			return null;

		}
		else {
			LinkedListNode lastNode = headNode;

			while (lastNode.getNextNode() != null) {
				if (lastNode.getNextNode() == null) {
					return lastNode;
				}
			}

		}
		return null;
	}
	private LinkedListNode nodeToInsert(String insertValue, LinkedListNode node) {

		 if (insertValue.compareTo(node.getValue()) > 0) {
			if (node.getNextNode() != null) {
				LinkedListNode insertNode = nodeToInsert(insertValue, node.getNextNode());
				return insertNode;
			}
			else {
				return node;
			}

		}
		else {
			return node;
		}



	}

	private boolean insertAtNode(String insertValue, LinkedListNode insertNode) {

		if (insertValue.compareTo(insertNode.getValue()) < 0) {
			if (insertNode.getPrevNode() == null) {
				insertNode.setPrevNode(new LinkedListNode(insertValue));
				insertNode.getPrevNode().setNextNode(insertNode);
				if (insertNode.getValue().equals(headNode.getValue())) {
					headNode = insertNode.getPrevNode();
				}

				return true;
			}
			else {
				LinkedListNode newNode = new LinkedListNode(insertValue, insertNode.getPrevNode());
				newNode.setNextNode(insertNode);
				insertNode.setPrevNode(newNode);
				newNode.getPrevNode().setNextNode(newNode);

				return true;
			}
		}
		else {
			if (insertValue.equals(insertNode.getValue())) {
				insertNode.addListAppearance();
				return true;
			}
			if (insertNode.getNextNode() == null) {

				insertNode.setNextNode(new LinkedListNode(insertValue, insertNode));
				insertNode.getNextNode().setPrevNode(insertNode);

				return true;
			}
			else {
				LinkedListNode newNode = new LinkedListNode(insertValue, insertNode);
				newNode.setNextNode(insertNode.getNextNode());
				insertNode.setNextNode(newNode);
				newNode.getNextNode().setPrevNode(newNode);
				return true;
			}
		}

	}
	
	public void add(T item) {
		// Implement me!

		String itemString = (String)item;
		LinkedListNode insertNode;
		if (headNode == null) {
			headNode = new LinkedListNode(itemString);

		}
		else {
			insertNode = nodeToInsert(itemString, headNode);
			if (insertNode != null) {
				insertAtNode(itemString, insertNode);
			}
			else {

			}
		}

	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		

		LinkedListNode comparisonNode;
		String itemString = (String)item;
		if (headNode == null) {
			return 0;
		}
		else {
			comparisonNode = headNode;
			if (comparisonNode.getValue().equals(itemString)) {
				return comparisonNode.getAppearancesInList();
			}
			while (comparisonNode.getNextNode() != null) {
				comparisonNode = comparisonNode.getNextNode();
				if (comparisonNode.getValue().equals(itemString)) {
					return comparisonNode.getAppearancesInList();
				}
			}
		}
		// default return, please override when you implement this method
		return 0;
	} // end of add()
	
	
	public void removeOne(T item) {
		// Implement me!
		LinkedListNode comparisonNode;
		String itemString = (String)item;

		if (headNode == null) {
			return;
		}
		else {
			comparisonNode = headNode;

			while (comparisonNode.getNextNode() != null) {
				if (comparisonNode.getValue().equals(itemString)) {
					if (comparisonNode.getAppearancesInList() <= 1) {
						if (comparisonNode.getPrevNode() != null) {
							comparisonNode.getPrevNode().setNextNode(comparisonNode.getNextNode());

						}
						else {
							headNode = comparisonNode.getNextNode();
						}
						if (comparisonNode.getNextNode() != null) {
							comparisonNode.getNextNode().setPrevNode(comparisonNode.getPrevNode());
						}
					}
					else {
						comparisonNode.removeListAppearance();
					}
				}
				comparisonNode = comparisonNode.getNextNode();
			}
		}

	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
		LinkedListNode comparisonNode;
		String itemString = (String)item;

		if (headNode == null) {
			return;
		}
		else {
			comparisonNode = headNode;

			do {
				if (comparisonNode.getValue().equals(itemString)) {
						if (comparisonNode.getNextNode() != null) {
							comparisonNode.getNextNode().setPrevNode(comparisonNode.getPrevNode());
						}
						else {

						}
						if (comparisonNode.getPrevNode() != null) {
							comparisonNode.getPrevNode().setNextNode(comparisonNode.getNextNode());
						}
						else {
							headNode = comparisonNode.getNextNode();
						}
						break;
				}
				if (comparisonNode.getNextNode() != null) {
					comparisonNode = comparisonNode.getNextNode();

				}
				else {
					return;
				}
			} while (comparisonNode != null);
		}
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		// Implement me!
		printAllNodesFrom(headNode, out);
	} // end of print()
	public void printAllNodesFrom(LinkedListNode headNode, PrintStream out) {

		if (headNode == null) {
			return;
		}
		System.out.println(headNode.getValue() + printDelim + headNode.getAppearancesInList());
		//out.println(headNode.getValue() + printDelim + headNode.getAppearancesInList());
		printAllNodesFrom(headNode.getNextNode(), out);
	}
//	public void printAllNodesFrom(LinkedListNode headNode) {
//		if (headNode == null) {
//			return;
//		}
////		System.out.println(headNode.getValue() + printDelim + headNode.getAppearancesInList());
////		System.out.println(headNode.getValue() + printDelim + this.search((T)headNode.getValue()));
//
//		printAllNodesFrom(headNode.getNextNode());
//
//	}
} // end of class SortedLinkedListMultiset