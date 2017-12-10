package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorContainer;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.items.Backpack;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Shift<A extends Actor> implements Action {

    private ActorContainer<?> container;
    private int pom = 0;
    private Actor item;
    /*public NextItem(BackpackImpl backpack) {
        this.backpack = backpack;
  this.item = this.backpack.getLastItem();
    */

    public Shift(ActorContainer<?> container) {
        this.container = container;
        pom = 0;
        item = container.peek();
    }

    @Override
    public void execute() {
//        container.shiftContent();
        //TODO isEmpty vs size > 0
        if (!container.getContent().isEmpty()) {
            ArrayList<Actor> content = (ArrayList<Actor>) container.getContent();
            while (pom < container.getContent().size() - 1) {
                content.set(pom, container.getContent().get(pom + 1));
                pom++;
            }
            content.set(container.getContent().size() -1, item);
        }
    }
}
