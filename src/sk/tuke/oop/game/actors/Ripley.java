package sk.tuke.oop.game.actors;

import org.lwjgl.Sys;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.Input.Key;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.Message;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.actions.Drop;
import sk.tuke.oop.game.actions.Move;
import sk.tuke.oop.game.actions.Shift;
import sk.tuke.oop.game.actions.Take;
import sk.tuke.oop.game.items.Backpack;

public class Ripley extends AbstractActor implements Movable {

    private String name;
    private int step = 2;
    private int health = 20;
    private int ammo = 100;
    private Backpack backpack;
    private Animation dead;

    public Ripley(String name) {
        super(name);
        this.name = "Ripleyova";
        setPosition(200, 200);
        setAnimation(new Animation("sprites/player.png", 32, 32, 100));
        dead = new Animation("sprites/player_die.png", 32, 32, 100);
        setHeight(32);
        setWidth(32);
        this.backpack = new Backpack(10);
    }

    @Override
    public void act() {
        super.getAnimation().stop();
        Input input = Input.getInstance();
        if (input.isKeyPressed(Key.ESCAPE)) {
            System.exit(0);
        } else if (input.isKeyPressed(Key.E)) {
            for (Actor actor : this.getWorld()) {
                if (intersects(actor) && actor instanceof Usable) {
                    ((Usable) actor).useBy(this);
                    break;
                }
            }
        } else if (input.isKeyPressed(Key.ENTER)) {
            for (Actor actor : getWorld()) {
                if (actor instanceof Item && intersects(actor)) {
                    Take takeItem = new Take(backpack, actor);
                    takeItem.execute();
                    break;
                }
            }
        } else if (input.isKeyPressed(Key.BACK)) {
            Drop drop = new Drop(backpack, getWorld(), getX(), getY());
            drop.execute();
        } else if (input.isKeyPressed(Key.S)) {
            Shift shift = new Shift(backpack);
            shift.execute();
        } else if ((input.isKeyDown(Key.UP)
                || input.isKeyDown(Key.DOWN)
                || input.isKeyDown(Key.LEFT)
                || input.isKeyDown(Key.RIGHT)) && health > 0) {
            int moveX = 0;
            int moveY = 0;
            if (input.isKeyDown(Key.UP)) {
                moveY = -1;
            }
            if (input.isKeyDown(Key.DOWN)) {
                moveY = 1;
            }
            if (input.isKeyDown(Key.LEFT)) {
                moveX = -1;
            }
            if (input.isKeyDown(Key.RIGHT)) {
                moveX = 1;
            }
            Move move = new Move(this, step, moveX, moveY);
            move.execute();
            super.getAnimation().start();
        }

        for (Actor actor : getWorld()) {
            if (actor instanceof Alien && intersects(actor)) {
                health--;
            }
//            if (health == 0) {
//                System.exit(0);
//            }
        }

        getWorld().showMessage(new Message("Health: " + health + "\nAmmo: " + ammo, 10, 40));

        if (health == 0) {
            setAnimation(this.dead);
            this.dead.setLooping(false);
            this.dead.start();
            this.health = 0;
        }
    }

    @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
//        world.showActorContainer(backpack);
        world.centerOn(this);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public Backpack getBackpack() {
        return backpack;
    }
}
