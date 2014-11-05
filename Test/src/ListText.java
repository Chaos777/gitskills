import java.util.ArrayList;
import java.util.List;


public class ListText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(2, 3);
		System.out.println(list);
	}

}
