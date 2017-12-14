package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;

public class LockedDoor extends AbstractActor implements Usable, Openable {

    private boolean locked;
    private boolean opened;
    private int tileSize;
    private int counter;
    private boolean poisonSpreading = true;

    public LockedDoor(String name) {
        super(name);
        setAnimation(new Animation("sprites/vdoor.png", 16, 32, 100));
        setWidth(16);
        setHeight(32);
        getAnimation().stop();
        locked = true;
        opened = false;
        tileSize = 16;
        counter = 100;
    }

    public void lock() {
        locked = true;
    }

    public void unlock() {
        locked = false;
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
    }

    @Override
    public void act() {
        if (isLocked()) {
            getWorld().setWall(getX() / tileSize, getY() / tileSize, true);
        }
        Cooler cooler = null;
        for (Actor actor : getWorld()) {
            if (actor instanceof Cooler) {
                cooler = (Cooler) actor;
                break;
            }
        }
        if (poisonSpreading && opened && !cooler.isFixed()) {
            if (counter == 0) {
                for (Actor actor : getWorld()) {
                    if (actor instanceof Ripley && ((Ripley) actor).getHealth() > 0) {
                        Ripley ripley = (Ripley) actor;
                        ripley.setHealth(ripley.getHealth() - 1);
                        counter = 100;
                        break;
                    }
                }
            } else {
                counter--;
            }
        }
    }

    @Override
    public void open() {
        if (!locked) {
            getWorld().setWall(getX() / tileSize, getY() / tileSize, false);
            getAnimation().start();
            getAnimation().stopAt(3);
            poisonSpreading = true;
            this.opened = true;
        }
    }

    @Override
    public void close() {
        getWorld().setWall(getX() / tileSize, getY() / tileSize, true);
        getAnimation().start();
        getAnimation().stopAt(0);
        this.opened = false;
    }

    @Override
    public void useBy(Actor actor) {
        if (actor instanceof Ripley) {
            Ripley ripley = (Ripley) actor;
            if (ripley.getBackpack().getContent().size() > 0 && ripley.getBackpack().peek().getName().equals("Access Card")) {
                unlock();
                ripley.getBackpack().remove(ripley.getBackpack().peek());
            }
            if (!opened) {
                open();
            } else {
                close();
            }
        }
    }

    @Override
    public boolean isOpen() {
        return false;
    }
}
