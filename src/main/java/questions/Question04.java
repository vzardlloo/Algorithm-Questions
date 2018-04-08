package questions;


import java.util.LinkedList;
import java.util.Queue;

public class Question04 {

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public Question04() {
        this.catQ = new LinkedList<PetEnterQueue>();
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, count++));
        } else if (pet.getType().equals("cat")) {
            this.catQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException();
        }
    }

    public Pet pollAll() {
        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("error,queue is empty!");
        }
    }

    public Dog pollDog() {
        if (!this.dogQ.isEmpty()) {
            return (Dog) this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty!");
        }
    }

    public Cat pollCat() {
        if (!this.catQ.isEmpty()) {
            return (Cat) this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("Cat queue is empty");
        }
    }

    public boolean isEmpty() {
        return dogQ.isEmpty() && catQ.isEmpty();
    }

}


class PetEnterQueue {

    private Pet pet;

    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}


class Pet {

    private String type;

    public Pet(String pet) {
        this.type = pet;
    }

    public String getType() {
        return type;
    }
}

class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}