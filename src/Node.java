
public class Node<T> {
	T data;
	Node<T> left;
	Node<T> right;
	
	public Node(T data){
		this(data,null,null);
	}
	
	public Node(T data,Node<T> left, Node<T> right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public boolean isLeafNode(){
		if(this.left == null && this.right == null) return true;
		return false;
	}
	
	public String toString(){
		return this.data.toString();
	}
}
