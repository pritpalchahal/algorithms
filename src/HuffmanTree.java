
public class HuffmanTree {

	public static <T extends Comparable<T>> void decode( String code, Node<T> node){
		char[] vals = code.toCharArray();
		Node<T> tmp = node;
		
		for(char c : vals){
			if(c == '1'){
				//go right
				if(tmp.isLeafNode()){
					System.out.print(node.data);
					tmp = node;
					continue;
				}
				tmp = node.right;
			}
			else if(c == '0'){
				//go left
				if(tmp.isLeafNode()){
					System.out.print(node.data);
					tmp = node;
					continue;
				}
				tmp = node.left;
			}
		}
	}
}
