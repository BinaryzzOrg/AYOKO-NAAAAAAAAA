package temp;

public class Node {
	// class field
	private int value;
	private int key;
	private Node next;

	public Node(int data, int key) {
		this.value = data;
		this.key = key;
		this.next = null;
	}// end method

	public int getData() {
		return value;
	}// end method

	public void setData(int data) {
		this.value = data;
	}// end method

	public int getKey() {
		return key;
	}// end method

	public void setKey(int key) {
		this.key = key;
	}// end method

	public Node getNext() {
		return next;
	}// end method

	public void setNext(Node next) {
		this.next = next;
	}// end method

}// end method
