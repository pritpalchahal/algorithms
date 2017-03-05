import static java.lang.System.out;

import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;

public class HackerRank {
	
	static BST tree;
	public static void main(String[] args){
//		String regex = "[a-z0-9-?]+";
//		String regex = "^[a-z0-9](?=[a-z0-9]+[-]?[a-z0-9]*$)[a-z0-9-]+$";
		String regex = "^[a-z][a-z]*[.]?[a-z]*";
		
		String hostName = "google.com..";
		String[] vals = hostName.split("\\.",2);
		System.out.println(vals[0]+" "+vals[1]);
		
		Pattern p = Pattern.compile(regex);
		boolean r = p.matches(regex, vals[1]);
		System.out.println(r);
		
//		int[] a = new int[]{1,2,2,1,1,3,5,1,2};
//		int[] b = new int[]{36,72};
//		
//		Print(DivisibleSumPairs.GetSockPairs(a));
//		Print(DivisibleSumPairs.GetCount(a, 3));
		
//		a = new int[]{2,3,6};
//		b = new int[]{42,84};
//		Print(BetweenTwoSets.GetCount(a, b));
		
//		tree = new BST();
		
		//Insert(15);
//		unbal_insert();
		
//		tree.byLevel(tree.root);
//		Print();
//		tree.printTree(tree.root);
//		Print();
//		tree.postorder();
//		Print();
//		Print(tree.isBalanced());
//		Print();
//		tree.Display();
//		tree.balancedInsert(6);
//		tree.Display();
//		Print();
//		System.out.println(tree.lca(tree.root,23, 30).data);
//		tree.top_view();
		
//		MyIterator iterator = (MyIterator) tree.iterator();
//		while(iterator.hasNext()){
//			Print(iterator.next().toString());
//		}
		//Print(tree.height());
	}
	
	private static void Insert(int length){
		final int[] ints = new Random().ints(1, 50).distinct().limit(length).toArray();
		for(int i : ints){
			Print(i);
		}
		Print();
		for(int i : ints){
//			tree.insert(i);
			tree.balancedInsert(i);
		}
	}
	
	private static void bal_insert(){
		tree.insert(5);
		tree.insert(3);
		tree.insert(4);
		tree.insert(1);
		tree.insert(7);
		tree.insert(6);
		tree.insert(9);
	}
	
	private static void unbal_insert(){
		tree.balancedInsert(3);
		tree.balancedInsert(2);
		tree.balancedInsert(4);
		tree.balancedInsert(5);
//		tree.balancedInsert(23);
//		tree.balancedInsert(15);
//		tree.balancedInsert(17);
//		tree.balancedInsert(4);
//		tree.balancedInsert(46);
//		tree.balancedInsert(42);
	}
	
	private static <T extends Comparable<T>> void Print(T msg){
		out.printf(msg.toString()+" ");
	}
	
	private static void Print(){
		out.println();
	}
}
