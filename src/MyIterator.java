import java.util.Iterator;
import java.util.Stack;

public class MyIterator<T> implements Iterator<T>{
	private Stack<Node<T>> stack = new Stack<Node<T>>();
	
	public MyIterator(BST tree){
		if(tree.root != null){
			stack.push(tree.root);
		}
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	//pre-order traversal
	@Override
    public T next()
    {
       Node<T> cur = stack.peek();
       if(cur.left != null)
       {
    	   stack.push(cur.left);
       }
       else
       {
          Node<T> tmp = stack.pop();
          while( tmp.right == null )
          {
             if(stack.isEmpty()) return cur.data;
             tmp = stack.pop();
          }
          stack.push(tmp.right);
       }
       return cur.data;
    }

}
