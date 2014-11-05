package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ȫ���� {

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
	 *��һ: 
	 * 
	 * */
	public static void perm(char[] buf,int start ,int end){
		if(start == end){					//��ֻҪ���������һ����ĸ����ȫ����ʱ��ֻҪ�Ͱ��������������
			for(int i=0;i<end;i++){
				System.out.print(buf[i]);
			}
			System.out.println();
		}
		else{								//�����ĸȫ����  
			for(int i=start;i<end;i++){
				char temp = buf[start];		//���������һ��Ԫ���������Ԫ��
				buf[start] = buf[i];
				buf[i] = temp;
				
				perm(buf, start+1, end);	//����Ԫ�صݹ�ȫ����
				
				temp = buf[start];			//������������黹ԭ 
				buf[start] = buf[i];
				buf[i] = temp;
			}
		}
	}
	
	
	// ������
    // ����ʹ�õݻؽ������и�Ϊ��С�ĵ�Ԫ����������ϣ�����1 2 3 4�����п��Է�Ϊ
    // 1 [2 3 4],2[1 3 4],3[1 2 4],4[1 2 3]�������У�������ת�����Ƚ���ת�����Ϊ0��
    // �����ұߵ�������ת������ߣ�����������ת�ļ��������
    // 1 2 3 4 --> ��ת1 --> �������ұ�2 3 4���еݻش���
    // 2 1 3 4 --> ��ת1 2 ��Ϊ 2 1 --> �������ұ�1 3 4 ���еݻش���
    // 3 1 2 4 --> ��ת1 2 3��Ϊ3 1 2 --> �������ұ�1 2 4���еݻش���
    // 4 1 2 3 --> ��ת1 2 3 4 ��Ϊ4 1 2 3 --> �������ұ�1 2 3 ���еݻش���
    public static void perm(char[] num, int i) { // iΪ�ڼ���
        if (i < num.length) { // С���ܲ����ת,��ת�����0��ʼ
            for (int j = i; j < num.length; j++) {
                char tmp = num[j];
                // ��ת���������ұߵ����ֵ������
                for (int k = j; k > i; k--) {
                    num[k] = num[k - 1];
                }
                num[i] = tmp;
 
                perm(num, i + 1);
 
                // ��ԭ
                for (int k = i; k < j; k++) {
                    num[k] = num[k + 1];
                }
                num[j] = tmp;
            }
        } else { // ���һ���ʱ���ӡ
            // ��ʾ�˴�����
            for (int j = 0; j < num.length; j++) {
                System.out.print(num[j]);
            }
            System.out.println();
        }
    }
 
    // ������
    private static void sort(List<String> datas, List<String> target) {
        if (target.size() == 4) { // ���4��ʾҪ�Լ����ַ�����ȫ����
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
