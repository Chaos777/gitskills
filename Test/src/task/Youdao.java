package task;

import java.util.Arrays;
import java.util.Stack;

public class Youdao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "011**01*";
		function_02(str, 0);
		
		LinkedlistNode head = new LinkedlistNode(0);
		LinkedlistNode node1 = new LinkedlistNode(1);
		LinkedlistNode node2 = new LinkedlistNode(2);
		LinkedlistNode node3 = new LinkedlistNode(3);
		LinkedlistNode node4 = new LinkedlistNode(4);
		LinkedlistNode node5 = new LinkedlistNode(5);
		LinkedlistNode node6 = new LinkedlistNode(6);
		LinkedlistNode node7 = new LinkedlistNode(7);
		LinkedlistNode node8 = new LinkedlistNode(8);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = null;
		
		/*while(head!=null){
			System.out.print(head.value+" ");
			head = head.next;
		}
		
		System.out.println();*/
		
		function_01(head);
		
		
		LinkedlistNode head11 = new LinkedlistNode(1);
		LinkedlistNode head12 = new LinkedlistNode(2);
		LinkedlistNode head13 = new LinkedlistNode(3);
		LinkedlistNode head14 = new LinkedlistNode(4);
		LinkedlistNode head15 = new LinkedlistNode(5);
		LinkedlistNode head16 = new LinkedlistNode(6);
		LinkedlistNode head17 = new LinkedlistNode(7);
		
		head11.next = head12;
		head12.next = head13;
		head13.next = head14;
		head14.next = head15;
		head15.next = head16;
		head16.next = head17;
		head17.next = null;
		
		LinkedlistNode head21 = new LinkedlistNode(1);
		LinkedlistNode head22 = new LinkedlistNode(2);
		LinkedlistNode head23 = new LinkedlistNode(3);
		LinkedlistNode head24 = new LinkedlistNode(4);
		/*LinkedlistNode head25 = new LinkedlistNode(5);
		LinkedlistNode head26 = new LinkedlistNode(6);
		LinkedlistNode head27 = new LinkedlistNode(7);*/
		
		head21.next = head22;
		head22.next = head23;
		head23.next = head24;
		head24.next = /*head25;
		head25.next = head26;
		head26.next = head27;
		head27.next =*/ null;
		
		functionAdd(head11, head21);
		
		int []a = {5,4,3,2,1};
		nextPermutation(a);
		for(int i:a){
			System.out.print(i+" ");
		}
		System.out.println();
		String strq = "abcde";
		char st[] = strq.toCharArray();
		nextString(st);
		for(char s:st){
			System.out.print(s);
		}
		System.out.println();
	
	}
	
	/**
	 * 改变链表输出顺序
	 * */
	public static void function_01(LinkedlistNode head){
		if(head==null){
			System.out.println("输入有误");
			return;
		}
		
		LinkedlistNode mid = findMidNode(head);
		mid = reverse(mid);
		
		/*LinkedlistNode temp = head;
		while(temp!=null){
			System.out.print(temp.value+" ");
			temp = temp .next;
		}
		System.out.println();*/
		
		
		LinkedlistNode p1 = head.next;
		LinkedlistNode p2 = mid.next;
		
		LinkedlistNode now = head;
		now.next = mid;
		now  = mid;
		
		
		while(p1!=null&&p2!=null){			
			now.next = p1;
			p1 = p1.next;
			now = now.next;
			now.next = p2;
			p2 = p2.next;
			now = now.next;			
		}
		now.next = null;
		while(head!=null){
			System.out.print(head.value+":");
			head = head.next;
		}
		System.out.println();
	}
	
	/**
	 * 找到练表的中间节点
	 * 
	 * */
	public static LinkedlistNode findMidNode(LinkedlistNode head){
		
		if(head==null){
			System.out.println("输入有误，链表为空!");
			return null;
		}
		
		LinkedlistNode lownode = head;
		LinkedlistNode hignode = head;
		while(hignode!=null&&hignode.next!=null){
			lownode = lownode.next;
			hignode = hignode.next.next;
		}
		
		return lownode;
	}
	
	/**
	 * 翻转一个链表
	 * 
	 * */
	public static LinkedlistNode reverse(LinkedlistNode head){
		if(head==null){
			System.out.println("输入有误");
			return null;
		}
		LinkedlistNode curNode = head.next;
		LinkedlistNode preNode = head;
		LinkedlistNode nexNode = null;
		while(curNode!=null){
			nexNode = curNode.next;
			curNode.next = preNode;
			preNode = curNode;
			curNode = nexNode;
		}
		
		head.next = null;
		head = preNode;
		
		return head;
	}
	
	
	
	public static void function_02(String str,int first){
		int index  = -1;
		for(int i=first;i<str.length();i++){
			if(str.charAt(i)=='*'){
				index = i;
				break;
			}
		}
		if(index==-1){
			System.out.println(str);
			return;
		}
		
		function_02(str.substring(0,index)+"0"+str.substring(index+1), index+1);
		function_02(str.substring(0,index)+"1"+str.substring(index+1), index+1);
	}
	
	
	/**
	 * 
	 *2014 计算 
	 * */
	public static void functionAdd(LinkedlistNode head1,LinkedlistNode head2){
		Stack<Integer> list1 = new Stack<>();
		Stack<Integer> list2 = new Stack<>();
		while(head1!=null){
			list1.add(head1.value);
			head1 = head1.next;
		}
		
		while(head2!=null){
			list2.add(head2.value);
			head2 = head2.next;
		}
		
		StringBuffer sb = new StringBuffer();
		int result = 0;
		int jd =0;
		while(!list1.isEmpty()&&!list2.isEmpty()){
			result = list1.pop()+list2.pop()+jd;
			jd = result/10;
			result = result%10;
			sb.insert(0,result);
		}
		
		while(!list1.isEmpty()){
			result = list1.pop()+jd;
			jd = result/10;
			result = result%10;
			sb.insert(0, result);
		}
		
		while(!list2.isEmpty()){
			result = list2.pop()+jd;
			jd = result/10;
			result = result%10;
			sb.insert(0, result);
		}
		System.out.println("计算结果是:"+sb.toString());
		
	}
	
	/**
	 * 下一个字典序
	 * 
	 * */
	public static void nextPermutation(int[] num)  
    {  
        if(num.length <= 1)  
            return ;  
        for(int i = num.length - 2; i >= 0; i--)  //从尾部向前找两个相邻的元素
        {  
            if(num[i] < num[i+1])  	//找到满足条件   前一个比后一个小
            {  
                int j;  			//再从尾部向头找一个元素，使之满足 num[i]<num[j];
                for(j = num.length - 1; j >= i; j--)  {
                    if(num[i] < num[j])  
                        break;  
                }
                // swap the two numbers.  
                num[i] = num[i] ^ num[j];  			//交换这两个元素
                num[j] = num[i] ^ num[j];  
                num[i] = num[i] ^ num[j];  
                //sort the rest of arrays after the swap point.  
                Arrays.sort(num, i+1, num.length);  		//
                return ;  
            }  
        }  
        //reverse the arrays.  
        for(int i = 0; i < num.length / 2; i++)  
        {  
            int tmp = num[i];  
            num[i] = num[num.length - i - 1];  
            num[num.length - i - 1] = tmp;  
        }  
       
    }
	
	public static void nextString(char [] str){
		if(str.length<=1){
			return;
		}
		for(int i=str.length-2;i>=0;i--){
			if(str[i]<str[i+1]){
				int j;
				for(j=str.length-1;j>=0;j--){
					if(str[i]<str[j]){
						break;
					}
				}
				char temp = str[i];
				str[i] = str[j];
				str[j] = temp;
				
				Arrays.sort(str, i+1, str.length);
				return;
			}
		}
		
		for(int i=0;i<str.length/2;i++){
			char temp = str[i];
			str[i] = str[str.length-i-1];
			str[str.length-i-1] = temp;
		}
	}

}




class LinkedlistNode{
	int value;
	LinkedlistNode next;
	
	public LinkedlistNode(int v){
		this.value = v;
		next = null;
	}

	@Override
	public String toString() {
		return "[value=" + value + ", next=" + next + "]";
	}
	
	
}
