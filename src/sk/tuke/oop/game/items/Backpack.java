package sk.tuke.oop.game.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorContainer;
import sk.tuke.oop.framework.Item;

//ActorContainer<? extends Actor>
public class Backpack implements ActorContainer<Item> {

    private int capacity;
    private String name;
    private final List<Item> content;

    public Backpack(int capacity) {
        this.capacity = capacity;
        this.content = new ArrayList<>(capacity);
    }

    @Override
    public void add(Item actor) {
        if (content.size() < capacity) {
            content.add(actor);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void remove(Item actor) {
        if (content.size() > 0 && containsItem(actor)) {
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
    public Item peek() {
        if (content.size() == 0) {
            return null;
        }
        return content.get(content.size() - 1);
    }

    @Override
    public List<Item> getContent() {
        return content;
    }

    //presunie posledny pridany prvok na dno batoha
    @Override
    public void shiftContent() {
        if (content.size() == 0) {
            return;
        }

        final Item itemToMove = peek();
        int idx = content.size() - 1;
        while (idx > 0) {
            Item prevItem = content.get(idx - 1);
            content.set(idx, prevItem);
            idx--;
        }
        content.set(0, itemToMove);
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
    public Iterator<Item> iterator() {
        return content.iterator();
    }

    @Override
    public String toString() {
        return "{"
                + "\"capacity\":\"" + capacity + "\""
                + ", \"name\":\"" + name + "\""
                + ", \"content\":" + content
                + "}";
    }

}
