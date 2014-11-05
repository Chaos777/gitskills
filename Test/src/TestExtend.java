
class Animal{
    int age ;
    public Animal(){
         
    }
    public Animal(int age) {
        // TODO Auto-generated constructor stub
        this.age = age;
    }
    void run(){
        System.out.println("animal run "+age);
    }
}
class Dog extends Animal{
    int age;
    String name;
    public Dog(int age,String name) {
        // TODO Auto-generated constructor stub
        this.age = age;
        this.name = name;
    }
    @Override
    void run(){
        System.out.println("dog run "+age);
    }
}
public class TestExtend {
    public static void main(String[] args) {
        Animal animal = new Animal(5);
        System.out.println(animal.age);
        animal.run();
         
        Dog dog = new Dog(1, "xiaobai");
        System.out.println(dog.age);
        dog.run();
         
        Animal animal2 = new Dog(11, "wangcai");
        System.out.println(animal2.age);
        animal2.run();
         
        Animal animal3;
        animal3 = dog;
        System.out.println(animal3.age);
        animal3.run();
    }
}