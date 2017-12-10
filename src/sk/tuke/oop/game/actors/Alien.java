package sk.tuke.oop.game.actors;

import java.util.Random;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.Input.Key;
import sk.tuke.oop.game.actions.Move;

public class Alien extends AbstractActor implements Movable {
    private String name;
    private int step = 100;
    private int interactionsToAct = 100;
    private int interactionsCounter = 0;

    public Alien(String name) {
        super(name);
        super.setPosition(300, 400);
        super.setAnimation(new Animation("sprites/warrior_alien.png", 32, 32, 100));
        setWidth(32);
        setHeight(32);
    }

    @Override
    public void act() {
        Input input = Input.getInstance();

        if (input.isKeyDown(Key.UP)
                || input.isKeyDown(Key.DOWN)
                || input.isKeyDown(Key.RIGHT)
                || input.isKeyDown(Key.LEFT)) {
            if (this.interactionsCounter >= this.interactionsToAct) {
                Random rand = new Random();
                int n = rand.nextInt(4) + 1;
                Move move = null;
                switch (n) {
                    case 1:
                        move = new Move(this, step, 0, -1);
                        move.execute();
                        break;
                    case 2:
                        move = new Move(this, step, 1, 0);
                        move.execute();
                        break;
                    case 3:
                        move = new Move(this, step, 0, 1);
                        move.execute();
                        break;
                    case 4:
                        move = new Move(this, step, -1, 0);
                        move.execute();
                        break;
                }
                this.interactionsCounter = 0;
            } else {
                this.interactionsCounter++;
            }
        }
    }

}
