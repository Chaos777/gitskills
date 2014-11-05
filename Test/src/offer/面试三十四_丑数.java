package offer;

public class 面试三十四_丑数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=1500 ;i++){
			System.out.println(GetUglyNumber(i));
		}
	}
	
	
	public static int GetUglyNumber(int index){
		if(index<=0){
			return -1;
		}
		int []num = new int[index];
		num[0] = 1;
		int nextIndex = 1;
		
		int Ugly2 = 0;
		int Ugly3 = 0;
		int Ugly5 = 0;
		while(nextIndex<index){
			int min = Min(num[Ugly2]*2, num[Ugly3]*3, num[Ugly5]*5);
			num[nextIndex] = min;
			while(num[Ugly2]*2<=num[nextIndex]){
				Ugly2++;
			}
			while(num[Ugly3]*3<=num[nextIndex]){
				Ugly3++;
			}
			while(num[Ugly5]*5<=num[nextIndex]){
				Ugly5++;
			}
			
			nextIndex++;
		}
		
		return num[nextIndex-1];
	}
	
	public static int Min(int a,int b,int c){
		int min = (a>b)?b:a;
		min = (min>c)?c:min;
		
		return min;
	}

}
