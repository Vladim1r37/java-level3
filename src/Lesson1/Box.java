package Lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        if (!fruits.isEmpty())
        return fruits.size() * fruits.get(0).getWeight();
        else return 0.0f;
    }

    public boolean compare(Box box) {
        if (getWeight() == box.getWeight())
            return true;
        else return false;
    }

    public void pourTo(Box<T> box) {
        for (int i = fruits.size(); i > 0; i--) {
            box.add(fruits.remove(i-1));
        }
    }
}
