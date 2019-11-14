package Practice3;

public class Girl {
    private Animal animal;

    public Girl(Animal animal) {
        this.animal = animal;
    }

    public void animalBark(){
        animal.bark();
    }
}
