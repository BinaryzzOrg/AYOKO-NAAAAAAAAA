package temp;

public class HashTable {
	// field variables
	Node[] table;
	int inputLength = 10;

	// constructor
	public HashTable() {
		int defaultSize = 17;
		int tableSize = 0;

		table = new Node[defaultSize];
	}// end constructor

	/*
	 * The Add method, ask the user to input 10x to the array of node named "table".
	 * it then calls the CheckUserInput method to handle input Errors. Next, it
	 * creates a node that contains the following: value(userInput), key. It also
	 * calls Hashcode method to get a key and HashFunction to put the node in the
	 * node array table. Lastly it prints the HashTable.
	 */
	public void Add() {
		for (int i = 0; i < inputLength; i++) {
			System.out.print("Enter a number: ");
			int value = Main.CheckUserInput("Enter a number: ");
			Node node = new Node(value, HashCode(value, table.length));

			HashFunction(node);
		} // end for

		ViewHashTable();
	}// end method

	/*
	 * The HashCode method, takes in the Following: value(userInput) and the
	 * tableLenght). This method computes the modulo and the result of that is made
	 * as key, which is then returned by the method.
	 */
	public int HashCode(int value, int tableLength) {
		int key = value % tableLength;
		return key;
	}// end method

	/*
	 * The HashFunction method, takes in a node as parameter. The if else condition
	 * first check if the current index it's has a node already in it, if it does
	 * then it calls the SeperateChaining method. Else if that current index does
	 * not contain a node, it populates it with a new node.
	 */
	public void HashFunction(Node node) {
		if (table[node.getKey()] != null) {
			SeperateChaining(node);
			return;

		} else {
			table[node.getKey()] = node;
		} // end if else
	}// end method

	/*
	 * The SeperateChaining method, takes in a node as parameter. It create a
	 * tempNode to act as "head" and iterates the linkedList, it checks if the next
	 * node is null and if it is, that next node will now be the node(userInput)
	 * that was passed in the parameter.
	 */
	public void SeperateChaining(Node node) {
		Node tempNode = table[node.getKey()];

		while (tempNode != null) {
			if (tempNode.getNext() == null) {
				tempNode.setNext(node);
				break;
			} // end if

			tempNode = tempNode.getNext();
		} // end while

	}// end method

	/*
	 * This method simply handles the printing of HashTable
	 */
	public void ViewHashTable() {
		System.out.println("\n");
		System.out.println("Key	Value ");
		for (int index = 0; index < table.length; index++) {
			if (table[index] == null) {

				System.out.println(index + "	");
			} else {
				Node node = table[index];
				System.out.print(index + "	");
				PrintNodes(node);
			} // end method
		} // end method
	}// end method

	/*
	 * This method simply handles the printing for the chained nodes
	 */
	public void PrintNodes(Node node) {

		while (node != null) {
			System.out.print(node.getData() + " -> ");
			node = node.getNext();
		} // end while
		System.out.println();
	}// end method

}// end method
