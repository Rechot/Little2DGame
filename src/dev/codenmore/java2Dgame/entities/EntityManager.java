package dev.codenmore.java2Dgame.entities;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.entities.creatures.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {

    //InstanceFields

    private Handler handler;
    private Player player; //Special Entity

    private ArrayList<Entity> entities;
    private Comparator<Entity> renderOrderSorter = new Comparator<Entity>(){
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY() + a.getHeight() <= b.getY() + b.getHeight())
                return -1;
            else return 1;
        }
    };

    //Constructors

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<>();
        entities.add(player);
    }

    //Getters

    public Handler getHandler() {
        return handler;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    //Methods

    public void tick(){
        Iterator<Entity> iterator = entities.iterator();
        while( iterator.hasNext()){
            Entity e = iterator.next();
            e.tick();
            if(!e.isEntityIsActive()) {iterator.remove();}
        }
        entities.sort(renderOrderSorter);
    }

    public void render(Graphics graphics){
        for(Entity e: entities){
            e.render(graphics);
        }
        player.postRender(graphics);
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }
}
