
public class Node<T> {
	
	private T value;
	private Node<T> nextNode;
	private Node<T> previousNode;
	
	
	//Construtor
	public Node(T value){
		nextNode = null;
		previousNode = null;
		
		this.setValue(value);
	}
	
	//Returns Next Node
	public Node<T> getNext(){
		return nextNode;
	}
	
	
	//Sets Next Node
	public void setNext(Node<T> next){
		
		this.nextNode = next;
		
	}
	
	//Returns Previous Node
	public Node<T> getPrevious(){
		return previousNode;
	}
	
	
	//Sets Previous Node
	public void setPrevious(Node<T> previous){
		
		this.previousNode = previous;
		
	}

	//Returns Value of Node
	public T getValue() {
		return value;
	}

	//Sets value of Node
	public void setValue(T value) {
		this.value = value;
	}
	
	

}
