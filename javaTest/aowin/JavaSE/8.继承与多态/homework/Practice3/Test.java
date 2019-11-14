package Practice3;

public class Test {
    public static void main(String[] args) {
        Girl a1 = new Girl(new Dog());
        Girl a2= new Girl(new Cat());

        a1.animalBark();
        a2.animalBark();
    }
}
