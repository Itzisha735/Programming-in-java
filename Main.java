abstract class   Animal{
    protected   String name;
    protected int   age;

    public  Animal(String  name, int age) {
        this .name = name;
        this .age = age;
    }

    public void  displayInfo(){
        System.out.println("Name: " + name + ", Age: " +age);
    }
    public void  breathe(){
        System.out.println(name + " is breathing...");
    }

    public abstract void      makeSound();
    public abstract void      move();

}

final class  Dog extends  Animal {
    private  String   breed;

    public  Dog(String  n, int a, String  b) {
        super (n, a); this .breed = b;
    }
   
    @Override
    public void     makeSound(){
        System.out.println(name + " says: Woof!");
   
    }

    @Override
    public void     move(){
        System.out.println(name + " is running!");
    }

}


final class  Cat extends  Animal {
    private  String   color;

    public  Cat(String  n, int a, String  c) {
        super (n, a); this .color = c;
    }
   
    @Override
    public void     makeSound(){
        System.out.println(name + " says: Meow!");
   
    }

    @Override
    public void     move(){
        System.out.println(name + " walks gracefully!");
    }

}
 final class Main {
    public static final  String APP_NAME  = " Animal kingdom";
    public static final int  MAX_ANIMALS = 10;


    public static void  main(String [] agrs) {
        System.out.println("=== " + APP_NAME + "===");

        Dog dog1 = new Dog("Buddy", 3 , "Golden Retriever");
        Cat cat1 = new Cat("Whiskers", 3 , "White");

        dog1.displayInfo();
        dog1.makeSound();



        cat1.displayInfo();
        cat1.makeSound();

        dog1.breathe();


    }

 }
