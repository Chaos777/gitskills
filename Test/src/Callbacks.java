
interface In
{
	void increment();
}

class class1 implements In
{
	private int i= 0;
	public void increment()
	{
		i++;
		System.out.println("class1:"+i);
	}
}

class As{
	public void increment()
	{
		System.out.println("other");
	}
	public static void f(As a){a.increment();}
}

class class2 extends As
{
	private int i=0;
	public void increment()
	{
		super.increment();
		i++;
		System.out.println("class2"+i);
	}
	
	private class B implements In{
		public void increment()
		{
			class2.this.increment();
		}
	}
	
	In getIn()
	{
		return new B();
	}
}

class Caller
{
	private In callIn;
	Caller(In cIn){callIn = cIn;}
	void go()
	{
		callIn.increment();
	}
}


public class Callbacks {
	public static void main(String[] args)
	{
		class1 c1 = new class1();
		class2 c2 = new class2();
		As.f(c2);
		Caller cl1 = new Caller(c1);
		Caller cl2 = new Caller(c2.getIn());
		cl1.go();
		cl1.go();
		cl2.go();
		cl2.go();
	}
}
