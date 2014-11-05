
public class ABC_new {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		function();
	}
	
	public static void function() throws InterruptedException{
		final char []m = {'A','B','C'};
		int count  =10;
		for(int i=0;i<count;i++){
			for(int k=0;k<m.length;k++){
				final int j = k;
				Thread thread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println(m[j]);
					}
				});
				thread.start();
				thread.join();
			}
			System.out.println("---------"+(i+1));
		}
	}

}
