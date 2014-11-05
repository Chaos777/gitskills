package task;
import java.util.ArrayList;
import java.util.Collections;


/**
 * A circus is designing a tower routine consisting of people standing atop one another��s shoulders. 
 * For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her.
 *  Given the heights and weights of each person in the circus, write a method to compute the largest possible number 
 *  of people in such a tower.

EXAMPLE:

Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)

Output: The longest tower is length 6 and includes from top to bottom: 
	(56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)

����:

��Ϸ�����������һ����Ŀ�����޺���һȺ�����ϵ���ÿ���˶�������һ���˵ļ���ϡ� Ҫ���������Ҫ��������˰����ұ���������ᡣ
����ÿ���˵���ߺ����أ� дһ������������޺���Ŀ�������Ե������ˣ�

���ӣ�

����(��� ����)��(65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)

��������ɵ�������6 �����ϵ����ǣ�(56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)�� 
 *
 */
public class Youdao2 {

	public static void main(String[] args) {
		ArrayList<HtWt> items = initialize();
//		System.out.println(solve(items));
		ArrayList<HtWt> solution = getIncreasingSequence(items);
		printList(solution);
		System.out.println(solution.size()+"��");
	}
	
	public static int solve(ArrayList<HtWt> items){
		boolean[] used = new boolean[items.size()];
		HtWt bottom = null;
		ArrayList<HtWt> ret = new ArrayList<HtWt>();
		int maxPeople = rec(items, used, bottom, ret);
		System.out.println(ret);
		return maxPeople-1;		// -1����Ϊ��һ��dummy element,�����ó�null
	}
	
	public static int rec(ArrayList<HtWt> items, boolean[] used, HtWt cur, ArrayList<HtWt> curAL){
		
		boolean flag = false;			// �ж��Ƿ��ҵ���һ��ѡ��
		int maxAbovePeople = 0;		// ���ڵ�ǰ������ѡ���ҵ������ӽṹ
		
		for(int i=0; i<items.size(); i++){
			if(!used[i]){
				used[i] = true;
				HtWt next = items.get(i);
				if(next.isBefore(cur)){
					flag = true;
					ArrayList<HtWt> nextAL = new ArrayList<HtWt>();		// Ϊ�ӵ����½���AL
					int abovePeople = rec(items, used, next, nextAL);
					if(abovePeople > maxAbovePeople){
						curAL.clear();					// ���������
						curAL.addAll(nextAL);		// �����������еľ�����ʹ����������ѡ��
						maxAbovePeople = abovePeople;
					}
				}
				used[i] = false;
			}
		}
		
		
		if(flag == false){
			curAL.clear();
			curAL.add(cur);
			return 1;
		}
		
		curAL.add(cur);
		return maxAbovePeople+1;
	}
	
	public static ArrayList<HtWt> initialize() {
        ArrayList<HtWt> items = new ArrayList<HtWt>();
        
        HtWt item = new HtWt(70, 150);
        items.add(item);
        
        item = new HtWt(68, 110);
        items.add(item);

        item = new HtWt(56, 90);
        items.add(item);
        
        item = new HtWt(75, 190);
        items.add(item);
        
        item = new HtWt(60, 95);
        items.add(item);
        
        
        item = new HtWt(35, 65);
        items.add(item);
        
        item = new HtWt(40, 60);
        items.add(item);
        
        item = new HtWt(45, 63);
        items.add(item);
        
        return items;

	}
	
	public static void printList(ArrayList<HtWt> list) {
        for (HtWt item : list) {
                System.out.println(item.toString() + " ");
        }
	}

	static class HtWt implements Comparable {
		private int Ht;
		private int Wt;

		public HtWt(int h, int w) {
			Ht = h;
			Wt = w;
		}

		public int compareTo(Object s) {
			HtWt second = (HtWt) s;
			if (this.Ht != second.Ht) {
				return ((Integer) this.Ht).compareTo(second.Ht);
			} else {
				return ((Integer) this.Wt).compareTo(second.Wt);
			}
		}

		public String toString() {
			return "(" + Ht + ", " + Wt + ")";
		}

		/*
		 * Returns true if ��this�� should be lined up before ��other��. Note that
		 * it��s possible that this.isBefore(other) and other.isBefore(this) are
		 * both false. This is different from the compareTo method, where if a <
		 * b then b > a.
		 */
		public boolean isBefore(HtWt other) {
			if(other == null){
				return true;
			}
			if (this.Ht < other.Ht && this.Wt < other.Wt) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	//=========================== ��һ�ַ�������LIS����
	private static ArrayList<HtWt> longestIncreasingSubsequence(ArrayList<HtWt> array) {
        ArrayList<HtWt>[] solutions = new ArrayList[array.size()];
        longestIncreasingSubsequence(array, solutions, 0);
        
        ArrayList<HtWt> best_sequence = null;
        for (int i = 0; i < array.size(); i++) {
        	best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
        }
        
        return best_sequence;
	}
	
	private static void longestIncreasingSubsequence(ArrayList<HtWt> array, ArrayList<HtWt>[] solutions, int current_index) {
        if (current_index >= array.size() || current_index < 0) {
                return;
        }
        HtWt current_element = array.get(current_index);
        
        // Find longest sequence that we can append current_element to
        ArrayList<HtWt> best_sequence = null;
        for (int i = 0; i < current_index; i++) {
                if (array.get(i).isBefore(current_element)) { // If current_element is bigger than list tail
                        best_sequence = seqWithMaxLength(best_sequence, solutions[i]); // Set best_sequence to our new max
                }
        }
        
        // Append current_element
        ArrayList<HtWt> new_solution = new ArrayList<HtWt>();
        if (best_sequence != null) {
                new_solution.addAll(best_sequence);
        } 
        new_solution.add(current_element);
        
        // Add to list and recurse
        solutions[current_index] = new_solution;
        longestIncreasingSubsequence(array, solutions, current_index + 1);
	}
	
	// Returns longer sequence
    private static ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
            if (seq1 == null) {
                    return seq2;
            } else if (seq2 == null) {
                    return seq1;
            }
            return seq1.size() > seq2.size() ? seq1 : seq2;
    }
    
    public static ArrayList<HtWt> getIncreasingSequence(ArrayList<HtWt> items) {
        Collections.sort(items);
        return longestIncreasingSubsequence(items);
    }
}
