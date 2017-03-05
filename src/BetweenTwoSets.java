import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BetweenTwoSets {
	public static int GetCount(int[] a, int[] b){
		int n = a.length;
		int m = b.length;
		
		if(n == 0 || m == 0) return 0;
		
		Arrays.sort(a);
		Arrays.sort(b);

		for(int i: a) System.out.printf("%d ", i); Print();
		for(int i: b) System.out.printf("%d ", i); Print();
		
		ArrayList<Integer> list = factors(gcd(b));
		
		HashMap<Integer,ArrayList<Integer>> map = new HashMap();
		
		for(int i : list){
			map.put(i, factors(i));
		}
		
		int count = 0;
		for(int i : a){
			if(map.containsKey(i)){
				count++;
			}
		}
		
		int result = 0;
		if(count == n){
			for(ArrayList<Integer> set : map.values()){
				int tmp_count = 0;
				for(int i : a){
					if(set.contains(i)) tmp_count++;
				}
				if(tmp_count == n) result++;
			}
			return result;
		}
		else{
			return 0;
		}
	}
	
	static ArrayList<Integer> factors(int number){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=number; i++){
			if(number % i == 0){
				System.out.printf("%d ", i);
				list.add(i);
			}
		}
		Print();
		return list;
	}
	
	static int gcd(int a, int b)
	{
	    while (b > 0)
	    {
	    	int temp = b;
	        b = a % b;
	        a = temp;
	    }
	    return a;
	}

	static int gcd(int[] input)
	{
		int result = input[0];
	    for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
	    return result;
	}
	
	private static void Print(){
		out.println();
	}
}
