import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DivisibleSumPairs {
	
	public static int GetCount(int[] a, int k){
//		Set<Integer> set = new HashSet<Integer>();
//		for(int i : a){set.add(i);}
//		
//		Integer[] arr = set.toArray(new Integer[0]);
//		for(int i : arr) System.out.printf("%d ", i); print();
//		int n = arr.length;
		int n = a.length;
		
		int count = 0;
		for(int i = 0;i<n;i++){
			for(int j=i+1;j<n;j++){
				int x = a[i];
				int y = a[j];
				if((x+y) % k == 0) count++;
			}
		}
		return count;
	}
	
	public static int GetSockPairs(int[] a){
		int n = a.length;
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			int b = a[i];
			if(list.contains(b)){
				list.remove(list.indexOf(b));
				count++;
			}
			else list.add(b);
		}
		return count;
	}
	
	private static void print(){
		out.println();
	}

}
