package Lesson1;

public abstract class Fruit {
    private String name;
    private float weight;

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }
}
