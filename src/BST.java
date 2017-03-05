import java.awt.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BST<T extends Comparable<T>> implements Iterable<T> {
	public Node<T> root;
	private Comparator<T> comparator;
	
	public BST(){
		root = null;
		comparator = null;
	}
	
	private int Compare(T x, T y){
		if(comparator == null) {
			return x.compareTo(y);
		}
		return comparator.compare(x, y);
	}
	
	public void Balance(){
		Balance(root);
	}
	
	private void Balance(Node<T> node){
		if(node == null) return;
		
		if(isBalanced(node)) return;
		
		int left = height(node.left);
		int right = height(node.right);
		
		if(left > right) rotateRight(node);
		else rotateLeft(node);
	}
	
	private Node<T> rotateRight(Node<T> node){
		Node<T> result = node.left;
		node.left = result.right;
		result.right = node;
		return result;
	}
	
	private Node<T> rotateLeft(Node<T> node){
		Node<T> result = node.right;
		node.right = result.left;
		result.left = node;
		return result;
	}
	
	private Node<T> doubleRotateRight(Node<T> node){
		node.left = rotateLeft(node.left);
		return rotateRight(node);
	}
	
	private Node<T> doubleRotateLeft(Node<T> node){
		node.right = rotateRight(node.right);
		return rotateLeft(node);
	}
	
	public void balancedInsert(T data){
		root = balancedInsert(data,root);
	}
	
	private Node<T> balancedInsert(T data, Node<T> node){
		if(node == null){
			node = new Node(data);
			return node;
		}
		
		if(Compare(node.data,data) == 0){
			return node;
		}
		//insert either in left or right subtree
		if(Compare(data,node.data) < 0){
			node.left = balancedInsert(data,node.left);
			if(height(node.left) - height(node.right) == 2){
				if(Compare(data,node.left.data) < 0){
					node = rotateRight(node);
				}
				else{
					node = doubleRotateRight(node);
				}
			}
		}
		else{
			node.right = balancedInsert(data,node.right);
			if(height(node.right) - height(node.left) == 2){
				if(Compare(data,node.right.data) > 0){
					node = rotateLeft(node);
				}
				else{
					node = doubleRotateLeft(node);
				}
			}
		}
		
		return node;
		
	}
	
	//***************** insert ****************//
	public void insert(T data){
		root = insert(data,root);
	}
	
	//add to BST
	private Node<T> insert(T data, Node<T> node){
		if(node == null){
			return new Node(data);
		}
		
		if(Compare(node.data,data) == 0){
			return node;
		}
		
		//insert either in left or right subtree
		if(Compare(data,node.data) < 0){
			node.left = insert(data,node.left);
		}
		else{
			node.right = insert(data,node.right);
		}
		
		return node;
	}
	
	//******************* traversal *******************//
	public void preorder(){
		preorder(root);
	}
	
	private void preorder(Node<T> node){
		if(node != null){
			System.out.printf("%d ", node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}
	public void inorder(){
		inorder(root);
	}
	
	private void inorder(Node<T> node){
		if(node != null){
			inorder(node.left);
			System.out.printf("%d ", node.data);
			inorder(node.right);
		}
	}
	public void postorder(){
		postorder(root);
	}
	
	private void postorder(Node<T> node){
		if(node != null){
			postorder(node.left);
			postorder(node.right);
			System.out.printf("%d ", node.data);
		}
	}
	
	public void top_view(){
		top_view(root);
	}

	//top view of BST
	void top_view(Node<T> node){
		if(node == null){
			return;
		}
		Map<Integer,T> set = new TreeMap<Integer,T>();
		Queue<QueueItem> Q = new LinkedList<QueueItem>();
		Q.add(new QueueItem(node,0));
		
		while(!Q.isEmpty()){
			QueueItem qi = Q.remove();
			int hd = qi.hd;
			Node<T> nd = qi.node;
			
			if(!set.containsKey(hd)){
				set.put(hd, nd.data);
			}
			
			if(nd.left != null){
				Q.add(new QueueItem(nd.left,hd-1));
			}
			if(nd.right != null){
				Q.add(new QueueItem(nd.right,hd+1));
			}
		}
		for(Map.Entry<Integer, T> value : set.entrySet()){
			System.out.printf("%d ", value.getValue());
		}
	}
	
	public class QueueItem{
		Node<T> node;
		int hd;
		public QueueItem(Node<T> node, int hd){
			this.node = node;
			this.hd = hd;
		}
	}
	
	public int height(){
		return height(root);
	}
	
	private int height(Node root){
		if(root == null) return -1;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public boolean isBalanced(){
		return isBalanced(root);
	}
	
	private boolean isBalanced(Node<T> node){
		if(node == null) return true;
		
		int left = height(node.left);
		int right = height(node.right);
		
		if(Math.abs(left-right) > 1){
			return false;
		}
		
		return true;
	}
	
	public void Print(){
		Print(root,5);
	}
	
	private void Print(Node<T> node, int level){
		if(node != null){
			PrintSpace(level * 4);
			System.out.printf("%d ", node.data);
			Print(node.left,level+1);
			Print(node.right,level+1);
		}
	}
	
	void PrintSpace(int n)
	{
		System.out.println();
		for (int i = 0; i < n; ++i){
			System.out.print(" ");
		}
	}
	
	void Display(){
		DisplayTree.display(root);
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(this);
	}
	
	public void byLevel(Node<T> root){
	     Queue<Node<T>> level  = new LinkedList<>();
	     level.add(root);
	     while(!level.isEmpty()){
	         Node<T> node = level.poll();
	         System.out.print(node.data + " ");
	         if(node.left!= null)
	         level.add(node.left);
	         if(node.right!= null)
	         level.add(node.right);
	     }
	}
	
	public void printTree(Node<T> tmpRoot) {

        Queue<Node<T>> currentLevel = new LinkedList<Node<T>>();
        Queue<Node<T>> nextLevel = new LinkedList<Node<T>>();

        currentLevel.add(tmpRoot);
        int count = 1;
        while (!currentLevel.isEmpty()) {
            Iterator<Node<T>> iter = currentLevel.iterator();
            while (iter.hasNext()) {
            	PrintSpace(count * 5 * currentLevel.size());
                Node<T> currentNode = iter.next();
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node<T>>();
            count++;
        }
    }
	
	//lowest common ancestor
	public Node<T> lca(Node<T> node, T v1, T v2){
		if(node == null) return null;
		
		T data = node.data;
		
		if((Compare(data,v1) == 0) || (Compare(data,v2) == 0)){
			return node;
		}
		
		Node<T> left = lca(node.left,v1,v2);
		Node<T> right = lca(node.right,v1,v2);
		
		if(left==null && right==null) return null;
		else if(left != null && right != null) return node;
		else return left==null?right:left;
		
//		if((Compare(data,v1) > 0) && (Compare(data,v2) < 0)){
//			return node;
//		}
//		if((Compare(data,v1) < 0)){
//			return lca(node.right,v1,v2);
//		}
//		else{
//			return lca(node.left,v1,v2);
//		}
	}
}
