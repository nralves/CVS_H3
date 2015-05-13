import java.util.Iterator;

public class LinkedList<T> {
	
	private Node<T> head, tail;
	private int nodeNumber;
	
	public LinkedList(){
		
		head = null;
		tail = null;
		nodeNumber = 0;
		
	}
	
	
	//Adds node to tail
	public void addNode(T value){
		Node<T> newNode = new Node<T>(value);
		
		if(head==null){
			head = newNode;
			tail = newNode;
			
			tail.setNext(null);
			tail.setPrevious(null);
			
			nodeNumber++;
		}
		else{
			
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			newNode.setNext(null);
			tail = newNode;
			
			nodeNumber++;
			
		}
		
	}
	
	public int removeNode(T valueToRemove){
		
		Node<T> nodeToRemove = null;
		Iterator<Node<T>> it = this.iteratorNodes();
		while(it.hasNext()){
			
			Node<T> tmp = it.next();
			if(tmp.getValue() == valueToRemove){
				nodeToRemove = tmp;
			}
		}
	
		
		//Case empty list
		if(nodeNumber == 0 || nodeToRemove == null)
			return -1;
		
		//Case 1 element
		else if(nodeNumber == 1){
			head = null;
			tail = null;
			
			nodeNumber--;
			return 1;
		}
		
		//case tail
		
		else if(nodeToRemove == tail){//compares reference to same object?
			tail = tail.getPrevious();
			tail.getNext().setPrevious(null);
			tail.setNext(null);
			
			nodeNumber--;
			return 1;
			
		}
		
		//case head
		else if(nodeToRemove == head){
			
			head = head.getNext();
			head.getPrevious().setNext(null);
			head.setPrevious(null);
			
			nodeNumber--;
			return 1;
		}
		
		else{
			
			nodeToRemove.getNext().setPrevious(nodeToRemove.getPrevious());
			nodeToRemove.getPrevious().setNext(nodeToRemove.getNext());
			nodeToRemove.setNext(null);
			nodeToRemove.setPrevious(null);

			nodeNumber--;
			return 1;
		}
		
	}
	
	public Iterator<T> iterator(){
		
		Iterator<T> it = new Iterator<T>() {

            int currentIndex = 0;
            int originalNodeNumber = nodeNumber;//Case removes node during iterator
            Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
            	
            	if(currentIndex >= originalNodeNumber || originalNodeNumber == 0)
            		return false;
            	else
            		return true;
            	
            }

            @Override
            public T next() {
            	currentIndex++;
            	T toReturn = currentNode.getValue();
            	
            	if(this.hasNext())
            		currentNode = currentNode.getNext();
            	
            	return toReturn;
                
            }
        };
        
        return it;
		
	}
	
	
private Iterator<Node<T>> iteratorNodes(){
		
		Iterator<Node<T>> it = new Iterator<Node<T>>() {

            int currentIndex = 0;
            Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
            	
            	if(currentIndex >= nodeNumber || nodeNumber == 0)
            		return false;
            	else
            		return true;
            	
            }

            @Override
            public Node<T> next() {
            	currentIndex++;
            	Node<T> toReturn = currentNode;
            	
            	if(this.hasNext())
            		currentNode = currentNode.getNext();
            	
            	return toReturn;
                
            }
        };
        
        return it;
		
	}

}
