
public class ∂‡Ã¨ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AA1 a1 = new AA1();
		AA1 a2 = new BB1();
		BB1 b = new BB1();
		Cc c = new Cc();
		Dd d = new Dd();
		
		a1.show(b);
		a1.show(c);
		a1.show(d);
		
		a2.show(b);
		a2.show(c);
		a2.show(d);
		
		b.show(b);
		b.show(c);
		b.show(d);
		
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+i*j+" ");
			}
			System.out.println();
		}
	}

}
class AA1{
	public void show(Dd obj){
		System.out.println("A and D");
	}
	public void show(AA1 obj){
		System.out.println("A and A");
	}
}
class BB1 extends AA1{
	public void show(BB1 obj){
		System.out.println("B and B");
	}
	public void show(AA1 obj){
		System.out.println("B and A");
	}
}

class Cc extends BB1{}
class Dd extends BB1{}