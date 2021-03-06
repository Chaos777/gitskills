import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class puzzle_02<E> extends HashSet<E> {
    private int addCount = 0;
    @Override
    public boolean add(E e){
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c){
        addCount += c.size();
        return super.addAll(c);
    }

    public static void main(String[] args) {
        puzzle_02<String> s = new puzzle_02<String>();
        s.addAll(Arrays.asList("Accordion","Banjo","Kazoo"));
        System.out.println(s.addCount);
    }
}
