package task;

import java.util.ArrayList;
import java.util.Stack;

public class DiDi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		/*String str = "12+(23*3-56+7)*(2+90)/2";
		ArrayList<String> result = getStringList(str);  //String转换为List   
        result = getPostOrder(result);   //中缀变后缀   
        System.out.println(calculate(result));
        
        
        function();
        
        System.out.println(Math.abs(Integer.MIN_VALUE));
        */
		
		String tep = "absgbdhs*()34$$$$3AAA";
		System.out.println(tep.replaceAll("[^a-z||A-Z]", ""));
		
        int n=100000000;
        long cur = System.currentTimeMillis();
        function_new(n);
        System.out.println(System.currentTimeMillis()-cur);
       
       
	}

	
    /** 
     * 将字符串转化成List 
     * @param str 
     * @return 
     */  
    public static ArrayList<String> getStringList(String str){  
        ArrayList<String> result = new ArrayList<String>();  
        String num = "";  
        for (int i = 0; i < str.length(); i++) {  
            if(Character.isDigit(str.charAt(i))){  
                num = num + str.charAt(i);  
            }else{  
                if(num != ""){  
                    result.add(num);  
                }  
                result.add(str.charAt(i) + "");  
                num = "";  
            }  
        }  
        if(num != ""){  
            result.add(num);  
        }  
        return result;  
    }  
      
    /** 
     * 将中缀表达式转化为后缀表达式 
     * @param inOrderList 
     * @return 
     */  
    public static ArrayList<String> getPostOrder(ArrayList<String> inOrderList){  
          
        ArrayList<String> result = new ArrayList<String>();  
        Stack<String> stack = new Stack<String>();  
        for (int i = 0; i < inOrderList.size(); i++) {  
            if(Character.isDigit(inOrderList.get(i).charAt(0))){  
                result.add(inOrderList.get(i));  
            }else{  
                switch (inOrderList.get(i).charAt(0)) {  
                case '(':  
                    stack.push(inOrderList.get(i));  
                    break;  
                case ')':  
                    while (!stack.peek().equals("(")) {  
                        result.add(stack.pop());  
                    }  
                    stack.pop();  
                    break;  
                default:  
                    while (!stack.isEmpty() && compare(stack.peek(), inOrderList.get(i))){  
                        result.add(stack.pop());  
                    }  
                    stack.push(inOrderList.get(i));  
                    break;  
                }  
            }  
        }  
        while(!stack.isEmpty()){  
            result.add(stack.pop());  
        }  
        return result;  
    }  
      
    /** 
     * 计算后缀表达式 
     * @param postOrder 
     * @return 
     */  
    public static double calculate(ArrayList<String> postOrder){  
        Stack<Double> stack = new Stack<>();  
        for (int i = 0; i < postOrder.size(); i++) {  
            if(Character.isDigit(postOrder.get(i).charAt(0))){  
                stack.push(Double.valueOf(postOrder.get(i)));  
            }else{  
                double back = stack.pop();  
                double front = stack.pop();  
                double res = 0;  
                switch (postOrder.get(i).charAt(0)) {  
                case '+':  
                    res = front + back;  
                    break;  
                case '-':  
                    res = front - back;  
                    break;  
                case '*':  
                    res = front * back;  
                    break;  
                case '/':  
                    res = front / back;  
                    break;  
                }  
                stack.push(res);  
            }  
        }  
        return stack.pop();  
    }  
      
    /** 
     * 比较运算符等级 
     * @param peek 
     * @param cur 
     * @return 
     */  
    public static boolean compare(String peek, String cur){  
        if("*".equals(peek) && ("/".equals(cur) || "*".equals(cur) ||"+".equals(cur) ||"-".equals(cur))){  
            return true;  
        }else if("/".equals(peek) && ("/".equals(cur) || "*".equals(cur) ||"+".equals(cur) ||"-".equals(cur))){  
            return true;  
        }else if("+".equals(peek) && ("+".equals(cur) || "-".equals(cur))){  
            return true;  
        }else if("-".equals(peek) && ("+".equals(cur) || "-".equals(cur))){  
            return true;  
        }  
        return false;  
    }
    
    
    public static void function(){
    	for(int i=10;i<100;i++){
    		StringBuffer sb = new StringBuffer();
    		sb.append(i).append(i).append(i).append(i);
    		int num = Integer.parseInt(sb.toString());
    		System.out.println((num/i)%9);
    	}
    }
    
   
    
    public static void function_new(int n){
    	int a[] = new int[n+1];
    	for(int i=1;i<a.length;i++){
    		a[i] = i;
    	}
    	a[1] =0;
    	for(int i=2;i<Math.sqrt(n);i++){
    		for(int j=i+1;j<a.length;j++){
    			if(a[j]!=0&&a[j]%i==0){
    				a[j] = 0;
    			}
    		}
    	}
    	for(int i=1;i<a.length;i++){
    		if(a[i]!=0){
    			System.out.println(a[i]);
    		}
    	}
    }

}
