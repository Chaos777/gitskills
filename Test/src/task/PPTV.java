package task;

public class PPTV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		head.nextNode = node1;
		node1.nextNode = node2;
		node2.nextNode = node3;
		node3.nextNode = node4;
		node4.nextNode = node5;
		node5.nextNode = null;
		
		Node cNode = function(head);
		while(cNode.nextNode!=null){
			System.out.print(cNode.value+" ");
			cNode = cNode.nextNode;
		}
		System.out.println();
		String str = "aabbaaccd";
		function(str);
	}
	
	public static Node function(Node head){
		if(head==null){
			System.out.println(" ‰»Î”–ŒÛ£°");
			return null;
		}
		Node pre = head;
		Node cur = head.nextNode;
		Node next = null;
		while(cur!=null){
			next = cur.nextNode;
			cur.nextNode = pre;
			pre = cur;
			cur = next;
		}
		head.nextNode = null;
		head = pre;
		
		return head;
		
		
	}
	
	
	/**baabbbaaccd*/
	public static void function(String str){
		int maxlength = 1;
		int end = 0;
		int templ =1;
		
		for(int i=1;i<str.length();i++){
			
			if(str.charAt(i)==str.charAt(i-1)){
				templ++;
				
			}
			else{
				if(templ>maxlength){
					maxlength = templ;	
					end=i;
				}
				
				templ = 1;
			}
		}
		
		System.out.println(str.substring(end-maxlength, end));
	}

}


class Node{
	Node nextNode;
	int value;
	
	public Node(int val){
		this.value = val;
		nextNode = null;
	}
	
}