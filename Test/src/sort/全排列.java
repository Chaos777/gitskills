package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] buf = {'1','2','3','4'};
		
		perm(buf, 0, buf.length);
		System.out.println();
		perm(buf, 0);
		System.out.println();
		String[] datas = new String[] { "1", "2", "3","4" };
		sort(Arrays.asList(datas), new ArrayList<String>());
	}
	/**
	 *法一: 
	 * 
	 * */
	public static void perm(char[] buf,int start ,int end){
		if(start == end){					//当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
			for(int i=0;i<end;i++){
				System.out.print(buf[i]);
			}
			System.out.println();
		}
		else{								//多个字母全排列  
			for(int i=start;i<end;i++){
				char temp = buf[start];		//交换数组第一个元素与后续的元素
				buf[start] = buf[i];
				buf[i] = temp;
				
				perm(buf, start+1, end);	//后续元素递归全排列
				
				temp = buf[start];			//将交换后的数组还原 
				buf[start] = buf[i];
				buf[i] = temp;
			}
		}
	}
	
	
	// 方法二
    // 可以使用递回将问题切割为较小的单元进行排列组合，例如1 2 3 4的排列可以分为
    // 1 [2 3 4],2[1 3 4],3[1 2 4],4[1 2 3]进行排列，利用旋转法，先将旋转间隔设为0，
    // 将最右边的数字旋转至最左边，并逐步增加旋转的间隔，例如
    // 1 2 3 4 --> 旋转1 --> 继续将右边2 3 4进行递回处理
    // 2 1 3 4 --> 旋转1 2 变为 2 1 --> 继续将右边1 3 4 进行递回处理
    // 3 1 2 4 --> 旋转1 2 3变为3 1 2 --> 继续将右边1 2 4进行递回处理
    // 4 1 2 3 --> 旋转1 2 3 4 变为4 1 2 3 --> 继续将右边1 2 3 进行递回处理
    public static void perm(char[] num, int i) { // i为第几层
        if (i < num.length) { // 小于总层就旋转,旋转间隔从0开始
            for (int j = i; j < num.length; j++) {
                char tmp = num[j];
                // 旋转该区段最右边的数字到最左边
                for (int k = j; k > i; k--) {
                    num[k] = num[k - 1];
                }
                num[i] = tmp;
 
                perm(num, i + 1);
 
                // 还原
                for (int k = i; k < j; k++) {
                    num[k] = num[k + 1];
                }
                num[j] = tmp;
            }
        } else { // 最后一层的时候打印
            // 显示此次排序
            for (int j = 0; j < num.length; j++) {
                System.out.print(num[j]);
            }
            System.out.println();
        }
    }
 
    // 方法三
    private static void sort(List<String> datas, List<String> target) {
        if (target.size() == 4) { // 这个4表示要对几个字符进行全排列
            for (Object obj : target)
                System.out.print(obj);
            System.out.println();
            return;
        }
        for (int i = 0; i < datas.size(); i++) {
            List<String> newDatas = new ArrayList<String>(datas);
            List<String> newTarget = new ArrayList<String>(target);
            newTarget.add(newDatas.get(i));
            newDatas.remove(i);
            sort(newDatas, newTarget);
        }
    }

}
