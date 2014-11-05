package task;

import java.util.Arrays;
import java.util.Comparator;

public class KuaiDi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student [] students = new Student[3];
		Student s1 = new Student("l1", "l1", 10, 10);
		Student s2 = new Student("l2", "l2", 20, 20);
		Student s3 = new Student("l3", "l3", 30, 30);
		
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				if(o1.score>o2.score){
					return -1;
				}
				else if(o1.score==o2.score){
					return 0;
				}
				else{
					return 1;
				}
			}
		});
		
		for(Student s:students){
			System.out.println(s);
		}
	}
	
	public static void  function(Student[]score){
		Arrays.sort(score, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				if(o1.score>o2.score){
					return -1;
				}
				else if(o1.score==o2.score){
					return 0;
				}
				else{
					return 1;
				}
			}
		});
		
		for(Student s:score){
			System.out.println(s);
		}
	}

}
class Student{
	String name;
	String cls;
	
	int age;
	int score;
	public Student(String n,String c,int a,int s){
		this.name = n;
		this.cls = c;
		this.age = a;
		this.score = s;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", cls=" + cls + ", age=" + age
				+ ", score=" + score + "]";
	}
	
}