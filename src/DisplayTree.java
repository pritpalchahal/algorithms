import java.util.Stack;

public class DisplayTree {
	
	public static <T extends Comparable<T>> void display(Node<T> root)
	{
		Stack<Node<T>> globalStack = new Stack<Node<T>>();
		globalStack.push(root);	
		int emptyLeaf = 32;
		boolean isRowEmpty = false;
		System.out.println("****......................................................****");
		while(isRowEmpty==false)
		{

			Stack<Node<T>> localStack = new Stack();
			isRowEmpty = true;
			for(int j=0; j<emptyLeaf; j++)
				System.out.print(' ');
			while(globalStack.isEmpty()==false)
			{
				Node<T> temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);
					if(temp.left != null ||temp.right != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<emptyLeaf*2-2; j++)
					System.out.print(' ');
			}
			System.out.println();
			emptyLeaf /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push( localStack.pop() );
		}
	System.out.println("****......................................................****");
	} 

}
