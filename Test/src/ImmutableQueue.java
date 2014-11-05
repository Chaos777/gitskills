import java.lang.reflect.Array;
import java.util.NoSuchElementException;


public class ImmutableQueue<E> {
	
	private final E[] queue;
	
	private final int size;
	
	public ImmutableQueue(){
		queue = null;
		size = 0;
		
	}
	
	private ImmutableQueue(E[] queue){
		this.queue = queue;
		this.size = queue.length;
	}
	
	
	public ImmutableQueue<E> enqueue(E e){
		if(e==null){
			throw new IllegalArgumentException();
		}
		@SuppressWarnings("unchecked")
		E[] clone = (E[])Array.newInstance(e.getClass(), size+1);
		clone[0] = e;
		if(size!=0){
			System.arraycopy(this.queue, 0, clone, 1, size);
			
		}
		return new ImmutableQueue<E>(clone);
	}
	
	public ImmutableQueue<E> dequeue(){
		if(size==0){
			throw new NoSuchElementException();
		}
		@SuppressWarnings("unchecked")
		E[] clone = (E[])new Object[size-1];
		System.arraycopy(this.queue, 0, clone, 0, size-1);
		
		return new ImmutableQueue<E>(clone);
	}
	
	public E peek(){
		if(size==0){
			throw new NoSuchElementException();
		}
		return (E)queue[size-1];
	}
	
	public int size(){
		return this.size;
	}
}
