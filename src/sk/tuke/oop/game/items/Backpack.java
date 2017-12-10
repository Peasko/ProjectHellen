package sk.tuke.oop.game.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorContainer;
import sk.tuke.oop.framework.Item;

public class Backpack implements ActorContainer {

    private int capacity;
    private String name;
    private ArrayList<Actor> content;

    public Backpack(int capacity) {
        this.capacity = capacity;
        content = new ArrayList<Actor>(capacity);
    }

    @Override
    public void add(Actor actor) {
        if (actor instanceof Item) {
            if (content.size() < capacity) {
                content.add(actor);
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    @Override
    public void remove(Actor actor) {
        if (actor instanceof Item && content.size() > 0 && containsItem(actor)) {
            content.remove(actor);
        } else {
            throw new NoSuchElementException();
        }
    }

    private boolean containsItem(Actor actor) {
        for (Actor item : content) {
            if (item.equals(actor)) {
                return true;
            }
        }
        return false;
    }

    //vrati posledny item vlozeny do batoha
    @Override
    public Actor peek() {
        return content.get(content.size() - 1);
    }

    @Override
    public List getContent() {
        return content;
    }

    //presunie posledny pridany prvok na dno batoha
    @Override
    public void shiftContent() {
        Actor itemToMove = peek();
        content.remove(itemToMove);
        content.add(0, itemToMove);
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Iterator iterator() {
        return content.iterator();
    }
}
