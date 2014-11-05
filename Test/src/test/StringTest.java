package test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringTest {
	
	/**
	 *测试String是否可变 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	  **/
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		String s1 = new String("Hello World");
		String s2 = new String("Hello World");
		
		String s3 = s1.substring(6);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	
		Field field = String.class.getDeclaredField("value");
		field.setAccessible(true);
		char [] value = (char[])field.get(s1);
		
		value[6] = 'J';
		value[7] = 'a';
		value[8] = 'v';
		value[9] = 'a';
		value[10] = '!';
		System.out.println("jjj"+s1);
		System.out.println(s2);
		System.out.println(s3);
		
		String a = "a";
		String b = "b";
		String c = a+"b";
		String d = "a"+"b";
		System.out.println(c=="ab");
		System.out.println(d=="ab");
	}
	
	/**
	 *测试String是否可变 
	 * SecurityException 
	 * NoSuchFieldException 
	 * IllegalAccessException 
	 * IllegalArgumentException 
	 * 
	
	 **/

}
